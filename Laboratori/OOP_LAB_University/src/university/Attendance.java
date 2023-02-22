package university;

public class Attendance {

	private String nomeS;
	private String cognomeS;
	private int matricola;

	private int codiceCorso;
	private String nomeCorso;
	private String nomeDocente;

	private int voto;


	public Attendance(int matricola, int codiceCorso, String nomeS, String cognomeS, String nomeCorso,
			String nomeDocente, int voto) {

		this.matricola = matricola;
		this.nomeS = nomeS;
		this.cognomeS = cognomeS;
		this.codiceCorso = codiceCorso;
		this.nomeCorso = nomeCorso;
		this.nomeDocente = nomeDocente;
		this.voto = voto;
	}

	public int getVoto() {
		return voto;
	}

	public void setVoto(int voto) {
		this.voto = voto;
	}

	public int getMatricola() {
		return matricola;
	}

	public void setMatricola(int matricola) {
		this.matricola = matricola;
	}

	public String getNomeCorso() {
		return nomeCorso;
	}

	public void setNomeCorso(String nomeCorso) {
		this.nomeCorso = nomeCorso;
	}

	public String getNomeDocente() {
		return nomeDocente;
	}

	public void setNomeDocente(String nomeDocente) {
		this.nomeDocente = nomeDocente;
	}

	public int getCodiceCorso() {
		return codiceCorso;
	}

	public String getNomeS() {
		return nomeS;
	}

	public void setNomeS(String nomeS) {
		this.nomeS = nomeS;
	}

	public String getCognomeS() {
		return cognomeS;
	}

	public void setCognomeS(String cognomeS) {
		this.cognomeS = cognomeS;
	}

	public void setCodiceCorso(int codiceCorso) {
		this.codiceCorso = codiceCorso;
	}

	public String toString() {

		return matricola + " " + nomeS + " " + cognomeS + "\n";

	}

}
