package progetto_iniziale.Compito_Noleggio;

public class Veicolo {
    private String casaProduttrice;
    private String targa;
    private int cilindrata;

    public String getCasaProduttrice(){return casaProduttrice;}
    public String getTarga(){return targa;}
    public int getCilindrata(){return cilindrata;}

    public void setCasaProduttrice(String casaProduttrice) {
        this.casaProduttrice = casaProduttrice;
    }

    public void setTarga(String targa) {
        this.targa = targa;
    }

    public void setCilindrata(int cilindrata) {
        this.cilindrata = cilindrata;
    }




    public Veicolo(){

    }

    public Veicolo(String casaProduttrice, String targa, int cilinderata){

    }
}
