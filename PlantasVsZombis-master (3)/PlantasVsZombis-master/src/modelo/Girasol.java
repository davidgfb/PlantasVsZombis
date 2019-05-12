package modelo;

public class Girasol extends Planta {
    static int soles = 0,cantidad= 0, vida =1;
    static String tipo = "G"; 

    public Girasol(int fila,int columna) {
        super(fila,columna,"G"+"("+vida+")");
        cantidad+=1;
    }
    
    static public int getSoles() {
        soles+=cantidad;
        return soles;
    }
}

