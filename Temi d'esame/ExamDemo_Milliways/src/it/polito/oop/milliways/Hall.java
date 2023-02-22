package it.polito.oop.milliways;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Hall {
	
	private int id;
	List<String> servizi = new ArrayList<>();

	public Hall(int id) {
		super();
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void addFacility(String facility) throws MilliwaysException {
		if(servizi.contains(facility))
			throw new MilliwaysException();
		servizi.add(facility);
	}

	public List<String> getFacilities() {
        Collections.sort(servizi);
        return servizi;
	}
	
	int getNumFacilities(){
        return servizi.size();
	}

	public boolean isSuitable(Party party) {
		return party.getRequirements().stream()
				.allMatch(r -> servizi.contains(r));
	}
	
	public Party gruppo (Party party) {
		return party;
	}

}
