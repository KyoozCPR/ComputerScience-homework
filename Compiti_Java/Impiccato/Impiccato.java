package Compiti_Java.Impiccato;

public class Impiccato {
    private String[] parole_da_indovinare = {"GIOCARE", "COMPUTER", "VISITA"};
    private String parola;
    private StringBuilder indovinare;
    private int tentativi;
    private boolean vittoria;
    public StringBuilder getIndovina(){return this.indovinare;}
    public int getTentativi(){return this.tentativi;}
    public boolean getVittoria(){return this.vittoria;}

    public Impiccato(){
        setParola();
        setParola_Da_Indovinare();
        this.vittoria = false;
        tentativi = 10;
    }


    private void setParola(){
        int randomNum = (int)(Math.random() * this.parole_da_indovinare.length);
        this.parola = parole_da_indovinare[randomNum];

    }

    private void setParola_Da_Indovinare(){
        int Lparola = this.parola.length();
        StringBuilder finale = new StringBuilder();

        finale.append(this.parola.charAt(0));
        for (int i = 1; i<Lparola-1; i++){finale.append("-");}
        finale.append(this.parola.charAt(Lparola-1));
        this.indovinare = finale;


    }

    public void indovina(char lettera){
        boolean presente = false;
        lettera = Character.toLowerCase(lettera);
        String finale = this.parola.toLowerCase();
        for (int i = 0; i<this.parola.length(); i++){
            if (finale.charAt(i) == lettera) {
                presente = true;
                this.indovinare.replace(i, i+1, ""+Character.toUpperCase(lettera));
            }

        }
        if (!presente) {
            this.tentativi -= 1;
            System.out.println("Lettera non presente!\nTentativi rimanenti: " + this.tentativi);
        }

        setVittoria();

    }
    public void indovina(String stringa) {
        if (!(this.parola.equalsIgnoreCase(stringa))){
            this.tentativi -= 1;
            System.out.println("Parola non corrispondente!\nTentativi rimanenti: " + this.tentativi);
        }
        else {

            this.indovinare.replace(0,this.indovinare.length(), this.parola);
        }
        setVittoria();
    }

    private void setVittoria(){
        this.vittoria = (this.indovinare).toString().equals(this.parola);
    }

    @Override
    public String toString(){
        return "Indovina la parola: " + this.indovinare;
    }

}