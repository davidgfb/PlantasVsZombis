public abstract class Planta {

    private int salud = 200,x,y;

    private PanelJuego panelJuego;

    public Planta(PanelJuego padre, int x, int y) {
        this.x = x;
        this.y = y;
        panelJuego = padre;
    }

    public void para() {}

    public int getSalud() {return salud;}

    public void setSalud(int salud) {this.salud = salud;}

    public int getX() {return x;}

    public void setX(int x) {this.x = x;}

    public int getY() {return y;}

    public void setY(int y) {this.y = y;}

    public PanelJuego getPanelJuego() {return panelJuego;}

    public void setPanelJuego(PanelJuego panelJuego) {this.panelJuego = panelJuego;}
}
