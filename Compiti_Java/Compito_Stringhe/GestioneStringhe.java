package progetto_iniziale.Compito_Stringhe;

public class GestioneStringhe {

    public static void countVocali(String stringa){
        String stringa_finale = stringa.toLowerCase().trim();
        int contatore = 0;
        char c;
        for (int i = 0; i < stringa.length(); i++){
            c = stringa.charAt(i);
            if (c=='a'|| c=='e'|| c=='i' ||c=='o' || c=='u')
                contatore++;
        }
        System.out.println("\nLa stringa finale: " + stringa_finale + " contiene " + contatore + " vocali.\n");
    }

    public static void posizioneA(String stringa){
        System.out.println("la posizione del primo carattere 'a' nella stringa: " + stringa +" è "+ stringa.indexOf('a'));
    }

    public static String replaceE_O(String stringa){
        return stringa.replace('e', 'o');

    }
    public static Boolean areEqual(String str1, String str2){
        return str1.compareTo(str2) == 0;
    }

    public static void centerChar(String stringa){
         char half = stringa.charAt(stringa.length()/2);
         String centro = stringa.length() % 2 == 0 ? "" + stringa.charAt((stringa.length()/2)-1) + half : "" + half;
         System.out.println("il centro della stringa " + stringa + " = " + centro);
    }

    public static void sommaLunghezze(String[] sequenza){
        int contatore = 0;
        for (int i = 0; i < sequenza.length; i++){
            if (Character.isUpperCase(sequenza[i].charAt(0)))
                contatore+=sequenza[i].length();
        }
        System.out.println("la somma delle lunghezze delle stringhe che iniziano con una lettera maiuscola: " + contatore);
    }

    public static void main(String[] args) {
        GestioneStringhe.countVocali("Ciao mi chiamo Diego");
        GestioneStringhe.posizioneA("Ciao mi chiamo Diego");
        String rimpiazzata = GestioneStringhe.replaceE_O("Ciao mi chiamo Diego");
        Boolean controllo = GestioneStringhe.areEqual("Ciao", "Ciao");
        GestioneStringhe.centerChar("ABCDEF");
        String[] parole = {"Diego", "ciprietti", "Informatica"};
        GestioneStringhe.sommaLunghezze(parole);

    }
}
