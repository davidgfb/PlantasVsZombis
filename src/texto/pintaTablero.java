//@author David
package texto;
import modelo.Matriz;
public class pintaTablero {
    
    int turno=0;
    
    public pintaTablero(Matriz matriz) { 
        int filas=matriz.getMatrizNumeroFilas();
        int columnas=matriz.getMatrizNumeroColumnas();
        turno+=1;
        String barra="|";
        Boolean filaImpar = true;
        String caracter=" ";
        int soles=0;
        if (turno==1) {System.out.println("Comenzando la partida.");}
        for (int fila=1;fila<2*filas+2;fila++) {
            System.out.print(barra); //Imprime una barra
            if (filaImpar) {
                for (int columna=1;columna<8*columnas;columna++) {System.out.print("-");}  //imprime guion
                System.out.println(barra); //imprime barra
            } else {
                for (int columna=0;columna<columnas;columna++) {
                    for (int hueco=1;hueco<8;hueco++) {// necesita de modelo.Matriz | Si ocupara mas de 1 hueco (x) habria que cambiar el 4 por 4-x 
                        if (hueco==4) {
                            caracter=matriz.getVectorSiguienteElemento();
                            if (caracter==null) {caracter=" ";}
                        } 
                        else {caracter=" ";}//imprime elemento Matriz (personaje, etc)
                        System.out.print(caracter); 
                    }
                    System.out.print(barra); //imprime barra
                }
                System.out.println(); //baja a la siguiente fila  
            }
            filaImpar=!filaImpar; //cambia fila impar a par o viceversa
        }
        System.out.println("Tienes "+soles+" soles y es el turno "+turno+"\n(Teclea ayuda para lista de comandos. <Enter> para terminar el turno.)");
    }
}
