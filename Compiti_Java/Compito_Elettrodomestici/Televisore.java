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
        float risultato = ((float) (this.potenza * minuti) / 60000) + this.nrPollici*0.1f;
        if (this.tecnologia.equals("CRT"))
            return risultato*1.2f;
        else if (this.tecnologia.equals("LCD"))
            return risultato*0.9f;
        else if (this.tecnologia.equals("LED") || this.tecnologia.equals("OLED"))
            return risultato*0.8f;
        return risultato;
    }


    @Override
    public String toString() {
        return super.toString() +
                ",\n\tnrPollici=" + nrPollici +
                ",\n\ttecnologia='" + tecnologia + '\'' +
                "\n\t}";
    }
}
