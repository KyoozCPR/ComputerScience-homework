package Compiti_Java.Compito_Ordinamento;

import Compiti_Java.Compito_Ereditarietà.Case;
import Compiti_Java.Compito_Ereditarietà.Monitor;
import Compiti_Java.Compito_Ereditarietà.Prodotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class GestionePrenotazioni {
    public ArrayList<Prenotazione> prenotazioni;
    public Scanner tastiera;
    public int posizioneP;

    public GestionePrenotazioni(){
        this.prenotazioni = new ArrayList<>();
        this.tastiera = new Scanner(System.in);
        this.posizioneP=0;
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
        System.out.println("Inserisci il luogo della prenotazione: ");
        tastiera.nextLine().trim();
        String luogo = tastiera.nextLine();
        Prenotazione prenotazione = null;
        switch (tipoP) {
            case 1:
                System.out.println("Inserisci il mezzo utilizzato per il Viaggio (Aereo o Treno): ");
                String mezzo = tastiera.nextLine();
                prenotazione = new Viaggio(luogo, mezzo, posizioneP);
                prenotazioni.add(prenotazione);
                posizioneP++;
                break;

            case 2:
                System.out.println("Inserisci il nome dell'artista del Concerto: ");
                String artista = tastiera.nextLine();
                System.out.println("Inserisci il numero del posto riservato a sedere del concerto (minimo 1): ");
                int posto = tastiera.nextInt();
                prenotazione = new Concerto(luogo, artista, posto, posizioneP);
                prenotazioni.add(prenotazione);
                posizioneP++;
                break;

            default: System.out.println("scelta non valida, riprovare!");
        }

        System.out.println("\nPrenotazione Creata con Successo!\nCodice Prenotazione: " + prenotazione.getCodiceNumerico());

    }

    public void menu(int scelta) {
        int input;
        switch (scelta) {
            case 0:
                System.out.println("\nArrivederci!");
                break;

            case 1:
                System.out.println("\nScegli la tipologia di prenotazione che vuoi effettuare:\n\t1) Viaggio\n\t2) Concerto");

                do {
                    input = tastiera.nextInt();
                    aggiungiPrenotazione(input);
                } while(input != 1 && input != 2);
                break;

            case 2:
                System.out.println("\nInserisci il codice della prenotazione: ");
                tastiera.nextLine().trim();
                String codice = tastiera.nextLine();
                boolean presente = false;
                for (Prenotazione prenotazione: prenotazioni){
                    if (prenotazione.codiceNumerico.equals(codice)) {
                        System.out.println(prenotazione);
                        presente = true;
                        break;
                    }
                }
                if (!presente)
                    System.out.println("Prenotazione non trovata!");
                break;

            case 3:
                //criterio di ordinamento naturale dei soli viaggi
                ArrayList<Viaggio> viaggi = new ArrayList<>();
                for (Prenotazione prenotazione: prenotazioni){
                    if (prenotazione instanceof Viaggio)
                        viaggi.add((Viaggio) prenotazione);
                }
                viaggi.sort(new PrenotazioneComparePrezzo());
                for (Viaggio viaggio: viaggi){
                    System.out.println(viaggio);
                }
                break;

            case 4:
                for (Prenotazione prenotazione: prenotazioni){
                    if (prenotazione instanceof Concerto)
                        System.out.println("Il costo del Concerto: " + prenotazione.codiceNumerico + " è di: " + prenotazione.getPrezzoFinale());

                }
                break;

            case 5:
                ArrayList<Prenotazione> copiaAP = prenotazioni;
                copiaAP.sort(new PrenotazioneCompareLuogo());
                for (Prenotazione prenotazione: prenotazioni){
                    System.out.println(prenotazione);
                }
                break;



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
