package it.polito.oop.milliways;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.*;

public class Party {

	private Map<Race, Integer> composition = new HashMap<>();
	
    public Map<Race, Integer> getComposition() {
		return composition;
	}

	public void addCompanions(Race race, int num) {
    	int oldNum = 0;
    	if(composition.containsKey(race))
    		oldNum = composition.get(race);
    	composition.put(race,oldNum+num);
	}

	public int getNum() {
        return composition.values().stream().mapToInt(i->i).sum();
	}

	public int getNum(Race race) {
		if(composition.containsKey(race))
			return composition.get(race);
		else
			return 0;
	}

	public List<String> getRequirements() {
        return composition.keySet().stream()
        		.flatMap(r -> r.getRequirements().stream())
        		.distinct()
        		.sorted()
        		.collect(toList());
	}

    public Map<String,Integer> getDescription(){
        return composition.entrySet().stream()
        		.collect(toMap(e->e.getKey().getName(),
        						e->e.getValue()));
    }

}
