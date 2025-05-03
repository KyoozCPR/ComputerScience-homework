package Compiti_Java.Compito_File;

public class Persona implements Comparable<Persona>{
	private int age;
	private String nominativo;
	
	public int getAge() {return age;}
	public String getNominativo() {return this.nominativo;}
	public void setAge(int age) {
		if(age<0)
			throw new IllegalArgumentException("L\'eta\' non puo\' essere negativa!!");
		this.age=age;
    }
	public void  setNominativo(String n) {this.nominativo=n;}
	public Persona(String n,int e) {
		setAge(e); //se e è negativo non creo l'oggetto
		this.nominativo=n;
	}
	@Override
	public String toString() {
		return this.nominativo+"@"+this.age;
	}
    public int compareTo(Persona p) {
    	int value=this.age-p.age;
    	if(value==0)
    		return this.nominativo.compareToIgnoreCase(p.nominativo);
    	return value;
    }
    
}

	