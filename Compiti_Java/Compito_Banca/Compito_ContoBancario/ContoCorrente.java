package Compiti_Java.Compito_Banca.Compito_ContoBancario;

import java.sql.Array;
import java.util.ArrayList;

public class ContoCorrente {
    private String utente;
    private String codiceBancario;
    private double saldo;
    private ArrayList<OperazioneBancaria> operazioni;

    public ArrayList<OperazioneBancaria> getOperazioni() {
        return operazioni;
    }

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

    public ContoCorrente(String utente, String codiceBancario) {
        this.utente = utente;
        this.codiceBancario = codiceBancario;
        this.saldo = 0;
        this.operazioni = new ArrayList<>();
    }

    public void addAccredito(double denaro) throws OperazioneBancariaNonAmmessaException {
        Accredito accredito = new Accredito(this, denaro);
        accredito.operazione();
        operazioni.add(accredito);

    }

    public void addPrelievo(double denaro) throws OperazioneBancariaNonAmmessaException, LimiteSuperatoException, SaldoInsufficienteException {
        Prelievo prelievo = new Prelievo(this, denaro);
        prelievo.operazione();
        operazioni.add(prelievo);

    }

    public void addLettura(){
        Lettura lettura = new Lettura(this);
        lettura.operazione();
        operazioni.add(lettura);

    }
}
