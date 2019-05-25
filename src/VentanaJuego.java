import javax.swing.*;
import java.awt.event.ActionEvent;

//@author David Gracia y Emmanuel Gbadegesin

public class VentanaJuego extends JFrame {

    enum tipoPlanta {Ninguna,Girasol,LanzaGuisantes,Nuez}
    
    static VentanaJuego ventanaJuego;
    
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

        CartaPlanta girasol = new CartaPlanta(new ImageIcon(this.getClass().getResource("imagenes/cartas/cartaGirasol.png")).getImage());
        girasol.setLocation(110, 8);
        girasol.setAccion((ActionEvent e) -> {gp.setPincelPlantaActiva(tipoPlanta.Girasol);});
        getLayeredPane().add(girasol, new Integer(3));

        CartaPlanta lanzaGuisantes = new CartaPlanta(new ImageIcon(this.getClass().getResource("imagenes/cartas/cartaLanzaGuisantes.png")).getImage());
        lanzaGuisantes.setLocation(175, 8);
        lanzaGuisantes.setAccion((ActionEvent e) -> {gp.setPincelPlantaActiva(tipoPlanta.LanzaGuisantes);});
        getLayeredPane().add(lanzaGuisantes, new Integer(3));
        
        CartaPlanta nuez = new CartaPlanta(new ImageIcon(this.getClass().getResource("imagenes/cartas/cartaNuez.png")).getImage());
        nuez.setLocation(240, 8);
        nuez.setAccion((ActionEvent e) -> {gp.setPincelPlantaActiva(tipoPlanta.Nuez);});
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
        ventanaJuego = new VentanaJuego(true);
        ventanaJuego.dispose();
        ventanaJuego = new VentanaJuego();
    }
}
