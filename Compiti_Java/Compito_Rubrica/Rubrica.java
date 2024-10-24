import java.util.Scanner;

public class Rubrica {
	Scanner tastiera = new Scanner(System.in);
	
	public Contatto input() {
		String nome, cognome, telefono;
		int giorno,mese,anno;
		Data data;
		nome = tastiera.nextLine();
		cognome = tastiera.nextLine();
		telefono = tastiera.nextLine();
		giorno = tastiera.nextInt();
		mese = tastiera.nextInt();
		anno= tastiera.nextInt();
		Data dataNascita = new Data(giorno, mese, anno);
		Contatto persona = new Contatto(nome, cognome, telefono, dataNascita);
		return persona;
	}

	public static void main(String[] args) {
		Rubrica rubrica = new Rubrica();
		Contatto persona = rubrica.input();
		
	}

}

