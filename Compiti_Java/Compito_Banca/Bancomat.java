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
        if (denaro >= 0)
            return 1;
        return 0;
    }

    public Bancomat(){
        this.saldo = 1000;
    }

    public int deposita(double denaro){
        if (isValidDenaro(denaro) == 1) {
            this.saldo += denaro;
            return 1;
        }
        return 0;
    }

    public int prelieva(double denaro){
        if (isValidDenaro(denaro) == 1 && denaro <= this.saldo ) {
            this.saldo -= denaro;
            return 1;
        }
        return 0;


    }

    @Override
    public String toString(){
        return "saldo attuale " + this.saldo + "€";
    }
}
