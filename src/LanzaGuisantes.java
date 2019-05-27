import javax.swing.*;
import java.awt.event.ActionEvent;

public class LanzaGuisantes extends Planta {

    public Timer temporizadorDisparo;

    public LanzaGuisantes(PanelJuego padre, int x, int y, int vida) {
        super(padre, x, y, vida);
        int frecuencia=1; //guisantes/ciclo
        int ciclo=frecuencia*1000; //1000ms=1 ciclo=1s
        temporizadorDisparo = new Timer (ciclo, (ActionEvent e) -> {
            if (getPanelJuego().getLaneZombies().get(y).size() > 0) {getPanelJuego().getLanePeas().get(y).add(new Guisante(getPanelJuego(), y, 103 + this.getX() * 100));}
        });
        temporizadorDisparo.start();
    }

    public void stop() {temporizadorDisparo.stop();} //no tocar
}
