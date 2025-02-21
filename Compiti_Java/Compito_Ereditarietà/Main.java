package progetto_iniziale.Compito_Ereditarietà;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    ArrayList<Prodotto> prodotti;
    Scanner tastiera = new Scanner(System.in);

    public Main(){
        this.prodotti = new ArrayList<Prodotto>();
    }

    public int input(){
        System.out.println(
                """
                        0) Uscire\s
                        1) aggiungere nuovi prodotti\s
                        2) Stampare le informazioni di uno dei qualsiasi prodotti presenti in negozio
                        3) Stampare tutti i prodotti presenti (l'inventario)
                        4) Contare tutti i monitor all'interno di un range di pollici
                        5) Modificare le caratteristiche di un prodotto conoscendo il suo codice a barre
                        6) Determinare il valore di tutti i prodotti presenti in negozio\n.
                """
        );
        return tastiera.nextInt();

    }

    private void aggiungiProdotti(int prodotto){
        switch (prodotto){
            case 0:
                System.out.println("Inserisci ram,os, ssd, motherboard (in questo ordine speicifico serparato da una virgola) :");

        }
    }

    public void menu(int scelta){
        int input;
        switch (scelta){
            case 0: System.out.println("Arrivederci!\n"); break;
            case 1:
                System.out.println("Scegli che tipo di prodotto inserire (0-Case, 1-Cpu, 2-Monitor): ");

                do{
                    input = tastiera.nextInt();
                    if(input < 0 || input > 2)
                        System.out.println("Valore non valido, riprova!: ");

                } while(input < 0 || input > 2);

                aggiungiProdotti(input);
                break;



        }

    }


    public static void main(String[] args) {

    }
}
