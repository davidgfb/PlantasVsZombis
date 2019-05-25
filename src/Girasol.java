import javax.swing.*;
import java.awt.event.ActionEvent;

public class Girasol extends Planta {

    private Timer sunProduceTimer;

    public Girasol(PanelJuego parent, int x, int y) {
        super(parent, x, y);
        sunProduceTimer = new Timer(15000, (ActionEvent e) -> {
            Sol sta = new Sol(getGp(), 60 + x * 100, 110 + y * 120, 130 + y * 120);
            getGp().getActiveSuns().add(sta);
            getGp().add(sta, new Integer(1));
        });
        sunProduceTimer.start();
    }
}
