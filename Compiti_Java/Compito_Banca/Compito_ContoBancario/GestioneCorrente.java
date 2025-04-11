package Compiti_Java.Compito_Banca.Compito_ContoBancario;

import java.util.Scanner;

public class GestioneCorrente {
    public Scanner tastiera = new Scanner(System.in);

    public int input(){
        System.out.println("""
                 0) Uscire
                 1) inserire un'operazione
                 2) calcolare il totale degli accrediti
                 3) il numero dei prelievi negati
                 4) l'elenco dei prelievi effettuati con successo
                 5) il numero delle letture richieste.
                 6) visualizza il saldo
                
                """);

        return tastiera.nextInt();
    }

    public void menu(int scelta){
        switch (scelta){
            case 0: System.out.println("Arrivederci!"); break;
            default: System.out.println("Scelta non valida, riprovare!");
        }
    }

    public static void main(String[] args) {
        GestioneCorrente obj = new GestioneCorrente();

        int scelta;
        do {
            scelta = obj.input();
            obj.menu(scelta);
        } while (scelta != 0);
    }
}
