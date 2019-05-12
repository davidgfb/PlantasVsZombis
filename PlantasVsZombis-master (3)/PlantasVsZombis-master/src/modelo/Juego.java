package modelo;

public class Juego {
    static public int turnosRepartosZombis=30,zombisPartida,turnosInicialesSinZombis;
    boolean apareceZombi=true;
    static public int turno;
    
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
