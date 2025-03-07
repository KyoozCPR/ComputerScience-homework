package Compiti_Java.Compito_Ordinamento;

final public class Viaggio extends Prenotazione{
    private String mezzo;


    public String getMezzo() {
        return mezzo;
    }

    public void setMezzo(String mezzo) {
        if (mezzo.equals("aereo") || mezzo.equals("treno"))
            this.mezzo = mezzo;
        else
            this.mezzo = "aereo"; // di default
    }

    private String generaCodice(int contatore){
        return "Viaggio" + contatore;
    }

    public Viaggio(String luogo, String mezzo, int conta) {
        super(luogo, 200);
        super.codiceNumerico += generaCodice(conta);
        setMezzo(mezzo);
        aggiornaPrezzo();
    }

    @Override
    public void aggiornaPrezzo() {
        if (mezzo.equals("aereo"))
            super.prezzoFinale += (float) (prezzoBase * 0.2);
        else if (mezzo.equals("treno"))
            super.prezzoFinale += (float) (prezzoBase * 0.1);

    }

    @Override
    public String toString() {
        return super.toString() +
                ", mezzo='" + mezzo + '\'' +
                ", prezzo= " + super.prezzoFinale+
                '}';
    }
}
