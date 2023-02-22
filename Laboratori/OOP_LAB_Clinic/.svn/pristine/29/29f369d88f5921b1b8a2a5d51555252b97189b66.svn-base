package clinic;

import java.util.ArrayList;
import java.util.Collection;

public class Doctor {

	private String nome;
	private String cognome;
	private String ssn;
	private Integer docID;
	private String specializzazione;

	public Doctor(String nome, String cognome, String ssn, Integer docID, String specializzazione) {
		super();
		this.nome = nome;
		this.cognome = cognome;
		this.ssn = ssn;
		this.docID = docID;
		this.specializzazione = specializzazione;
	}

	public String getNome() {
		return nome;
	}

	public String getCognome() {
		return cognome;
	}

	public String getSsn() {
		return ssn;
	}

	public Integer getDocID() {
		return docID;
	}

	public String getSpecializzazione() {
		return specializzazione;
	}

	public String toString() {
		return cognome + " " + nome + " " + "(" + ssn + ")" + " " + "[" + docID + "]:" + " " + specializzazione;
	}
	
	Collection<String> pazientiPerDottore = new ArrayList<>();
}
