package modelo; 

public abstract class Planta extends Personaje {
    public static Girasol[] girasoles;
    public static Lanzaguisantes[] grupoLanzaguisantes;
    static public int frecuencia,vida,danno,coste,soles,graficos,estado = 0; //añade soles y coste 
    boolean ataca;
    static public String tipo;
    
    public Planta(int fila,int columna,String planta) {
        super(fila,columna,planta);
        this.coste = 50;
    }
    
    public void reseteaEstado() {this.estado = 0;}
    
    public void incrementaEstado(){this.estado++;}
    
    public void reseteaTiempoCarga() {this.frecuencia = 0;}
    
    public void incrementaTiempoCarga(){this.frecuencia++;}
    
    public void getCoste(String objeto){ //proceso para restar coste al numero de soles en posesión 
        if(objeto.equals("L")){
            tipo = "L";
            soles = soles - Lanzaguisantes.coste;} 
        else {
            tipo = "G";
            soles = soles - Girasol.coste;}
    }
    
    public int getEstado() {
        this.estado = vida; 
        return this.estado;
    }
    
    public static void planta(String planta,int fila,int columna) {
        if (!Juego.partidaCreada) {System.out.println("Aún no ha iniciado la partida");} 
        else {
            if (!Matriz.getOcupado(fila, columna)) { 
                if (planta.equalsIgnoreCase("girasol")) {
                    Girasol girasol = new Girasol(fila,columna);
                    girasoles[Girasol.cantidad]=girasol;
                } 
                else {
                    Lanzaguisantes lanzaguisantes = new Lanzaguisantes(fila,columna);
                    grupoLanzaguisantes[Lanzaguisantes.cantidad]=lanzaguisantes;
                }
                Juego.tablero.Tablero();
            } else {System.out.println("Casilla ocupada: por favor escoja otra");}
        }
    }
}
