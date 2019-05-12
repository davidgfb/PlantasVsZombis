package modelo;

public class Matriz {
    public static String[][] matriz;
    String[] vector; //estas variables ocupan espacio fijo en memoria
    int posicionVector=-1;
    
    void MatrizAVector() {
        vector=new String[getMatrizNumeroElementos()];
        int posicionElementoMatriz=0;
        for (String[] filas : matriz) {
            for (String columna : filas) {
                vector[posicionElementoMatriz]=columna;
                posicionElementoMatriz++;
            }
        }
    }
    
    public Matriz (int filas, int columnas) {matriz = new String[filas][columnas];}
    
    public static void setElemento(int fila,int columna,String valor) {matriz[fila-1][columna-1]=valor;}
    
    public int getMatrizNumeroFilas() {return matriz.length;}
    
    public int getMatrizNumeroColumnas() {return matriz[0].length;} 
    
    int getMatrizNumeroElementos() {return getMatrizNumeroFilas()*getMatrizNumeroColumnas();}
    
    public String getVectorSiguienteElemento() {
        MatrizAVector(); //convierte la matriz a un vector 
        posicionVector++;
        if (posicionVector==getMatrizNumeroElementos()) {posicionVector=0;}
        return vector[posicionVector];
    }
    
    static public boolean getOcupado(int fila, int columna, String personaje){
        boolean ocupado=false;
        String casilla=matriz[fila-1][columna-1];
        if(casilla!=null) {ocupado = true;}
        return ocupado;
    }   
    
    public void Ataca(String objeto, int filas, int columnas){
        if (objeto.equals("Z")) {
            for (int fila = filas; fila>0; fila--) {
                matriz[fila][columnas] = objeto; 
                matriz[fila-1][columnas] = null; //-1? null?
            }
        }
        if (objeto.equals("L")) {
            for (int fila = filas; fila>0; fila--) {
                matriz[fila+1][columnas] = Lanzaguisantes.sprite; //if() escribir que si posicion zombie igual posicion sprite --> zombie vida - 1
            }
        }
    }
}    
    

