package sports;

import java.util.Set;
import java.util.TreeSet;

public class Category {
	private String nomeCategoria;
	private Set<String> attivitąCollegate;

	public Category(String nomeCategoria) {
		super();
		this.nomeCategoria = nomeCategoria;
		this.attivitąCollegate = new TreeSet<>();
	}

	public String getNomeCategoria() {
		return nomeCategoria;
	}

	public Set<String> getAttivitąCollegate() {
		return attivitąCollegate;
	}

}
