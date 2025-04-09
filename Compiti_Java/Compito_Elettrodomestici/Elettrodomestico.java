package Compiti_Java.Compito_Elettrodomestici;

import javax.swing.*;
import java.util.Comparator;

abstract public class Elettrodomestico implements Comparable<Elettrodomestico> {

    /*
        un'interfaccia, come quella del Comparable
        (interfaccia funzionale), può essere vista
        come un'applicazione della classe astratta più estrema,
        poiché contiene solamente metodi astratti e al più delle costanti(final).
        Essa quindi definisce un contratto con le sottoclassi, che non devono
        essere perforza correlate come con le classi astratte, che le obbliga
        ad implementare i metodi presenti nell'interfaccia
     */

    protected String proprietà;
    protected int potenza;
    protected String dataAcquisto;
    protected boolean inGaranzia;
    protected float prezzo;
    protected int minuti;
    protected float consumo;


    public float getConsumo() {
        return consumo;
    }

    public void setConsumo(float consumo) {
        this.consumo = consumo;
    }

    public int getMinuti() {
        return minuti;
    }

    public void setMinuti(int minuti) {
        this.minuti = minuti;
    }

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

    public Elettrodomestico(String proprietà, int potenza, String dataAcquisto, boolean inGaranzia, float prezzo, int minuti) {
        setProprietà(proprietà);
        setPotenza(potenza);
        setDataAcquisto(dataAcquisto);
        setInGaranzia(inGaranzia);
        setPrezzo(prezzo);
        setMinuti(minuti);

    }

    abstract protected void CalcolaConsumo();

    @Override
    public int compareTo(Elettrodomestico E2){
        if (this.getClass() != E2.getClass())
            return this.getClass().getSimpleName().compareToIgnoreCase(E2.getClass().getSimpleName());
        else{
            if (this.consumo == E2.consumo){
                return Float.compare(E2.prezzo, this.prezzo);
            }
            return Float.compare(this.consumo, E2.consumo);
        }


    }

    @Override
    public String toString() {
        return "\n\t"+ "Elettrodomestico{\n" +
                "\tproprietà='" + proprietà + '\'' +
                ",\n\tpotenza=" + potenza +
                ",\n\tdataAcquisto='" + dataAcquisto + '\'' +
                ",\n\tinGaranzia=" + inGaranzia +
                ",\n\tprezzo=" + prezzo +
                ",\n\tCONSUMO=" + consumo;
    }
}
