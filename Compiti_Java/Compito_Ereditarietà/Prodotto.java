package Compiti_Java.Compito_Ereditarietà;

public class Prodotto {
    protected String nome;
    protected float prezzo;
    protected long CodiceBarre;


    public String getNome(){return nome;}
    public float getPrezzo(){ return prezzo;}
    public long getCodiceBarre(){ return CodiceBarre;}

    public void setNome(String nome){ this.nome = nome;}
    public void setPrezzo(float prezzo){ this.prezzo = prezzo;}
    public void setCodiceBarre(){ this.CodiceBarre++;}

    @Override
    public String toString() {
        return "Prodotto = {\n\tnome='" + nome + '\'' +
                ",\n\tprezzo=" + prezzo +
                ",\n\tCodiceBarre=" + CodiceBarre;
    }

    public Prodotto(String nome, float prezzo){
        setNome(nome);
        setPrezzo(prezzo);
        this.CodiceBarre = 100000000000L;
    }

}
