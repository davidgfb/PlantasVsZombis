package modelo;

public abstract class Zombi {
    int velocidad,vida;
    
    public Zombi(int vida, int dmg, int vel_attck, String tipo, String graphics, int velocidad) {this.velocidad = velocidad;}
    
    public void mueve(int filas, int columnas) {
	for(int fila = filas; fila>0; fila++){}
    }
}
