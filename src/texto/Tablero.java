//@author David
package texto;
import modelo.Matriz;
public class Tablero {
    public Tablero(int filas, int columnas, Matriz matriz) {
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
                        // aqui introduzco la magia. Si ocupara mas de 1 hueco (x) habria que cambiar el 4 por 4-x | el metodo siguiente solo pasa un String 
                        if (columna==4) {caracter=matriz.getVectorSiguienteElemento();}
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
