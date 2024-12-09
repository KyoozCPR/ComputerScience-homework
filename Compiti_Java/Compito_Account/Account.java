package progetto_iniziale.Compito_Account;
import java.util.ArrayList;
public class Account {
    private String nome, pwd, Ip;
    private boolean logged;

    public String getIp() {
        return this.Ip;
    }

    public String getNome() {
        return this.nome;
    }

    public Boolean getLogged() {
        return this.logged;
    }

    public String getPwd() {
        return this.pwd;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setPwd(String pwd) {
        this.pwd = isValidPwd(pwd);
    }

    public void setIp(String ip) {
        this.Ip = isValidIp(ip);
    }

    public void setLogged(boolean log) {
        this.logged = log;
    }


    public Account(String nome, String password, String ip) {
        setNome(nome);
        setPwd(password);
        setIp(ip);
        this.logged = false;
    }


    private String isValidPwd(String pwd) {
        return (pwd.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*[\\\\._%]).{5,10}$")) ? pwd : "4Cinf";
    }

    private String isValidIp(String ip) {
        String randomIp, casuale;
        String regex = "(25[0-5]||[2][0-4]\\d||1\\d\\d||\\d{1,2})\\.(25[0-5]||[2][0-4]\\d||1\\d\\d||(\\d{1,2}))\\.(25[0-5]||[2][0-4]\\d||1\\d\\d||(\\d{1,2}))\\.(25[0-5]||[2][0-4]\\d||1\\d\\d||(\\d{1,2}))";
        if (ip.matches(regex))
            return ip;
        System.out.println("\nnon valido, creato ip casuale");
        int i = 0;
        casuale = "" + (int) (Math.random() * 256) + "." +
                (int) (Math.random() * 256) + "." +
                (int) (Math.random() * 256) + "." +
                (int) (Math.random() * 256);
        randomIp = casuale;

        if (PC.classe.size() == 0)
            return randomIp;
        do {
            if (PC.classe.get(i).getIp().equals(randomIp)) {
                randomIp = casuale;
                i = 0;
            }
            i++;
        } while (PC.classe.get(i).getIp().equals(randomIp) && i < PC.classe.size());


        return randomIp;


    }

    @Override
    public String toString(){
        return "Account con nome: " + this.nome + " e indirizzo ip: " + this.Ip;
    }



}
