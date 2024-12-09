package progetto_iniziale.Compito_Account;
import java.util.ArrayList;
import java.util.Scanner;

public class PC {
    public Scanner tastiera = new Scanner(System.in);
    private ArrayList<Account> classe;

    public PC(){
        this.classe = new ArrayList<Account>();
    }

    public int input(){
        System.out.println(
                "1) inserire un account ed assegnargli un indirizzo IP\n" +
                "2) visualizzare account e indirizzo assegnato\n" +
                "3) visualizzare l'elenco degli account e degli indirizzi assegnati\n" +
                "4) disconnettere un utente\n" +
                "5) cercare le caratteristiche dei login che contengono la porzione di parola\n" +
                "6) consentire la modifica della password dato il nome account (la nuova password deve soddisfare le caratteristiche precedentemente descritte)\n" +
                "7) visualizzare gli account in ordine rispetto all'indirizzo IP "+
                "0) Uscire");
        System.out.println("\nScegli un'opzione: ");
        return tastiera.nextInt();
    }

    public void menu(int scelta){
        switch (scelta) {
            case 0: System.out.println("\nArrivederci"); break;
            case 1:break;
            default:
                System.out.println("\nScelta non valida!");
                break;
        }
    }


    public static void main(String[] args){
        PC classe = new PC();
        int scelta;
        do {
            scelta = classe.input();


        } while (scelta != 0);



    }
}
