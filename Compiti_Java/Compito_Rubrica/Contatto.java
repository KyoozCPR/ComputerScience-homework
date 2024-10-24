
public class Contatto {
	private String nome, cognome, telefono;
	private Data data;
	
	public String getNome() {
		return this.nome;
	}
	public String getCognome(){
		return this.cognome;
	}
	public String getTelefono() {
		return this.telefono;
	}
	
	public Data getData() {
		return this.data;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	
	public void setData(Data data) {
		this.data = data;
	}
	
	
	public Contatto(String nome, String cognome, String telefono, Data data) {
		setNome(nome);
		setCognome(cognome);
		setTelefono(telefono);
		setData(data);

	}
	
	
}

