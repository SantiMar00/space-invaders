package modelo;

import views.MuroView;


public class Muro {

	// Constructor
    public Muro(int x, int y) {
    	this.vida = 20;
    	this.estado = true;
    	this.posicionx = x;
    	this.posiciony = y;
    	this.ancho = 102;
    	this.alto = 42;
    }

    private int posicionx;
    private int posiciony;
    private int ancho;
    private int alto;
    private int vida;
    private boolean estado;

    
    public boolean isImpactoEnemigo(int peX, int peY) {
    	
    	if((posicionx  <= peX && peX <= posicionx + ancho) 
    			&& (posiciony <= peY && peY <= posiciony + alto - 40)) {
    		return true;
    	}
    	return false;
    }
    
    public boolean isImpactoBateria(int pbX, int pbY) {
    
    	if((posicionx - 34 <= pbX && pbX <= posicionx - 34 + ancho) && (pbY == posiciony + alto-28)) {
    		return true;
    	}
    	return false;
    }
    
    public MuroView toView() {
    	return new MuroView(posicionx, posiciony, ancho, alto, vida, estado);
    }
    
}