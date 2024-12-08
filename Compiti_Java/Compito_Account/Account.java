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
        this.nome = isValidNome(nome);
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

    private String isValidNome(String nome) {
        System.out.println("\nnome gia presente , creato  casuale");
        String finale = "PC";
        for (int i = 0; i < PC.classe.size(); i++){
            if (PC.classe.get(i).getNome().equals(nome)){
                return finale + PC.classe.size();
            }
        }


        return nome;
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
        casuale = "192.168." +
                (int) (Math.random() * 256) + "." +
                (int) (Math.random() * 256);
        randomIp = casuale;

        if (PC.classe.size() == 0)
            return randomIp;
        do {
            if (PC.classe.get(i).getIp().equals(randomIp)) {
                randomIp = casuale;
                i = -1;
            }
            i++;
        } while (i < PC.classe.size() && PC.classe.get(i).getIp().equals(randomIp) );


        return randomIp;


    }

    @Override
    public String toString(){
        return "Account con nome: " + this.nome + " password: " + this.pwd + " e indirizzo ip: " + this.Ip;
    }



}
