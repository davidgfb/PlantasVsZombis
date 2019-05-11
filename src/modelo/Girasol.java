package modelo;

public class Girasol extends Planta {
    static int vida = 130,DANNO = 35,FRECUENCIA = 25,soles = 0,cantidad=0;
    String TIPO = "Girasol",GRAFICOS = "G";

    //public Girasol(int vida, int danno, int frecuencia, String tipo, String graficos, int soles) {super(vida, danno, frecuencia, tipo, graficos, soles);}

    //public Girasol(int vida, int danno, int frecuencia, String tipo, String graficos, int soles) { super(vida, danno, frecuencia, tipo, graficos, soles);}

    public Girasol(int fila,int columna) {
        super(fila,columna,"G");
        cantidad+=1;
    }
    
    static public int getSoles() {
        soles+=cantidad;
        return soles;
    }
}

