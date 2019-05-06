//@author David
package controlador;
import java.util.Scanner;
import modelo.Matriz;
import texto.pintaTablero;
public class Main {
    private static boolean partidaCreada=false;
    public static void main (String[] argumentos) {
        try {
            //getLetraValida(argumentos[0]);
            getEnteroValido(argumentos[1]);
            getEnteroValido(argumentos[2]);
            
        } catch (IllegalArgumentException|ArrayIndexOutOfBoundsException|NegativeArraySizeException excepcion) {
            System.out.println("Error: "+excepcion);
            capturaComandos(); 
        }
        
        /*try { //el usuario al menos debe introducir el primer argumento //Pulsa Enter
            if (compruebaPrimerArgumentoValido(argumentos[0]).equalsIgnoreCase("")) {PasaTurno();} 
            if (!compruebaPrimerArgumentoValido(argumentos[0]).equalsIgnoreCase("s")) { //es distinto de s
                int filas=Integer.parseInt(argumentos[1]); //convierto filas y columnas (String) a enteros
                int columnas=Integer.parseInt(argumentos[2]);
                if (filas==(int)filas && columnas==(int)columnas) { //comprueba q filas y columnas sean enteros

                }
            }
        }
        catch(IllegalArgumentException|ArrayIndexOutOfBoundsException|NegativeArraySizeException excepcion){
            System.out.println("Error: "+excepcion);
            capturaComandos(); 
        }
        if (PrimerArgumento.equals("N")) { //el usuario ha introducido una N
            int filas=Integer.parseInt(argumentos[1]); //convierto filas y columnas (String) a enteros
            int columnas=Integer.parseInt(argumentos[2]);
            if (!partidaCreada) { //si es la primera vez que ejecutamos el juego | solo se hace una vez
                if (filas==(int)filas && columnas==(int)columnas) { //comprueba q filas y columnas sean enteros
                    String[] nivelesDificultad = {"BAJA","MEDIA","ALTA","IMPOSIBLE"};
                    String dificultad=argumentos[3].toUpperCase();
                    Boolean dificultadEncontrada=false;
                    for (String nivelDificultad : nivelesDificultad) {
                        if (dificultad.equals(nivelDificultad)) {
                            dificultadEncontrada=true;
                            CreaPartida(filas,columnas);
                        }
                    }
                    if (!dificultadEncontrada) {throw new IllegalArgumentException();} //el usuario no ha introducido bien la dificultad | al menos 1 vez no sustituir por elsedwa
                } //reinicia la partida
            } else {CreaPartida(filas,columnas);}
        } else {
            if (PrimerArgumento.equals("G")) {

            } else {
                if (PrimerArgumento.equals("L")) {

                } else { //el usuario ha pulsado Enter 
                    if (PrimerArgumento.equals("")) {
                        //PasaTurno();
                    } else {
                        if (PrimerArgumento.equals("S")) {

                        } 
                    }   
                }
            }
        } */
        
    }
    static void capturaComandos () {
        Scanner escaner = new Scanner(System.in);
        System.out.print("Introduzca comandos: ");
        String comandosLinea = escaner.nextLine();
        String[] comandosPedidos = comandosLinea.split(" ");
        main(comandosPedidos);
    }
    static void creaPartida(int filas,int columnas) {
        Matriz matriz = new Matriz(filas,columnas);
        //Girasol girasol = new Girasol();
        //RellenaMatriz();
        pintaTablero tablero = new pintaTablero(filas,columnas,matriz); //TABLERO | crea el objeto tablero.matriz para representar
        partidaCreada=true;
        capturaComandos();
    }
    static void pasaTurno() {
        System.out.println("Caracteristica PasaTurno aun no implementada");
    }
    void rellenaMatriz () {
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
    static String getExpresionValida(String expresion) {
        String[] EXPRESIONESVALIDAS={"N","G","L","S",""};
        String argumentoValidoEncontrado=null;
        for (String argumentoValido : EXPRESIONESVALIDAS) { //traduce el primer argumento a uno de la lista (minusculas-->mayusculas)
            if (expresion.equalsIgnoreCase(argumentoValido)) {argumentoValidoEncontrado=argumentoValido;}
        }   
        if (argumentoValidoEncontrado == null) {throw new IllegalArgumentException();}
        return argumentoValidoEncontrado;
    }
    static int getEnteroValido(String expresion) {
        int entero=Integer.parseInt(expresion); //convierto expresion a entero //comprueba q expresion sea un entero
        return entero;
    }
}
    

