package progetto_iniziale.Compito_Account;

public class Account {
    private String nome, pwd;
    private boolean logged;
    public String getNome(){return this.nome;}
    public Boolean getLogged(){return this.logged;}
    public String getPwd(){return this.pwd;}
    public void setNome(String nome){this.nome = nome;}
    public void setPwd(String pwd){this.pwd = isValidPwd(pwd);}


    public Account(String nome, String password){
        setNome(nome);
        setPwd(password);
        this.logged = false;
    }



    private String isValidPwd(String pwd){
        return (pwd.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*[\\\\._%]).{5,10}$")) ? pwd : "4Cinf";




    }




}
