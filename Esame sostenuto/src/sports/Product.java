package sports;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Product {

	private String nome;
	private String nomeAttivitą;
	private String categoria;
	private List<Rating> recensioniProdotto = new ArrayList<>();

	public Product(String nome, String nomeAttivitą, String categoria) {
		super();
		this.nome = nome;
		this.nomeAttivitą = nomeAttivitą;
		this.categoria = categoria;
	}

	public String getNome() {
		return nome;
	}

	public String getNomeAttivitą() {
		return nomeAttivitą;
	}

	public String getCategoria() {
		return categoria;
	}

	public List<Rating> getRecensioniProdotto() {
		return recensioniProdotto;
	}

}
