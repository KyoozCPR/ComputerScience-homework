package Compiti_Java.PortaMonete;

public class Portamonete implements Comparable<Portamonete>{
    private String proprietario;
    private int cent50;
    private int eur1;
    private int eur2;


    public String getProprietario() {
        return proprietario;
    }

    public int getCent50() {
        return cent50;
    }

    public int getEur1() {
        return eur1;
    }

    public int getEur2() {
        return eur2;
    }

    public void setProprietario(String proprietario) {
        this.proprietario = proprietario;
    }

    public void setCent50(int cent50) {
        this.cent50 = cent50;
    }

    public void setEur1(int eur1) {
        this.eur1 = eur1;
    }

    public void setEur2(int eur2) {
        this.eur2 = eur2;
    }

    public Portamonete(String proprietario) {
        this.proprietario = proprietario;
        setCent50(0);
        setEur1(0);
        setEur2(0);
    }



    public void aggiungiMonete(float moneta){
        if (moneta == .50)
            this.cent50++;
        else if (moneta ==  1)
            this.eur1++;
        else if (moneta == 2)
            this.eur2++;
        else
            System.out.print("Moneta non valida!");
    }

    public void aggiungiMonete(float tipo, int n){
        if (tipo == .50)
            this.cent50+=n;
        else if (tipo ==  1)
            this.eur1+=n;
        else if (tipo == 2)
            this.eur2+=n;
        else
            System.out.print("Moneta non valida!");
    }

    public float denaro(){
        return (float) (this.cent50*.50)+(this.eur1)+(this.eur2*2);
    }

    public void stampaDenaro(){
        System.out.println("Portamonete:\nMonete da 50 cent: "  + this.cent50 + "\nMonete da 1 euro: " + this.eur1 + "\nMonete da 2 euro: " + this.eur2);
    }


    @Override
    public int compareTo(Portamonete o) {
        float denaroTot = this.denaro();
        float denaroTot2 = o.denaro();

        float val = denaroTot2-denaroTot;
        if (val == 0)
            return 0;
        else if (val < 0)
            return -1;
        else
            return 1;
    }
}
