package progetto_iniziale.Compito_Rubrica;
import java.util.Scanner;


public class Contatto {
	private String nome, cognome, telefono;
	private Data data, dataOggi;
	
	public String getNome() {return this.nome;}
	public String getCognome(){
		return this.cognome;
	}
	public String getTelefono() {
		return this.telefono;
	}
	public Data getData() {
		return this.data;
	}

	public void setNome(String nome) {this.nome = isValidString(nome, false);}
	public void setCognome(String cognome) {this.cognome = isValidString(cognome, true);}
	public void setTelefono(String telefono) {this.telefono = isValidTel(telefono);}
	public void setData(Data data) {this.data = data;}
	public void setDataOggi(Data dataOggi) {this.dataOggi = dataOggi;}
	
	public Contatto(String nome, String cognome, String telefono, Data data, Data dataOggi) {
		setNome(nome);
		setCognome(cognome);

		telefono = telefono.strip();
		setTelefono(telefono);

		setData(data);
		setDataOggi(dataOggi);
	}

	private String isValidString(String str, boolean cognome){
		String formattedString = str.trim().toLowerCase();
		for (int i = 0; i < formattedString.length(); i++) {
			if (!Character.isLetter(formattedString.charAt(i))){
				str = cognome ? "Ciprietti" : "Diego";
			}
		}
		return str;
	}

	private String isValidTel(String telefono){
		String stringaFinale = telefono.trim();

		for (int i = 0; i < telefono.length(); i++){
			if (!(Character.isDigit(telefono.charAt(i))))
				stringaFinale="00000000000";
		}
		return stringaFinale;
	}

	private int giorniInizioFineMese(){
		int giorniMancantiFine = 0;
		for (int i=this.dataOggi.getGg(); i < dataOggi.giornidelMese(this.dataOggi.getMm(), this.dataOggi.getAaaa()); i++)
			giorniMancantiFine++;

		giorniMancantiFine += this.data.getGg();

		return giorniMancantiFine;
	}



	private int giorniMancanti(){
		int giorniTotali = 0;

		if (dataOggi.getMm() == data.getMm())
			giorniTotali = data.getGg() - dataOggi.getGg();
		else {
			for (int i=this.dataOggi.getMm()+1; i < this.data.getMm()-1; i++){
				giorniTotali += dataOggi.giornidelMese(i, this.dataOggi.getAaaa());
			}
			giorniTotali += giorniInizioFineMese();
		}

		return giorniTotali;
	}



	
	@Override
	public String toString() {
		return "Nome: " + this.nome +
				"\nCognome: " + this.cognome +
				"\nNumero di Telefono: " + this.telefono +
				"\nGiorni mancanti al compleanno: " + giorniMancanti() + "\n";
	}
	
	
}
