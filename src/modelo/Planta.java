package modelo;
import controlador.Main; 

public abstract class Planta extends Personaje {
    public static Girasol[] girasoles;
    public static Lanzaguisantes[] grupoLanzaguisantes;
    static public int frecuencia,vida,danno,coste,soles,tipo,graficos,estado = 0; //añadido soles y coste 
    boolean ataca;

    public Planta(int fila,int columna,String planta) {
        super(fila,columna,planta);
        this.coste = 50;
    }
    
    public void reseteaEstado() {this.estado = 0;}
    
    public void incrementaEstado(){this.estado++;}
    
    public void reseteaTiempoCarga() {this.frecuencia = 0;}
    
    public void incrementaTiempoCarga(){this.frecuencia++;}
    
    public void getCoste(String tipo){ //proceso para restar coste al numero de soles en posesión 
        if(tipo.equals("L")){soles = soles - Lanzaguisantes.coste;} 
        else {soles = soles - Girasol.coste;}
    }
    
    public int getEstado() {
        this.estado = vida; 
        return this.estado;
    }
    
    public static void planta(String planta,int fila,int columna) {
        if (Main.partidasCreadas==0) {System.out.println("Aún no ha iniciado la partida");} 
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
