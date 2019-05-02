//@author David
package controlador;
import java.util.Scanner;
import modelo.Matriz;
import texto.pintaTablero;
import modelo.Girasol;
public class Main {
    public static void main (String[] argumentos) {
        try {
            pintaTablero tablero;
            Matriz matriz;
            String NMayuscula=argumentos[0].toUpperCase();
            if (NMayuscula.equals("N")) {
                int filas=Integer.parseInt(argumentos[1]); //convierto filas y columnas (String) a enteros
                int columnas=Integer.parseInt(argumentos[2]);
                if (filas==(int)filas && columnas==(int)columnas) { //comprueba q filas y columnas sean enteros
                    String[] nivelesDificultad = {"BAJA","MEDIA","ALTA","IMPOSIBLE"};
                    String dificultad=argumentos[3].toUpperCase();
                    Boolean dificultadEncontrada=false;
                    for (String nivelDificultad : nivelesDificultad) {
                        if (dificultad.equals(nivelDificultad)) {
                        dificultadEncontrada=true;
                        matriz = new Matriz(filas,columnas);
                        //Girasol girasol = new Girasol();
                        //RellenaMatriz();
                        tablero = new pintaTablero(filas,columnas,matriz); //TABLERO | crea el objeto tablero.matriz para representar
                        }
                    }
                    if (!dificultadEncontrada) {throw new IllegalArgumentException();} //el usuario no ha introducido bien la dificultad | al menos 1 vez no sustituir por else
                    else {
                    //tablero.pintaTablero(filas,columnas,matriz);
                    } //empieza turno 2 
                }
            } else {throw new IllegalArgumentException();} //el usuario no ha introducido una N
        }
        catch(IllegalArgumentException|ArrayIndexOutOfBoundsException|NegativeArraySizeException excepcion){
            System.out.println("Error: "+excepcion);
            capturaComandos(); //pide a entra que capture los comandos y se los lance a main
        }
    }
    static void capturaComandos () {
        Scanner escaner = new Scanner(System.in);
        System.out.print("Repita comandos: ");
        String comandosLinea = escaner.nextLine();
        String[] comandosArray = comandosLinea.split(" ");
        main(comandosArray);
    }
    void RellenaMatriz () {
        /*int numero0_9=0; //cambia todos los elementos null de la matriz por numeros 0-9
        for (int fila=0;fila<filas;fila++) {
            for (int columna=0;columna<columnas;columna++) {
              if (numero0_9>9) {numero0_9=0;}//reseteo numero 0-9
              String cadena=Integer.toString(numero0_9);//convierto el numero a String para representar
              matriz.setElemento(fila,columna,cadena);
              numero0_9++;
            }
        } //Le esta pasando el objeto matriz */
    }
}
    

