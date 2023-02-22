package sports;

import java.util.ArrayList;
import java.util.List;

public class Activity {

	private String attivit�;
	private List<String> categorieLegate;
	private List<Product> prodottiLegati = new ArrayList<>();

	public Activity(String attivit�) {
		super();
		this.attivit� = attivit�;
		this.categorieLegate = new ArrayList<>();
	}

	public String getAttivit�() {
		return attivit�;
	}

	public void setAttivit�(String attivit�) {
		this.attivit� = attivit�;
	}

	public List<String> getCategorieLegate() {
		return categorieLegate;
	}

	public List<Product> getProdottiLegati() {
		return prodottiLegati;
	}

}
