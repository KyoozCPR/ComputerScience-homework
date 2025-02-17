
public class Veicolo implements Comparable<Veicolo> {
    private String targa;
    private int velocity;
    private int distanza;
    private boolean fermo;

    public Veicolo(String targa) {
        this.setTarga(targa);
    }

    public Veicolo() {
        this("VA123456");
    }

    public boolean isFermo() {
        return this.fermo;
    }

    public int getDistanza() {
        return this.distanza;
    }

    public int getVelocity() {
        return this.velocity;
    }

    public String getTarga() {
        return this.targa;
    }

    private void setTarga(String targa) {
        this.targa = targa;
    }

    public void accelera(int quot) {
        if (quot > 0) {
            this.fermo = false;
            this.distanza += quot;
            this.velocity = this.velocity + quot <= 110 ? this.velocity + quot : 110;
        }
    }

    public void decelera(int quot) {
        if (quot > 0) {
            this.velocity = this.velocity - quot < 0 ? 0 : this.velocity - quot;
            if (this.velocity == 0) {
                this.fermo = true;
            }

        }
    }

    public String toString() {
        String var10000 = this.getClass().getName();
        return var10000 + " " + this.targa + " " + this.velocity + " " + this.distanza + " " + (this.fermo ? "Fermo" : "In Moto");
    }

    public int compareTo(Veicolo altro) {
        return altro.distanza - this.distanza;
    }
}
