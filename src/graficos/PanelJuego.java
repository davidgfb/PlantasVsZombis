package graficos;

import modelo.ZombiCabezaCono;
import modelo.Planta;
import modelo.Nuez;
import modelo.Guisante;
import modelo.ZombiNormal;
import modelo.LanzaGuisantes;
import modelo.Girasol;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.Random;
import modelo.Zombi;

public class PanelJuego extends JLayeredPane implements MouseMotionListener {

    private final Image imagenFondo, lanzaguisantesImagen, girasolImagen, nuez, imagenZombiNormal, imagenZombiCabezaCono;
    
    private Colisionador[] colisionadores;

    private ArrayList<ArrayList<Zombi>> filaZombis;
    private ArrayList<ArrayList<Guisante>> filaGuisantes;
    private final Timer contadorRefresco, contadorAvance, productorSoles, productorZombis;
    
    private final JLabel puntuacionSoles;

    private VentanaJuego.tipoPlanta pincelPlantaActiva = VentanaJuego.tipoPlanta.Ninguna;

    private int mouseX, mouseY, soles;

    public int getPuntuacionSoles() {return soles;}

    public void setPuntuacionSoles(int solesPuntuacion) {
        this.soles = solesPuntuacion;
        puntuacionSoles.setText(String.valueOf(solesPuntuacion)); //
    }
    
    public void añadeSoles (int solesAñadidos) {
        this.soles += solesAñadidos;
        puntuacionSoles.setText(String.valueOf(soles)); //
    }

    public PanelJuego(JLabel puntuacionSoles) {
        setSize(1000, 752); //
        setLayout(null); //
        addMouseMotionListener(this); //
        this.puntuacionSoles = puntuacionSoles;
        setPuntuacionSoles(150);  

        imagenFondo = new ImageIcon(this.getClass().getResource("imagenes/fondo.png")).getImage();
        nuez = new ImageIcon(this.getClass().getResource("imagenes/nuez.gif")).getImage();
        lanzaguisantesImagen = new ImageIcon(this.getClass().getResource("imagenes/lanzaguisantes.gif")).getImage();
        girasolImagen = new ImageIcon(this.getClass().getResource("imagenes/girasol.gif")).getImage();
        imagenZombiNormal = new ImageIcon(this.getClass().getResource("imagenes/comun.png")).getImage();
        imagenZombiCabezaCono = new ImageIcon(this.getClass().getResource("imagenes/cabezacono.png")).getImage();

        filaZombis = new ArrayList<>();
        filaGuisantes = new ArrayList<>();
        
        for (int i=0;i<5;i++) { //1 por linea
            filaZombis.add(new ArrayList<>()); 
            filaGuisantes.add(new ArrayList<>());
        }

        colisionadores = new Colisionador[45];
        
        for (int colisionador = 0; colisionador < 45; colisionador++) {
            Colisionador colisionadorObjeto = new Colisionador();
            colisionadorObjeto.setLocation(44 + (colisionador % 9) * 100, 109 + (colisionador / 9) * 120);
            colisionadorObjeto.setAccion(new PlantActionListener((colisionador % 9), (colisionador / 9)));
            colisionadores[colisionador] = colisionadorObjeto;
            add(colisionadorObjeto, 0); //
        }

        contadorRefresco = new Timer(25, (ActionEvent evento) -> {repaint();}); //
        contadorAvance = new Timer(60, (ActionEvent evento) -> avanza()); //
        productorSoles = new Timer(5000, (ActionEvent e) -> {añadeSoles(10);});
        contadorRefresco.start(); //
        contadorAvance.start();
        productorSoles.start();

        productorZombis = new Timer(7000, (ActionEvent e) -> {
            Random rnd = new Random();
            int aleatorio5 = rnd.nextInt(5);
            int aleatorioBinario = rnd.nextInt(2);
            String[] tipoZombi={"NormalZombie","ConeHeadZombie"};
            Zombi zombi = Zombi.getZombi(tipoZombi[aleatorioBinario], PanelJuego.this, aleatorio5);
            filaZombis.get(aleatorio5).add(zombi);
        });
        productorZombis.start();

    }

