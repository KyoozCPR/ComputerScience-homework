package Compiti_Java.Compito_Banca.Compito_ContoBancario;

import java.sql.Array;
import java.util.ArrayList;

public class ContoCorrente {
    private String utente;
    private String codiceBancario;
    private double saldo;
    private ArrayList<OperazioneBancaria> operazioni;
    private int operazioniEffettuateOggi;
    private boolean limiteSuperato;

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

    public boolean isLimiteSuperato() {
        return limiteSuperato;
    }

    public void setLimiteSuperato(boolean limiteSuperato) {
        this.limiteSuperato = limiteSuperato;
    }

    public int getOperazioniEffettuateOggi() {
        return operazioniEffettuateOggi;
    }



    public void aggiornaCounterOperazioni() {
        if (limiteSuperato && (operazioniEffettuateOggi+1) > 20){
            throw new LimiteSuperatoException("Hai superato le 20 operazioni in un giorno, riprova domani!");
        }
        else
            operazioniEffettuateOggi++;

    }

    public ContoCorrente(String utente, String codiceBancario) {
        this.utente = utente;
        this.codiceBancario = codiceBancario;
        this.saldo = 0;
        this.operazioniEffettuateOggi = 0;
        this.limiteSuperato = false;
        this.operazioni = new ArrayList<>();
    }

    public void addAccredito(double denaro) {
        Accredito accredito = new Accredito(this, denaro);
        accredito.operazione();
        operazioni.add(accredito);
        aggiornaCounterOperazioni();

    }

    public void addPrelievo(double denaro) {
        Prelievo prelievo = new Prelievo(this, denaro);
        prelievo.operazione();
        operazioni.add(prelievo);
        aggiornaCounterOperazioni();
    }

    public void addLettura(){
        Lettura lettura = new Lettura(this);
        lettura.operazione();
        operazioni.add(lettura);
        aggiornaCounterOperazioni();

    }
}
