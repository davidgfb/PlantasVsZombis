package modelo;


import graficos.PanelJuego;

public class ZombiCabezaCono extends Zombi {

    public ZombiCabezaCono(PanelJuego padre, int fila) {
        super(padre, fila);
        setSalud(1800);
    }
}
