package Compiti_Java.Compito_Ordinamento;

import java.util.Comparator;

//Utilizzo il comparator visto che voglio avere 2 ordinamenti diversi, se fosse stato 1 solo allora usavo Comparable

public class PrenotazioneComparePrezzo implements Comparator<Prenotazione>{


    @Override
    public int compare(Prenotazione p1, Prenotazione p2) {
        if (p1.prezzoFinale > p2.getPrezzoFinale())
            return 1;
        else if (p1.prezzoFinale < p2.getPrezzoFinale())
            return -1;
        return 0;
    }
}
