import java.util.ArrayList;

public class GestionePersone {
    public ArrayList<Persona> persone;

    public GestionePersone(){
        this.persone = new ArrayList<>();
    }

    private ArrayList<Persona> calcolaMaggiorenni(){
        ArrayList<Persona> maggiorenni = new ArrayList<>();
        for (Persona persona: persone){
            if (persona.getAge() >= 18){
                maggiorenni.add(persona);
            }
        }
        return maggiorenni;

    }



    public static void main(String[] args) {

    }
}
