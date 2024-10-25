package progetto_iniziale.Compito_Rubrica;
import java.util.Scanner;
import java.time.LocalDate;
public class Rubrica {
	Scanner tastiera = new Scanner(System.in);
	
	public Contatto input(Data dataOggi) {
		String nome, cognome, telefono;
		int giorno,mese,anno;
		System.out.print("\nInserisci il nome: ");
		tastiera.nextLine();
		nome = tastiera.nextLine().trim(); // SALTA L'INPUT
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
		System.out.println(persona.toString());

		
	}



}

