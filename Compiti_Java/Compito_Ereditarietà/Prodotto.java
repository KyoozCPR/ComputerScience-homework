package progetto_iniziale.Compito_Ereditarietà;

public class Prodotto {
    protected String nome;
    protected float prezzo;
    protected String CodiceBarre;


    public String getNome(){return nome;}
    public float getPrezzo(){ return prezzo;}
    public String getCodiceBarre(){ return CodiceBarre;}

    public void setNome(String nome){ this.nome = nome;}
    public void setPrezzo(float prezzo){ this.prezzo = prezzo;}
    public void setCodiceBarre(String CodiceBarre){ this.CodiceBarre = CodiceBarre;}


    public Prodotto(String nome, float prezzo, String CodiceBarre){
        setNome(nome);
        setPrezzo(prezzo);
        setCodiceBarre(CodiceBarre);
    }

}
