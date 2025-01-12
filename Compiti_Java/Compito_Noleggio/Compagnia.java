package progetto_iniziale.Compito_Noleggio;
import java.util.ArrayList;
public class Compagnia {
    private String nome;
    private String nomeTitolare;
    private String cognomeTitolare;
    private ArrayList<Veicolo> veicoli;

    public String getNome(){return nome;}
    public String getNomeTitolare(){return nomeTitolare;}
    public String getCognomeTitolare(){return cognomeTitolare;}
    public ArrayList<Veicolo> getVeicoli(){return veicoli;}

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setNomeTitolare(String nomeTitolare) {
        this.nomeTitolare = nomeTitolare;
    }

    public void setCognomeTitolare(String cognomeTitolare) {
        this.cognomeTitolare = cognomeTitolare;
    }



    public void setVeicoli(ArrayList<Veicolo> veicoli) {
        this.veicoli = veicoli;
    }

    public Compagnia(){

    }

    public Compagnia(String nome, String nomeTitolare, String cognomeTitolare, Veicolo[] veicoli){


    }


}
