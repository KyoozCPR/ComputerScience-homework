package progetto_iniziale.Compito_Noleggio;

import progetto_iniziale.Compito_Banca.Bancomat;
import progetto_iniziale.Compito_Banca.GestioneBanca;

import java.util.Scanner;

public class Principale {

    public Scanner tastiera = new Scanner(System.in);




    public int menu(){
        System.out.println("\n1 - Calcolo del costo di noleggio (l’utente sceglie quale veicolo noleggiare tra quelli\n" +
                "proposti);\n" +
                "2 - Visualizza gli sconti previsti;\n" +
                "3 – Uscita.");
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

                break;

            case 2:

                break;
            case 3:

                break;

            default:
                System.out.println("Scelta non valida, riprova!");
                break;
        }
    }
    public static void main(String[] args){
        Principale menu = new Principale();
        int risultato;

        do {
            risultato = menu.menu();
            menu.eseguiOperazioni(risultato);
        } while (risultato != 0);
    }
}
