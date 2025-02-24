package Compiti_Java.Compito_Ereditarietà;

public class Case extends Prodotto{
    private int ram;
    private String os;
    private int ssd;
    private String motherboard;

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        if (ram < 4)
            this.ram = ram;
        else
            this.ram = 16;
    }

    public String getOs() {
        return os;
    }

    public void setOs(String os) {
        this.os = os;
    }

    public int getSsd() {
        return ssd;
    }

    public void setSsd(int ssd) {
        this.ssd = ssd;
    }

    public String getMotherboard() {
        return motherboard;
    }

    public void setMotherboard(String motherboard) {
        this.motherboard = motherboard;
    }

    public Case(String nome, float prezzo, int ram, String os, int ssd, String motherboard) {
        super(nome, prezzo);
        setMotherboard(motherboard);
        setOs(os);
        setRam(ram);

    }

    @Override
    public String toString() {
        return super.toString() +
                ",\n\tram=" + ram +
                ",\n\tos='" + os + '\'' +
                ",\n\tssd=" + ssd +
                ",\n\tmotherboard='" + motherboard + '\'' +
                "\n}\n";
    }
}
