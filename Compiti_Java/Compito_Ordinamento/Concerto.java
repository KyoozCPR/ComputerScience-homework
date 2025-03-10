package Compiti_Java.Compito_Ordinamento;

public class Concerto extends Prenotazione{
    private String artista;
    private int numPosto;

    public String getArtista() {
        return artista;
    }

    public void setArtista(String artista) {
        this.artista = artista;
    }

    public int getNumPosto() {
        return numPosto;
    }

    public void setNumPosto(int numPosto) {
        if (numPosto > 0)
            this.numPosto = numPosto;
        else
            this.numPosto = 1;
    }

    private String generaCodice(int contatore){
        return "Concerto" + contatore;
    }

    public Concerto(String luogo, String artista, int numPosto, int conta) {
        super(luogo, 50);
        super.codiceNumerico += generaCodice(conta);
        setArtista(artista);
        setNumPosto(numPosto);
        aggiornaPrezzo();
    }

    @Override
    public void aggiornaPrezzo() {

         if (numPosto >= 1 && numPosto <= 30)
             super.prezzoFinale += (float) (prezzoBase * 0.3);
         else if (numPosto <= 50)
             super.prezzoFinale += (float) (prezzoBase * 0.2);


    }

    @Override
    public String toString() {
        return super.toString() +
                ", artista='" + artista + '\'' +
                ", numPosto=" + numPosto +
                ", prezzo= " + super.prezzoFinale+
                '}';
    }
}
