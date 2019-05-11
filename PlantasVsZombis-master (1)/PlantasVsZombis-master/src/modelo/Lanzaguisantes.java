package modelo;

public class Lanzaguisantes extends Planta{
    private final static int VIDA = 3;
    private final static int DMG = 1;
    private final static int FRECUENCIA= 1;
    private final static String TIPO = "Lanza guisantes";
    static int coste = 50;
    private final static String GRAPHICS = "L";
    static String sprite = "---";

    public Lanzaguisantes(int fila,int columna) {super(fila,columna,"L");}
}
