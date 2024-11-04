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

	
	public Contatto(String nome, String cognome, String telefono, Data data, Data dataOggi) {
		setNome(nome);
		setCognome(cognome);
		telefono = telefono.strip();
		setTelefono(telefono);
		this.data = data;
		this.dataOggi = dataOggi;
	}
	
	public int compareCredenziali(Contatto contatto){
		int ris = this.cognome.compareTo(contatto.getCognome());
		ris = ris > 0 ? -1: 1;
		// se il cognome è uguale allora controlla il nome
		if(ris==0)
			return this.nome.compareTo(contatto.getNome());
		return ris;

	}

	private String isValidString(String str, boolean cognome){
		String formattedString = str.trim().toLowerCase();
		for (int i = 0; i < formattedString.length(); i++) {
			if (!Character.isLetter(formattedString.charAt(i))){
				return cognome ? "Ciprietti" : "Diego";
			}
		}
		return str;
	}

	private String isValidTel(String telefono){
		/* stringhe sono immutabili quindi quando riassegnamo un valore
		   andiamo a creare un nuovo spazio di memoria
		   che viene quindi puntato alla variabile precedente,
		   il Garbage Collector poi andrà a liberare lo spazio di memoria
		   usato in precedenza poiché non più referenziato
		 */


		String stringaFinale = telefono.trim();

		// il numero di telefono deve avere un + davanti
		 String errore = "Numero non assegnato correttamente!";
		if (stringaFinale.charAt(0) != '+')
			return errore;
		for (int i = 1; i < stringaFinale.length(); i++){
			if (!(Character.isDigit(stringaFinale.charAt(i))))
				return errore;
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
