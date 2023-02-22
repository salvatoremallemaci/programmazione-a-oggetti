package clinic;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import static java.util.stream.Collectors.*;
import static java.util.Comparator.*;

/**
 * Represents a clinic with patients and doctors.
 * 
 */
public class Clinic {

	Map<String, Patient> pazienti = new TreeMap<>();
	Map<Integer, Doctor> dottori = new TreeMap<>();
	List<String> inputList = new ArrayList<>();
	private double mediaPazienti = 0.0;

	/**
	 * Add a new clinic patient.
	 * 
	 * @param first
	 *            first name of the patient
	 * @param last
	 *            last name of the patient
	 * @param ssn
	 *            SSN number of the patient
	 */
	public void addPatient(String first, String last, String ssn) {
		Patient p = new Patient(first, last, ssn);
		pazienti.put(ssn, p);
	}

	/**
	 * Retrieves a patient information
	 * 
	 * @param ssn
	 *            SSN of the patient
	 * @return the object representing the patient
	 * @throws NoSuchPatient
	 *             in case of no patient with matching SSN
	 */
	public String getPatient(String ssn) throws NoSuchPatient {
		if (!pazienti.containsKey(ssn)) {
			throw new NoSuchPatient();
		} else
			return pazienti.get(ssn).toString();
	}

	/**
	 * Add a new doctor working at the clinic
	 * 
	 * @param first
	 *            first name of the doctor
	 * @param last
	 *            last name of the doctor
	 * @param ssn
	 *            SSN number of the doctor
	 * @param docID
	 *            unique ID of the doctor
	 * @param specialization
	 *            doctor's specialization
	 */
	public void addDoctor(String first, String last, String ssn, int docID, String specialization) {
		Doctor d = new Doctor(first, last, ssn, docID, specialization);
		Patient p = new Patient(first, last, ssn);
		dottori.put(docID, d);
		pazienti.put(ssn, p);		
	}

	/**
	 * Retrieves information about a doctor
	 * 
	 * @param docID
	 *            ID of the doctor
	 * @return object with information about the doctor
	 * @throws NoSuchDoctor
	 *             in case no doctor exists with a matching ID
	 */
	public String getDoctor(int docID) throws NoSuchDoctor {
		if (!dottori.containsKey(docID)) {
			throw new NoSuchDoctor();
		} else
			return dottori.get(docID).toString();
	}

	/**
	 * Assign a given doctor to a patient
	 * 
	 * @param ssn
	 *            SSN of the patient
	 * @param docID
	 *            ID of the doctor
	 * @throws NoSuchPatient
	 *             in case of not patient with matching SSN
	 * @throws NoSuchDoctor
	 *             in case no doctor exists with a matching ID
	 */
	public void assignPatientToDoctor(String ssn, int docID) throws NoSuchPatient, NoSuchDoctor {
		if (!pazienti.containsKey(ssn))
			throw new NoSuchPatient();
		if (!dottori.containsKey(docID))
			throw new NoSuchDoctor();
		Doctor d = dottori.get(docID);
		d.pazientiPerDottore.add(ssn);
		pazienti.get(ssn).setDottore(d);
	}

	/**
	 * Retrieves the id of the doctor assigned to a given patient.
	 * 
	 * @param ssn
	 *            SSN of the patient
	 * @return id of the doctor
	 * @throws NoSuchPatient
	 *             in case of not patient with matching SSN
	 * @throws NoSuchDoctor
	 *             in case no doctor has been assigned to the patient
	 */
	public int getAssignedDoctor(String ssn) throws NoSuchPatient, NoSuchDoctor {
		if (!pazienti.containsKey(ssn))
			throw new NoSuchPatient();
		if (pazienti.get(ssn).getDottore() == null)
			throw new NoSuchDoctor();
		return pazienti.get(ssn).getDottore().getDocID();
	}

	/**
	 * Retrieves the patients assigned to a doctor
	 * 
	 * @param id
	 *            ID of the doctor
	 * @return collection of patient SSNs
	 * @throws NoSuchDoctor
	 *             in case the {@code id} does not match any doctor
	 */
	public Collection<String> getAssignedPatients(int id) throws NoSuchDoctor {
		if (!dottori.containsKey(id))
			throw new NoSuchDoctor();
		return dottori.get(id).pazientiPerDottore;
	}

