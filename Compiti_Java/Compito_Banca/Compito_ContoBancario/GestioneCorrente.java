package Compiti_Java.Compito_Banca.Compito_ContoBancario;

import java.util.Scanner;

public class GestioneCorrente {
    public Scanner tastiera = new Scanner(System.in);
    public ContoCorrente conto;
    public int operazioniNonAmmesse;
    public int prelieviConSuccesso;

    public GestioneCorrente(){
        this.conto = new ContoCorrente("Diego Ciprietti", "102002002000");
        this.operazioniNonAmmesse = 0;
        this.prelieviConSuccesso = 0;
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

    public void menu(int scelta){
        switch (scelta){
            case 0: System.out.println("Arrivederci!"); break;
            case 1:
                System.out.println("Scelgliere che operazione effettuare:\n[\n\t0-Accredito\n\t1-Prelievo\n]: ");
                double denaro;
                try {
                    do {
                        scelta = tastiera.nextInt();
                        if (scelta == 0) {
                            System.out.println("quanti soldi vuoi accreditare: ");
                            denaro = tastiera.nextDouble();
                            conto.addAccredito(denaro);
                        } else if (scelta == 1) {
                            System.out.println("quanti soldi vuoi Prelevare: ");
                            denaro = tastiera.nextDouble();
                            conto.addPrelievo(denaro);

                        }
                        else
                            System.out.println("Scelta non valida, riprova!");
                    } while (scelta < 0 || scelta > 2);
                }

                catch(LimiteSuperatoException e){
                    if (!conto.isLimiteSuperato()) {
                        System.out.println(e.getMessage());
                        conto.setLimiteSuperato(true);
                    }
                    conto.aggiornaCounterOperazioni();
                    break;
                }


                catch(Exception e){
                    System.out.println(e.getMessage());
                    operazioniNonAmmesse++;

                    break;
                }

                finally{
                    System.out.println("Operazione Effettuata!");
                }
                break;

            case 2:
                System.out.println("Sono state effettuate  un totale di: " + conto.getOperazioniEffettuateOggi());
                break;

            case 3:
                System.out.println("Operazioni non ammesse: " + operazioniNonAmmesse);
                break;

            case 4:
                System.out.println("Prelievi effettuati con successo [ ");
                for (OperazioneBancaria op: conto.getOperazioni()){
                    if (op instanceof Prelievo){
                        Prelievo prelievo = (Prelievo) op;
                        System.out.println("\n\tPrelievo effettuato: " + prelievo.getDenaro());
                    }
                }
                System.out.println("\n");
                break;

            case 6:
                conto.addLettura();
                break;


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
