package views;


public class MuroView {
	
	public MuroView() {}
	
	public MuroView(int posicionx, int posiciony, int ancho, int alto, int vida, boolean estado) {
		this.posicionx = posicionx;
		this.posiciony = posiciony;
		this.ancho = ancho;
		this.alto = alto;
		this.vida = vida;
		this.estado = estado;
	}
	
	private int posicionx;
	private int posiciony;
	private int ancho;
	private int alto;
	private int vida;
	private boolean estado;
	
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

	public int getVida() {
		return vida;
	}

	public void setVida(int vida) {
		this.vida = vida;
	}

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}
	
}
