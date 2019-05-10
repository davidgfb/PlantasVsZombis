package modelo;

public abstract class Planta {
    int soles, frecuencia,vida,danno,tipo,graficos,estado = 0;
    boolean ataca;

    public Planta(int vida, int danno, int frecuencia, String tipo, String graficos,int soles) {this.soles = soles;}
    
    // Setters
    public void reseteaEstado() {this.estado = 0;}
    public void incrementaEstado(){this.estado++;}
    public void reseteaTiempoCarga() {this.frecuencia = 0;}
    public void incrementaTiempoCarga(){this.frecuencia++;}

    // Getters
    public int getSoles() {return this.soles;}
    public int getEstado() {return this.estado;}
    public boolean Compra(int soles) {return this.estado == this.soles || soles >= this.soles;}

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
