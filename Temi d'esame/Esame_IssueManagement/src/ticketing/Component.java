package ticketing;

import java.util.HashSet;
import java.util.Set;

public class Component {

	private String nome;
	private String path;
	private Component sottoComponente;
	Set<String> sottoComponenti = new HashSet<>(); 

	public Component(String nome) {
		super();
		this.nome = nome;
		this.path = "/System";
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getNome() {
		return nome;
	}

	public Component getSottoComponente() {
		return sottoComponente;
	}

	public void setSottoComponente(Component sottoComponente) {
		this.sottoComponente = sottoComponente;
	}

	public void setSottoComponenti(String sottoComponente) {
		this.sottoComponenti.add(sottoComponente);
	}

	public Set<String> getSottoComponenti() {
		return sottoComponenti;
	}
	
	
	
	
}
