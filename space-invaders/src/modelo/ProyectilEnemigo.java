package modelo;

import views.ProyectilEnemigoView;


public class ProyectilEnemigo {

    // Constructor
    public ProyectilEnemigo(int x, int y) {
    	this.posicionx = x;
    	this.posiciony = y;
    	this.estado = false;
    }

    private int posicionx;
    private int posiciony;
    private boolean estado;
    
    
    public ProyectilEnemigoView toView() {
    	return new ProyectilEnemigoView(posicionx, posiciony, estado);
    }
}