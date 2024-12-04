package progetto_iniziale.EserciziRegex;
import java.util.regex.Pattern;

public class GestioneRegEx {
    public static boolean verifica(String regex, String input) { // Metodo statico per verificare l’espressione
        return Pattern.matches(regex, input); // Restituisce valore true
    }

    public static void checkRegEx(String regex, String input){
        boolean verifica = GestioneRegEx.verifica(regex, input);
        System.out.println(verifica ? "Verificato":"Errore");
    }

    public static void main(String[] args) {
        String input = "test@email.com"; // Stringa da verificare
        String regex = "([a-zA-Z0-9._])+@([a-z])+(\\.[a-z]+)";
        GestioneRegEx.checkRegEx(regex, input);
        String input2 = "31/03/2008"; // Stringa da verificare
        String regex2 = "([012][1-9]|3[01])/(0[1-9]|1[012])/([012][0-9][0-9][0-9])";
        GestioneRegEx.checkRegEx(regex2, input2);
        String input3 = "23:59";
        String regex3 = "([01][0-9]|2[0-3]):([0-5][0-9])";
        GestioneRegEx.checkRegEx(regex3, input3);
    }



}
