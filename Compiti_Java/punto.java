
public class Punto {
	
	private int q, x,y;
	
	
	/* il polimorfismo statico è 
	 * quando all'interno della stessa classe 
	 * andiamo ad avere 2 o più classi 
	 * con lo stesso nome, ma parametri diversi
	 * === OverLoading
	*/
	
	/* il polimorfismo dinamico è quando 
	 * andiamo a sovrascrivere una classe
	 * parente rispetto alla funzionalità
	*/
	
	public double getX() {
		return x;
	}
	
	public double getY() {
		return y;
	}
		
	
	/* this rappresenta l'oggetto e 
	 * per il richiamo del costruttore deve 
	 * essere la prima istruzione
	 */
	public void setX(int pippo) {
		this.x=pippo;
	}
	
	public void setY(int pippo) {
		this.y=pippo;
	}
	
	@Override
	public String toString() {
		return (
				"Punto: " + "(" + getX() + "," + 
				getY() + ")"
				);
	}
	
	public Punto(int x, int y) {
		setX(x);
		setY(y);
		setQ();
	}
	
	
	// Overloading del costruttore ma dato il controllo non posso scrivere il this
	public Punto(boolean isAscissa, int valore) {
		if (isAscissa) 
			this.y = valore;
		else 
			this.x = valore;
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
		); // utilizzo i metodi statici della classe Math
		return risultato;
		
	}
	public static void puntoL(Punto p) {
		String qLetterale;
		if (p.q == 1)
			qLetterale = "Primo";
		else if (p.q == 2)
			qLetterale = "Secondo";
		else if (p.q == 3)
			qLetterale = "Terzo";
		else if (p.q == 4)
			qLetterale = "Quarto";
		else
			qLetterale = "Origine";
		
		System.out.println("P= (" + p.x +","+p.y+ ")- "+ qLetterale);
	}
	
	public static void PuntoMedio(Punto p1, Punto p2) {
		float risultatoX, risultatoY;
		risultatoX = (p1.x + p2.x)  / 2;
		risultatoY = (p1.y + p2.y)  / 2;
		System.out.println("Punto Medio: ("+ risultatoX + "," + risultatoY + ")");
		
	}
	
	
}
