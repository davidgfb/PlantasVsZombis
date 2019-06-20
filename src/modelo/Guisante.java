package modelo;

import graficos.PanelJuego;
import java.awt.*;

public class Guisante {

    private int x,miCarril;
    protected PanelJuego panelJuego;
    
    public Guisante(PanelJuego padre, int carril, int xInicial) {
        this.panelJuego = padre;
        this.miCarril = carril;
        x = xInicial;
    }

    public void avanza() {
        for (int tamaño = 0; tamaño < panelJuego.getFilaZombis().get(miCarril).size(); tamaño++) {
            Zombi zombi = panelJuego.getFilaZombis().get(miCarril).get(tamaño);
            if (new Rectangle(x, 130 + miCarril * 120, 28, 28).intersects(new Rectangle(
                    zombi.getPosX(), 109 + miCarril * 120, 400, 120))) { //
                zombi.quitaSalud(1); //igual que el zombi
                
                //boolean sale = false;
                if (zombi.getSalud() < 0) {
                    System.out.println("zombi muerto");

                    panelJuego.getFilaZombis().get(miCarril).remove(zombi);
                    
                    //sale = true;
                }
                panelJuego.getFilaZombis().get(miCarril).remove(this); //
            }
        }
        x += 15;
    }

    public int getX() {return x;}

    public void setX(int x) {this.x = x;}

    public int getMiCarril() {return miCarril;}

    public void setMiCarril(int miCarril) {this.miCarril = miCarril;}
}
