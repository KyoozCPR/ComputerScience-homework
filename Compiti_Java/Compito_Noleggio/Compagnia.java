package progetto_iniziale.Compito_Noleggio;
import java.util.ArrayList;
import java.util.Arrays;

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
        this.nome = "Unknown";
        this.nomeTitolare = "Unknown";
        this.cognomeTitolare = "Unknown";
        this.veicoli = new ArrayList<>();
    }

    public Compagnia(String nome, String nomeTitolare, String cognomeTitolare, ArrayList<Veicolo> veicoli){
        setNome(nome);
        setNomeTitolare(nomeTitolare);
        setVeicoli(veicoli);


    }

    public void stampaSconti(){
        System.out.println("\n- almeno  3 giorni a 7 sconto  8%\n" +
                "- giorni tra 8 e 30  sconto 18%\n" +
                "-  oltre un mese  50%\n");
    }



    public float calcolaCosto(int posizioneVeicolo, int giorni){
        float costoFinale = 0;
        int aggiunta;
        int cilindrata = veicoli.get(posizioneVeicolo).getCilindrata();
        if (cilindrata <= 1000)
            aggiunta=10;
        else if (cilindrata <= 1200)
            aggiunta=12;
        else if (cilindrata <= 1400)
            aggiunta=16;
        else if (cilindrata <= 1800)
            aggiunta=19;
        else
            aggiunta = 25;

        for (int i=0; i<=giorni; i++){costoFinale+=aggiunta;}

        if (giorni >= 3 && giorni < 8)
            costoFinale*=0.8;
        else if (giorni >= 8 && giorni <= 30)
            costoFinale*=1.8;
        else if (giorni >30)
            costoFinale*=5;

        return costoFinale;

    }

}
