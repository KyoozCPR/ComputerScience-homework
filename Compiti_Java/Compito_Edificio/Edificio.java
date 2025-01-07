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
                "0) Uscire\n" +
                        "1) Aggiungere un utente e verificarne il login.\n" +
                        "2) Prenotare una sala disponibile.\n" +
                        "3) Visualizzare l’elenco delle sale e il loro stato (disponibile o occupata).\n" +
                        "4) Liberare una sala occupata.\n" +
                        "5) Cercare le sale che hanno una capacità minima specificata.\n" +
                        "6) Ordinare le sale per capacità."

        );
        return tastiera.nextInt();
    }

    private Utente login(String email, String pwd){
        for (Utente utente : utenti) {
            if (utente.getEmail().equals(email) && utente.getPassword().equals(pwd)) {
                return utente;
            }
        }
        return null;
    }

    public void menu(int scelta){
        String nome, email, pwd;
        switch (scelta){
            case 0: System.out.println("Arrivederci!"); break;
            case 1:
                System.out.println("\nInserire il nome dell'utente: ");
                nome = tastiera.nextLine();
                System.out.println("Inserire l'email: ");
                email = tastiera.nextLine();
                System.out.println("Inserisci una password: ");
                pwd = tastiera.nextLine();

                utenti.add(new Utente(nome, email, pwd));
                break;

            case 2:
                System.out.println("Scegli quale sala da prenotare tra le elencate: ");
                for (int i=0; i< sala.size(); i++){
                    System.out.println("\t"+ i+") " + sala.get(i).getNome());
                }
                int scelta_sala = tastiera.nextInt();
                System.out.println("Effettuare il login ad un account per prenotare: ");
                tastiera.nextLine().trim();
                System.out.println("Inserire l'email: ");
                email = tastiera.nextLine();
                System.out.println("Inserisci una password: ");
                pwd = tastiera.nextLine();
                Utente logged = login(email, pwd);
                if (logged != null){
                    logged.setSala_prenotata(sala.get(scelta_sala));
                }
                else {
                    System.out.println("Credenziali non valide!");
                }
                break;

            case 3:

                break;


            default:
                System.out.println("Scelta non valida, riprovare!");
        }
    }

    public static void main(String[] args){
        Edificio obj = new Edificio();
        int scelta;

        do {
            scelta = obj.input();
            obj.tastiera.nextLine().trim();
            obj.menu(scelta);
        } while(scelta != 0);
    }

}
