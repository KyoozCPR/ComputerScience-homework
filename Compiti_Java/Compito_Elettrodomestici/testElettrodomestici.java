package Compiti_Java.Compito_Elettrodomestici;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class testElettrodomestici {
    ArrayList<Elettrodomestico> elettrodomestici;

    public testElettrodomestici() {
        this.elettrodomestici = new ArrayList<>();
    }

    public static void main(String[] args) {
        testElettrodomestici obj = new testElettrodomestici();
        obj.elettrodomestici.add(new Televisore("Sony", 100, "2008-05-17", true, 1200.0f, 40.0f, "LCD"));
        obj.elettrodomestici.add(new Aspirapolvere("Folletto", 1000, "2020-03-20", false, 200.0f, 200));
        obj.elettrodomestici.add(new Frigorifero("LG", 1000, "2018-03-20", false, 200.0f, 20));
        for (Elettrodomestico elettrodomestico: obj.elettrodomestici)
            System.out.println(elettrodomestico);


    }

}
