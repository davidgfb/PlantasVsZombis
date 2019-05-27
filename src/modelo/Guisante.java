package modelo;

import graficos.PanelJuego;
import java.awt.*;

public class Guisante {

    private int posX,myLane;
    protected PanelJuego panelJuego;
    
    public Guisante(PanelJuego padre, int lane, int startX) {
        this.panelJuego = padre;
        this.myLane = lane;
        posX = startX;
    }

    public void avanza() {
        Rectangle pRect = new Rectangle(posX, 130 + myLane * 120, 28, 28);
        for (int i = 0; i < panelJuego.getFilaZombis().get(myLane).size(); i++) {
            Zombi zombi = panelJuego.getFilaZombis().get(myLane).get(i);
            Rectangle zRect = new Rectangle(zombi.getPosX(), 109 + myLane * 120, 400, 120);
            if (pRect.intersects(zRect)) {
                zombi.quitaSalud(1);
                boolean exit = false;
                if (zombi.getSalud() < 0) {
                    System.out.println("ZOMBIE DIED");

                    panelJuego.getFilaZombis().get(myLane).remove(i);
                    exit = true;
                }
                panelJuego.getFilaZombis().get(myLane).remove(this);
            }
        }
        posX += 15;
    }

    public int getPosX() {return posX;}

    public void setPosX(int posX) {this.posX = posX;}

    public int getMyLane() {return myLane;}

    public void setMyLane(int myLane) {this.myLane = myLane;}
}
