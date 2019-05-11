package modelo;

public class ZombiComun extends Zombi {
    int VIDA = 5,DMG = 1,VELOCIDAD_ATAQUE = 1,VELOCIDAD = 1;
    String GRAFICOS = "Z",TIPO = "Zombie normal";

    public ZombiComun(int vida, int danno, int VELOCIDAD_ATAQUE, String tipo, String GRAFICOS, int velocidad) {super(vida, danno, VELOCIDAD_ATAQUE, tipo, GRAFICOS, velocidad);}
}
