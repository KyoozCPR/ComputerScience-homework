package progetto_iniziale.Compito_Rubrica;

public class Data {
	private int gg, mm, aaaa;
	
	public int getGg() {
		return this.gg;
	}
	public int getMm(){
		return this.mm;
	}
	public int getAaaa() {
		return this.aaaa;
	}
	
	public void setGg(int giorno) {
		this.gg = giorno;
	}
	public void setMm(int giorno) {
		this.gg = giorno;
	}
	public void setAaaa(int giorno) {
		this.gg = giorno;
	}
	
	
	public Data(int giorno, int mese, int anno) {
		if (isValid()) {
			setGg(giorno);
			setMm(mese);
			setAaaa(anno);
		}
		else
			System.out.println("Data non valida\n");


	}

	private boolean isValid(){
		if (!(this.gg >= 1 && this.gg <= 31))
			return false;
		else return this.mm >= 1 && this.mm <= 12;
	}

	
	@Override
	public String toString() {
		return this.gg + "/" + this.mm + "/" + this.aaaa;
	}
	
	
	
}
