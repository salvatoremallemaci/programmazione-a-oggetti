package it.polito.oop.rubrica.classi;

public class Rubrica {

	private String nome;

	private Voce[] voci;
	private int next = 0;
	private String ds = "(";
	private int i;
	private int j;

	private final int MAX_VOCI = 100;

	public Rubrica(String nome) {
		this.nome = nome;
		voci = new Voce[MAX_VOCI];
	}

	public String getNome() {
		return nome;
		// return null;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void aggiungi(String nome, String cognome, String numTel) {
		Voce v = new Voce(nome, cognome, numTel);
		if (next < MAX_VOCI) {
			voci[next] = v;
			next++;
		} else
			System.err.println("Impossibile aggiungere voce : rubrica piena!");
	}

	public String primo() {
		if (next != 0)
			return voci[0].getNome() + " " + voci[0].getCognome() + " " + voci[0].getNumTelefono();
		// return voci[0].toString();
		else
			return "Rubrica vuota!";
	}

	public String voce(int index) {
		if (next != 0 && index < MAX_VOCI) {
			return voci[index - 1].getNome() + " " + voci[index - 1].getCognome() + " "
					+ voci[index - 1].getNumTelefono();
		} else if (next == 0)
			return "Rubrica vuota!";
		else
			return "Indice non consentito, massimo 100 contatti in Rubrica!";
	}

	public String elenco() {
		while (i != next) {
			ds += voci[i].getNome() + " " + voci[i].getCognome() + " " + voci[i].getNumTelefono() + ",";
			i++;
		}
		ds = ds + ")";
		return ds;
	}

	public String ricerca(String stringa_parametro) {

		while (j != next) {
			if (voci[j].getNome() == stringa_parametro || voci[j].getCognome() == stringa_parametro
					|| voci[j].getNumTelefono() == stringa_parametro)
				return "La voce contenente " + "'" + stringa_parametro + "' " + "? la seguente : " + voci[j].getNome()
						+ "," + voci[j].getCognome() + "," + voci[j].getNumTelefono();
			j++;
		}
		return "Nessuna voce contiene il parametro richiesto!";
	}

}
