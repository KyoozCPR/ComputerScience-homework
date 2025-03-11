package Compiti_Java.Compito_Elettrodomestici;

public class Frigorifero extends Elettrodomestico{
    private int litri;

    public int getLitri() {
        return litri;
    }

    public void setLitri(int litri) {
        this.litri = litri;
    }

    public Frigorifero(String proprietà, int potenza, String dataAcquisto, boolean inGaranzia, float prezzo, int minuti,int litri) {
        super(proprietà, potenza, dataAcquisto, inGaranzia, prezzo, minuti);
        setLitri(litri);
        CalcolaConsumo();
    }

    @Override
    protected void CalcolaConsumo() {
        super.consumo =  (float) (((double) (minuti * this.potenza) / 60000) + this.litri*0.05);
    }

    @Override
    public String toString() {
        return super.toString()  +
                ",\n\tlitri=" + litri +
                '}';
    }
}
