

public class Vagone {
	protected String codice;
	protected int pesoV;
	
	
	public String getCodice() {
		return codice;
	}
	public void setCodice(String codice) {
		this.codice = codice;
	}
	public int getPesoV() {
		return pesoV;
	}
	public void setPesoV(int pesoV) {
		this.pesoV = pesoV;
	}
	public Vagone(String codice, int pesoV) {
		super();
		this.codice = codice;
		this.pesoV = pesoV;
	}
	
	
	
	

}
