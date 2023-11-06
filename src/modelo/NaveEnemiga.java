package modelo;

import views.NaveEnemigaView;


public class NaveEnemiga {

	// Constructor
    public NaveEnemiga(int x, int y, int px) {
    	this.posicionx = x;
    	this.posiciony = y;
    	this.ancho = 47;
    	this.alto = 33;
    	this.estado = false;
    	this.velocidad = px;
    	
    }

    private int posicionx;
    
    private int posiciony;
    
    public int ancho;
    
    private int alto;
        
    private boolean estado;
    
    private int velocidad;
    
    
    public boolean isImpacto(int pbX, int pbY, int naveX, int naveY) {
    	if(naveX - 30 <= pbX && pbX <= naveX - 30 + ancho && naveY - 30 <= pbY && pbY <= naveY + alto) {
    		return true;
    	}
    	
    	return false;
    }
    
    
    public NaveEnemigaView toView() {
		return new NaveEnemigaView(posicionx, posiciony, ancho, alto, estado, velocidad);
    }
    
    
}