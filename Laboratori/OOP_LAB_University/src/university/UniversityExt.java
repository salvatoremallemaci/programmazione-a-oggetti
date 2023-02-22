package university;

import java.util.Arrays;
import java.util.Comparator;
import java.util.logging.Logger;

public class UniversityExt extends University {

	private final static Logger logger = Logger.getLogger("University");

	private int nEsamiStudente = 0;
	private float AVG_GRADE_STUDENT = 0;
	private int totVotoStudente = 0;

	private int nEsamiCorso = 0;
	private float AVG_GRADE_COURSE = 0;
	private int totVotoCorso = 0;

	private int nEsamiStudenteTotali = 0;
	private int nCorsiStudenteTotali = 0;

	public UniversityExt(String name) {
		super(name);
		// Example of logging
		logger.info("Creating extended university object");
	}

	public void exam(int studentId, int courseID, int grade) {

		int i = 0;

		if (grade < 0 || grade > 30)
			return;

		for (i = 0; i < l; i++) {
			if (registro[i].getMatricola() == studentId && registro[i].getCodiceCorso() == courseID) {
				registro[i].setVoto(grade);

				logger.info(
						"Student " + studentId + " took an exam in course " + courseID + " with grade " + grade + "\n");
				break;
			}
		}

	}

	public String studentAvg(int studentId) {

		int j = 0;

		for (j = 0; j < l; j++) {
			if (registro[j].getMatricola() == studentId) {
				nEsamiStudente++;
				totVotoStudente += registro[j].getVoto();
			}
		}
		if (nEsamiStudente != 0) {
			AVG_GRADE_STUDENT = (float) totVotoStudente / nEsamiStudente;
			return "Student " + studentId + ": " + AVG_GRADE_STUDENT + "\n";
		} else
			return "Student " + studentId + "hasn't taken any exams";
	}

	public String courseAvg(int courseId) {

		int k = 0;

		for (k = 0; k < l; k++) {
			if (registro[k].getCodiceCorso() == courseId) {
				nEsamiCorso++;
				totVotoCorso += registro[k].getVoto();
			}
		}
		if (nEsamiCorso != 0) {
			AVG_GRADE_COURSE = (float) totVotoCorso / nEsamiCorso;
			return "The average for the course " + courseId + " is : " + AVG_GRADE_COURSE + "\n";
		} else
			return "No student has taken the exam in " + courseId + "\n";
	}

	public float Average(int studentId) {

		int j = 0;

		for (j = 0; j < l; j++) {
			if (registro[j].getMatricola() == studentId) {
				nEsamiStudente++;
				totVotoStudente += registro[j].getVoto();
			}
		}
		if (nEsamiStudente != 0) {
			AVG_GRADE_STUDENT = (float) totVotoStudente / nEsamiStudente;
			return AVG_GRADE_STUDENT;
		}
		return AVG_GRADE_STUDENT;
	}

	public String topThreeStudents() {

		int tmpMatricola = 0;
		int counter = 1;
		int j = 0;
		tmpMatricola = registro[0].getMatricola();

		for (int i = 1; i < l; i++) {
			if (tmpMatricola != registro[i].getMatricola()) {
				counter++;
				tmpMatricola = registro[i].getMatricola();
			}
		}

		// Adesso ho il numero di studenti distinti
		// Per ciascun studente, devo allegare la media corrente e il numero di corsi a
		// cui è iscritto.

		nEsamiStudenteTotali = 0;
		nCorsiStudenteTotali = 0;

		return null;
	}

	@Override
	public int enroll(String first, String last) {
		int studentId = super.enroll(first, last);
		logger.info("New student enrolled: " + studentId + ", " + first + " " + last);
		return studentId;
	}

	@Override
	public int activate(String title, String teacher) {
		int code = super.activate(title, teacher);
		logger.info("New course activated: " + code + ", " + title + " " + teacher);
		return code;
	}

	@Override
	public void register(int studentID, int courseCode) {
		super.register(studentID, courseCode);
		logger.info("Student " + studentID + " signed up for course " + courseCode);
	}

}
