package progetto_iniziale;
import java.util.Scanner;

public class ProvaLinguaggio {

	public static void main(String[] args) {
		boolean flag = true;
		char variabile='e';
		int x = 2;
		float f=0.0f;
		double d=0.1;
		String parola = "Benvenuti in Java";
		if (x>0)
			System.out.println(x + " e\' maggiore di 0");
		else 
			f++;
		
		
		Scanner tastiera = new Scanner(System.in); // input 
		int y;
		do {
			System.out.println("Inserisci");
			y=tastiera.nextInt();
		} while(y%5!=0);
		
		for(int i=0; i<y; i++) {
			System.out.println("lezione finita\n");
			
		}

	}

}