    private void avanza() {
        for (int columna = 0; columna < 5; columna++) {
            for (Zombi z : filaZombis.get(columna)) {z.avanza();}

            for (int j = 0; j < filaGuisantes.get(columna).size(); j++) {
                Guisante p = filaGuisantes.get(columna).get(j);
                p.avanza();
            }
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(imagenFondo, 0, 0, null);

        //Dibuja plantas
        for (int i = 0; i < 45; i++) {
            Colisionador c = colisionadores[i];
            if (c.plantaAsignada != null) {
                Planta p = c.plantaAsignada;
                if (p instanceof LanzaGuisantes) {g.drawImage(lanzaguisantesImagen, 60 + (i % 9) * 100, 129 + (i / 9) * 120, null);}
                
                if (p instanceof Nuez) {g.drawImage(nuez, 60 + (i % 9) * 100, 129 + (i / 9) * 120, null);}
                
                if (p instanceof Girasol) {g.drawImage(girasolImagen, 60 + (i % 9) * 100, 129 + (i / 9) * 120, null);}
            }
        }

        for (int i = 0; i < 5; i++) {
            for (Zombi z : filaZombis.get(i)) {
                if (z instanceof ZombiNormal) {g.drawImage(imagenZombiNormal, z.getPosX(), 109 + (i * 120), null);} 
                else if (z instanceof ZombiCabezaCono) {g.drawImage(imagenZombiCabezaCono, z.getPosX(), 109 + (i * 120), null);}
            }
        }
    }
    
    void restaSoles(int cantidad) {this.soles-=cantidad;}

    private class PlantActionListener implements ActionListener {

        int x, y, vidaGirasol=1, vidaNuez=10, vidaLanzaGuisantes=3, precioGirasol=20, precioNuez=10, precioLanzaGuisantes=50;

        public PlantActionListener(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
                
            //Girasol
            if (pincelPlantaActiva == VentanaJuego.tipoPlanta.Girasol) {
                if (getPuntuacionSoles() >= precioGirasol) {
                    colisionadores[x + y * 9].setPlant(new Girasol(PanelJuego.this, x, y, vidaGirasol));
                    restaSoles(precioGirasol);
                }
            }
            
            //Nuez
            if (pincelPlantaActiva == VentanaJuego.tipoPlanta.Nuez) {
                if (getPuntuacionSoles() >= precioNuez) {
                    colisionadores[x + y * 9].setPlant(new Nuez(PanelJuego.this, x, y, vidaNuez));
                    restaSoles(precioNuez);
                }
            }
            
            //LanzaGuisantes
            if (pincelPlantaActiva == VentanaJuego.tipoPlanta.LanzaGuisantes) {
                if (getPuntuacionSoles() >= precioLanzaGuisantes) {
                    colisionadores[x + y * 9].setPlant(new LanzaGuisantes(PanelJuego.this, x, y, vidaLanzaGuisantes));
                    restaSoles(precioLanzaGuisantes);
                }
            }
            pincelPlantaActiva = VentanaJuego.tipoPlanta.Ninguna;
        }
    }

    @Override
    public void mouseDragged(MouseEvent e) {}

    @Override
    public void mouseMoved(MouseEvent e) {
        mouseX = e.getX();
        mouseY = e.getY();
    }

    public VentanaJuego.tipoPlanta getPincelPlantaActiva() {return pincelPlantaActiva;}

    public void setPincelPlantaActiva (VentanaJuego.tipoPlanta pincelPlantaActiva) {this.pincelPlantaActiva = pincelPlantaActiva;}

    public ArrayList<ArrayList<Zombi>> getFilaZombis() {return filaZombis;}

    public void setFilaZombis(ArrayList<ArrayList<Zombi>> filaZombis) {this.filaZombis = filaZombis;}

    public ArrayList<ArrayList<Guisante>> getFilaGuisantes() {return filaGuisantes;}

    public void setFilaGuisantes(ArrayList<ArrayList<Guisante>> filaGuisantes) {this.filaGuisantes = filaGuisantes;}

    public Colisionador[] getColliders() {return colisionadores;}

    public void setColliders(Colisionador[] colisionadores) {this.colisionadores = colisionadores;}
}
