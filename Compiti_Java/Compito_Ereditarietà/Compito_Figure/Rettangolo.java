package Compiti_Java.Compito_Ereditarietà.Compito_Figure;

import java.util.ArrayList;

public class Rettangolo extends Figura{
    public Rettangolo(String colore, int nrLati, ArrayList<Double> listaLati) {
        super(colore, nrLati, listaLati);

    }

    @Override
    public float calcolaPerimetro() {
        if (listaLati == null || listaLati.size() < 2) {
            throw new IllegalArgumentException("Lista lati non valida per un rettangolo.");
        }
        double base = listaLati.get(0);
        double altezza = listaLati.get(1);
        return (float) (2 * (base + altezza));
    }

    @Override
    public float calcolaArea() {
        if (listaLati == null || listaLati.size() < 2) {
            throw new IllegalArgumentException("Lista lati non valida per un rettangolo.");
        }
        double base = listaLati.get(0);
        double altezza = listaLati.get(1);
        return (float) (base * altezza);
    }


}
