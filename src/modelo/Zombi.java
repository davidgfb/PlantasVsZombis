package modelo;

import graficos.VentanaJuego;
import graficos.Colisionador;
import graficos.PanelJuego;
import javax.swing.*;

public class Zombi extends Personaje {
    
    double velocidad = 0.5;
            
    private int vida = 5, x = 1000, miFila, daño = 1, poblacion=0;

    private PanelJuego panelJuego;

    private boolean seMueve = true;

    public Zombi(PanelJuego padre, int fila) {
        super(1);
        if (poblacion<=5) {
            this.panelJuego = padre;
            miFila = fila;
            poblacion++;
        }
        else {
            while (padre.getFilaZombis().size()<=0) {
                System.out.println("Ganaste!"); //NO FUNCIONA
            }
        }
        
        while (vida>0) {
            if (this.vida < 0) {
                System.out.println("zombi muerto");

                panelJuego.getFilaZombis().get(miFila).remove(this);

                //sale = true;
            }
        }
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
                choque.plantaAsignada.quitaSalud(daño);
                if (choque.plantaAsignada.getSalud() < 0) {choque.quitaPlanta();}
            }
            if (x < 0) {
                seMueve = false;
                JOptionPane.showMessageDialog(panelJuego, "Los zombis ganan!");
                System.out.print("Escribiendo partida perdida");
                VentanaJuego.ventanaJuego.dispose(); //
            }
        }
    }
    
    

    double lento = 0.5;

    public void lento() {lento = 0.5;}

    public static Zombi getZombi(String type, PanelJuego padre, int fila) {
        Zombi zombi = null;
        if (type.equals("ZombiNormal")) {zombi = new ZombiNormal(padre, fila);}
        else if (type.equals("ZombiCabezaCono")) {zombi = new ZombiCabezaCono(padre, fila);}
        return zombi;
    }

    //public int getSalud () {return vida;}

    public void setSalud (int vida) {this.vida = vida;}

    public double getVelocidad () {return velocidad;}

    public void setSpeed (int velocidad) {this.velocidad = velocidad;}

    public PanelJuego getPanelJuego () {return panelJuego;}

    public void setPanelJuego (PanelJuego panelJuego) {this.panelJuego = panelJuego;}

    public int getPosX () {return x;}

    public void setPosX (int x) {this.x = x;}

    public int getMyLane () {return miFila;}

    public void setMyLane (int miFila) {this.miFila = miFila;}

    public boolean seMueve () {return seMueve;}

    public void setMoving(boolean moving) {seMueve = moving;}

    public double getSlowInt() {return lento;}

    public void setSlowInt(int lento) {this.lento = lento;}
}
