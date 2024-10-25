package progetto_iniziale.Compito_Rubrica;
import java.util.Scanner;


public class Contatto {
	private String nome, cognome, telefono;
	private Data data, dataOggi;
	
	public String getNome() {
		return this.nome;
	}
	public String getCognome(){
		return this.cognome;
	}
	public String getTelefono() {
		return this.telefono;
	}
	public Data getData() {
		return this.data;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	public void setTelefono(String telefono) {this.telefono = telefono;}
	public void setData(Data data) {this.data = data;}
	public void setDataOggi(Data dataOggi) {this.dataOggi = dataOggi;}
	
	public Contatto(String nome, String cognome, String telefono, Data data, Data dataOggi) {
		setNome(nome);
		setCognome(cognome);

		telefono = telefono.strip();
		if (isValidTel(telefono))
			setTelefono(telefono);
		else
			System.out.println("Numero di telefono non valido");

		setData(data);
		setDataOggi(dataOggi);
	}

	private boolean isValidTel(String telefono){
		for (int i = 0; i < telefono.length(); i++){
			if (!Character.isDigit(telefono.charAt(i)))
				return false;
		}
		return true;
	}

	private int giorniInizioFineMese(){
		int giorniMancantiFine = 0;
		for (int i=this.dataOggi.getGg(); i < giornidelMese(this.dataOggi.getMm(), this.dataOggi.getAaaa()); i++)
			giorniMancantiFine++;

		giorniMancantiFine += this.data.getGg();

		return giorniMancantiFine;
	}

	private int giorniMancanti(){
		int giorniTotali = 0;
		// 24/10/2024 data attuale
		if (dataOggi.getMm() == data.getMm())
			giorniTotali = data.getGg() - dataOggi.getGg();
		else {
			for (int i=this.dataOggi.getMm(); i < this.data.getMm()-1; i++){
				giorniTotali += giornidelMese(i, this.dataOggi.getAaaa());
			}
			giorniTotali += giorniInizioFineMese();
		}

		return giorniTotali;
	}


	public static int giornidelMese(int mese, int anno ){
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
		return "Nome: " + this.nome +
				"\nCognome: " + this.cognome +
				"\nNumero di Telefono: " + this.telefono +
				"\nGiorni mancanti al compleanno: " + giorniMancanti() + "\n";
	}
	
	
}
