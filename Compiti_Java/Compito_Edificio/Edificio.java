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
    public static Utente loggedUser;
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
        int scelta_sala;
        switch (scelta){
            case 0: System.out.println("Arrivederci!"); break;
            case 1:
                System.out.println("\nInserire il nome dell'utente: ");
                nome = tastiera.nextLine();
                System.out.println("Inserire l'email: ");
                email = tastiera.nextLine();
                System.out.println("Inserisci una password: ");
                pwd = tastiera.nextLine();
                loggedUser = new Utente(nome, email, pwd); //log in
                utenti.add(loggedUser);
                break;

            case 2:
                System.out.println("Scegli quale sala da prenotare tra le elencate: ");
                for (int i=0; i< sala.size(); i++){
                    System.out.println("\t"+ i+") " + sala.get(i).getNome());
                }
                scelta_sala = tastiera.nextInt();
                loggedUser.setSala_prenotata(sala.get(scelta_sala));
                break;

            case 3:
                for(Sala sale: sala){System.out.println(sale);}
                break;

            case 4:
                System.out.println("Vuoi liberare la sala: "+ loggedUser.getSala_prenotata().getNome() + " da te prenotata?\n[0-si 1-no]: ");
                scelta_sala = tastiera.nextInt();
                if (scelta_sala == 1)
                    sala.get(scelta_sala).setDisponibilità(true);
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
