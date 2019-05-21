import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Sun extends JPanel implements MouseListener {

    private GamePanel gp;

    private int myX;
    private int myY;
    private int endY;

    private int destruct = 200;

    public Sun(GamePanel parent, int startX, int startY, int endY) {
        this.gp = parent;
        this.endY = endY;
        setSize(80, 80);
        setOpaque(false);
        myX = startX;
        myY = startY;
        setLocation(myX, myY);
        addMouseListener(this);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); 
        gp.setSunScore(gp.getSunScore() + 25); //añade 25 soles
        gp.remove(this);
        gp.getActiveSuns().remove(this);
    }

    public void advance() {
        if (myY < endY) {
            myY += 4;
        } else {
            destruct--;
            if (destruct < 0) {
                gp.remove(this);
                gp.getActiveSuns().remove(this);
            }
        }
        setLocation(myX, myY);
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
