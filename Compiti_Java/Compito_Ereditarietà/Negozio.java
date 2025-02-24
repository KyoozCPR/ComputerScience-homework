package Compiti_Java.Compito_Ereditarietà;
import java.util.ArrayList;
import java.util.Scanner;


public class Negozio {
    public ArrayList<Prodotto> prodotti;
    public Scanner tastiera = new Scanner(System.in);

    public Negozio() {
        this.prodotti = new ArrayList<Prodotto>();
    }

    public int input() {
        System.out.println(
                """
                                0) Uscire\s
                                1) aggiungere nuovi prodotti\s
                                2) Stampare le informazioni di uno dei qualsiasi prodotti presenti in negozio
                                3) Stampare tutti i prodotti presenti (l'inventario)
                                4) Contare tutti i monitor all'interno di un range di pollici
                                5) Modificare le caratteristiche di un prodotto conoscendo il suo codice a barre
                                6) Determinare il valore di tutti i prodotti presenti in negozio.\n
                        """
        );
        return tastiera.nextInt();

    }

    private void aggiungiProdotti(int prodotto) {
        String nomeP;
        float prezzo;

        System.out.println("Inserisci il nome del prodotto che vuoi inserire: ");
        nomeP = tastiera.nextLine();
        System.out.println("Inserisci il prezzo del prodotto: ");
        prezzo = tastiera.nextFloat();
        tastiera.nextLine().trim();
        Prodotto prodottoD = null;

        switch (prodotto) {
            case 0:
                System.out.println("Inserisci quantità di ram, nome del SO, quantità in GB dell'ssd, nome della motherboard (nell'esatto ordine):\n");
                int ram = tastiera.nextInt();
                tastiera.nextLine().trim();
                String os = tastiera.nextLine();
                int ssd = tastiera.nextInt();
                tastiera.nextLine().trim();
                String motherboard = tastiera.nextLine();
                prodottoD = new Case(nomeP, prezzo, ram, os, ssd, motherboard);
                prodotti.add(prodottoD);
                break;

            case 2:
                System.out.println("Inserisci  hrz, pollici e risoluzione (nell'esatto ordine):\n");
                int hrz = tastiera.nextInt();
                tastiera.nextLine();
                float pollici = tastiera.nextFloat();
                tastiera.nextLine();
                int risoluzione = tastiera.nextInt();
                prodottoD = new Monitor(nomeP, prezzo, hrz, pollici, risoluzione);
                prodotti.add(prodottoD);
                break;

            default:
                System.out.println("scelta non valida, riprovare!");
                return;
        }


        prodottoD.setCodiceBarre();
        System.out.println("\nProdotto Creato con Successo!\n");
    }



    public void menu(int scelta) {
        int input;
        switch (scelta) {
            case 0:
                System.out.println("Arrivederci!\n");
                break;
            case 1:
                System.out.println("Scegli che tipo di prodotto inserire (0-Case, 1-Cpu, 2-Monitor): ");

                do {
                    input = tastiera.nextInt();
                    tastiera.nextLine().trim();
                    if (input < 0 || input > 2)
                        System.out.println("Valore non valido, riprova!: ");

                } while (input < 0 || input > 2);

                aggiungiProdotti(input);
                break;
            case 2:
                System.out.print("Inserisci il nome del prodotto: ");
                tastiera.nextLine().trim();
                String nome_inserito = tastiera.nextLine();

                for (Prodotto prodotto: prodotti){

                    if (prodotto.getNome().equals(nome_inserito))
                        System.out.println(prodotto);
                    else
                        System.out.println("\nProdotto non esistente!\n");


                }
                break;
            case 3:

                for (Prodotto prodotto:prodotti){
                    System.out.println(prodotto);
                }
                break;
            case 4:
                System.out.println("entro che range vuoi cercare i monitor: 0-{18-27} 1-{27-34} 2-{34-49}");
                int intervallo = tastiera.nextInt();
                for (Prodotto prodotto : prodotti) {
                    if (prodotto instanceof Monitor) {
                        System.out.println(prodotto);
                    }
                }
                break;
            case 5:
                System.out.println("Inserisci il codice a barre del prodotto che vuoi moficare: ");
                long codiceAbarre = tastiera.nextLong();
                for (Prodotto prodotto : prodotti) {
                    if (prodotto.getCodiceBarre() == codiceAbarre) {
                        System.out.println("modifica il nome");
                        prodotto.setNome(tastiera.nextLine());
                    }
                }

            case 6:
                float valoreNegozio = 0;
                for (Prodotto prodotto : prodotti) {
                    valoreNegozio += prodotto.getPrezzo();
                }
                System.out.println("valore totale del negozio: " + valoreNegozio + "$");
                break;

                default:
                System.out.println("scelta non valida, riprovare!");
        }

    }


    public static void main(String[] args) {
        Negozio obj = new Negozio();
        int scelta;

        do {
            scelta = obj.input();

            obj.menu(scelta);
        } while (scelta != 0);

    }
}
