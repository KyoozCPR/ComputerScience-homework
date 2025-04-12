package Compiti_Java.Compito_Banca.Compito_ContoBancario;

public class LimiteSuperatoException extends RuntimeException{
    public LimiteSuperatoException(String messaggio){
        super(messaggio);
    }
}
