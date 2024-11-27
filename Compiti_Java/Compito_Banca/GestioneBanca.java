package progetto_iniziale.Compito_Banca;
import java.util.Scanner;
public class GestioneBanca {
    public Scanner tastiera = new Scanner(System.in);
    private Bancomat banca;

    public GestioneBanca(){
        this.banca = new Bancomat();
    }

    public int menu(){
        System.out.println("0)Uscire\n1)Visualizza Saldo\n2)Deposita\n3)Preleva Denaro\n");
        System.out.println("Inserisci opzione: ");
        int ris = this.tastiera.nextInt();
        return ris;

    }

    public void eseguiOperazioni(int scelta){
        switch(scelta){
            case 0:
                System.out.println("Arrivederci!");
                break;
            case 1:
                System.out.println(this.banca.toString());
                break;

            case 2:
                System.out.println("Inserisci l'importo da depositare: ");
                double soldi = tastiera.nextDouble();
                this.banca.deposita(soldi);
                System.out.println(this.banca +  " dopo il deposito");
                break;
            case 3:
                System.out.println("Inserisci l'importo da prelevare: ");
                double soldi_p = tastiera.nextDouble();
                this.banca.prelieva(soldi_p);
                System.out.println(this.banca + " dopo il prelievo");
                break;

            default:
                System.out.println("Scelta non valida, riprova!");
                break;
        }
    }

    public static void main(String[] args){
        GestioneBanca banca = new GestioneBanca();
        int risultato;

        do {
            risultato = banca.menu();
            banca.eseguiOperazioni(risultato);
        } while (risultato != 0);
    }
}