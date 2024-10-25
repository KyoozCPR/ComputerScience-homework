package progetto_iniziale.Compito_Rubrica;
import java.util.Scanner;

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
		int giorno,mese,anno;


		System.out.println("Inserisci il giorno di oggi: ");
		giorno = rubrica.tastiera.nextInt();

		System.out.println("nserisci il mese di oggi: ");
		mese = rubrica.tastiera.nextInt();

		System.out.println("Inserisci l'anno di oggi: ");
		anno= rubrica.tastiera.nextInt();


		Data dataOggi = new Data(giorno, mese, anno);
		Contatto persona = rubrica.input(dataOggi);

		System.out.println(persona.toString());

		
	}



}

