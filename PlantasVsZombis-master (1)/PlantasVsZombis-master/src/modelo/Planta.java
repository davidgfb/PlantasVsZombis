package modelo;
import modelo.Girasol;
import modelo.Lanzaguisantes;
import controlador.Main;

public abstract class Planta {
    static public int frecuencia,vida,danno,coste,soles,tipo,graficos,estado = 0; //añadido soles y coste 
    boolean ataca;

    public Planta(int fila,int columna,String planta) {
        Matriz.setElemento(fila,columna,planta);
        this.coste = 50; 
    }
    
    // Setters
    public void reseteaEstado() {this.estado = 0;}
    
    public void incrementaEstado(){this.estado++;}
    
    public void reseteaTiempoCarga() {this.frecuencia = 0;}
    
    public void incrementaTiempoCarga(){this.frecuencia++;}
    
    public void getCoste(String tipo){ //proceso para restar coste al numero de soles en posesión 
        if(tipo.equals("L")){
          soles = soles - Lanzaguisantes.coste; 
          
        }else{
            soles = soles - Girasol.coste; 
        }
        
    }

    // Getters
    
    
    public int getEstado() {
        this.estado = vida; 
        
        return this.estado;}
    
    //public boolean Compra(int soles) {return this.estado == this.soles || soles >= this.soles;}
    
    public static void planta(String planta,int fila,int columna) {
        if (!Main.partidaCreada) {System.out.println("aun no ha iniciado la partida");} 
        else {
            if (!Matriz.getOcupado(fila, columna, planta)) { 
                if (planta.equalsIgnoreCase("girasol")) {Planta girasol = new Girasol(fila,columna);} 
                else {Planta lanzaGuisantes = new Lanzaguisantes(fila,columna);}
                Main.tablero.pintaTablero();
            } else {System.out.println("Casilla ocupada: por favor escoja otra");}
        }
    }

    // Threading
    //@Override
    public void corre() {
        /*zombies ataca = this.university.frontStudent(this.arrX, this.arrY);

        while(this.vida != 0 && this.university.isActive()) {
            if(ataca != null) {
                this.ataque(ataca);
                //this.university.elementRemover();
                //this.university.log();

                //if(this.puntosDanno != 0) {ataca.indicateAttacked();} // check if incurred damage

                try {Thread.sleep(100 * this.velocidadAtaque);} 
                catch(Exception excepcion) {}
            }

            while(this.university.isPaused()) {
                try {Thread.sleep(1000);} //wtf?
                catch (Exception excepcion) {}
            }
            
            if(!this.university.hasStudentsLeft()) {ataca = this.university.frontStudent(this.arrX, this.arrY);}

            if(this.vida == 0) {tipo = "";}
        }*/
    }
}
