package progetto_iniziale.Compito_Ereditarietà;

public class Monitor extends Prodotto{
    private int hrz;
    private float pollici;
    private int risoluzione;


    public int getRisoluzione(){return risoluzione;}
    public int getHrz(){return hrz;}
    public float getPollici(){return pollici;}



    public void setRisoluzione(int risoluzione){
        if (risoluzione == 720 || risoluzione == 1080 || risoluzione == 1440 || risoluzione == 2160){
            this.risoluzione = risoluzione;
        }
        else {
            this.risoluzione = 1080;
        }
    }

    public void setHrz(int hrz) {
        this.hrz = hrz;
    }

    public void setPollici(float pollici) {
        this.pollici = pollici;
    }



    public Monitor(String nome, float prezzo, String CodiceBarre, int hrz, float pollici, int risoluzione) {
        super(nome, prezzo, CodiceBarre);
        setHrz(hrz);
        setRisoluzione(risoluzione);
        setPollici(pollici);
    }
}
