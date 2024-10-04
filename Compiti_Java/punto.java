package progetto_iniziale;

public class Punto {
	//Definisco gli attributi della classe
	private double x,y;
	private int q;
	
	public double getX() {
		return x;
	}
	
	public double getY() {
		return y;
	}
	
	// this rappresenta l'oggetto
	
	public void setX(double pippo) {
		this.x=pippo;
	}
	
	public void setY(double pippo) {
		this.y=pippo;
	}
	
	public Punto(double x, double y) {
		setX(x);
		setY(y);
		setQ();
	}
	
	private void setQ() {
		if (x >= 0 && y >= 0)
			this.q=1;
	}
}
