package progetto_iniziale.Impiccato;
import java.util.Scanner;
public class GestioneIMP {


    public static void main(String[] args){
        Impiccato gioco = new Impiccato();
        Scanner tastiera = new Scanner(System.in);


        do {
            System.out.println(gioco);
            System.out.println("\n\nInserisci una lettera o una parola: ");
            String indovina = tastiera.nextLine();
            if (indovina.length() > 1)
                gioco.indovina(indovina);
            else {
                char convertito = indovina.charAt(0);
                gioco.indovina(convertito);

            }

        } while (gioco.getTentativi() != 0 && !gioco.getVittoria());
        if (gioco.getVittoria())
            System.out.println("Parola indovinata!");
    }
}
