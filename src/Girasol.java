import javax.swing.*;
import java.awt.event.ActionEvent;

public class Girasol extends Planta {

    private Timer contadorProductorSoles;

    public Girasol(PanelJuego parent, int x, int y) {
        super(parent, x, y);
        contadorProductorSoles = new Timer(15000, (ActionEvent evento) -> {
            Sol estado = new Sol(getPanelJuego(), 60 + x * 100, 110 + y * 120, 130 + y * 120);
            getPanelJuego().getsolesActivos().add(estado);
            getPanelJuego().add(estado, 1);
        });
        contadorProductorSoles.start();
    }
}
