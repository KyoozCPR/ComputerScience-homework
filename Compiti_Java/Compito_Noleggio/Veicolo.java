package Compiti_Java.Compito_Noleggio;

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
        this.targa = isValidTarga(targa);
    }

    public void setCilindrata(int cilindrata) {
        this.cilindrata = cilindrata;
    }

    private String isValidTarga(String targa) {
        String regex = "^[A-Z]{2}[0-9]{3}[A-Z]{2}$";
        return targa.matches(regex)? targa: "AA000AA";
    }


    public Veicolo(){
        this.casaProduttrice = "Unknown";
        this.targa = "Unknown";
        this.cilindrata = 0;
    }

    public Veicolo(String casaProduttrice, String targa, int cilindrata){
        setCilindrata(cilindrata);
        setTarga(targa);
        setCasaProduttrice(casaProduttrice);
    }
}
