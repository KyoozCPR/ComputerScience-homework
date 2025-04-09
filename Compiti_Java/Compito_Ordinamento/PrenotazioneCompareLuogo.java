package Compiti_Java.Compito_Ordinamento;

import java.util.Comparator;

public class PrenotazioneCompareLuogo implements Comparator<Prenotazione> {

    //Ordinamento decrescente in base al luogo
    @Override
    public int compare(Prenotazione p1, Prenotazione p2) {
        int compareP = p1.getLuogo().compareToIgnoreCase(p2.getLuogo());
        if (compareP > 0)
            return -1;
        else if (compareP < 0)
            return 1;
        return 0;

    }
}
