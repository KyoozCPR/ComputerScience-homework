package progetto_iniziale.Compito_Banca;

public class Bancomat {
    private double saldo;

    public double getSaldo(){return this.saldo;}
    public void setSaldo(double denaro){
        if (isValidDenaro(denaro) == 1)
            this.saldo = denaro;
        else
            System.out.println("Denaro non valido!");

    }

    private int isValidDenaro(double denaro){
        if (saldo >= 0)
            return 1;
        return 0;
    }

    public Bancomat(){
        this.saldo = 1000;
    }

    public void deposita(double denaro){
        if (isValidDenaro(denaro) == 1)
            this.saldo += denaro;
        else
            System.out.println("Denaro non valido!");
    }

    public void prelieva(double denaro){
        if (denaro <= this.saldo)
            this.saldo -= denaro;
        else
            System.out.println("Denaro maggiore del saldo!");


    }

    @Override
    public String toString(){
        return "saldo attuale " + this.saldo + "€";
    }
}
