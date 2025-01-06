package progetto_iniziale.Compito_Edificio;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Edificio {
    public Scanner tastiera = new Scanner(System.in);
    ArrayList<Sala> sala = new ArrayList<Sala>(
            Arrays.asList(
                    new Sala("Main", 100),
                    new Sala("Cucina", 20),
                    new Sala("Camera", 5))
    );
    ArrayList<Utente> utenti = new ArrayList<>();

    public int input(){
        System.out.println(
                "0) Uscire" +
                        "Aggiungere un utente e verificarne il login.\n" +
                        "Prenotare una sala disponibile.\n" +
                        "Visualizzare l’elenco delle sale e il loro stato (disponibile o occupata).\n" +
                        "Liberare una sala occupata.\n" +
                        "Cercare le sale che hanno una capacità minima specificata.\n" +
                        "Ordinare le sale per capacità."

        );
        return tastiera.nextInt();
    }


    public void menu(int scelta){
        switch (scelta){
            case 0: System.out.println("Arrivederci!");
            case 1:
                System.out.println("\nInserire il nome dell'utente: ");
                String nome = tastiera.nextLine();
                System.out.println("Inserire l'email: ");
                String email = tastiera.nextLine();
                System.out.println("Inserisci una password: ");
                String pwd = tastiera.nextLine();
                utenti.add(new Utente(nome, email, pwd));

            default:
                System.out.println("Scelta non valida, riprovare!");
        }
    }

    public static void main(String[] args){
        Edificio obj = new Edificio();
        int scelta;

        do {
            scelta = obj.input();
            obj.menu(scelta);
        } while(scelta != 0);
    }

}
