
public class Punto {
	
	public int q, x,y;
	
	public double getX() {
		return x;
	}
	
	public double getY() {
		return y;
	}
	
	// this rappresenta l'oggetto
	
	public void setX(int pippo) {
		this.x=pippo;
	}
	
	public void setY(int pippo) {
		this.y=pippo;
	}
	
	public Punto(int x, int y) {
		setX(x);
		setY(y);
		setQ();
	}
	
	private void setQ() {
		if (x >= 0 && y >= 0)
			this.q=1;
		else if(x < 0 && y>0)
            this.q=2;
        else if(x < 0 && y<0)
            this.q=3;
        else if(x > 0 && y<0)
            this.q=4;
        else 
            this.q=0;
	}
}
