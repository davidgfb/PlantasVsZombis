package modelo;

public class Lanzaguisantes extends Planta{
    private final static int VIDA = 3;
    private final static int DMG = 1;
    private final static int FRECUENCIA= 1;
    private final static String TIPO = "Lanza guisantes";
    static int coste = 50;
    private final static String GRAPHICS = "L";
    static String sprite = "-";
    static int cantidad=0;
    public static int F, C; //fila y columna
    
    public Lanzaguisantes(int fila,int columna) {
        super(fila,columna,"L(3)");
        F = fila; C = columna; 
    }
    
    public void Attck(){
        int i = Lanzaguisantes.F; 
        
        for(int j= Lanzaguisantes.C ; j <3; j++){
            Matriz.matriz[i][j] = sprite;} 
        
    }
}
