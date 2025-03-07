package Compiti_Java.Compito_Ordinamento;

abstract public class Prenotazione {
    protected String luogo;
    protected float prezzoBase;
    protected String codiceNumerico;

    public String getLuogo() {
        return luogo;
    }

    public void setLuogo(String luogo) {
        this.luogo = luogo;
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


    public Prenotazione(String luogo, float prezzoBase) {
        setLuogo(luogo);
        setPrezzoBase(prezzoBase);
        this.codiceNumerico = "pre";

    }

    abstract public float aggiornaPrezzo();


}


