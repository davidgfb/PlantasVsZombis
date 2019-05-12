//@author David
package texto;
import modelo.Matriz;
import modelo.Girasol;
import modelo.Juego;

public class Tablero {
    static public void Tablero() {
        int filas = Matriz.getMatrizNumeroFilas(), soles = Girasol.getSoles(), columnas = Matriz.getMatrizNumeroColumnas();
        String barra = "|", caracter;
        boolean filaImpar = true;
        Juego.turno+=1;
        if (Juego.turno==1) {System.out.println("Comenzando la partida.");}
        for (int fila=1;fila<2*filas+2;fila++) {
            System.out.print(barra); //Imprime una barra
            if (filaImpar) {
                for (int columna=1;columna<8*columnas;columna++) {System.out.print("-");}  //imprime guion
                System.out.println(barra); //imprime barra
            } else {
                for (int columna=0;columna<columnas;columna++) {
                    caracter=Matriz.getVectorSiguienteElemento();
                    if (caracter==null) {caracter="       ";}
                    else {caracter=caracter+"   ";}
                    System.out.print(caracter); 
                    System.out.print(barra); //imprime barra
                }
                System.out.println(); //baja a la siguiente fila  
            }
            filaImpar=!filaImpar; //cambia fila impar a par o viceversa
        }
        System.out.println("Tienes "+soles+" soles y es el turno "+Juego.turno+"\n(Teclea ayuda para lista de comandos. <Enter> para terminar el turno.)");
    }   
}

