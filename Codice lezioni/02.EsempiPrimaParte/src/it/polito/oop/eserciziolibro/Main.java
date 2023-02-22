package it.polito.oop.eserciziolibro;

public class Main {

	static Libro[] libri = { new Libro(1, "pietra filosofale"), new Libro(2, "camera dei segreti"),
			new Libro(3, "prigioniero di akzaban"), new Libro(4, "calice di fuoco") };

	static int ricercaCodice(String titolo) {
		for (Libro l : libri)
			if (l.getTitolo().equals(titolo))
				return l.getCodice();
		return 0;
	}

	public static void main(String[] args) {
		String titolo = "calice di fuoco";
		System.out.println(ricercaCodice(titolo));
	}

}
