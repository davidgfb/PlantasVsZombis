import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class CartaPlanta extends JPanel implements MouseListener {

    private Image imagen;
    private ActionListener actionListener;

    public CartaPlanta(Image imagen) {
        setSize(64, 90); //
        this.imagen = imagen;
        addMouseListener(this); //
    }

    public void setAccion(ActionListener actionListener) {this.actionListener = actionListener;}

    @Override
    protected void paintComponent(Graphics graficos) { //
        super.paintComponent(graficos);
        graficos.drawImage(imagen, 0, 0, null);
    }

    @Override
    public void mouseClicked(MouseEvent evento) {} //

    @Override
    public void mousePressed(MouseEvent evento) {} //

    @Override
    public void mouseReleased(MouseEvent evento) { //
        if (actionListener != null) {actionListener.actionPerformed(new ActionEvent(this, ActionEvent.RESERVED_ID_MAX + 1, ""));} //
    }

    @Override
    public void mouseEntered(MouseEvent evento) {} //

    @Override
    public void mouseExited(MouseEvent evento) {} //
}
