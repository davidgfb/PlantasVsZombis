import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Sol extends JPanel implements MouseListener {

    private PanelJuego panelJuego;

    private int miX,miY,yFinal,destruccion = 200;

    public Sol(PanelJuego padre, int xComienzo, int YComienzo, int yFinal) {
        this.panelJuego = padre;
        this.yFinal = yFinal;
        setSize(80, 80);
        setOpaque(false);
        miX = xComienzo;
        miY = YComienzo;
        setLocation(miX, miY);
        addMouseListener(this);
    }

    @Override
    protected void paintComponent(Graphics graficos) { //
        super.paintComponent(graficos); 
        panelJuego.setPuntuacionSoles(panelJuego.getpuntuacionSoles() + 25); //añade 25 soles
        panelJuego.remove(this);
        panelJuego.getsolesActivos().remove(this);
    }

    public void avanza() {
        if (miY < yFinal) {miY += 4;} 
        else {
            destruccion--;
            if (destruccion < 0) {
                panelJuego.remove(this);
                panelJuego.getsolesActivos().remove(this);
            }
        }
        setLocation(miX, miY);
    }

    @Override
    public void mouseClicked(MouseEvent e) {}

    @Override
    public void mousePressed(MouseEvent e) {}

    @Override
    public void mouseReleased(MouseEvent e) {}

    @Override
    public void mouseEntered(MouseEvent e) {}

    @Override
    public void mouseExited(MouseEvent e) {}
}
