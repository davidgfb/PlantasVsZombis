import java.awt.*;

public class Guisante {

    private int posX,myLane;
    protected PanelJuego gp;
    
    public Guisante(PanelJuego parent, int lane, int startX) {
        this.gp = parent;
        this.myLane = lane;
        posX = startX;
    }

    public void avanza() {
        Rectangle pRect = new Rectangle(posX, 130 + myLane * 120, 28, 28);
        for (int i = 0; i < gp.getLaneZombies().get(myLane).size(); i++) {
            Zombi z = gp.getLaneZombies().get(myLane).get(i);
            Rectangle zRect = new Rectangle(z.getPosX(), 109 + myLane * 120, 400, 120);
            if (pRect.intersects(zRect)) {
                z.setSalud(z.getSalud() - 300);
                boolean exit = false;
                if (z.getSalud() < 0) {
                    System.out.println("ZOMBIE DIED");

                    gp.getLaneZombies().get(myLane).remove(i);
                    exit = true;
                }
                gp.getLaneZombies().get(myLane).remove(this);
            }
        }
        posX += 15;
    }

    public int getPosX() {return posX;}

    public void setPosX(int posX) {this.posX = posX;}

    public int getMyLane() {return myLane;}

    public void setMyLane(int myLane) {this.myLane = myLane;}
}
