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
		Data dataP2 = new Data("2/11/2024");
		Contatto persona2 = new Contatto("Francesco", "Concu", "351", dataP2, dataIniziale);
		System.out.println(persona.toString());
		int comparazione = persona.compareCredenziali(persona2);
		if (comparazione == 0)
			comparazione = dataIniziale.compareData(dataP2);
		if(comparazione == 1)
			System.out.println(persona +"\n"+ persona2);
		else if (comparazione == -1)
			System.out.println(persona2 +"\n"+ persona);



		
	}



}

