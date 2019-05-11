package modelo;

public class Girasol extends Planta {
    static int soles = 0, cantidad=0;

    public Girasol(int fila,int columna) {
        super(fila,columna,"G");
        cantidad+=1;
    }
    
    static public int getSoles() {
        soles+=cantidad;
        return soles;
    }
    
    public static void reseteaAtributos() {
        for (Girasol girasol : Planta.girasoles) {
            girasol.soles=0;
            girasol.cantidad=0;
        }
    }
}

