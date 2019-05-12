package modelo;
import controlador.Main;
import java.util.Random;

public class Zombi extends Personaje {
    static int fila=new Random().nextInt(Matriz.getMatrizNumeroFilas())+1;
    
    static public String tipoZombi = "Z";
    static public int vidaZombie = 5;
            
    static int columna=Matriz.getMatrizNumeroColumnas();
    boolean avanza=false, puedeAvanzar=true;
    
    public Zombi() {super(generaFilaValida(),columna,"Z"+"("+vidaZombie+")");} //variables definidas
    
    static public void eligeGanador() { //si hay columna a su izquierda
        if (columna <=0) { 
            System.out.println("Zombis ganan!");
            Main.noTerminada=false;
        }
    }
    
    static int generaFilaValida() {
        while (Matriz.getOcupado(fila,columna)) {fila=new Random().nextInt(Matriz.getMatrizNumeroFilas())+1;}
        return fila; 
    } 
}
