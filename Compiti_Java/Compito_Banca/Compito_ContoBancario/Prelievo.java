package Compiti_Java.Compito_Banca.Compito_ContoBancario;

public class Prelievo extends OperazioneBancaria{
    private double denaro;


    private void setDenaro(double denaro) throws OperazioneBancariaNonAmmessaException, SaldoInsufficienteException, LimiteSuperatoException {
        if (denaro <= 0)
            throw new OperazioneBancariaNonAmmessaException("Il denaro non può essere negativo!");
        else if (denaro > conto.getSaldo())
            throw new SaldoInsufficienteException("Il prelievo non può essere superiore del conto stesso!");
        else if ((conto.getSaldo()-denaro) < 1000 )
            throw new LimiteSuperatoException("Il limite è stato superato adesso non potrà effettuare più di venti operazioni in un giorno!");
        else
            this.denaro = denaro;
    }

    public Prelievo(ContoCorrente conto, double denaro) throws OperazioneBancariaNonAmmessaException, SaldoInsufficienteException, LimiteSuperatoException {
        super(conto);
        setDenaro(denaro);
    }

    @Override
    public void operazione() {
        conto.setSaldo(denaro);
    }
}
