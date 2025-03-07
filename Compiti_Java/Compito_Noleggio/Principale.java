package Compiti_Java.Compito_Noleggio;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Principale {

    public Scanner scanner = new Scanner(System.in);
    public Compagnia auto;


    public Principale(){
        this.auto = new Compagnia("Noleggio SRL", "Diego", "Ciprietti",
                new ArrayList<>(Arrays.asList(
                        new Veicolo("Audi RS6", "AB123CD", 1200),
                        new Veicolo("Lamborghini Aventador", "EF456GH", 2400),
                        new Veicolo("BMW M3", "IJ789KL", 1800)
                )));
    }



    public int menu(){
        System.out.println("\n1 - Calcolo del costo di noleggio (l’utente sceglie quale veicolo noleggiare tra quelli\n" +
                "proposti);\n" +
                "2 - Visualizza gli sconti previsti;\n" +
                "0 – Uscita.");
        System.out.println("Inserisci opzione: ");
        int ris = scanner.nextInt();
        return ris;

    }

    private void mostraVeicoli() {
        for (int i = 0; i < auto.getVeicoli().size(); i++) {
            Veicolo veicolo = auto.getVeicoli().get(i);
            System.out.println(i + ". " + veicolo.getCasaProduttrice() + " " + veicolo.getCasaProduttrice() + " (" + veicolo.getTarga() + ", " + veicolo.getCilindrata() + "cc)");
        }
    }

    public void eseguiOperazioni(int scelta){
        switch(scelta){
            case 0:
                System.out.println("Arrivederci!");
                break;
            case 1:
                System.out.println("\nVeicoli disponibili:");
                mostraVeicoli();
                System.out.print("Seleziona il veicolo (indice): ");
                int indiceVeicolo = scanner.nextInt();
                System.out.print("Inserisci il numero di giorni di noleggio: ");
                int giorni = scanner.nextInt();
                double costo = auto.calcolaCosto(indiceVeicolo, giorni);
                System.out.println("Costo totale del noleggio: " + costo + " euro");
                break;

            case 2:
                auto.stampaSconti();
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
