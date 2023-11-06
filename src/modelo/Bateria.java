package modelo;

import views.BateriaView;


public class Bateria {

   // Constructor
    public Bateria() {
    	this.posicionx = 360;
    	this.posiciony = 540;
    	this.velocidad = 0;
    }

    private int posicionx;
    private int posiciony;
    private int velocidad;
   
    
    public boolean isImpactoEnemigo(int peX, int peY, int batX, int batY) {    	
    	if((batX <= peX && peX <= batX + 60) && (batY <= peY && peY <= batY)) {
    		
    		return true;
    	}
    	
    	return false;
    }
    
    
    public BateriaView toView() {
    	return new BateriaView(posicionx, posiciony, velocidad);
    }
    
}