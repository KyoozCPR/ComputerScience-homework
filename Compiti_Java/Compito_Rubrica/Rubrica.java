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
		System.out.println("Inserisci la data di oggi: ");
		int giorno,mese,anno;
		giorno = rubrica.tastiera.nextInt();
		mese = rubrica.tastiera.nextInt();
		anno= rubrica.tastiera.nextInt();
		Data dataOggi = new Data(giorno, mese, anno);
		Contatto persona = rubrica.input(dataOggi);

		
	}

}

