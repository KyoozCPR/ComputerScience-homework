package Compiti_Java.Impiccato;
import java.util.Scanner;
public class GestioneIMP {
    public Scanner tastiera = new Scanner(System.in);
    private Impiccato gioco;

    public Impiccato getGioco(){return this.gioco;}

    public GestioneIMP(){
        this.gioco = new Impiccato();
    }


    public void input(){
        System.out.println("\n\nInserisci una lettera o una parola: ");
        String indovina = tastiera.nextLine();
        if (indovina.length() > 1)
            gioco.indovina(indovina);
        else {
            char convertito = indovina.charAt(0);
            gioco.indovina(convertito);

        }
    }

    public static void main(String[] args){

        GestioneIMP gestione = new GestioneIMP();

        do {
            System.out.println(gestione.getGioco());
            gestione.input();

        } while (gestione.getGioco().getTentativi() != 0 && !gestione.getGioco().getVittoria());
        if (gestione.getGioco().getVittoria())
            System.out.println("Parola indovinata!");
        else
            System.out.println("Hai perso!");
    }
}
