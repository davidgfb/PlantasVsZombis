public abstract class Planta {

    private int health = 200,x,y;

    private PanelJuego gp;

    public Planta(PanelJuego parent, int x, int y) {
        this.x = x;
        this.y = y;
        gp = parent;
    }

    public void stop() {}

    public int getHealth() {return health;}

    public void setHealth(int health) {this.health = health;}

    public int getX() {return x;}

    public void setX(int x) {this.x = x;}

    public int getY() {return y;}

    public void setY(int y) {this.y = y;}

    public PanelJuego getGp() {return gp;}

    public void setGp(PanelJuego gp) {this.gp = gp;}
}
