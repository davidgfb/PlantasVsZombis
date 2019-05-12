package modelo;

import static modelo.Matriz.matriz;

public class Personaje {
    
    public Personaje(int fila,int columna,String personaje) {Matriz.setElemento(fila,columna,personaje);}
    
    public void AtacaAPanta(int filas, int columnas){ 
            for (int fila = filas; fila>0; fila--) {
                
                if(matriz[filas][columnas] == null){
                    matriz[fila][columnas] = Zombi.tipoZombi; 
                    matriz[fila-1][columnas] = null; //asi la posición anterior queda vaciada
                }else{
                    for(int i = Planta.vida; i<0; i--){
                        
                        
                    }
                }
            }
        
    }
    public void AtacaAZombi(int filas, int columnas, String objeto){ 
        for (int fila = filas; fila>0; fila--) {
                
            if(matriz[filas][columnas] == null){
                //matriz[fila][columnas] = Planta.getCoste(objeto); 
                
            }else{
                for(int i = Planta.vida; i<0; i--){
                        
                        
                }
            }
        }
        
    }
    public void Zloseshealth(){
         try{//cada ºThread1000 1 de vida
             
         }catch(Exception e){
         
         }
    }
    public void Ploseshealth(){
        try{
            
         }catch(Exception e){
         
         }
    }
}
