package Compiti_Java.Compito_Ereditarietà.Compito_Figure;

import java.util.ArrayList;

public class GestioneFigure {
    public static void main(String[] args) {
        ArrayList<Double> listaLati = new ArrayList<>();
        listaLati.add(5.0);
        listaLati.add(10.0);

        Rettangolo rettangolo = new Rettangolo("blue", 4, listaLati);

        try {
            float perimetro = rettangolo.calcolaPerimetro();
            float area = rettangolo.calcolaArea();
            System.out.println("Perimetro: " + perimetro);
            System.out.println("Area: " + area);
        } catch (IllegalArgumentException e) {

            System.err.println("Errore: " + e.getMessage());
        }
    }
}
