package Compiti_Java.Compito_File;
import java.io.PrintWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class GestisciPersone {
	private ArrayList<Persona> folla;
    private final String pathPersone="persone.txt";     
	public GestisciPersone() {
		folla=new ArrayList<>();
	}
	public void scrivi() {
		PrintWriter pw=null;
		try {
			pw=new PrintWriter(new FileWriter(this.pathPersone, true),true);
			for(Persona p:this.folla)
				pw.println(p);
		}catch(IOException ioe) {System.out.println("Errore in scrittura: "+ioe.getMessage());}
	}
	public boolean aggiungi(String n,int e) {
		boolean result=true;
		Persona p=new Persona(n,e);
		return aggiungi(p);
	}
	public boolean aggiungi(Persona p) {
		boolean result=false;
		try {
			folla.add(p);
			if(folla.contains(p)) return result;
			try {
					folla.add(p);
			}catch(IllegalArgumentException iae) {
		          	System.out.println(iae.getMessage());
		            //Riscrivi la porzione di codice che permetta di registrare la gestione dell'eccezione in un file errori.txt
					return result;
				 }
		}catch(NullPointerException npe) {
            System.out.println("Oggetto non inserito, probabilmente per eta\' non valida\n");
            //Riscrivi la porzione di codice che permetta di registrare la gestione dell'eccezione in un file errori.txt
			return result ;
		}
		return true;
	}
	public void maggiorenni(String path) {
		FileWriter fw=null;
		PrintWriter scrittore=null; 
		try {
			 fw=new FileWriter(path,true);
			 scrittore=new java.io.PrintWriter(fw,true);
			 for(Persona p:folla)
				 if(p.getAge()>=18) //scrivo solo le persone maggiorenni
					 scrittore.println(p);
		}catch(IOException ioe) {System.out.println("Errore in scrittura: "+ioe.getMessage());}
		finally {
			try {
				fw.close();
				scrittore.close();
			}catch(IOException ioe) {}
		}
	}
	public void ChiIniziaCon(char iniziale, String path) throws FileNotFoundException {
	    int i = 0, j = 0;
	    try (Scanner leggi = new Scanner(new FileReader(path))) {
	        while (leggi.hasNextLine()) {
	            try {
	                i++;
	                String riga = leggi.nextLine();
	                if (riga.charAt(0) == iniziale)
	                    System.out.println(riga);
	            } catch (NoSuchElementException | IllegalStateException e) {
	                j++;
	                System.out.println(e.getMessage() + " riga letta " + i + " Eccezioni in lettura verificate: " + j);
	            }
	        }
	    }
	}
	public void leggi() {
		try (
			Scanner leggi=new Scanner(new FileReader(this.pathPersone))){
			while(leggi.hasNextLine()) {
				String riga=leggi.nextLine();
				String[] campi=riga.split("@");
				this.aggiungi(campi[0], Integer.parseInt(campi[1]));
			}
		}catch(FileNotFoundException fnfe) {System.out.println(fnfe.getMessage());}
	} 
    public int acquisisciAge() {
    	Scanner leggi=new Scanner(System.in);
    	System.out.print("Eta\'(non negativa): ");
    	return leggi.nextInt();
    }
    public String acquisisciNominativo() {
    	Scanner leggi=new Scanner(System.in);
    	System.out.print("Nominativo: ");
    	return leggi.nextLine();
    }
    public Persona acquisisciPersona() {
    	/*Esempio di utilizzo del costrutto try-with-resources
    	 * permette di chiudere i flussi senza utilizzare in modo
    	 * esplicito il finally. 
    	 * E' possibile per le classi che implementano l'interfaccia
    	 * Closeable, fra queste, Scanner,FileReader, BufferedReader,
    	 * InputStream, OutputStream,Connection (in JDBC).
    	 *  
    	 */
    	try (Scanner leggi = new Scanner(System.in)) {
			System.out.print("Nominativo: ");
			String n=leggi.nextLine();
			System.out.print("Eta\'(non negativa): ");
			return new Persona(n,leggi.nextInt());
		}
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        GestisciPersone gp=new GestisciPersone();
        gp.aggiungi("Pingo Pallino", 16);
        gp.aggiungi(gp.acquisisciNominativo(),gp.acquisisciAge());
        gp.aggiungi(gp.acquisisciPersona());
        gp.maggiorenni("Maggiorenni.txt");
        try {
        	gp.ChiIniziaCon('M', "Maggiorenni.txt");
        }catch(FileNotFoundException ioe) {System.out.println("File non trovato: " +gp.pathPersone);}
        
        }

}
