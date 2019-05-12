//@author David
package texto;
import modelo.Matriz;
import modelo.Girasol;
import controlador.Main;

public class Tablero {
    static public int turno;

    public void Tablero() {
        Matriz matriz=Main.matriz;
        int filas=matriz.getMatrizNumeroFilas(), columnas=matriz.getMatrizNumeroColumnas(), soles=Girasol.getSoles();
        String caracter,barra="|",espacio=" ";
        boolean filaImpar = true;
        turno+=1;
        if (turno==1) {System.out.println("Comenzando la partida.");}
        for (int fila=1;fila<2*filas+2;fila++) {
            System.out.print(barra); //Imprime una barra
            if (filaImpar) {
                for (int columna=1;columna<8*columnas;columna++) {System.out.print("-");}  //imprime guion
                System.out.println(barra); //imprime barra
            } else {
                for (int columna=0;columna<columnas;columna++) {
                    caracter=matriz.getVectorSiguienteElemento();
                    if (caracter==null) {caracter="       ";}
                    else {caracter=caracter+"   ";}
                    System.out.print(caracter); 
                    System.out.print(barra); //imprime barra
                }
                System.out.println(); //baja a la siguiente fila  
            }
            filaImpar=!filaImpar; //cambia fila impar a par o viceversa
        }
        System.out.println("Tienes "+soles+" soles y es el turno "+turno+"\n(Teclea ayuda para lista de comandos. <Enter> para terminar el turno.)");
    }
}
