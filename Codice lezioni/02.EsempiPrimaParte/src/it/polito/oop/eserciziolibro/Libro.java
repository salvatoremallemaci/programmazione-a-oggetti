package it.polito.oop.eserciziolibro;

public class Libro {

	private int codice;
	private String titolo;

	public int getCodice() {
		return codice;
	}

	public void setCodice(int codice) {
		this.codice = codice;
	}

	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public Libro(int codice, String titolo) {
		super();
		this.codice = codice;
		this.titolo = titolo;
	}

}
