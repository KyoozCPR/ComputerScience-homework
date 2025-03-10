package Compiti_Java.Compito_Elettrodomestici;

import java.util.Comparator;

abstract public class Elettrodomestico  {
    protected String proprietà;
    protected int potenza;
    protected String dataAcquisto;
    protected boolean inGaranzia;
    protected float prezzo;

    public String getProprietà() {
        return proprietà;
    }

    public void setProprietà(String proprietà) {
        this.proprietà = proprietà;
    }

    public int getPotenza() {
        return potenza;
    }

    public void setPotenza(int potenza) {
        this.potenza = potenza;
    }

    public String getDataAcquisto() {
        return dataAcquisto;
    }

    public void setDataAcquisto(String dataAcquisto) {
        this.dataAcquisto = dataAcquisto;
    }

    public boolean isInGaranzia() {
        return inGaranzia;
    }

    public void setInGaranzia(boolean inGaranzia) {
        this.inGaranzia = inGaranzia;
    }

    public float getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(float prezzo) {
        this.prezzo = prezzo;
    }

    public Elettrodomestico(String proprietà, int potenza, String dataAcquisto, boolean inGaranzia, float prezzo) {
        setProprietà(proprietà);
        setPotenza(potenza);
        setDataAcquisto(dataAcquisto);
        setInGaranzia(inGaranzia);
        setPrezzo(prezzo);
    }

    abstract protected float CalcolaConsumo(int minuti);

    @Override
    public String toString() {
        return "Elettrodomestico{" +
                "proprietà='" + proprietà + '\'' +
                ", potenza=" + potenza +
                ", dataAcquisto='" + dataAcquisto + '\'' +
                ", inGaranzia=" + inGaranzia +
                ", prezzo=" + prezzo;
    }
}
