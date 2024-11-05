package progetto_iniziale.Compito_Rubrica;
import java.util.Scanner;
import java.time.LocalDate;
public class Rubrica {
	static Scanner tastiera = new Scanner(System.in);
	private Contatto[] listaAmici;
	private int nrAmici; // Dimensione logica dell'array


	public Rubrica(int maxContatti){
		listaAmici = new Contatto[maxContatti]; // creo un array di maxContatti contatti

	}


	public void insert(Data dataOggi){
		//funzione che aggiunge in code un contatto 
		if (nrAmici < listaAmici.length)
			listaAmici[nrAmici++]=this.input(dataOggi);

	}

	

	public Contatto input(Data dataOggi) {
		String nome, cognome, telefono;
		System.out.print("\nInserisci il nome: ");
		tastiera.nextLine().trim();
		nome = tastiera.nextLine();
		System.out.print("Inserisci il cognome: ");
		cognome = tastiera.nextLine();
		System.out.print("Inserisci il telefono: ");
		telefono = tastiera.nextLine();
		System.out.print("Inserisci la data [gg/mm/aaaa]: ");
		String data = tastiera.nextLine();
		
		Data dataNascita = new Data(data);
        	return new Contatto(nome, cognome, telefono, dataNascita, dataOggi);
	}

	public void caricaValori(Data dataOggi){
		for (int i = 0; i < listaAmici.length; i++) {
			System.out.println("\nInserisci credenziali del contatto" + (i+1) + ": ");
			insert(dataOggi);
			visualizza(listaAmici[i]);
		}
	}

	public void visualizza(Contatto persona){
		System.out.println(persona.toString());
	}

	public static void main(String[] args) {
		System.out.println("Inserisci quanti contatti vuoi creare:");
		int numeroContatti = tastiera.nextInt();
		Rubrica rubrica = new Rubrica(numeroContatti);

		// Otteniamo la data locale al sistema e creiamo un oggetto Data
		LocalDate dataAttuale = LocalDate.now();
		Data dataIniziale = new Data(dataAttuale.getDayOfMonth(), dataAttuale.getMonthValue(), dataAttuale.getYear());

		rubrica.caricaValori(dataIniziale); // carichiamo i contatti nell'array
		
	}
}

