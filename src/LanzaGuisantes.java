import javax.swing.*;
import java.awt.event.ActionEvent;

public class LanzaGuisantes extends Planta {

    public Timer temporizadorDisparo;

    public LanzaGuisantes(PanelJuego padre, int x, int y) {
        super(padre, x, y);
        temporizadorDisparo = new Timer(2000, (ActionEvent e) -> {
            if (getPanelJuego().getLaneZombies().get(y).size() > 0) {getPanelJuego().getLanePeas().get(y).add(new Guisante(getPanelJuego(), y, 103 + this.getX() * 100));}
        });
        temporizadorDisparo.start();
    }

    public void stop() {temporizadorDisparo.stop();} //no tocar
}
