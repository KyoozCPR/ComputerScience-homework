package Compiti_Java.Compito_Elettrodomestici;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;

public class testElettrodomestici {
    ArrayList<Elettrodomestico> elettrodomestici;

    public testElettrodomestici() {
        this.elettrodomestici = new ArrayList<>();
    }

    public static void main(String[] args) {
        testElettrodomestici obj = new testElettrodomestici();
        obj.elettrodomestici.add(new Aspirapolvere("Folletto", 1000, "2020-03-20", false, 150.0f, 20, 200));
        obj.elettrodomestici.add(new Televisore("Sony", 1500, "2008-05-17", true, 500.0f, 10 ,40.0f, "LCD"));
        obj.elettrodomestici.add(new Frigorifero("LG", 100, "2018-03-20", false, 1200.0f, 15, 20));


        System.out.println("I prodotti ordinati: ");
        ArrayList<Elettrodomestico> eOrdinati = obj.elettrodomestici;
        Collections.sort(eOrdinati);

        for (Elettrodomestico elettrodomestico: eOrdinati)
            System.out.println(elettrodomestico);


    }

}
