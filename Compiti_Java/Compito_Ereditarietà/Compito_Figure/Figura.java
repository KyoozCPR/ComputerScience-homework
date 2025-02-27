package Compiti_Java.Compito_Ereditarietà.Compito_Figure;

import java.util.ArrayList;

public abstract class Figura {
    protected String colore;
    protected int nrLati;
    protected ArrayList<Double> listaLati;

    public String getColore() {
        return colore;
    }

    public void setColore(String colore) {
        this.colore = colore;
    }

    public int getNrLati() {
        return nrLati;
    }

    public void setNrLati(int nrLati) {
        this.nrLati = nrLati;
    }

    public ArrayList<Double> getListaLati() {
        return listaLati;
    }

    public void setListaLati(ArrayList<Double> listaLati) {
        this.listaLati = listaLati;
    }

    public Figura(String colore, int nrLati, ArrayList<Double> listaLati) {
        setColore(colore);
        setListaLati(listaLati);
        setNrLati(nrLati);
    }

    abstract public float calcolaPerimetro();
    abstract public float calcolaArea();


    @Override
    public String toString() {
        return "Figura{" +
                "colore='" + colore + '\'' +
                ", nrLati=" + nrLati +
                ", listaLati=" + listaLati +
                '}';
    }
}
