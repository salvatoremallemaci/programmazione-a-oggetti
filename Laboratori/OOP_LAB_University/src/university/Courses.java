package university;

public class Courses {

	private static final String SEPARATOR = " ";

	private Students[] students;

	private int codiceCorso;
	private String nomeCorso;
	private String nomeDocente;
	
	

	public Courses(String nomeCorso, String nomeDocente, int codiceCorso) {

		this.nomeCorso = nomeCorso;
		this.nomeDocente = nomeDocente;
		this.codiceCorso = codiceCorso;

	}

	public int getCodiceCorso() {
		return codiceCorso;
	}

	public void setCodiceCorso(int codiceCorso) {
		this.codiceCorso = codiceCorso;
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

	public String toString() {
		return codiceCorso + SEPARATOR + nomeCorso + SEPARATOR + nomeDocente;
	}

	public void enroll(Students s) {
		for (int i = 0; i < students.length; i++) {
			if (students[i] == null) {
				students[i] = s;
				break;
			}
		}
	}

	public String attendees() {
		/*
		 * String res = ""; for (Students s : students){ if(s != null) res +=
		 * s.toString() + "\n"; } return res;
		 */
		StringBuffer result = new StringBuffer();
		for (Students s : students)
			if (s != null)
				result.append(s.toString()).append("\n");
		return result.toString();
	}
	
	
	
	
}