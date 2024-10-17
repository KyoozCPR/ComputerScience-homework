package progetto_iniziale;
import java.util.Scanner;

public class GestionePunti{

	public int scelta() {

	    System.out.println("\n0. Uscire \n1.Visualizzare un punto selezionato \n2. Restiruire la distanza tra due punti selezionati\n3. Restituire il punto medio tra due punti\n4.Restituire la distanza tra un punto e l'origine\n");
	    Scanner tastiera = new Scanner(System.in);
	    int scelta = tastiera.nextInt();
	    return scelta;

	}


	public void menu(int scelta, Punto p1, Punto p2) {
		Scanner tastiera = new Scanner(System.in);
		int punto;
		float risultato;
		switch (scelta) {

			case 0:
				System.out.println("Arrivederci!\n");
				break;

			case 1:

				System.out.println("\nScegli quale punto visualizzare [1,2]: ");
				punto = tastiera.nextInt();
				if (punto == 1)
					System.out.println(p1.toString());
				else if (punto == 2)
					System.out.println(p2.toString());
				break;

			case 2:

				System.out.println("\nScegli su quale punto visualizzare il quadrante letteralmente [1,2]: ");
				punto = tastiera.nextInt();
				if (punto == 1)
					p1.puntoL();
				else if (punto == 2)
					p2.puntoL();
				break;

			case 3:

				risultato = p1.distanza(p2);
				System.out.println(risultato);
				break;

			case 4:

				Punto.PuntoMedio(p1, p2);
				break;

			case 5:

				System.out.println("\nScegli su quale punto operare la distanza con l'origine [1,2]: ");
				punto = tastiera.nextInt();
				if (punto == 1)
					System.out.println(p1.distanza());
				else if (punto == 2)
					System.out.println(p2.distanza());
				break;


			default:
				System.out.println("Scelta non valida!\n");
				break;
		}
	}

	public static void main(String[] args) {
		GestionePunti m = new GestionePunti();
		Scanner tastiera = new Scanner(System.in);


		System.out.println("Inserisci il primo punto");
		int s,x1,y1,x2,y2;
		x1 = tastiera.nextInt();
		y1 = tastiera.nextInt();

		System.out.println("Inserisci il secondo punto");
		x2 = tastiera.nextInt();
		y2 = tastiera.nextInt();

		Punto punto1 = new Punto(x1, y1);
		Punto punto2 = new Punto(x2, y2);


		do {
			s = m.scelta();
			m.menu(s, punto1, punto2);

		}while(s != 0);


		
	}

}
