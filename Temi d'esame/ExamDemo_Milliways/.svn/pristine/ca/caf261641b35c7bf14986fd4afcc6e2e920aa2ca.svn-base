package it.polito.oop.milliways;

import java.util.ArrayList;
import java.util.List;
import static java.util.stream.Collectors.*;

public class Race {

	private String nome;
	private List<String> listaRequisti = new ArrayList<>();

	public Race(String nome) {
		super();
		this.nome = nome;
	}

	public void addRequirement(String requirement) throws MilliwaysException {
		if (listaRequisti.contains(requirement))
			throw new MilliwaysException();
		listaRequisti.add(requirement);
	}

	public List<String> getRequirements() {
		return listaRequisti.stream().sorted().collect(toList());
	}

	public String getName() {
		return nome;
	}
}
