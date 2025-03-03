abstract public class Prenotazione {
    protected String prenota;
    protected float prezzoBase;
    protected String codiceNumerico;

    public String getPrenota() {
        return prenota;
    }

    public void setPrenota(String prenota) {
        this.prenota = prenota;
    }

    public float getPrezzoBase() {
        return prezzoBase;
    }

    public void setPrezzoBase(float prezzoBase) {
        this.prezzoBase = prezzoBase;
    }

    public String getCodiceNumerico() {
        return codiceNumerico;
    }


    public Prenotazione(String prenota, float prezzoBase) {
        setPrenota(prenota);
        setPrezzoBase(prezzoBase);
        this.codiceNumerico = "pre";

    }

    abstract public float aggiornaPrezzo();


}


