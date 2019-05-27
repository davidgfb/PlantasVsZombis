package modelo;


import graficos.PanelJuego;

public abstract class Planta extends Personaje {

    private int salud, x, y;

    PanelJuego panelJuego;

    public Planta(PanelJuego padre, int x, int y, int salud) {
        super(salud);
        this.x = x;
        this.y = y;
        this.salud=salud;
        panelJuego = padre;
    }

    public void para() {}

    //public int getSalud() {return salud;}
    
    public void setSalud(int salud) {this.salud = salud;}

    public int getX() {return x;}

    public void setX(int x) {this.x = x;}

    public int getY() {return y;}

    public void setY(int y) {this.y = y;}

    public PanelJuego getPanelJuego() {return panelJuego;}

    public void setPanelJuego(PanelJuego panelJuego) {this.panelJuego = panelJuego;}
}
