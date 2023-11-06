package views;


public class NaveEnemigaView {
	
	public NaveEnemigaView() {}
	
	public NaveEnemigaView(int posicionx, int posiciony, int ancho, int alto, boolean estado, int velocidad) {
		this.posicionx = posicionx;
		this.posiciony = posiciony;
		this.ancho = ancho;
		this.alto = alto;
		this.estado = true;
		this.velocidad = velocidad;
	}

	private int posicionx;
	private int posiciony;
	private int ancho;
	private int alto;
	private boolean estado;
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

	public int getAncho() {
		return ancho;
	}

	public void setAncho(int ancho) {
		this.ancho = ancho;
	}

	public int getAlto() {
		return alto;
	}

	public void setAlto(int alto) {
		this.alto = alto;
	}

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}
	
	public int getVelocidad() {
		return velocidad;
	}

	public void setVelocidad(int velocidad) {
		this.velocidad = velocidad;
	}
	
}
