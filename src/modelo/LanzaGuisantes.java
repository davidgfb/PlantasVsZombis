package modelo;

import graficos.PanelJuego;
import javax.swing.*;
import java.awt.event.ActionEvent;

public class LanzaGuisantes extends Planta {

    public Timer temporizadorDisparo;

    public LanzaGuisantes(PanelJuego padre, int x, int y, int vida) {
        super(padre, x, y, vida);
        temporizadorDisparo = new Timer (10000, (ActionEvent e) -> { //1000 es el tiempo que tarda en disparar
            if (getPanelJuego().getFilaZombis().get(y).size() > 0) {
                getPanelJuego().getFilaGuisantes().get(y).add(new Guisante(
                        getPanelJuego(), y, 103 + this.getX() * 100));}
        });
        temporizadorDisparo.start();
    }

    public void stop() {temporizadorDisparo.stop();} //no tocar
}
