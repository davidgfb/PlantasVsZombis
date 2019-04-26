package texto;
public class Matriz {
    public void pintaMatriz(String[][] matriz){
        for (String[] filas : matriz) {
            for (String columnas : filas) {System.out.print(columnas);}
            System.out.println();
        }
    }
}
