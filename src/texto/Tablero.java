package texto;
import modelo.*;
//@author David
public class Tablero {
    public void pintaTablero(int filas,int columnas,Juego juego) {
        Boolean lineaImpar = true;
        String caracter;
        for (int fila=1;fila<2*filas+2;fila++) {
            System.out.print("|"); 
            if (lineaImpar) {
                caracter="-";
                for (int columna=1;columna<8*columnas;columna++) {System.out.print(caracter);}    
                System.out.println("|"); 
            } else {
                //linea par
                caracter=" ";
                for (int i=0;i<columnas;i++) {
                    //añade elemento de arraylist
                    for (int columna=1;columna<8;columna++) {
                        if (columna==4) {
                            //aqui introduzco la magia. Si ocupara mas de 1 hueco (x) habria que cambiar el 4 por 4-x
                            caracter=juego.getSiguienteElemento();
                            //
                        }
                            System.out.print(caracter);
                            caracter=" "; 
                    }
                    System.out.print("|"); 
                }
                System.out.println();      
            }
            lineaImpar=!lineaImpar;
        }
    }
}
