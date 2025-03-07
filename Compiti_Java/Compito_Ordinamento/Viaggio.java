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
    }

    @Override
    public float aggiornaPrezzo() {
        if (mezzo.equals("aereo"))
            super.prezzoBase += (float) (prezzoBase * 0.2);
        else if (mezzo.equals("treno"))
            super.prezzoBase += (float) (prezzoBase * 0.1);


        return super.prezzoBase;
    }

    @Override
    public String toString() {
        return "Viaggio{" +
                "mezzo='" + mezzo + '\'' +
                '}';
    }
}
