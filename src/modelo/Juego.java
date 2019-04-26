package modelo;
public class Juego {
    /**@param args the command line arguments
     matriz, pintaTablero y update
     funciones extra*/
    String[][] matriz;
    String[] salida;
    int j=0;
    int elemento=-1;
    
    void getMatrizFila() {
        salida=new String[getMatrizElementos()];
        for (String[] filas : matriz) {
            for (String columnas : filas) {
                salida[j]=columnas;
                j++;
            }
        }
    }
    void setMatriz(int filas,int columnas) {matriz = new String[filas][columnas];}
    void setElemento(int fila,int columna,String valor) {matriz[fila][columna]=valor;}
    int getMatrizFilas() {return matriz.length;}
    int getMatrizColumnas() {return matriz[0].length;} 
    int getMatrizElementos() {return getMatrizFilas()*getMatrizColumnas();}
    public String[][] getMatriz() {return matriz;}
    //void update() {}
    public String getSiguienteElemento() {
        elemento++;
        if (elemento==49) {elemento=0;}
        return salida[elemento];
    }
}    
    

