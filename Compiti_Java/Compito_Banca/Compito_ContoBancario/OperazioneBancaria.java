package Compiti_Java.Compito_Banca.Compito_ContoBancario;

abstract public class OperazioneBancaria {
     protected ContoCorrente conto;

     public OperazioneBancaria(ContoCorrente conto){
          this.conto = conto;
     }

     abstract public void operazione();
}
