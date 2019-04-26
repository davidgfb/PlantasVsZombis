//@author David
package texto;
import modelo.*;
public class Tablero {
    public void pintaTablero(int filas,int columnas,Juego juego) {
        String espacio=" ";
        String barra="|";
        Boolean lineaImpar = true;
        String caracter;
        for (int fila=1;fila<2*filas+2;fila++) {
            //Imprime una barra
            System.out.print(barra); 
            if (lineaImpar) {
                caracter="-";
                for (int columna=1;columna<8*columnas;columna++) {System.out.print(caracter);}  
                //imprime barra
                System.out.println(barra); 
            } else {
                //linea par. fija espacio
                caracter=espacio;
                for (int i=0;i<columnas;i++) {
                    for (int columna=1;columna<8;columna++) {
                        //aqui introduzco la magia. Si ocupara mas de 1 hueco (x) habria que cambiar el 4 por 4-x
                        if (columna==4) {caracter=juego.getVectorSiguienteElemento();}
                        //imprime elemento Matriz (personaje, etc)
                        System.out.print(caracter);
                        //resetea caracter a espacio
                        caracter=espacio; 
                    }
                    //imprime barra
                    System.out.print(barra); 
                }
                System.out.println();      
            }
            lineaImpar=!lineaImpar;
        }
    }
}
