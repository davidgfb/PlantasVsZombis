//@author David
package controlador;
import modelo.Matriz;
import texto.Tablero;
public class Main {
        int filas=7;  
        int columnas=7;
        int numero0_9=0;
        Matriz matriz = new Matriz(filas,columnas); 
    //solo existe el primer argumento (String)
    public static void main (String[] argumentos) {
        //iniciaJuego();
        String argumento0Mayus=argumentos[0].toUpperCase();
        if (argumento0Mayus.equals("N")) {
            //convierto String a entero
            try {
                int argumento1Numero=Integer.parseInt(argumentos[1]);
                int argumento2Numero=Integer.parseInt(argumentos[2]);
                //comprobacion: son enteros
                if (argumento1Numero==(int)argumento1Numero && argumento2Numero==(int)argumento2Numero) {
                    String[] nivelesDificultad = {"BAJA","MEDIA","ALTA","IMPOSIBLE"};
                    System.out.println("Hola somos enteros!");
                    String argumento3Mayus=argumentos[3].toUpperCase();
                    for (String nivelDificultad : nivelesDificultad) {
                        if (argumento3Mayus.equals(nivelDificultad)) {
                            System.out.println("tenemos un ganador!");
                        }
                    }
                }   
            }
            catch (NumberFormatException excepcion) {
                System.out.println("Error: no ha introducido un entero valido");
                //entra();
            }
        }         
    }
    void entra() {
        
    }
    /*void iniciaJuego() {
        //excepcion si filas y/o columnas negativas PROVISIONAL encuentra sentencias try/catch
        if (filas<0) {filas=0;}
        if (columnas<0) {columnas=0;}
        //MATRIZ | crea el objeto matriz e inicializa la matriz filasxcolumnas
        
        rellenaMatriz();
        /*pinta la matriz en forma de fila
         *for (int j=0;j<matriz.getMatrizNumeroElementos();j++) {System.out.print(matriz.getVectorSiguienteElemento());}
         *System.out.println();*/
        /*TEXTO MATRIZ | crea el objeto texto.matriz para representar y pinta la matriz en texto
         *Matriz matriz = new Matriz(juego.getMatriz());*/
        //TABLERO | crea el objeto tablero.matriz para representar  
        /*Tablero tablero = new Tablero(filas,columnas,matriz);
    }
    void rellenaMatriz() {
        //cambia todos los elementos null de la matriz por numeros 0-9
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
    }*/
}
    

