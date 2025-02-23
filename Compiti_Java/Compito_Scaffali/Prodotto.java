package Compiti_Java.Compito_Scaffali;

public class Prodotto implements Comparable<Prodotto>{
	private String nome;
	private double price;
	private int quot;
	private int codice;
	private static int contaProdotti;
	
	
	public String getNome() {return nome;}
	public double getPrice() {return price;}
	public int getQuot() {return quot;}
	public int getCodice() {return codice;}
	
	
	public void setQuot(int quot) {
		this.quot = quot;
	}
	
	public void setPrice(double price) {
		if(price<=0)price=1;
		this.price = price;
	}
	
	public void setNome(String nome) {
		nome=nome.trim().toUpperCase();
		this.nome = nome;
	}
	
	public Prodotto(String nome, double price, int quot){
		setNome(nome);
		setPrice(price);
		setQuot(quot);
		this.codice=++contaProdotti;
	}
	public Prodotto(String nome){
		this(nome,1,50);
	}
	
	
	@Override
	public String toString() {
		return nome+" "+price+" "+quot;
	}
	
	
	@Override //criterio di ordinamento sovrascritto
	public int compareTo(Prodotto altro) {
		if(this.price==altro.price)
			return this.nome.compareToIgnoreCase(altro.nome);
		if(this.price>altro.price)
			return 1;
		return -1;
	}

}
