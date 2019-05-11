package modelo;

import texto.Tablero;

public abstract class Zombi extends Tablero{
    int velocidad,vida;

    public Zombi(int vida, int dmg, int vel_attck, String tipo, String graphics, int velocidad) {this.velocidad = velocidad;}

    public void mueve(int filas, int columnas) {
	for(int fila = filas; fila>0; fila++){}
    }

    //@Override
    public void corre () {}
}