	/**
	 * Loads data about doctors and patients from the given stream.
	 * <p>
	 * The text file is organized by rows, each row contains info about either a
	 * patient or a doctor.
	 * </p>
	 * <p>
	 * Rows containing a patient's info begin with letter {@code "P"} followed by
	 * first name, last name, and SSN. Rows containing doctor's info start with
	 * letter {@code "M"}, followed by badge ID, first name, last name, SSN, and
	 * specialization.<br>
	 * The elements on a line are separated by the {@code ';'} character possibly
	 * surrounded by spaces that should be ignored.
	 * </p>
	 * <p>
	 * In case of error in the data present on a given row, the method should be
	 * able to ignore the row and skip to the next one.<br>
	 * 
	 * 
	 * @param readed
	 *            linked to the file to be read
	 * @throws IOException
	 *             in case of IO error
	 */
	public void loadData(Reader reader) throws IOException {
		try (BufferedReader in = new BufferedReader(reader)) {
			inputList = in.lines().collect(toList());
		} catch (IOException e) {
			System.err.println(e.getMessage());
		}

		int lunghezzaLista = inputList.size();
		int ID = 0;

		for (int i = 0; i < lunghezzaLista; i++) {
			String line = inputList.get(i);
			if (line.matches("(\\s*(P)\\s*;\\s*(\\w*)\\s*;\\s*(\\w*)\\s*;\\s*(\\w*)\\s*)") 
					|| line.matches("(\\s*(M)\\s*;\\s*(\\d)+\\s*;\\s*(\\w*)\\s*;"
							+ "\\s*(\\w*)\\s*;\\s*(\\w*)\\s*;\\s*(\\w*)\\s*)")) {
				
				String[] tmp = line.split(";");

				if (tmp[0] == "P") {
					Patient paziente = new Patient(tmp[1], tmp[2], tmp[3]);
					if (!pazienti.containsKey(tmp[3]))
						pazienti.put(tmp[3], paziente);
				}
				if (tmp[0] == "M") {
					Doctor dottore = new Doctor(tmp[2], tmp[3], tmp[4], ID, tmp[5]);
					if (!dottori.containsKey(ID))
						dottori.put(ID, dottore);
				}

			} else
				break; // salto alla prossima iterazione

		}
	}

	@SuppressWarnings("unused")
	public Reader creazioneReader(String nomeFile) throws IOException {
		Reader r = new FileReader(nomeFile);
		if (r == null)
			throw new IOException();
		else
			return r;
	}

	/**
	 * Retrieves the collection of doctors that have no patient at all. The doctors
	 * are returned sorted in alphabetical order
	 * 
	 * @return the collection of doctors' ids
	 */
	public Collection<Integer> idleDoctors() {
		 
		 return dottori.values().stream()
		 .filter(d -> d.pazientiPerDottore.isEmpty())
		 .sorted(comparing(Doctor::getCognome).thenComparing(Doctor::getNome))
		 .map(Doctor::getDocID)
		 .collect(toList());
		 
	}

	/**
	 * Retrieves the collection of doctors having a number of patients larger than
	 * the average.
	 * 
	 * @return the collection of doctors' ids
	 */
	public Collection<Integer> busyDoctors() {
		
		for(Doctor d : dottori.values()) {
			mediaPazienti += d.pazientiPerDottore.size();
		}
	
		mediaPazienti = mediaPazienti/dottori.size();
		
		 return dottori.values().stream()
				 .filter(d -> d.pazientiPerDottore.size() > mediaPazienti)
				 .map(Doctor::getDocID)
				 .collect(toList());
		
	}

	/**
	 * Retrieves the information about doctors and relative number of assigned
	 * patients.
	 * <p>
	 * The method returns list of strings formatted as
	 * "{@code ### : ID SURNAME NAME}" where {@code ###} represent the number of
	 * patients (printed on three characters).
	 * <p>
	 * The list is sorted by decreasing number of patients.
	 * 
	 * @return the collection of strings with information about doctors and patients
	 *         count
	 */
	public Collection<String> doctorsByNumPatients() {
		
		return dottori.values().stream()
		.sorted(comparing((Doctor d) -> d.pazientiPerDottore.size()).reversed())
		.map(d -> String.format("%3d", d.pazientiPerDottore.size()) + " :" + 
		d.getDocID() + " " + d.getCognome() + " " + d.getNome())
		.collect(toList());
		
	}

	/**
	 * Retrieves the number of patients per (their doctor's) speciality
	 * <p>
	 * The information is a collections of strings structured as
	 * {@code ### - SPECIALITY} where {@code SPECIALITY} is the name of the
	 * speciality and {@code ###} is the number of patients cured by doctors with
	 * such speciality (printed on three characters).
	 * <p>
	 * The elements are sorted first by decreasing count and then by alphabetic
	 * speciality.
	 * 
	 * @return the collection of strings with speciality and patient count
	 *         information.
	 */
	public Collection<String> countPatientsPerSpecialization() {
		
	/*	Map<String,Long> mappa =
		pazienti.values().stream()
		.collect(groupingBy(
				(Patient p) -> p.getDottore().getSpecializzazione(),
				() -> new TreeMap<String,Long>(),
				counting()
				));
		
		Collection<String> risultato = new ArrayList<String>();
		
		String str= "";
		
		Set<Map.Entry<String, Long>> entries = mappa.entrySet();
		
		for(Map.Entry<String, Long> e : entries)
		{
			str = String.format("%3d", e.getValue()) + " - " + e.getKey(); 
			risultato.add(str);
		}
		
		return risultato; 
		*/
		return 
		pazienti.values().stream()
		.filter(p -> p.getDottore() != null)
		.collect(groupingBy(
				(Patient p) -> p.getDottore().getSpecializzazione(),
				() -> new TreeMap<String,Long>(),
				counting()
				))
		.entrySet().stream()
		.sorted(comparing(Map.Entry::getValue,reverseOrder()))
		.map(e -> String.format("%3d", e.getValue()) + " - " + e.getKey() )
		.collect(toList());
		
	}
	
}
