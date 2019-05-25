import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Colisionador extends JPanel implements MouseListener {

    private ActionListener accionEscuchada;

    public Colisionador() { //constructor
        setOpaque(false); //
        addMouseListener(this); //
        setSize(100, 120); //
    }

    public Planta plantaAsignada;

    public void setPlant(Planta planta) {plantaAsignada = planta;}

    public void quitaPlanta() {
        plantaAsignada.para();
        plantaAsignada = null;
    }

    public boolean estaColisionando(int area) {return (area > getLocation().x) && (area < getLocation().x + 100);}

    public void setAccion(ActionListener accionEscuchada) {this.accionEscuchada = accionEscuchada;}


    @Override
    public void mouseClicked(MouseEvent evento) {}

    @Override
    public void mousePressed(MouseEvent evento) {}

    @Override
    public void mouseReleased(MouseEvent evento) {
        if (accionEscuchada != null) {accionEscuchada.actionPerformed(new ActionEvent(this, ActionEvent.RESERVED_ID_MAX + 1, ""));}
    }

    @Override
    public void mouseEntered(MouseEvent evento) {}

    @Override
    public void mouseExited(MouseEvent evento) {}
}
