package modelo;
import controlador.Main;
import java.util.Random;

public class Zombi extends Personaje {
    static int fila=new Random().nextInt(Matriz.getMatrizNumeroFilas())+1;
    static int columna=Matriz.getMatrizNumeroColumnas();
    static boolean avanza=false;
    static public String tipoZombi = "Z";
    
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
    
    static public void avanza() {
        if (avanza) {
            mueveElementos();
            avanza=!avanza;
        }
        avanza=!avanza;
    }
    
    static void mueveElementos() {
        /*int posicionActual=0;
        for (String elemento : Matriz.vector) {
            posicionActual++; //cuenta posiciones
            if(elemento!=null && elemento.equalsIgnoreCase("Z(5)")) {
                int filaActual=Math.round(posicionActual/Matriz.getMatrizNumeroColumnas());
                int columnaActual=Math.round(posicionActual/filaActual);
                
                System.out.println("fila actual: "+filaActual+", columna actual: "+columnaActual);
                Matriz.setElemento(filaActual,columnaActual,null); //hace desaparecer zombi
                Matriz.setElemento(filaActual,columnaActual-1,elemento);
            }
        }*/
        int filaActual=0, columnaActual=0;
        
        for (String[] fila : Matriz.matriz) {
            filaActual++;
            for (String columna : fila) {
                columnaActual++;
                if (columnaActual>Matriz.getMatrizNumeroColumnas()) {columnaActual=0;}
                if(columna!=null && columna.equalsIgnoreCase("Z(5)")) {
                    System.out.println("Fila: "+filaActual+", columna: "+columnaActual);
                }
            }
        }
    }
}
