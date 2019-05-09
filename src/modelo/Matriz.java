package modelo;
public class Matriz {
    public String[][] matriz=new String[7][7]; 
    String[] vector;//estas variables ocupan espacio fijo en memoria
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
    public void setElemento(int fila,int columna,String valor) {matriz[fila][columna]=valor;}
    public int getMatrizNumeroFilas() {return matriz.length;}
    public int getMatrizNumeroColumnas() {return matriz[0].length;} 
    int getMatrizNumeroElementos() {return getMatrizNumeroFilas()*getMatrizNumeroColumnas();}
    public String getVectorSiguienteElemento() {
        MatrizAVector();//convierte la matriz a un vector 
        posicionVector++;
        if (posicionVector==50) {posicionVector=0;}
        return vector[posicionVector];
    }
}    
    

