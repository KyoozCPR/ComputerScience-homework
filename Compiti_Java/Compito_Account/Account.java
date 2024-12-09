package progetto_iniziale.Compito_Account;
import java.util.ArrayList;
public class Account {
    private String nome, pwd, Ip;
    private boolean logged;

    public String getIp(){return this.Ip;}
    public String getNome(){return this.nome;}
    public Boolean getLogged(){return this.logged;}
    public String getPwd(){return this.pwd;}
    public void setNome(String nome){this.nome = nome;}
    public void setPwd(String pwd){this.pwd = isValidPwd(pwd);}
    public void setIp(String ip){this.Ip = isValidIp(ip);}

    public Account(String nome, String password,String ip){
        setNome(nome);
        setPwd(password);
        setIp(ip);
        this.logged = false;
    }



    private String isValidPwd(String pwd){
        return (pwd.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*[\\\\._%]).{5,10}$")) ? pwd : "4Cinf";
    }
    private String isValidIp(String ip){
        String randomIp;
        String regex = "(2([0-5]+)||1(\\d+)||(\\d{1,2}){1,3}).(2([0-5]+)||1(\\d+)||(\\d{1,2}){1,3}).([2]([0-5]+)||1(\\d+)||(\\d{1,2}){1,3}).(2([0-5]+)||1(\\d+)||(\\d{1,2}){1,3})";
        if (ip.matches(regex))
            return ip;


        int i = -1;
        do {
            randomIp = "" + (int) (Math.random() * 256) + "." +
                    (int) (Math.random() * 256) + "." +
                    (int) (Math.random() * 256) + "." +
                    (int) (Math.random() * 256);
            i++;
        } while (PC.classe.get(i).getIp().equals(randomIp));


        return randomIp;


    }




}
