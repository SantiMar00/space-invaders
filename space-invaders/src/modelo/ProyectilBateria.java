package modelo;

import views.ProyectilBateriaView;


public class ProyectilBateria {

	// Constructor
    public ProyectilBateria(int x, int y) {
    	this.posicionx = x;
    	this.posiciony = y;
    	this.estado = false;
    }

    private int posicionx; 
    private int posiciony;
    private boolean estado;
    
    
    public ProyectilBateriaView toView() {
    	return new ProyectilBateriaView(posicionx, posiciony, estado);
    }
    
}