package Compiti_Java.Compito_Banca.Compito_ContoBancario;

public class ContoCorrente {
    private String utente;
    private String codiceBancario;
    private double saldo;

    public String getUtente() {
        return utente;
    }

    public void setUtente(String utente) {
        this.utente = utente;
    }

    public String getCodiceBancario() {
        return codiceBancario;
    }

    public void setCodiceBancario(String codiceBancario) {
        this.codiceBancario = codiceBancario;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public ContoCorrente(String utente, String codiceBancario, double saldo) {
        this.utente = utente;
        this.codiceBancario = codiceBancario;
        this.saldo = saldo;
    }
}
