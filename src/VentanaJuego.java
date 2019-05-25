import javax.swing.*;
import java.awt.event.ActionEvent;

//@author David Gracia y Emmanuel Gbadegesin

public class VentanaJuego extends JFrame {

    enum PlantType {None,Sunflower,Peashooter,Nuez}
    
    static VentanaJuego gw;
    
    /*Falta:
    -vida personajes
    -hashmap
    -documento explicativo 
    -traducir a español 
    -comentar en español
    -agrupar fotos en una sola 
    -optimizar codigo con enum,listas,tuplas,for */

    public VentanaJuego() {
        setSize(1012, 785);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLayout(null);

        JLabel sun = new JLabel("SUN");
        sun.setLocation(37, 80);
        sun.setSize(60, 20);

        PanelJuego gp = new PanelJuego(sun);
        gp.setLocation(0, 0);
        getLayeredPane().add(gp, new Integer(0));

        CartaPlanta sunflower = new CartaPlanta(new ImageIcon(this.getClass().getResource("images/cards/card_sunflower.png")).getImage());
        sunflower.setLocation(110, 8);
        sunflower.setAction((ActionEvent e) -> {gp.setActivePlantingBrush(PlantType.Sunflower);});
        getLayeredPane().add(sunflower, new Integer(3));

        CartaPlanta peashooter = new CartaPlanta(new ImageIcon(this.getClass().getResource("images/cards/card_peashooter.png")).getImage());
        peashooter.setLocation(175, 8);
        peashooter.setAction((ActionEvent e) -> {gp.setActivePlantingBrush(PlantType.Peashooter);});
        getLayeredPane().add(peashooter, new Integer(3));
        
        CartaPlanta nuez = new CartaPlanta(new ImageIcon(this.getClass().getResource("images/cards/card_wallnut.png")).getImage());
        nuez.setLocation(240, 8);
        nuez.setAction((ActionEvent e) -> {gp.setActivePlantingBrush(PlantType.Nuez);});
        getLayeredPane().add(nuez, new Integer(3));

        getLayeredPane().add(sun, new Integer(2));
        setResizable(false);
        setVisible(true);
    }

    public VentanaJuego(boolean b) {
        setSize(1012, 785);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(true);
    }

    public static void main(String[] args) {
        gw = new VentanaJuego(true);
        gw.dispose();
        gw = new VentanaJuego();
    }
}
