package it.polito.oop.rubrica.classi;

public class Voce {

	// Li definisco come private
	private String nome;
	private String cognome;
	private String numTelefono;

	public Voce(String nome, String cognome, String numTelefono) {
		this.nome = nome;
		this.cognome = cognome;
		this.numTelefono = numTelefono;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getNumTelefono() {
		return numTelefono;
	}

	public void setNumTelefono(String numTelefono) {
		this.numTelefono = numTelefono;
	}

	public String toString() {
		return nome + " " + cognome + " " + numTelefono;
	}

}
