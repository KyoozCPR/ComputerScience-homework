package Compiti_Java.Compito_File;

import java.io.*;
import java.util.ArrayList;

public class GestionePersone {
    public ArrayList<Persona> persone;

    public GestionePersone(){
        this.persone = new ArrayList<>();
    }

    public void aggiungi(int e, String n){

        try{
            persone.add(new Persona(n, e));
        } catch(IllegalArgumentException ea){
            System.out.println(ea.getMessage());
        }

    }

    private ArrayList<Persona> calcolaMaggiorenni(){
        ArrayList<Persona> maggiorenni = new ArrayList<>();
        for (Persona persona: persone){
            if (persona.getAge() >= 18){
                maggiorenni.add(persona);
            }
        }
        return maggiorenni;

    }

    public void scriviPersone()  {
        try{
            BufferedWriter file = new BufferedWriter(new FileWriter("persone.txt"));
            ArrayList<Persona> persone = calcolaMaggiorenni();
            for (Persona persona: persone){
                file.write(persona.toString());
            }
        } catch(IOException e){
            System.out.println(e.getMessage());
        }

    }



    public static void main(String[] args) {
        GestionePersone obj = new GestionePersone();
        obj.aggiungi(18, "Marco Lauria");
        obj.aggiungi(17, "Diego Ciprietti");
        obj.aggiungi(25, "Marco Rossi");
        obj.scriviPersone();


    }
}
