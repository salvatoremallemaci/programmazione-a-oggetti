package warehouse;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Supplier {

	private String codice;
	private String nome;
	private List<Product> rifornimenti;

	public Supplier(String codice, String nome) {
		super();
		this.codice = codice;
		this.nome = nome;
		this.rifornimenti = new ArrayList<>();
	}

	public String getCodice() {
		return codice;
	}

	public String getNome() {
		return nome;
	}

	public void newSupply(Product product) {
		this.rifornimenti.add(product);
		product.setFornitoriProdotto(this);
	}

	public List<Product> supplies() {
		List<Product> listaProdottiOrdinata = new ArrayList<>(this.rifornimenti);
		Collections.sort(listaProdottiOrdinata,
				Comparator.comparing(Product::getDescription)
				);
		return listaProdottiOrdinata;
	}
}
