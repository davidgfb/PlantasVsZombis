import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.Random;

public class PanelJuego extends JLayeredPane implements MouseMotionListener {

    private Image imagenFondo, lanzaguisantesImagen, girasolImagen, nuez, imagenZombiNormal, imagenZombiCabezaCono;
    
    private Colisionador[] colisionadores;

    private ArrayList<ArrayList<Zombi>> filaZombis;
    private ArrayList<ArrayList<Guisante>> filaGuisantes;
    private ArrayList<Sol> solesActivos;

    private Timer contadorRefresco, contadorAvance, productorSoles, productorZombis;
    
    private JLabel puntuacionSoles;

    private VentanaJuego.tipoPlanta pincelPlantaActiva = VentanaJuego.tipoPlanta.Ninguna;

    private int mouseX, mouseY,sunScore;

    public int getpuntuacionSoles() {return sunScore;}

    public void setPuntuacionSoles(int solesPuntuacion) {
        this.sunScore = solesPuntuacion;
        puntuacionSoles.setText(String.valueOf(solesPuntuacion));
    }

    public PanelJuego(JLabel puntuacionSoles) {
        setSize(1000, 752); //
        setLayout(null); //
        addMouseMotionListener(this); //
        this.puntuacionSoles = puntuacionSoles;
        setPuntuacionSoles(150);  

        imagenFondo = new ImageIcon(this.getClass().getResource("imagenes/fondo.png")).getImage();
        nuez = new ImageIcon(this.getClass().getResource("imagenes/plantas/nuez.gif")).getImage();
        lanzaguisantesImagen = new ImageIcon(this.getClass().getResource("imagenes/plantas/lanzaguisantes.gif")).getImage();
        girasolImagen = new ImageIcon(this.getClass().getResource("imagenes/plantas/girasol.gif")).getImage();
        imagenZombiNormal = new ImageIcon(this.getClass().getResource("imagenes/zombis/comun.png")).getImage();
        imagenZombiCabezaCono = new ImageIcon(this.getClass().getResource("imagenes/zombis/cabezacono.png")).getImage();

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

        solesActivos = new ArrayList<>();

        contadorRefresco = new Timer(25, (ActionEvent evento) -> {repaint();}); //
        contadorRefresco.start(); //

        contadorAvance = new Timer(60, (ActionEvent evento) -> avanza()); //
        contadorAvance.start();

        productorSoles = new Timer(5000, (ActionEvent e) -> {
            Random rnd = new Random();
            Sol sta = new Sol(this, rnd.nextInt(800) + 100, 0, rnd.nextInt(300) + 200);
            solesActivos.add(sta);
            add(sta, new Integer(1));
        });
        productorSoles.start();

        productorZombis = new Timer(7000, (ActionEvent e) -> {
            Random rnd = new Random();
            DatosNivel lvl = new DatosNivel();
            String[] nivel = lvl.LEVEL_CONTENT[Integer.parseInt(lvl.LEVEL_NUMBER) - 1];
            int[][] LevelValue = lvl.LEVEL_VALUE[Integer.parseInt(lvl.LEVEL_NUMBER) - 1];
            int aleatorio5 = rnd.nextInt(5);
            int aleatorio100 = rnd.nextInt(100);
            Zombi zombi = null;
            for (int i = 0; i < LevelValue.length; i++) {
                if (aleatorio100 >= LevelValue[i][0] && aleatorio100 <= LevelValue[i][1]) {zombi = Zombi.getZombi(nivel[i], PanelJuego.this, aleatorio5);}
            }
            filaZombis.get(aleatorio5).add(zombi);
        });
        productorZombis.start();

    }

    private void avanza() {
        for (int i = 0; i < 5; i++) {
            for (Zombi z : filaZombis.get(i)) {z.avanza();}

            for (int j = 0; j < filaGuisantes.get(i).size(); j++) {
                Guisante p = filaGuisantes.get(i).get(j);
                p.avanza();
            }
        }

        for (int i = 0; i < solesActivos.size(); i++) {solesActivos.get(i).avanza();}
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

    private class PlantActionListener implements ActionListener {

        int x, y;

        public PlantActionListener(int x, int y) {
            this.x = x;
            this.y = y;
        }

        
        int vidaNuez=50;
        
        @Override
        public void actionPerformed(ActionEvent e) {
            if (pincelPlantaActiva == VentanaJuego.tipoPlanta.Girasol) {
                if (getpuntuacionSoles() >= vidaNuez) {
                    colisionadores[x + y * 9].setPlant(new Girasol(PanelJuego.this, x, y));
                    setPuntuacionSoles(getpuntuacionSoles() - vidaNuez);
                }
            }
            
            if (pincelPlantaActiva == VentanaJuego.tipoPlanta.Nuez) {
                if (getpuntuacionSoles() >= vidaNuez) {
                    colisionadores[x + y * 9].setPlant(new Nuez(PanelJuego.this, x, y));
                    setPuntuacionSoles(getpuntuacionSoles() - vidaNuez);
                }
            }
            
            if (pincelPlantaActiva == VentanaJuego.tipoPlanta.LanzaGuisantes) {
                if (getpuntuacionSoles() >= 100) {
                    colisionadores[x + y * 9].setPlant(new LanzaGuisantes(PanelJuego.this, x, y));
                    setPuntuacionSoles(getpuntuacionSoles() - 100);
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

    public VentanaJuego.tipoPlanta getActivePlantingBrush() {return pincelPlantaActiva;}

    public void setPincelPlantaActiva (VentanaJuego.tipoPlanta pincelPlantaActiva) {this.pincelPlantaActiva = pincelPlantaActiva;}

    public ArrayList<ArrayList<Zombi>> getLaneZombies() {return filaZombis;}

    public void setLaneZombies(ArrayList<ArrayList<Zombi>> filaZombis) {this.filaZombis = filaZombis;}

    public ArrayList<ArrayList<Guisante>> getLanePeas() {return filaGuisantes;}

    public void setLanePeas(ArrayList<ArrayList<Guisante>> filaGuisantes) {this.filaGuisantes = filaGuisantes;}

    public ArrayList<Sol> getsolesActivos() {return solesActivos;}

    public void setsolesActivos(ArrayList<Sol> solesActivos) {this.solesActivos = solesActivos;}

    public Colisionador[] getColliders() {return colisionadores;}

    public void setColliders(Colisionador[] colisionadores) {this.colisionadores = colisionadores;}
}
