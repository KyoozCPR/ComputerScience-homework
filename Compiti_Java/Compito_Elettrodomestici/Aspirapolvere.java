package Compiti_Java.Compito_Elettrodomestici;

public class Aspirapolvere extends Elettrodomestico{
    private int volume;

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public Aspirapolvere(String proprietà, int potenza, String dataAcquisto, boolean inGaranzia, float prezzo, int volume) {
        super(proprietà, potenza, dataAcquisto, inGaranzia, prezzo);
        setVolume(volume);

    }

    @Override
    protected float CalcolaConsumo(int minuti) {
        return 0;
    }

    @Override
    public String toString() {
        return super.toString() +
                "volume=" + volume +
                '}';
    }
}
