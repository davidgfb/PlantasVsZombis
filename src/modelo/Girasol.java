package modelo;

public class Girasol extends Planta {
    static int vida = 1,DANNO = 0,FRECUENCIA = 2,soles = 0,cantidad= 0, coste = 20;
    String TIPO = "Girasol",GRAFICOS = "G";

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

