package progetto_iniziale.Compito_Rubrica;
import java.util.Scanner;
import java.time.LocalDate;
public class Rubrica {
	Scanner tastiera = new Scanner(System.in);
	private Contatto[] listaAmici;
	private int nrAmici;


	public Rubrica(int maxContatti){
		listaAmici = new Contatto[maxContatti] // creo un array di maxContatti contatti

	}


	public void insert(){
		//funzione che aggiunge in code un contatto 
		if (nrAmici < listaAmici.length-1)
			listaAmici[nrAmici++]=this.input(); 

	}

	

	public Contatto input(Data dataOggi) {
		String nome, cognome, telefono;
		int giorno,mese,anno;
		System.out.print("\nInserisci il nome: ");
		nome = tastiera.nextLine();
		System.out.print("Inserisci il cognome: ");
		cognome = tastiera.nextLine();
		System.out.print("Inserisci il telefono: ");
		telefono = tastiera.nextLine();
		System.out.print("Inserisci il giorno: ");
		giorno = tastiera.nextInt();
		System.out.print("Inserisci il mese: ");
		mese = tastiera.nextInt();
		System.out.print("Inserisci l'anno: ");
		anno= tastiera.nextInt();
		Data dataNascita = new Data(giorno, mese, anno);
        return new Contatto(nome, cognome, telefono, dataNascita, dataOggi);
	}

	public static void main(String[] args) {
		Rubrica rubrica = new Rubrica();
		LocalDate dataAttuale = LocalDate.now();


		Data dataIniziale = new Data(dataAttuale.getDayOfMonth(), dataAttuale.getMonthValue(), dataAttuale.getYear());
		Contatto persona = rubrica.input(dataIniziale);

		Data dataP2 = new Data("2/11/2024");
		Contatto persona2 = new Contatto("Diego", "Ciprietti", "351", dataP2, dataIniziale);


		// Stampiamo in ordine le due persone
		int comparazione = persona.compareCredenziali(persona2);
		// se il nome completo e uguale allora compariamo le date
		if (comparazione == 0)
			comparazione = dataIniziale.compareData(dataP2); //riutilizzo della variabile
		if(comparazione == 1)
			System.out.println("Il primo contatto arriva prima\n"+ persona2 +"\n"+ persona);
		else if (comparazione == -1)
			System.out.println("Il secondo contatto arriva prima\n"+ persona2 +"\n"+ persona);
		else
			System.out.println("I due contatti sono uguali\n"+ persona +"\n"+ persona2);


		
	}



}

