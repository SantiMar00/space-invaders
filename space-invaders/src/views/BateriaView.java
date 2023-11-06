package views;


public class BateriaView {
    
	public BateriaView() {}
    
    public BateriaView(int posicionx, int posiciony, int velocidad) {
    	this.posicionx = posicionx;
    	this.posiciony = posiciony;
    	this.velocidad = velocidad;
    }
    
	private int posicionx;
    private int posiciony;
    private int velocidad;

	public int getPosicionx() {
		return posicionx;
	}

	public void setPosicionx(int posicionx) {
		this.posicionx = posicionx;
	}

	public int getPosiciony() {
		return posiciony;
	}

	public void setPosiciony(int posiciony) {
		this.posiciony = posiciony;
	}
	
	public int getVelocidad() {
		return velocidad;
	}

	public void setVelocidad(int velocidad) {
		this.velocidad = velocidad;
	}

	
}
