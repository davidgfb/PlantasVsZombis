package modelo;

public class Personaje {
    
    int salud;
    
    Personaje(int vida) {this.salud=vida;}
    
    void quitaSalud (int cantidad) {this.salud-=cantidad;}
    
    int getSalud () {return salud;}
}
