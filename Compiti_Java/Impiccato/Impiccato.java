package progetto_iniziale.Impiccato;

public class Impiccato {
    private String[] parole_da_indovinare = {"GIOCARE", "COMPUTER", "VISITA"};
    private String parola;
    private StringBuilder indovinare;
    private int tentativi;

    public StringBuilder getIndovina(){return this.indovinare;}
    public int getTentativi(){return this.tentativi;}


    public Impiccato(){
        setParola();
        setParola_Da_Indovinare();
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
        for (int i = 1; i<Lparola-1; i++){finale.append("_ ");}
        finale.append(this.parola.charAt(Lparola-1));
        this.indovinare = finale;


    }

    public void indovina(char lettera){
        for (int i = 0; i<this.parola.length()-1; i++){
            if (!(this.parola.charAt(i) == lettera)){
                this.tentativi -= 1;

        }
    }
    public void indovina(String stringa) {
        if (!(this.parola.equalsIgnoreCase(stringa))){
            this.tentativi -= 1;
        }
    }

}