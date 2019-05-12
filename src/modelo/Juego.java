package modelo;

import static controlador.Main.juego;
import texto.Tablero;

public class Juego {
    static public int turnosRepartosZombis=30,zombisPartida,turnosInicialesSinZombis, turno=0;
    boolean apareceZombi=true;
    public static boolean partidaCreada = false, noTerminada=true;
    public static Tablero tablero;
    
    static public void reiniciaAtributos() {Juego.turno=0;}
    
    public static void pasaTurno() {tablero.Tablero();}
    
    public static void creaPartida(int filas,int columnas, String dificultad) {
        Juego.partidaCreada=true;
        new Matriz(filas,columnas); //crea el objeto tablero.matriz para representar
        new Tablero();
        juego = new Juego(dificultad);
        Girasol.reiniciaAtributos();
        Juego.reiniciaAtributos();
    }
    
    public Juego(String dificultadJuego) {
        if (dificultadJuego.equalsIgnoreCase("baja")) {
            zombisPartida=5;
            turnosInicialesSinZombis=10;
        }
        else if (dificultadJuego.equalsIgnoreCase("media")) {
            zombisPartida=15;
            turnosInicialesSinZombis=7;
        }
        else if (dificultadJuego.equalsIgnoreCase("alta")) {
            zombisPartida=25;
            turnosInicialesSinZombis=5;
        }
        else if (dificultadJuego.equalsIgnoreCase("imposible")) {
            zombisPartida=50;
            turnosInicialesSinZombis=5;
        }
        System.out.println(toString());
    }
    
    @Override
    public String toString() {return "Juego {turnosRepartosZombis: "+turnosRepartosZombis+", zombisPartida: "+zombisPartida+", turnosInicialesSinZombis: "+turnosInicialesSinZombis+"}";}
}
