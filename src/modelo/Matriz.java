package modelo;
public class Matriz {
    //estas variables ocupan espacio fijo en memoria
    String[][] matriz;
    String[] vector;
    int posicionVector=-1;
    void getMatrizAVector() {
        //estas excepciones deberian estar en controlador.Main
            vector=new String[getMatrizNumeroElementos()];
            int posicionElementoMatriz=0;
            for (String[] filas : matriz) {
                for (String columna : filas) {
                    vector[posicionElementoMatriz]=columna;
                    posicionElementoMatriz++;
                }
            }
        
    }
    public Matriz(int filas, int columnas) {matriz = new String[filas][columnas];}
    public void setElemento(int fila,int columna,String valor) {matriz[fila][columna]=valor;}
    int getMatrizNumeroFilas() {return matriz.length;}
    int getMatrizNumeroColumnas() {return matriz[0].length;} 
    int getMatrizNumeroElementos() {return getMatrizNumeroFilas()*getMatrizNumeroColumnas();}
    /*ocupa mucho espacio en memoria
     *public String[][] getMatriz() {return matriz;}*/
    public String getVectorSiguienteElemento() {
        //convierte la matriz a un vector
        getMatrizAVector();
        posicionVector++;
        if (posicionVector==49) {posicionVector=0;}
        return vector[posicionVector];
    }
}    
    

