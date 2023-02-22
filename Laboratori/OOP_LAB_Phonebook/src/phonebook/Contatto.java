package phonebook;

/*public*/ class Contatto { // visibilità di package

	private String nome;
	private String cognome;
	private String telefono;
	
	Contatto(String nome, String cognome, String telefono) {
		this.nome = nome;
		this.cognome = cognome;
		this.telefono = telefono;
	}
	
	public String toString() {
		return nome + " " + cognome + " " + telefono;
	}

	public boolean contiene(String needle) {
		
		return nome.contains(needle) ||
				cognome.contains(needle) ||
				telefono.contains(needle);
		
	}
}
