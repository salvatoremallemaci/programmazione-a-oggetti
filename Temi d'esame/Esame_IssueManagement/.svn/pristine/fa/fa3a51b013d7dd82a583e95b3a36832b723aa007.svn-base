package ticketing;

import java.util.HashSet;
import java.util.Set;

import ticketing.IssueManager.UserClass;

public class User {
	private String username;
	private Set<UserClass> ruoli = new HashSet<>();
	private Set<Ticket> bigliettiAssegnati = new HashSet<>();
	private Set<Ticket> bigliettiChiusi = new HashSet<>();

	public User(String username, Set<UserClass> ruoli) {
		super();
		this.username = username;
		this.ruoli = ruoli;
	}

	public String getUsername() {
		return username;
	}

	public Set<UserClass> getRuoli() {
		return ruoli;
	}

	public void setBiglietto(Ticket biglietto) {
		this.bigliettiAssegnati.add(biglietto);
	}

	public void setBigliettoChiuso(Ticket biglietto) {
		this.bigliettiChiusi.add(biglietto);
	}

	public Set<Ticket> getBigliettiChiusi() {
		return bigliettiChiusi;
	}

	public Set<Ticket> getBigliettiAssegnati() {
		return bigliettiAssegnati;
	}

}
