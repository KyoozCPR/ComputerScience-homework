package progetto_iniziale.Compito_Rubrica;
import java.util.Scanner;

public class Rubrica {
	Scanner tastiera = new Scanner(System.in);
	
	public Contatto input(Data dataOggi) {
		String nome, cognome, telefono;
		int giorno,mese,anno;
		nome = tastiera.nextLine();
		cognome = tastiera.nextLine();
		telefono = tastiera.nextLine();
		giorno = tastiera.nextInt();
		mese = tastiera.nextInt();
		anno= tastiera.nextInt();
		Data dataNascita = new Data(giorno, mese, anno);
        return new Contatto(nome, cognome, telefono, dataNascita, dataOggi);
	}

	public static void main(String[] args) {
		Rubrica rubrica = new Rubrica();
		int giorno,mese,anno;

		System.out.println("Inserisci la data di oggi:\n ");

		System.out.println("\tInserisci la giorno di oggi: ");
		giorno = rubrica.tastiera.nextInt();

		System.out.println("\tInserisci il mese di oggi: ");
		mese = rubrica.tastiera.nextInt();

		System.out.println("\tInserisci l'anno di oggi: ");
		anno= rubrica.tastiera.nextInt();


		Data dataOggi = new Data(giorno, mese, anno);
		Contatto persona = rubrica.input(dataOggi);

		System.out.println(persona.toString());

		
	}



}

