//@author David Gracia y Emmanuel Gbadegesin

package controlador;
import java.util.Scanner;
import modelo.Matriz;
import modelo.Planta;
import texto.Tablero;
import modelo.Juego;
import modelo.Zombi;

public class Main {
    public static int partidasCreadas = 0; 
    public static boolean noTerminada=true;
    public static Matriz matriz;
    public static Tablero tablero;
    public static Juego juego;
    
    static void capturaComandos() {
        while (noTerminada) {
            Scanner escaner = new Scanner(System.in);
            System.out.println("Introduzca comandos: ");
            String comandosLinea = escaner.nextLine();
            String[] comandosPedidos = comandosLinea.split(" ");
            main(comandosPedidos);
            generaZombis();
            Zombi.eligeGanador();
        }
    }
    
    static void generaZombis() {
        if (Juego.turno>=Juego.turnosInicialesSinZombis) {new Zombi();}
    }
    
    static void creaPartida(int filas,int columnas, String dificultad) {
        partidasCreadas++;
        matriz = new Matriz(filas,columnas); //crea el objeto tablero.matriz para representar
        tablero = new Tablero();
        juego = new Juego(dificultad);
    }
    
    static String getExpresionValida(String expresion,int tipo) {
        String[] EXPRESIONESVALIDAS=new String[6];
        if (tipo==0) {EXPRESIONESVALIDAS = new String[] {"N","G","L","S","","ayuda"};}
        else if (tipo==3) {EXPRESIONESVALIDAS= new String[] {"BAJA","MEDIA","ALTA","IMPOSIBLE","BAJA","MEDIA"};}
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
    
    static void sal() {
        noTerminada=false;
        System.out.println("Gracias por jugar");
    }
    
    static void ayuda() {System.out.println("Lista de comandos:\n____________________________________________________________\nN <filas> <columnas> <Dificultad>: Nueva partida (Dificultad: BAJA, MEDIA, ALTA, IMPOSIBLE\nG <fila> <columna>: colocar girasol.\nL <fila> <columna>: colocar LanzaGuisantes\n\nÚnicamente se podrá añadir un nueva planta de cada tipo por turno y si tiene el número suficiente de soles. No podrá añadir nuecvas plantas en una casilla ocupada por otra planta o por un zombie\nS: Salir de la aplicación.\nEnter pasar de turno \nayuda: este comando solicita a la aplicación que muestre la ayuda sobre cómo utilizar los comandos.");}
    
    static void pasaTurno() {tablero.Tablero();}
    
    public static void main (String[] argumentos) {
        try { //el usuario al menos debe introducir el primer argumento 
            String letra=getExpresionValida(argumentos[0],0);
            if (letra == null) {throw new IllegalArgumentException();}
            if (letra.equalsIgnoreCase("")) {pasaTurno();} //Pulsa Enter
            if (letra.equalsIgnoreCase("ayuda")) {ayuda();} 
            else if (letra.equalsIgnoreCase("s")) {sal();}
            if (argumentos.length==3) {
                int filas= getEnteroValido(argumentos[1]);
                int columnas= getEnteroValido(argumentos[2]);
                if (letra.equalsIgnoreCase("g")) {Planta.planta("Girasol",filas,columnas);}
                else if (letra.equalsIgnoreCase("l")) {Planta.planta("Lanzaguisantes",filas,columnas);}
                else if (letra.equalsIgnoreCase("n")) {throw new IllegalArgumentException();}
            } 
            if (argumentos.length==4) {
                int filas= getEnteroValido(argumentos[1]);
                int columnas= getEnteroValido(argumentos[2]);
                String dificultad=getExpresionValida(argumentos[3],3);
                if (dificultad == null) {throw new IllegalArgumentException();} 
                if (letra.equalsIgnoreCase("n")) {
                    if (filas*columnas<=0) {throw new IllegalArgumentException();}
                    creaPartida(filas,columnas,dificultad);
                }
            }
        } catch (Exception excepcion) {
            System.out.println("Error: "+excepcion);
            capturaComandos(); 
        }
    }
}
    


    

