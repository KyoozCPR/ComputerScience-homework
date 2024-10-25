package progetto_iniziale.Compito_Rubrica;

public class Data {
	private int gg, mm, aaaa;

	public int getGg() {return this.gg;}
	public int getMm(){return this.mm;}
	public int getAaaa() {return this.aaaa;}

	public void setGg(int giorno) {this.gg = giorno;}
	public void setMm(int mese) {this.mm = mese;}
	public void setAaaa(int anno) {this.aaaa = anno;}


	public Data(int giorno, int mese, int anno) {
		setGg(giorno);
		setMm(mese);
		setAaaa(anno);

		if (!isValid())
			System.out.println("Data non valida\n");
	}

	//Overloading
	public Data(String data){
		// ES: "24/10/2024" => gg=24  mm=10  aaaa=2024
		String[] dataSuddivisa = data.split("/");
		this.gg = Integer.parseInt(dataSuddivisa[0]);
		this.mm = Integer.parseInt(dataSuddivisa[1]);
		this.aaaa = Integer.parseInt(dataSuddivisa[2]);

	}


	private boolean isValid(){

		if (this.mm < 1 || this.mm > 12)
			return false;


		if (this.gg < 1 || this.gg > Contatto.giornidelMese(this.mm, this.aaaa))
			return false;

		return true; // Data valida
	}
	public static boolean bisestile(int anno) {
		return (anno % 4 == 0 && anno % 100 != 0) || (anno % 400 == 0);
	}

	@Override
	public String toString() {
		return this.gg + "/" + this.mm + "/" + this.aaaa;
	}



}
