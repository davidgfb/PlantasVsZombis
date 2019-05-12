package modelo;
import java.util.Random;

public class Zombi extends Personaje {
    static int fila=new Random().nextInt(Matriz.getMatrizNumeroFilas())+1, columna=Matriz.getMatrizNumeroColumnas();
    static boolean avanza=false;
    static public String tipoZombi = "Z";
    static int filaActual=0, columnaActual=0;
    static int vidaZombi;
    
    static int generaFilaValida() {
        while (Matriz.getOcupado(fila,columna)) {fila=new Random().nextInt(Matriz.getMatrizNumeroFilas())+1;}
        return fila; 
    } 
    
    public static void generaZombis() {
            new Zombi();
            Zombi.eligeGanador();
            Zombi.avanza();
    }
    
    static public void eligeGanador() { //si hay columna a su izquierda
        if (columna-1<=0) {
            System.out.println("Zombis ganan!");
            Juego.noTerminada=false;
        }
    }
    
    public Zombi() {super(generaFilaValida(),columna,"Z(5)");}
    
    static public void avanza() {
        if (avanza) {
            posicionZombi();
            mueveZombi();
            avanza=!avanza;
        }
        avanza=!avanza;
    }
    
    static void posicionZombi() {
        for (String[] fila : Matriz.matriz) {
            filaActual++;
            for (String columna : fila) {
                if (columnaActual<=Matriz.getMatrizNumeroColumnas()) {columnaActual++;}
                if(columna!=null && columna.equalsIgnoreCase("Z(5)")) {
                    System.out.println("Fila: "+filaActual+", columna: "+columnaActual);
                }
            }
            columnaActual=1;
        }
    }
    
    static void mueveZombi() {
        Matriz.setElemento(filaActual,columnaActual,null); //hace desaparecer zombi
        Matriz.setElemento(filaActual,columnaActual-1,"Z(5)");
    }
}
