package Compiti_Java.Compito_Banca.Compito_ContoBancario;

public class Prelievo extends OperazioneBancaria{
    private double denaro;


    private void setDenaro(double denaro){
        if (denaro <= 0)
            throw new OperazioneBancariaNonAmmessaException("Il denaro non può essere negativo!");
        else if (denaro > conto.getSaldo())
            throw new SaldoInsufficienteException("Il prelievo non può essere superiore del conto stesso!");
        else if ((conto.getSaldo()-denaro) < 1000 ) {
            this.denaro -= denaro;
            super.conto.setSaldo(denaro);
            throw new LimiteSuperatoException("Il limite è stato superato adesso non potrà effettuare più di venti operazioni in un giorno!");
        }
        else
            this.denaro -= denaro;
    }

    public double getDenaro() {
        return denaro;
    }

    public Prelievo(ContoCorrente conto, double denaro)  {
        super(conto);
        this.denaro = conto.getSaldo();
        setDenaro(denaro);
    }

    @Override
    public void operazione() {
        conto.setSaldo(denaro);
    }
}
