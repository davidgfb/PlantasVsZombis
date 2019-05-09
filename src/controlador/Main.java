//@author David Gracia y Emmanuel Gbadegesin

package controlador;
import java.util.Scanner;
import modelo.Matriz;
import texto.pintaTablero;
public class Main {
    static String dificultad;
    static Matriz matriz= new Matriz(7,7);
    static pintaTablero tablero; 
    static boolean partidaCreada = false;
    
    static void capturaComandos() {
        Scanner escaner = new Scanner(System.in);
        System.out.print("Introduzca comandos: ");
        String comandosLinea = escaner.nextLine();
        String[] comandosPedidos = comandosLinea.split(" ");
        main(comandosPedidos);
    }
    static void creaPartida(int filas,int columnas,String dificultad) {
        //crea el objeto tablero.matriz para representar
        capturaComandos();
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
        String[] EXPRESIONESVALIDAS={"N","G","L","S","","ayuda"};
        String argumentoValidoEncontrado=null;
        for (String argumentoValido : EXPRESIONESVALIDAS) { //traduce el primer argumento a uno de la lista (minusculas-->mayusculas)
            if (expresion.equalsIgnoreCase(argumentoValido)) {argumentoValidoEncontrado=argumentoValido;}
        }
        return argumentoValidoEncontrado;
    }
    static int getEnteroValido(String expresion) {
        int entero=Integer.parseInt(expresion); //convierto expresion a entero //comprueba q expresion sea un entero
        return entero;
    }
    static String getDificultadValida(String expresion) {
        String[] NIVELESDIFICULTAD = {"BAJA","MEDIA","ALTA","IMPOSIBLE"};
        String dificultadEncontrada=null;
        for (String nivelDificultad : NIVELESDIFICULTAD) { //traduce el primer argumento a uno de la lista (minusculas-->mayusculas)
            if (expresion.equalsIgnoreCase(nivelDificultad)) {dificultadEncontrada=nivelDificultad;}
        }
        return dificultadEncontrada;
    }
    static void sal() {System.out.println("Metodo sal aun no implementado");}
    static void plantaGirasol() {
        if (!partidaCreada) {
            System.out.println("aun no ha iniciado la partida");
            capturaComandos();
        } 
        else {System.out.println("Metodo plantaGirasol aun no implementado");}
        //Girasol girasol = new Girasol();
    }
    static void plantaLanzaGuisantes() {
        if (!partidaCreada) {
            System.out.println("aun no ha iniciado la partida");
            capturaComandos();
        } 
        else {System.out.println("Metodo plantaLanzaGuisantes aun no implementado");}
    }
    static void ayuda() {
        System.out.println("Metodo ayuda aun no implementado");
        capturaComandos();
    }
    static void pasaTurno() {
        System.out.println("Metodo pasaTurno aun no implementado");
        tablero=new pintaTablero(matriz);
        capturaComandos();
    }
    
    public static void main (String[] argumentos) {
        try { //el usuario al menos debe introducir el primer argumento 
            String letra=getExpresionValida(argumentos[0]);
            if (letra == null) {throw new IllegalArgumentException();}
            if (letra.equalsIgnoreCase("")) {pasaTurno();} //Pulsa Enter
            if (letra.equalsIgnoreCase("ayuda")) {ayuda();} 
            else if (letra.equalsIgnoreCase("s")) {sal();}
            if (argumentos.length==3) {
                int filas= getEnteroValido(argumentos[1]);
                int columnas= getEnteroValido(argumentos[2]);
                if (letra.equalsIgnoreCase("g")) {plantaGirasol();}
                else if (letra.equalsIgnoreCase("l")) {plantaLanzaGuisantes();}
                else if (letra.equalsIgnoreCase("n")) {throw new IllegalArgumentException();}
            } 
            if (argumentos.length==4) {
                int filas= getEnteroValido(argumentos[1]);
                int columnas= getEnteroValido(argumentos[2]);
                String dificultad=getDificultadValida(argumentos[3]);
                if (dificultad == null) {throw new IllegalArgumentException();} 
                if (letra.equalsIgnoreCase("n")) {creaPartida(filas,columnas,dificultad);}
            }
        } catch (IllegalArgumentException|ArrayIndexOutOfBoundsException|NegativeArraySizeException excepcion) {
            System.out.println("Error: "+excepcion);
            capturaComandos(); 
        }
    }
}
    

