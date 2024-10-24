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
		setGg(giorno);
		setMm(mese);
		setAaaa(anno);
	}
	
	@Override
	public String toString() {
		return this.gg + "/" + this.mm + "/" + this.aaaa;
	}
	
	
	
}
