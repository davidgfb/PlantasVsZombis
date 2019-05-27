package graficos;

import javax.swing.*;
import java.awt.event.ActionEvent;

//@author David Gracia

public class VentanaJuego extends JFrame {

    enum tipoPlanta {Ninguna,Girasol,LanzaGuisantes,Nuez}
    
    public static VentanaJuego ventanaJuego;
    
    /*Falta:
    -hashmap
    -evitar reemplazo personajes getOcupado
    -documento explicativo 
    -agrupar fotos en una sola 
    -optimizar codigo con enum,listas,tuplas,for */

    public VentanaJuego() {
        
        setSize(1012, 785);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLayout(null);

        JLabel soles = new JLabel();
        
        soles.setSize(60, 20);

        PanelJuego ventanaJuego = new PanelJuego(soles);
        
        CartaPlanta girasol = new CartaPlanta(new ImageIcon(this.getClass().getResource("imagenes/cartaGirasol.png")).getImage());
        CartaPlanta lanzaGuisantes = new CartaPlanta(new ImageIcon(this.getClass().getResource("imagenes/cartaLanzaGuisantes.png")).getImage());
        CartaPlanta nuez = new CartaPlanta(new ImageIcon(this.getClass().getResource("imagenes/cartaNuez.png")).getImage());
        
        soles.setLocation(37, 80);
        ventanaJuego.setLocation(0, 0);
        girasol.setLocation(110, 8);
        lanzaGuisantes.setLocation(175, 8);
        nuez.setLocation(240, 8);
        
        girasol.setAccion((ActionEvent e) -> {ventanaJuego.setPincelPlantaActiva(tipoPlanta.Girasol);});
        lanzaGuisantes.setAccion((ActionEvent e) -> {ventanaJuego.setPincelPlantaActiva(tipoPlanta.LanzaGuisantes);});
        nuez.setAccion((ActionEvent e) -> {ventanaJuego.setPincelPlantaActiva(tipoPlanta.Nuez);});
        
        getLayeredPane().add(ventanaJuego, 0); 
        getLayeredPane().add(girasol, new Integer(3));
        getLayeredPane().add(lanzaGuisantes, new Integer(3));
        getLayeredPane().add(nuez, new Integer(3));
        getLayeredPane().add(soles, new Integer(2));
        
        setResizable(false);
        setVisible(true);
    }

    public static void main(String[] args) {ventanaJuego = new VentanaJuego();}
}
