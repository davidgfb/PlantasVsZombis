package modelo;

public class ZombiComun extends Zombi {
    int VIDA = 150,DMG = 10,VELOCIDAD_ATAQUE = 10,VELOCIDAD = 20;
    String GRAFICOS = "Z",TIPO = "Zombie normal";

    public ZombiComun(int vida, int danno, int VELOCIDAD_ATAQUE, String tipo, String GRAFICOS, int velocidad) {super(vida, danno, VELOCIDAD_ATAQUE, tipo, GRAFICOS, velocidad);}
}
