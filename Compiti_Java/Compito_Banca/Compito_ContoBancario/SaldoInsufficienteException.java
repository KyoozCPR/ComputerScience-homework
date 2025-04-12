package Compiti_Java.Compito_Banca.Compito_ContoBancario;

public class SaldoInsufficienteException extends RuntimeException{

    public SaldoInsufficienteException(String messaggio){
        super(messaggio);
    }
}
