//@author David
package controlador;
import java.util.Scanner;
import modelo.Matriz;
import texto.Tablero;
public class Main {
    public static void main (String[] argumentos) {
        try {
            String NMayuscula=argumentos[0].toUpperCase();
            if (NMayuscula.equals("N")) {
                //convierto filas y columnas (String) a enteros
                int filas=Integer.parseInt(argumentos[1]);
                int columnas=Integer.parseInt(argumentos[2]);
                //comprueba q filas y columnas sean enteros
                if (filas==(int)filas && columnas==(int)columnas) {
                    String[] nivelesDificultad = {"BAJA","MEDIA","ALTA","IMPOSIBLE"};
                    String dificultad=argumentos[3].toUpperCase();
                    Boolean encontrado=false;
                    for (String nivelDificultad : nivelesDificultad) {
                        if (dificultad.equals(nivelDificultad)) {
                        encontrado=true;
                        Matriz matriz = new Matriz(filas,columnas);
                        /*MATRIZ | crea el objeto matriz e inicializa la matriz
                        filasxcolumnas
                        *pinta la matriz en forma de fila
                        *for (int j=0;j<matriz.getMatrizNumeroElementos();j++)
                        {System.out.print(matriz.getVectorSiguienteElemento());}
                        *System.out.println();
                        **TEXTO MATRIZ | crea el objeto texto.matriz para representar
                        y pinta la matriz en texto
                        *Matriz matriz = new Matriz(juego.getMatriz());*/
                        //cambia todos los elementos null de la matriz por numeros 0-9
                        int numero0_9=0;
                        for (int fila=0;fila<filas;fila++) {
                            for (int columna=0;columna<columnas;columna++) {
                              //reseteo numero 0-9
                              if (numero0_9>9) {numero0_9=0;}
                              //convierto el numero a String para representar
                              String cadena=Integer.toString(numero0_9);
                              matriz.setElemento(fila,columna,cadena);
                              numero0_9++;
                            }
                        }
                        //TABLERO | crea el objeto tablero.matriz para representar
                        Tablero tablero = new Tablero(filas,columnas,matriz);
                        }
                    }
                    //el usuario no ha introducido bien la dificultad
                    if (!encontrado) {throw new IllegalArgumentException();}
                }
            }
        }
        catch(IllegalArgumentException|ArrayIndexOutOfBoundsException|NegativeArraySizeException excepcion){
            System.out.println("Error: "+excepcion);
            //pide a entra que capture los comandos y se los lance a main
            Entra();
        }
    }
    static void Entra () {
        //falta salir del bucle
        Scanner entrada = new Scanner(System.in);
        System.out.print("Repita comandos: ");
        String comandos = entrada.nextLine();
        String[] values = comandos.split(" ");
        main(values);
    }
}
    

