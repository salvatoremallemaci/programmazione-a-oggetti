package it.polito.oop.milliways;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Hall {

	private int id;
	private Set<String> facilities = new TreeSet<>();
	
	Hall(int id) {
		this.id = id;
	}
	
	public int getId() {
		return id;
	}

	public void addFacility(String facility) throws MilliwaysException {
		if(facilities.contains(facility))
			throw new MilliwaysException();
		facilities.add(facility);
	}

	public List<String> getFacilities() {
		return new ArrayList<>(facilities);
	}
	
	int getNumFacilities(){
        return facilities.size();
	}

	public boolean isSuitable(Party party) {
		return party.getRequirements().stream()
				.allMatch(r -> facilities.contains(r));
	}

}
