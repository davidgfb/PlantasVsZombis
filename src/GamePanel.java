import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.Random;

public class GamePanel extends JLayeredPane implements MouseMotionListener {

    private Image bgImage,peashooterImage,sunflowerImage,peaImage,nuez,
            normalZombieImage,coneHeadZombieImage;
    
    private Collider[] colliders;

    private ArrayList<ArrayList<Zombie>> laneZombies;
    private ArrayList<ArrayList<Pea>> lanePeas;
    private ArrayList<Sun> activeSuns;

    private Timer redrawTimer,advancerTimer,sunProducer,zombieProducer;
    private JLabel sunScoreboard;

    private GameWindow.PlantType activePlantingBrush = GameWindow.PlantType.None;

    private int mouseX, mouseY,sunScore;

    public int getSunScore() {return sunScore;}

    public void setSunScore(int sunScore) {
        this.sunScore = sunScore;
        sunScoreboard.setText(String.valueOf(sunScore));
    }

    public GamePanel(JLabel sunScoreboard) {
        setSize(1000, 752);
        setLayout(null);
        addMouseMotionListener(this);
        this.sunScoreboard = sunScoreboard;
        setSunScore(150);  //pool avalie

        bgImage = new ImageIcon(this.getClass().getResource("images/mainBG.png")).getImage();

        nuez = new ImageIcon(this.getClass().getResource("images/plants/nuez.gif")).getImage();
        
        peashooterImage = new ImageIcon(this.getClass().getResource("images/plants/peashooter.gif")).getImage();
        sunflowerImage = new ImageIcon(this.getClass().getResource("images/plants/sunflower.gif")).getImage();

        normalZombieImage = new ImageIcon(this.getClass().getResource("images/zombies/zombie1.png")).getImage();
        coneHeadZombieImage = new ImageIcon(this.getClass().getResource("images/zombies/zombie2.png")).getImage();

        laneZombies = new ArrayList<>();
       
        lanePeas = new ArrayList<>();
        
        for (int i=0;i<5;i++) { //1 por linea
            laneZombies.add(new ArrayList<>()); 
            lanePeas.add(new ArrayList<>());
        }

        colliders = new Collider[45];
        
        for (int i = 0; i < 45; i++) {
            Collider a = new Collider();
            a.setLocation(44 + (i % 9) * 100, 109 + (i / 9) * 120);
            a.setAction(new PlantActionListener((i % 9), (i / 9)));
            colliders[i] = a;
            add(a, new Integer(0));
        }

        activeSuns = new ArrayList<>();

        redrawTimer = new Timer(25, (ActionEvent e) -> {repaint();});
        redrawTimer.start();

        advancerTimer = new Timer(60, (ActionEvent e) -> advance());
        advancerTimer.start();

        sunProducer = new Timer(5000, (ActionEvent e) -> {
            Random rnd = new Random();
            Sun sta = new Sun(this, rnd.nextInt(800) + 100, 0, rnd.nextInt(300) + 200);
            activeSuns.add(sta);
            add(sta, new Integer(1));
        });
        sunProducer.start();

        zombieProducer = new Timer(7000, (ActionEvent e) -> {
            Random rnd = new Random();
            LevelData lvl = new LevelData();
            String[] Level = lvl.LEVEL_CONTENT[Integer.parseInt(lvl.LEVEL_NUMBER) - 1];
            int[][] LevelValue = lvl.LEVEL_VALUE[Integer.parseInt(lvl.LEVEL_NUMBER) - 1];
            int l = rnd.nextInt(5);
            int t = rnd.nextInt(100);
            Zombie z = null;
            for (int i = 0; i < LevelValue.length; i++) {
                if (t >= LevelValue[i][0] && t <= LevelValue[i][1]) {z = Zombie.getZombie(Level[i], GamePanel.this, l);}
            }
            laneZombies.get(l).add(z);
        });
        zombieProducer.start();

    }

    private void advance() {
        for (int i = 0; i < 5; i++) {
            for (Zombie z : laneZombies.get(i)) {z.advance();}

            for (int j = 0; j < lanePeas.get(i).size(); j++) {
                Pea p = lanePeas.get(i).get(j);
                p.advance();
            }
        }

        for (int i = 0; i < activeSuns.size(); i++) {activeSuns.get(i).advance();}
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(bgImage, 0, 0, null);

        //Dibuja plantas
        for (int i = 0; i < 45; i++) {
            Collider c = colliders[i];
            if (c.assignedPlant != null) {
                Plant p = c.assignedPlant;
                if (p instanceof Peashooter) {g.drawImage(peashooterImage, 60 + (i % 9) * 100, 129 + (i / 9) * 120, null);}
                
                if (p instanceof Nuez) {g.drawImage(nuez, 60 + (i % 9) * 100, 129 + (i / 9) * 120, null);}
                
                if (p instanceof Sunflower) {g.drawImage(sunflowerImage, 60 + (i % 9) * 100, 129 + (i / 9) * 120, null);}
            }
        }

        for (int i = 0; i < 5; i++) {
            for (Zombie z : laneZombies.get(i)) {
                if (z instanceof NormalZombie) {g.drawImage(normalZombieImage, z.getPosX(), 109 + (i * 120), null);} 
                else if (z instanceof ConeHeadZombie) {g.drawImage(coneHeadZombieImage, z.getPosX(), 109 + (i * 120), null);}
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
            if (activePlantingBrush == GameWindow.PlantType.Sunflower) {
                if (getSunScore() >= vidaNuez) {
                    colliders[x + y * 9].setPlant(new Sunflower(GamePanel.this, x, y));
                    setSunScore(getSunScore() - vidaNuez);
                }
            }
            
            if (activePlantingBrush == GameWindow.PlantType.Nuez) {
                if (getSunScore() >= vidaNuez) {
                    colliders[x + y * 9].setPlant(new Nuez(GamePanel.this, x, y));
                    setSunScore(getSunScore() - vidaNuez);
                }
            }
            
            if (activePlantingBrush == GameWindow.PlantType.Peashooter) {
                if (getSunScore() >= 100) {
                    colliders[x + y * 9].setPlant(new Peashooter(GamePanel.this, x, y));
                    setSunScore(getSunScore() - 100);
                }
            }

            activePlantingBrush = GameWindow.PlantType.None;
        }
    }

    @Override
    public void mouseDragged(MouseEvent e) {}

    @Override
    public void mouseMoved(MouseEvent e) {
        mouseX = e.getX();
        mouseY = e.getY();
    }

    public GameWindow.PlantType getActivePlantingBrush() {return activePlantingBrush;}

    public void setActivePlantingBrush(GameWindow.PlantType activePlantingBrush) {this.activePlantingBrush = activePlantingBrush;}

    public ArrayList<ArrayList<Zombie>> getLaneZombies() {return laneZombies;}

    public void setLaneZombies(ArrayList<ArrayList<Zombie>> laneZombies) {this.laneZombies = laneZombies;}

    public ArrayList<ArrayList<Pea>> getLanePeas() {return lanePeas;}

    public void setLanePeas(ArrayList<ArrayList<Pea>> lanePeas) {this.lanePeas = lanePeas;}

    public ArrayList<Sun> getActiveSuns() {return activeSuns;}

    public void setActiveSuns(ArrayList<Sun> activeSuns) {this.activeSuns = activeSuns;}

    public Collider[] getColliders() {return colliders;}

    public void setColliders(Collider[] colliders) {this.colliders = colliders;}
}
