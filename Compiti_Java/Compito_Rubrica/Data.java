package Compiti_Java.Compito_Rubrica;

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
	public Data(String data) {
		// ES: "24/10/2024" => gg=24  mm=10  aaaa=2024
		String[] dataSuddivisa = data.split("/");
		this.gg = Integer.parseInt(dataSuddivisa[0]);
		this.mm = Integer.parseInt(dataSuddivisa[1]);
		this.aaaa = Integer.parseInt(dataSuddivisa[2]);

		if (!isValid())
			System.out.println("Data non valida\n");


	}



	public int compareData(Data data){
	    /*
	    ritorna:
		 	0 se primo == secondo
		 	1 se primo > secondo
		   -1 se primo < secondo
		*/
		/* 
		PRIMA SOLUZIONE NON OTTIMIZZATA 
		if (this.getAaaa() < data.getAaaa())
			return -1;
		else if (this.getAaaa() > data.getAaaa())
			return 1;
		else {
			if (this.getMm() < data.getMm())
				return -1;
			else if(this.getMm() > data.getMm())
				return 1;
			else {
                return Integer.compare(this.getGg(), data.getGg());
			}
		}
		*/
		
		if (this.getAaaa() != data.getAaaa())
			return (data.getAaaa() - this.getAaaa()) > 0 ? -1:1;
		if (this.getMm() != data.getMm())
			return (data.getMm() - this.getMm()) > 0 ? -1:1;
		return (data.getGg() - this.getGg())  > 0 ? -1:1;

	

	}

	private boolean isValid(){

		if (this.mm < 1 || this.mm > 12)
			return false;

		// Controllo rispetto agli specifici giorni del mese
		if (this.gg < 1 || this.gg > giornidelMese(this.mm, this.aaaa))
			return false;

		return true; // Data valida
	}


	public static boolean bisestile(int anno) {
		return (anno % 4 == 0 && anno % 100 != 0) || (anno % 400 == 0);
	}


	public int giornidelMese(int mese, int anno ){
		if (mese == 1 || mese == 3 || mese == 5 || mese == 7 || mese == 8 || mese == 10 || mese == 12)
			return 31;
		else if (mese == 4 || mese == 6 || mese == 9 || mese == 11)
			return 30;
		else{
			if (Data.bisestile(anno))
				return 29;
			else
				return 28;
		}
	}

	@Override
	public String toString() {
		return this.gg + "/" + this.mm + "/" + this.aaaa;
	}



}
