package progetto_iniziale.Compito_Ereditarietà;

public class Case extends Prodotto{
    private int ram;
    private String os;
    private int ssd;
    private String motherboard;

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
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

    public Case(String nome, float prezzo, String CodiceBarre, int ram, String os, int ssd, String motherboard) {
        super(nome, prezzo, CodiceBarre);
        setMotherboard(motherboard);
        setOs(os);
        setRam(ram);

    }
}
