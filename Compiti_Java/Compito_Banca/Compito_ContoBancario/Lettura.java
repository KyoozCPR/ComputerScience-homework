package Compiti_Java.Compito_Banca.Compito_ContoBancario;

public class Lettura extends OperazioneBancaria{
    public Lettura(ContoCorrente conto) {
        super(conto);
    }

    @Override
    public void operazione() {
        System.out.println("Il tuo saldo è pari a: " + conto.getSaldo());
    }
}
