package progetto_iniziale.Compito_Edificio;

public class Utente {
    private String nome;
    private String email;
    private String password;
    private Sala sala_prenotata;
    private boolean login;
    public String getNome(){return nome;}
    public String getEmail(){return email;}
    public String getPassword(){return password;}

    public Sala getSala_prenotata() {
        return sala_prenotata;
    }

    public boolean isLogin() {
        return login;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEmail(String email) {
        this.email = isValidEmail(email);
    }

    public void setPassword(String password) {
        this.password = isValidPassword(password);
    }

    public void setLogin(boolean login) {
        this.login = login;
    }

    public void setSala_prenotata(Sala sala){
        this.sala_prenotata = sala;
        sala.setDisponibilità(false);
    }

    public Utente(String nome, String email, String pwd){
        setNome(nome);
        setEmail(email);
        setPassword(pwd);
        this.sala_prenotata = null;
        this.login = false;

    }


    private String isValidPassword(String password){
        if (password.matches("(?=.*[a-z])(?=.*[A-Z])(?=.*[._%]).{5,10}"))
            /* il ?= nel regex indica un lookahead positivo cioè
               controlla che il pattern esista nella stringa,
               senza però includerlo nel match finale.
               Può essere interpretato come una condizione
             */
            return password;
        System.out.println("Password non valida! Assegnata una di default\n");
        return "defaultP$_";

    }

    private String isValidEmail(String email){
        //example@dominio.com
        if (email.matches("(.+)@([a-z]+)\\.(com|it)"))
            return email;
        System.out.println("Email non valida! Assegnata una di default");
        return "example@dominio.com";
    }


}
