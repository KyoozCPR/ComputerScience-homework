package progetto_iniziale.Compito_Edificio;

public class Utente {
    private String nome;
    private String email;
    private String password;

    public String getNome(){return nome;}
    public String getEmail(){return email;}
    public String getPassword(){return password;}

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEmail(String email) {
        this.email = isValidEmail(email);
    }

    public void setPassword(String password) {
        this.password = isValidPassword(password);
    }

    private String isValidPassword(String password){
        if (password.matches("(?=.*[a-z])(?=.*[A-Z])(?=.*[._%]).{5,10}"))
            /* il ?= nel regex indica un lookahead positivo cioè
               controlla che il pattern esista nella stringa,
               senza però includerlo nel match finale.
               Può essere interpretato come una condizione
             */
            return password;
        return "defaultP$_";

    }

    private String isValidEmail(String email){
        //example@dominio.com
        if (email.matches("(.+)@([a-z]+)\\.(com || it)"))
            return email;
        return "example@dominio.com";
    }


}
