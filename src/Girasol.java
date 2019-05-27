import javax.swing.*;
import java.awt.event.ActionEvent;

public class Girasol extends Planta {

    private Timer contadorProductorSoles;

    public Girasol(PanelJuego padre, int x, int y, int vida) {
        super(padre, x, y, vida);
        contadorProductorSoles = new Timer(15000, (ActionEvent evento) -> {panelJuego.añadeSoles(10);});
        contadorProductorSoles.start();
    }
}
