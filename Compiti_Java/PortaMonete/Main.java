package Compiti_Java.PortaMonete;
import javax.swing.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collections;

public class Main {
    public ArrayList<Portamonete> portamonete;
    public Scanner tastiera;

    public Main(){
        this.portamonete = new ArrayList<>();
        this.tastiera = new Scanner(System.in);
    }

    public void menu(){
        int scelta;
        do {
            System.out.println("Inserisci il tuo nome: ");
            String proprietario = tastiera.nextLine();
            this.portamonete.add(new Portamonete(proprietario));
            System.out.println("0) Esci\n1) Aggiungi monete\n2)Stampa contenuto portamonete");
            scelta = tastiera.nextInt();
            gestioneOperazioni(scelta);
        } while (scelta != 0);


    }

    private void gestioneOperazioni(int scelta) {
        switch(scelta){
            case 0:
                System.out.println("Arrivederci!");
            case 1:
                System.out.println("Inserisci la moneta che vuoi aggiungere: ");
                float moneta = tastiera.nextFloat();
                System.out.println("Quante ne vuoi aggiungere: ");
                int quantita = 1;
                do {
                    if (quantita <= 0)
                        System.out.println("quantita non valida! riprovare");
                    quantita = tastiera.nextInt();
                    this.portamonete.getLast().aggiungiMonete(moneta);
                } while (quantita <= 0);
            case 2:
                this.portamonete.getLast().stampaDenaro();
                System.out.print("Totale: " + this.portamonete.getLast().denaro());

            default:
                System.out.println("Scelta non valida! riprova");
        }
    }

    public void maxPortamonete(){
        Collections.sort(this.portamonete);
    }


    public static void main(String[] args){
        Main obj = new Main();
        obj.menu();
        System.out.println("Inserire nuova persona? [0-No 1-Si]: ");
        int input = obj.tastiera.nextInt();
        if (input == 0)
            obj.maxPortamonete();
        else
            obj.menu();



    }
}
