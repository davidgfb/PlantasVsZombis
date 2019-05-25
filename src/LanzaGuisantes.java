import javax.swing.*;
import java.awt.event.ActionEvent;

public class LanzaGuisantes extends Planta {

    public Timer shootTimer;

    public LanzaGuisantes(PanelJuego parent, int x, int y) {
        super(parent, x, y);
        shootTimer = new Timer(2000, (ActionEvent e) -> {
            if (getGp().getLaneZombies().get(y).size() > 0) {getGp().getLanePeas().get(y).add(new Guisante(getGp(), y, 103 + this.getX() * 100));}
        });
        shootTimer.start();
    }

    @Override
    public void stop() {shootTimer.stop();}
}
