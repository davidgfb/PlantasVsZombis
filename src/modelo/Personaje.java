package modelo;

import static modelo.Matriz.matriz;

public class Personaje {
    public Personaje(int fila,int columna,String personaje) {Matriz.setElemento(fila,columna,personaje);}
    
    public void AtacaAPlanta(int filas, int columnas){  //Definido ataque de Zombia a Planta 
        for (int fila = filas; fila>0; fila--) {
            if(matriz[filas][columnas] == null){
                matriz[fila][columnas] = Zombi.tipoZombi; 
                matriz[fila-1][columnas] = null; //asi la posición anterior queda vaciada
            }else{
                for(int i = Planta.vida; i<0; i--){
                    if(Planta.vida != 0){
                        Planta.vida = Planta.vida - 1;
                        confirmaMuerte(Planta.vida, filas, columnas);
                    }

                }
            }
        }
        
    }
    public void AtacaAZombi(int filas, int columnas, String objeto){ 
        for (int fila = filas; fila>0; fila--) {
            if(matriz[filas][columnas] == null){
                //matriz[fila][columnas] = Planta.getCoste(objeto); 
            } else {
                for(int i = Zombi.vidaZombi; i<0; i--){
                    if(Zombi.vidaZombi != 0){
                        Zombi.vidaZombi = Zombi.vidaZombi - 1;
                        confirmaMuerte(Zombi.vidaZombi, filas, columnas);
                    }
                }
            }
        }
    }
    public void confirmaMuerte(int vida, int fila, int columna){
        if(vida == 0){
            vida = 0; 
            Matriz.matriz[fila][columna] = null;
        }  
    }   
}
