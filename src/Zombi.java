import javax.swing.*;

public class Zombi {

    private int vida = 1000, velocidad = 1, x = 1000, miFila;

    private PanelJuego panelJuego;

    private boolean seMueve = true;

    public Zombi (PanelJuego padre, int fila) {
        this.panelJuego = padre;
        miFila = fila;
    }

    public void avanza() {
        if (seMueve) {
            boolean estaChocando = false;
            Colisionador choque = null;
            for (int fila = miFila * 9; fila < (miFila + 1) * 9; fila++) {
                if (panelJuego.getColliders()[fila].plantaAsignada != null && panelJuego.getColliders()[fila].estaColisionando(x)) {
                    estaChocando = true;
                    choque = panelJuego.getColliders()[fila];
                }
            }
            if (!estaChocando) {
                if (lento > 0) {
                    if (lento % 2 == 0) {x--;}
                    lento--;
                } else {x -= 1;}
            } else {
                choque.plantaAsignada.setSalud(choque.plantaAsignada.getSalud() - 10);
                if (choque.plantaAsignada.getSalud() < 0) {choque.quitaPlanta();}
            }
            if (x < 0) {
                seMueve = false;
                JOptionPane.showMessageDialog(panelJuego, "Los zombis ganan!\nReiniciando nivel");
                VentanaJuego.ventanaJuego.dispose(); //
                VentanaJuego.ventanaJuego = new VentanaJuego();
            }
        }
    }

    int lento = 0;

    public void slow() {lento = 1000;}

    public static Zombi getZombi(String type, PanelJuego padre, int fila) {
        Zombi z = new Zombi(padre, fila);
        if (type.equals("NormalZombie")) {z = new ZombiNormal(padre, fila);}
        else if (type.equals("ConeHeadZombie")) {z = new ZombiCabezaCono(padre, fila);}
        return z;
    }

    public int getSalud() {return vida;}

    public void setSalud(int vida) {this.vida = vida;}

    public int getSpeed() {return velocidad;}

    public void setSpeed(int velocidad) {this.velocidad = velocidad;}

    public PanelJuego getGp() {return panelJuego;}

    public void setGp(PanelJuego panelJuego) {this.panelJuego = panelJuego;}

    public int getPosX() {return x;}

    public void setPosX(int x) {this.x = x;}

    public int getMyLane() {return miFila;}

    public void setMyLane(int miFila) {this.miFila = miFila;}

    public boolean seMueve() {return seMueve;}

    public void setMoving(boolean moving) {seMueve = moving;}

    public int getSlowInt() {return lento;}

    public void setSlowInt(int lento) {this.lento = lento;}
}
