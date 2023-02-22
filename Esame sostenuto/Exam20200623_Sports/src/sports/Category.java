package sports;

import java.util.Set;
import java.util.TreeSet;

public class Category {
	private String nomeCategoria;
	private Set<String> attivit‡Collegate;

	public Category(String nomeCategoria) {
		super();
		this.nomeCategoria = nomeCategoria;
		this.attivit‡Collegate = new TreeSet<>();
	}

	public String getNomeCategoria() {
		return nomeCategoria;
	}

	public Set<String> getAttivit‡Collegate() {
		return attivit‡Collegate;
	}

}
