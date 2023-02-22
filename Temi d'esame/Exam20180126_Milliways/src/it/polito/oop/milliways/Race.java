package it.polito.oop.milliways;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Race {
    
	private String name;
	private Set<String> requirements = new TreeSet<>();
	
	
	Race(String name)
	{
		this.name = name;
	}
	
	public void addRequirement(String requirement)
			throws MilliwaysException {
		if(requirements.contains(requirement))
			throw new MilliwaysException();
		requirements.add(requirement);
	}
	
	public List<String> getRequirements() {
        return new ArrayList<>(requirements);
	}
	
	public String getName() {
        return name;
	}
}
