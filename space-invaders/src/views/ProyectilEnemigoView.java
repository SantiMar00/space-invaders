package views;


public class ProyectilEnemigoView {


	public ProyectilEnemigoView() {}
	
	public ProyectilEnemigoView(int posicionx, int posiciony, boolean estado) {
		this.posicionx = posicionx;
		this.posiciony = posiciony;
		this.estado = estado;
	}
	
	
	private int posicionx;
	private int posiciony;
	private boolean estado;
	
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
	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}
	
	
}
