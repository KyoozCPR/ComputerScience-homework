package Compiti_Java.Compito_Scaffali;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class ScaffaleArrayList {
     private ArrayList<Prodotto> lista;
     
     
     public void ordina() {
    	 Collections.sort(lista);
     }
     
     public ArrayList<Prodotto> getLista() {
    	return lista;
     }
   
    
    public Prodotto acquisisciProdotto() {
    	Scanner tastiera=new Scanner(System.in);
    	System.out.println("Nome: ");
    	String n=tastiera.nextLine();
    	System.out.println("Prezzo: ");
    	double d=tastiera.nextDouble();
    	System.out.println("Quantita\': ");
    	int q=tastiera.nextInt();
          return new Prodotto(n,d,q);
    }
    
    
    public boolean aggiungi(Prodotto p){return lista.add(p);}
    
    public boolean aggiungiDistinti() {
	    Prodotto p=this.acquisisciProdotto();
    	int pos=ricerca(p.getNome());
        if(pos==-1)
        	return aggiungi(p);
        int q=lista.get(pos).getQuot();
        double pr=lista.get(pos).getPrice()<p.getPrice()?p.getPrice():lista.get(pos).getPrice();//assegno come prezzo il più alto
        aggiorna(pos, new Prodotto(p.getNome(),pr,q+p.getQuot()));
        return true;
    }
    
    
    public boolean aggiorna(int pos, Prodotto p) {
    	if(pos<0 || pos>this.lista.size())
    		return false;
    	lista.set(pos, p);
    	return true;
    }
    
    
    public boolean aggiorna(Prodotto old, Prodotto newsted) {
    	int pos=ricerca(old.getNome());
    	if(pos==-1)return false;
    	lista.set(pos,newsted);
    	return true;
    }
    
    public int ricerca(String nome) {
    	nome=nome.trim();
    	for(int i=0;i<this.lista.size();i++)
    		if(lista.get(i).getNome().equalsIgnoreCase(nome))
    			return i;
    	return -1;
    }
    
    
    public ScaffaleArrayList() {
       	lista=new ArrayList<>();
    }
    
	
    public boolean cancella(String name) {	
    	int pos=ricerca(name);
    	return cancella(pos);
    }
    
    
    public int cheaper() {
    	int i,min;
    	for(i=1,min=0;i<lista.size();i++)
    		if(lista.get(i).getPrice()<lista.get(min).getPrice())
    			min=i;
    	return min;
    }
    
    
    public double mediaQuot() {
    	double avg=0;
    	int dim=lista.size();
    	for(int i=0;i<dim;i++)
    		avg+=lista.get(i).getQuot();
    	return avg/dim;
    }
    
    
    /*Ritorna la posizione del prodotto con nome più lungo*/
	public int ProdottoConNomeLongest() {
		int max=0;
		for(int i=1;i<lista.size();i++)
			if(lista.get(i).getNome().length()>lista.get(max).getNome().length())
				max=i;
		return max;
	}
	
	public ArrayList<Prodotto> sottoscorta(int quot) {
		ArrayList<Prodotto> subscorta=new ArrayList<>();
		for(Prodotto p:lista)
			if(p.getQuot()<quot)
				subscorta.add(p);
		return subscorta;
	}

	public boolean cancella(int i) {
		if(i<0|| i>lista.size())
			return false;
		lista.remove(i);
		return true;
	}
	
	
	public Prodotto get(int i) {return lista.get(i);} 
	
	
	@Override
	public String toString() {
		String res="I prodotti presenti sono: "+lista.size()+"\n";
		for(Prodotto p:lista)
			  res+=p+"\n";
		return res;
	}
	
	public static String toString(ArrayList<Prodotto> sublist) {
		String res="",inizio="I prodotti presenti sono: "+sublist.size();
		for(Prodotto e: sublist)
			if(e!=null) {
			  res+=e+"\n";
			}
		return inizio+" "+res;
	}
	 
 
}

