package Compiti_Java.Compito_Banca.Compito_ContoBancario;

import java.util.Scanner;

public class GestioneCorrente {
    public Scanner tastiera = new Scanner(System.in);
    public ContoCorrente conto;


    public GestioneCorrente(){
        this.conto = new ContoCorrente("Diego Ciprietti", "102002002000");
    }

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

    public void menu(int scelta) throws OperazioneBancariaNonAmmessaException, LimiteSuperatoException, SaldoInsufficienteException {
        switch (scelta){
            case 0: System.out.println("Arrivederci!"); break;
            case 1:
                System.out.println("Scelgliere che operazione effettuare:\n[\n\t0-Accredito\n\t1-Prelievo\n\t2-Lettura\n]: ");
                scelta = tastiera.nextInt();
                double denaro;
                do {
                    if (scelta == 0) {
                        System.out.println("quanti soldi vuoi accreditare: ");
                        denaro = tastiera.nextDouble();
                        conto.addAccredito(denaro);
                    } else if (scelta == 1) {
                        System.out.println("quanti soldi vuoi Prelevare: ");
                        denaro = tastiera.nextDouble();
                        conto.addPrelievo(denaro);
                    } else if (scelta == 2)
                        conto.addLettura();
                }while(scelta < 0 || scelta > 2);


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
