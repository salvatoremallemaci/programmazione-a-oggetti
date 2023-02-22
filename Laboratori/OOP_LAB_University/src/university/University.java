package university;

/**
 * This class represents a university education system.
 * 
 * It manages students and courses.
 *
 */
public class University {

	private String nomeUni;
	private String rector;

	private final int MAX_STUDENTI = 1000;
	private final int MAX_INSEGNAMENTI = 50;

	private final int MAX_I = 25;
	private final int MAX_S = 100;

	private int matricola = 9999;
	private int codice = 9;

	protected Students[] studenti;
	protected Courses[] insegnamenti = new Courses[MAX_INSEGNAMENTI];
	protected int nStudenti = 0;
	private int nInsegnamenti = 0;
	private int i = 0;
	private int j = 0;
	private int indexS = 0;
	private int indexI = 0;

	protected int l = 0;
	private int countI = 0;
	private int countS = 0;
	private int count = 0;

	private boolean checkS = true;
	private boolean checkI = true;
	private boolean checkRegister = false;
	private int lunghezzaRegistro = 0;
	protected Attendance[] registro = new Attendance[MAX_I * MAX_S];
	private String stringaLista;
	private String stringaPiano;

	/**
	 * Constructor
	 * 
	 * @param name
	 *            name of the university
	 */

	public University(String name) {
		this.nomeUni = name;
		this.studenti = new Students[MAX_STUDENTI];
	}

	/**
	 * Getter for the name of the university
	 * 
	 * @return name of university
	 */
	public String getName() {
		return this.nomeUni;
	}

	/**
	 * Defines the rector for the university
	 * 
	 * @param first
	 * @param last
	 */
	public void setRector(String first, String last) {

		this.rector = first + " " + last;
	}

	/**
	 * Retrieves the rector of the university
	 * 
	 * @return
	 */
	public String getRector() {

		return rector;
	}

	/**
	 * Enroll a student in the university
	 * 
	 * @param first
	 *            first name of the student
	 * @param last
	 *            last name of the student
	 * @return
	 */
	public int enroll(String first, String last) {

		Students s = new Students(first, last, ++matricola);
		if (nStudenti < MAX_STUDENTI) {
			studenti[nStudenti] = s;
			nStudenti++;

		} else {
			System.err.println("Impossibile aggiungere studente : limite massimo raggiunto!");
			return -1;
		}
		return matricola;
	}

	/**
	 * Retrieves the information for a given student
	 * 
	 * @param id
	 *            the id of the student
	 * @return information about the student
	 */
	public String student(int id) {
		if (nStudenti == 0)
			return "Non ci sono studenti in questa università!";

		if (nStudenti != 0) {
			while (i != nStudenti) {
				if (studenti[i].getMatricola() == id)
					return studenti[i].toString();
				i++;
			}
		}

		return "Non c'è uno studente con questa matricola!";

	}

	/**
	 * Activates a new course with the given teacher
	 * 
	 * @param title
	 *            title of the course
	 * @param teacher
	 *            name of the teacher
	 * @return the unique code assigned to the course
	 */
	public int activate(String title, String teacher) {

		Courses c = new Courses(title, teacher, ++codice);
		if (nInsegnamenti < MAX_INSEGNAMENTI) {
			insegnamenti[nInsegnamenti] = c;
			nInsegnamenti++;

		} else
			System.err.println("Impossibile aggiungere insegnamento : limite massimo raggiunto!");

		return codice;
	}

	/**
	 * Retrieve the information for a given course
	 * 
	 * @param code
	 *            unique code of the course
	 * @return information about the course
	 */
	
	public String course(int code) {
		
		if (nInsegnamenti == 0)
			return "Non ci sono insegnamenti in questa università!";

		if (nInsegnamenti != 0) {
			while (j != nInsegnamenti) {
				if (insegnamenti[j].getCodiceCorso() == code)
					return insegnamenti[j].toString();
				j++;
			}
		}
		return "Non ci sono insegnamenti in questa università!";
	}

	/**
	 * Register a student to attend a course
	 * 
	 * @param studentID
	 *            id of the student
	 * @param courseCode
	 *            id of the course
	 */
	public void register(int studentID, int courseCode) {

		indexS = 0;
		indexI = 0;
		// Attendance zero = new Attendance(0, 0, "", "", "", "");
		// lunghezzaRegistro = nStudenti * nInsegnamenti;

		for (int i = 0; i < nStudenti; i++) {
			if (studenti[i].getMatricola() == studentID) {
				indexS = i;
				countS++;
			}
		}
		if (countS == 0)
			checkS = false;

		for (int j = 0; j < nInsegnamenti; j++) {
			if (insegnamenti[i].getCodiceCorso() == courseCode) {
				indexI = j;
				countI++;
			}
		}
		if (countI == 0)
			checkI = false;

		if (checkS && checkI) {
			Attendance r = new Attendance(studentID, courseCode, studenti[indexS].getNomeS(),
					studenti[indexS].getCognomeS(), insegnamenti[indexI].getNomeCorso(),
					insegnamenti[indexI].getNomeDocente(),-1);
			registro[l++] = r;

		}

		// Students s = studenti[nStudenti];
		// Courses c = insegnamenti[nInsegnamenti];
		// s.enroll(c);
		// c.enroll(s);
	}

	/**
	 * Retrieve a list of attendees
	 * 
	 * @param courseCode
	 *            unique id of the course
	 * @return list of attendees separated by "\n"
	 */
	public String listAttendees(int courseCode) {

		stringaLista = "";

		for (int i = 0; i < l; i++) {

			if (registro[i].getCodiceCorso() == courseCode)
				stringaLista += registro[i].toString();
			else
				stringaLista += "";
		}

		return stringaLista;

		// Courses c = insegnamenti[nInsegnamenti];
		// return c.attendees();

	}

	/**
	 * Retrieves the study plan for a student
	 * 
	 * @param studentID
	 *            id of the student
	 * @return list of courses the student is registered for
	 */
	public String studyPlan(int studentID) {
		stringaPiano = "";

		for (int i = 0; i < l; i++) {
			if (registro[i].getMatricola() == studentID) {
				stringaPiano += registro[i].getCodiceCorso() + "," + registro[i].getNomeCorso() + ","
						+ registro[i].getNomeDocente() + "\n";
			} else
				stringaPiano += "";
		}

		return stringaPiano;

		// Students s = studenti[nStudenti];
		// return s.courses();
	}
}
