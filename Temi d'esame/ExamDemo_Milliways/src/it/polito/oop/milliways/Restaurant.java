package it.polito.oop.milliways;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import static java.util.Comparator.*;
import static java.util.stream.Collectors.*;

public class Restaurant {

	Map<String, Race> listaRazze = new TreeMap<>();
	List<Hall> listaHall = new LinkedList<>();
	Map<Integer, Hall> mappaHall = new TreeMap<>();
	private List<Party> seatedParty = new LinkedList<>();

	public Restaurant() {
	}

	public Race defineRace(String name) throws MilliwaysException {

		Race r = new Race(name);
		if (listaRazze.containsKey(name))
			throw new MilliwaysException();
		listaRazze.put(name, r);
		return r;
	}

	public Party createParty() {
		Party p = new Party();
		return p;
	}

	public Hall defineHall(int id) throws MilliwaysException {

		if (mappaHall.containsKey(id))
			throw new MilliwaysException();
		Hall h = new Hall(id);
		listaHall.add(h);
		mappaHall.put(id, h);

		return h;
	}

	public List<Hall> getHallList() {
		return listaHall;
	}

	public Hall seat(Party party, Hall hall) throws MilliwaysException {

		if (!hall.isSuitable(party))
			throw new MilliwaysException();

		party.salone(hall);
		hall.gruppo(party);
		seatedParty.add(party);

		return hall;
	}

	public Hall seat(Party party) throws MilliwaysException {

		for (Hall h : listaHall) {
			if (h.isSuitable(party))
				party.salone(h);
			return seat(party,h);
		}
		throw new MilliwaysException();
	}

	public Map<Race, Integer> statComposition() {
		
		return seatedParty.stream()
        		.flatMap(e -> e.composition.entrySet().stream())
        		.collect(groupingBy(
        					Map.Entry::getKey,
        					summingInt(Map.Entry::getValue)
        				))
        		;
	}

	public List<String> statFacility() {
		return null;
	}

	public Map<Integer, List<Integer>> statHalls() {
		return null;
	}

}
