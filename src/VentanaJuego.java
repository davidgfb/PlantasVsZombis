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
    -agrupar fotos en una sola 
    -optimizar codigo con enum,listas,tuplas,for */

    public VentanaJuego() {
        setSize(1012, 785);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLayout(null);

        JLabel sol = new JLabel("SUN");
        sol.setLocation(37, 80);
        sol.setSize(60, 20);

        PanelJuego ventanaJuego = new PanelJuego(sol);
        ventanaJuego.setLocation(0, 0);
        getLayeredPane().add(ventanaJuego, new Integer(0));

        CartaPlanta girasol = new CartaPlanta(new ImageIcon(this.getClass().getResource("imagenes/cartas/cartaGirasol.png")).getImage());
        girasol.setLocation(110, 8);
        girasol.setAccion((ActionEvent e) -> {ventanaJuego.setPincelPlantaActiva(tipoPlanta.Girasol);});
        getLayeredPane().add(girasol, new Integer(3));

        CartaPlanta lanzaGuisantes = new CartaPlanta(new ImageIcon(this.getClass().getResource("imagenes/cartas/cartaLanzaGuisantes.png")).getImage());
        lanzaGuisantes.setLocation(175, 8);
        lanzaGuisantes.setAccion((ActionEvent e) -> {ventanaJuego.setPincelPlantaActiva(tipoPlanta.LanzaGuisantes);});
        getLayeredPane().add(lanzaGuisantes, new Integer(3));
        
        CartaPlanta nuez = new CartaPlanta(new ImageIcon(this.getClass().getResource("imagenes/cartas/cartaNuez.png")).getImage());
        nuez.setLocation(240, 8);
        nuez.setAccion((ActionEvent e) -> {ventanaJuego.setPincelPlantaActiva(tipoPlanta.Nuez);});
        getLayeredPane().add(nuez, new Integer(3));

        getLayeredPane().add(sol, new Integer(2));
        setResizable(false);
        setVisible(true);
    }

    public static void main(String[] args) {ventanaJuego = new VentanaJuego();}
}
