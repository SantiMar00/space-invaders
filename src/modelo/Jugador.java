package modelo;



public class Jugador {

	// Constructor
    public Jugador(String nombre) {
    	this.nombre = nombre;
    	this.vidas = 3;
    }

    private String nombre;

    public int vidas;
    
    
    public String devolverNombre() {
    	return this.nombre;
    }
    
    public int devolverVidas() {
    	return this.vidas;
    }
    
    public void modificarVidas(String flag) {
    	if(flag == "Restar") {
    		this.vidas--;
    	}
    	else if(flag == "Sumar") {
    		this.vidas++;
    	}
    }

}