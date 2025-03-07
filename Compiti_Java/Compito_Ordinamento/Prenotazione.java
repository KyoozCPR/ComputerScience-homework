package Compiti_Java.Compito_Ordinamento;

abstract public class Prenotazione {
    protected String luogo;
    protected float prezzoBase;
    protected String codiceNumerico;
    protected float prezzoFinale;
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

    public float getPrezzoFinale() {
        return prezzoFinale;
    }

    public void setPrezzoFinale(float prezzoFinale) {
        this.prezzoFinale = prezzoFinale;
    }

    public void setCodiceNumerico(String codiceNumerico) {
        this.codiceNumerico = codiceNumerico;
    }

    public Prenotazione(String luogo, float prezzoBase) {
        setLuogo(luogo);
        setPrezzoBase(prezzoBase);
        this.codiceNumerico = "pre";
        this.prezzoFinale = prezzoBase;

    }

    abstract public void aggiornaPrezzo();

    @Override
    public String toString() {
        return "Prenotazione{" +
                "luogo='" + luogo + '\'' +
                ", codiceNumerico='" + codiceNumerico + '\'';
    }
}


