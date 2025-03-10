package Compiti_Java.Compito_Elettrodomestici;

import java.util.Comparator;

public class comparePrezzo implements Comparator<Elettrodomestico> {
    @Override
    public int compare(Elettrodomestico o1, Elettrodomestico o2) {
        return Float.compare(o2.prezzo, o1.prezzo);
    }
}
