
public class Punto {
	
	private int q, x,y;
	
	public double getX() {
		return x;
	}
	
	public double getY() {
		return y;
	}
	
	
	
	/* il polimorfismo statico è 
	 * quando all'interno della stessa classe 
	 * andiamo ad avere 2 o più classi 
	 * con lo stesso nome, ma parametri diversi
	 * === OverLoading
	*/
	
	
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
	
	
	//Aggiungo caso dell'origine
	public Punto() {
		this(0,0);
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
	
	
	public static double distanza(Punto p1, Punto p2) {
		double risultato;
		risultato = Math.sqrt(
				Math.pow(p1.x - p2.x, 2) + 
				Math.pow(p1.y - p2.y, 2)
		);
		return risultato;
		
	}
}
