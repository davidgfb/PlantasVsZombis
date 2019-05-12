package modelo;
import controlador.Main;
import java.util.Random;

public class Zombi extends Personaje {
    static int fila=new Random().nextInt(Matriz.getMatrizNumeroFilas())+1;
    static int columna=Matriz.getMatrizNumeroColumnas();
    boolean avanza=false, puedeAvanzar=true;
    
    static int generaFilaValida() {
        while (Matriz.getOcupado(fila,columna)) {fila=new Random().nextInt(Matriz.getMatrizNumeroFilas())+1;}
        return fila; 
    } 
    
    static public void eligeGanador() { //si hay columna a su izquierda
        if (columna-1<=0) {
            System.out.println("Zombis ganan!");
            Main.noTerminada=false;
        }
    }
    
    public Zombi() {super(generaFilaValida(),columna,"Z(5)");}
}
