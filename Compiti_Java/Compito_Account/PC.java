package progetto_iniziale.Compito_Account;
import java.util.ArrayList;
import java.util.Scanner;

public class PC {
    public Scanner tastiera = new Scanner(System.in);
    public static ArrayList<Account> classe = new ArrayList<Account>();



    public int input(){
        System.out.println(
                "1) inserire un account ed assegnargli un indirizzo IP\n" +
                "2) visualizzare account e indirizzo assegnato\n" +
                "3) visualizzare l'elenco degli account e degli indirizzi assegnati\n" +
                "4) disconnettere un utente\n" +
                "5) cercare le caratteristiche dei login che contengono la porzione di parola\n" +
                "6) consentire la modifica della password dato il nome account (la nuova password deve soddisfare le caratteristiche precedentemente descritte)\n" +
                "7) visualizzare gli account in ordine rispetto all'indirizzo IP\n"+
                "0) Uscire");
        System.out.println("\nScegli un'opzione: ");
        return tastiera.nextInt();
    }

    private int getAccount(String nome){
        for (int i=0; i<classe.size(); i++) {
            if (classe.get(i).getNome().equals(nome))
                return i;

        }
        return -1;
    }

    public void menu(int scelta){
        String nome;
        int posizione;
        switch (scelta) {
            case 0: System.out.println("\nArrivederci"); break;
            case 1:
                System.out.println("\nInserisci un Account [nome e pwd] e un indirizzo IP: ");

                nome = tastiera.nextLine();
                String pwd = tastiera.nextLine();
                String indirizzoIp = tastiera.nextLine();
                classe.add(new Account(nome, pwd, indirizzoIp));
                classe.getLast().setLogged(true);
                break;

            case 2:
                System.out.println("\nInserisci un Account[nome] da visualizzare: ");
                nome = tastiera.nextLine();
                posizione = getAccount(nome);
                if (posizione != -1)
                    System.out.println(classe.get(posizione));
                else
                    System.out.println("Account non trovato!\n");


                break;

            case 3:
                for (Account account : classe) System.out.println(account);
                break;

            case 4:
                System.out.println("\nInserisci un Account[nome] da disconnettere : ");
                nome = tastiera.nextLine();
                posizione = getAccount(nome);
                if (posizione != -1) {
                    classe.get(posizione).setLogged(false);
                    System.out.println("Account Disconnesso!\n");
                } else
                    System.out.println("Account non trovato!\n");
                break;

            case 6:
                System.out.println("\nInserisci un Account[nome] per cambiargli la password : ");
                nome = tastiera.nextLine();
                posizione = getAccount(nome);
                if (posizione != -1) {
                    System.out.println("\nInserisci nuova password : ");
                    String password = tastiera.nextLine();
                    classe.get(posizione).setPwd(password);
                } else
                    System.out.println("Account non trovato!\n");
                break;
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
            classe.tastiera.nextLine().trim();
            classe.menu(scelta);

        } while (scelta != 0);



    }
}
