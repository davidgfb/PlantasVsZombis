//@author David
package modelo;
import texto.*;
public class Main {
    public static void main (String[] args) {
        int filas=7;  
        int columnas=7;
        int i=0;
        //excepcion si filas negativo
        if (filas<0) {filas=0;}
        //MATRIZ JUEGO
        //crea el objeto juego
        Juego juego = new Juego(); 
        //inicializa la matriz filasxcolumnas
        juego.setMatriz(filas,columnas);
        //cambia todos los elementos null de la matriz por numeros 0-9
        for (int fila=0;fila<filas;fila++) {
            for (int columna=0;columna<columnas;columna++) {
                if (i>9) {i=0;}
                String j=Integer.toString(i);
                juego.setElemento(fila,columna,j);
                i++;
            }
        }
        //pinta la matriz en forma de fila
        //for (int j=0;j<juego.getMatrizElementos();j++) {System.out.print(juego.getSiguienteElemento());}
        //System.out.println();
        //TEXTO MATRIZ
        //crea el objeto texto.matriz para representar
        Matriz matriz = new Matriz();  
        //pinta la matriz en texto
        //matriz.pintaMatriz(juego.getMatriz());
        //TABLERO
        //crea el objeto tablero.matriz para representar  
        Tablero tablero = new Tablero();
        tablero.pintaTablero(filas,columnas,juego);
    }
}
    

