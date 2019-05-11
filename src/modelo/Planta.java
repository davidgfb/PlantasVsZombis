package modelo;
import controlador.Main; 

public abstract class Planta {
    public static Girasol[] girasoles;
    public static Lanzaguisantes[] grupoLanzaguisantes;

    public Planta(int fila,int columna,String planta) {Matriz.setElemento(fila,columna,planta);}
    
    public static void planta(String planta,int fila,int columna) {
        if (Main.partidasCreadas==0) {System.out.println("aun no ha iniciado la partida");} 
        else {
            if (!Matriz.getOcupado(fila, columna, planta)) { 
                if (planta.equalsIgnoreCase("girasol")) {
                    Girasol girasol = new Girasol(fila,columna);
                    girasoles[Girasol.cantidad]=girasol;
                } 
                else {
                    Lanzaguisantes lanzaguisantes = new Lanzaguisantes(fila,columna);
                    grupoLanzaguisantes[Lanzaguisantes.cantidad]=lanzaguisantes;
                }
                Main.tablero.Tablero();
            } else {System.out.println("Casilla ocupada: por favor escoja otra");}
        }
    }
}
