package progetto_iniziale;

public class Main {

//	public static int scelta() {
//
//	    System.out.println("\n0. Uscire \n1. Visualizzare un punto selezionato\n2. Visualizzare tutti i punti in un certo insieme\n3. Restiruire la distanza tra due punti selezionati\n4. Restituire il punto medio tra due punti\n5. Restituire in ordine i punti piu vicino all'origine\n6. Cancellare un punto\n");
//	    Scanner tastiera = new Scanner(System.in);
//	    int scelta = tastiera.nextInt();
//	    return scelta;
//
//	}
//
	public static void main(String[] args) {
		Punto punto1 = new Punto(12, 5);
		Punto punto2 = new Punto(1, 1);
		System.out.println(punto1.toString());
		Punto.puntoL(punto1);
		Punto.puntoL(punto2);
		System.out.println(Punto.distanza(punto1, punto2));
		System.out.println(Punto.distanza(punto2));
		Punto.PuntoMedio(punto1, punto2);
		

		
		
		
	}

}
