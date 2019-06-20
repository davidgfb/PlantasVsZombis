package modelo;

public class Personaje {
    
    int salud;
    
    Personaje(int vida) {this.salud=vida;}
    
    void quitaSalud (int cantidad) {
        this.salud-=cantidad;
        System.out.println("quita "+cantidad+" de salud");
    }
    
    int getSalud () {return salud;}
}
