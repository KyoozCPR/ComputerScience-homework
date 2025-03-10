package Compiti_Java.Compito_Elettrodomestici;

public class Televisore extends Elettrodomestico{
    private float nrPollici;
    private String tecnologia;

    public float getNrPollici() {
        return nrPollici;
    }

    public void setNrPollici(float nrPollici) {
        this.nrPollici = nrPollici;
    }

    public String getTecnologia() {
        return tecnologia;
    }

    public void setTecnologia(String tecnologia) {
        this.tecnologia = tecnologia;
    }

    public Televisore(String proprietà, int potenza, String dataAcquisto, boolean inGaranzia, float prezzo, float nrPollici, String tecnologia) {
        super(proprietà, potenza, dataAcquisto, inGaranzia, prezzo);
        setNrPollici(nrPollici);
        setTecnologia(tecnologia);
    }

    @Override
    protected float CalcolaConsumo(int minuti) {
        return 0;
    }


    @Override
    public String toString() {
        return super.toString() +
                "nrPollici=" + nrPollici +
                ", tecnologia='" + tecnologia + '\'' +
                '}';
    }
}
