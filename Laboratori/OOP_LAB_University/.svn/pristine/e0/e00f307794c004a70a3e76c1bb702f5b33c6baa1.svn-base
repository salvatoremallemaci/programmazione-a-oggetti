package university;

public class Students {

	private static final String SEPARATOR = " ";

	private Courses[] courses;
	
	private String nomeS;
	private String cognomeS;
	private int matricola;

	public Students(String nomeS, String cognomeS, int matricola) {

		this.nomeS = nomeS;
		this.cognomeS = cognomeS;
		this.matricola = matricola;
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

	public int getMatricola() {
		return matricola;
	}

	public void setMatricola(int matricola) {
		this.matricola = matricola;
	}

	public String toString() {
		return matricola + SEPARATOR + nomeS + SEPARATOR + cognomeS;
	}

	public void enroll(Courses c) {

		for (int i = 0; i < courses.length; i++) {
			if (courses[i] == null) {
				courses[i] = c;
				break;
			}
		}
	}

	public String courses() {
		StringBuffer result = new StringBuffer();
		for (Courses c : courses)
			if (c != null)
				result.append(c.toString()).append("\n");
		return result.toString();

	}

}
