import javax.swing.*;
import java.awt.event.ActionEvent;

public class Nuez extends Planta {

    private Timer shootTimer;

    public Nuez(PanelJuego parent, int x, int y) {
        super(parent, x, y);
        shootTimer = new Timer(2000, (ActionEvent e) -> {
            if (getPanelJuego().getLaneZombies().get(y).size() > 0) {}
        });
        shootTimer.start();
    }

    public void stop() {shootTimer.stop();} //no tocar
}
