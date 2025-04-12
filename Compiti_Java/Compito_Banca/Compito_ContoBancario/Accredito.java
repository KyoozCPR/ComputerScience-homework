package Compiti_Java.Compito_Banca.Compito_ContoBancario;

public class Accredito extends OperazioneBancaria{
    private double denaro;


    private void setDenaro(double denaro){
        if (denaro <= 0)
            throw new OperazioneBancariaNonAmmessaException("Il denaro non può essere negativo!");
        else
            this.denaro = denaro;
    }

    public Accredito(ContoCorrente conto, double denaro){
        super(conto);
        setDenaro(denaro);
    }

    @Override
    public void operazione() {
        conto.setSaldo(denaro);
    }
}
