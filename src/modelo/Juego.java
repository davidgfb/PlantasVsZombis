package modelo;
public class Juego {
    //estas variables ocupan espacio fijo en memoria
    String[][] matriz;
    String[] vector;
    int posicionVector=-1;
    void getMatrizAVector() {
        try {
            vector=new String[getMatrizNumeroElementos()];
            int posicionElementoMatriz=0;
            for (String[] filas : matriz) {
                for (String columnas : filas) {
                    vector[posicionElementoMatriz]=columnas;
                    posicionElementoMatriz++;
                }
            }
        } catch (ArrayIndexOutOfBoundsException excepcion) {System.out.println("Error: fuera del indice de la matriz");}
    }
    void setMatriz(int filas,int columnas) {matriz = new String[filas][columnas];}
    void setElemento(int fila,int columna,String valor) {matriz[fila][columna]=valor;}
    int getMatrizNumeroFilas() {return matriz.length;}
    int getMatrizNumeroColumnas() {return matriz[0].length;} 
    int getMatrizNumeroElementos() {return getMatrizNumeroFilas()*getMatrizNumeroColumnas();}
    public String[][] getMatriz() {return matriz;}
    public String getVectorSiguienteElemento() {
        //convierte la matriz a un vector
        getMatrizAVector();
        posicionVector++;
        if (posicionVector==49) {posicionVector=0;}
        return vector[posicionVector];
    }
}    
    

