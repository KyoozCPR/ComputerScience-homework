package Compiti_Java.Compito_Ordinamento;

import Compiti_Java.Compito_Ereditarietà.Case;
import Compiti_Java.Compito_Ereditarietà.Monitor;
import Compiti_Java.Compito_Ereditarietà.Prodotto;

import java.util.ArrayList;
import java.util.Scanner;

public class GestionePrenotazioni {
    public ArrayList<Prenotazione> prenotazioni;
    public Scanner tastiera;

    public GestionePrenotazioni(){
        this.prenotazioni = new ArrayList<>();
        this.tastiera = new Scanner(System.in);
    }

    public int input() {
        System.out.println(
                """
                    0) Uscire 
                    1) Crei una prenotazione e la aggiunga alla lista.
                    2) Dato un codice mi restituisca lo stato dell’oggetto.
                    3) Restituisca la lista dei soli viaggi ordinata secondo il criterio naturale
                    4) Restituisca il costo di tutte le prenotazioni riferite ai soli concerti
                    5) Restituisca tutte le prenotazioni ordinate rispetto al luogo di prenotazione.
                    \nInserisci la tua scelta: 
                """
        );
        return tastiera.nextInt();

    }

    private void aggiungiPrenotazione(int tipoP){

            switch (tipoP) {
                case 1:


                default:
                    System.out.println("scelta non valida, riprovare!");
                    return;
            }



            System.out.println("\nProdotto Creato con Successo!\n");

    }

    public void menu(int scelta) {
        int input;
        switch (scelta) {
            case 0:
                System.out.println("\nArrivederci!");
                break;

            case 1:
                System.out.println("\nScegli la tipologia di prenotazione che vuoi effettuare:\t1) Viaggio\n\t2) Concerto");

                do {
                    input = tastiera.nextInt();
                    aggiungiPrenotazione(input);
                } while(input != 1 && input != 2);
            default:
                System.out.println("\nscelta non valida, riprovare!");
        }

    }
    public static void main(String[] args) {
        GestionePrenotazioni obj = new GestionePrenotazioni();
        int scelta;

        do {
            scelta = obj.input();
            obj.menu(scelta);
        } while(scelta != 0);
    }
}
