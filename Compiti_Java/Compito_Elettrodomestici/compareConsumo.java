package Compiti_Java.Compito_Elettrodomestici;

import java.util.Comparator;

public class compareConsumo implements Comparator<Elettrodomestico> {
    @Override
    public int compare(Elettrodomestico o1, Elettrodomestico o2) {
        return Integer.compare(o1.potenza, o2.potenza);

    }
}
