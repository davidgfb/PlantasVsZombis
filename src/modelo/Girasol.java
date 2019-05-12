package modelo;

public class Girasol extends Planta {
    static int soles = 0, cantidad= 0;

    static public void reiniciaAtributos() {
        Girasol.cantidad=0;
        Girasol.soles=0;
    }

    public Girasol(int fila,int columna) {
        super(fila,columna,"G(1)");
        cantidad+=1;
    }
    
    static public int getSoles() {
        soles+=cantidad;
        return soles;
    }
}

