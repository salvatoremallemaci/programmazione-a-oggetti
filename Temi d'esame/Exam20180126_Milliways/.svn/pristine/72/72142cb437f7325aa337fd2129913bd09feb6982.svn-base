package it.polito.oop.milliways;

import static java.util.Comparator.*;
import static java.util.stream.Collectors.*;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Restaurant {

	private List<Hall> halls = new LinkedList<>();
	private List<Party> seatedParty = new LinkedList<>();
	private Map<String,Race> races = new HashMap<>();
	
	private Map<Integer,Hall> hallsm = new HashMap<>();
	
    public Restaurant() {
	}
	
	public Race defineRace(String name) throws MilliwaysException{
		if(races.containsKey(name))
			throw new MilliwaysException();
		Race r = new Race(name);
		races.put(name,r);
	    return r;
	}
	
	public Party createParty() {
	    return new Party();
	}
	
	public Hall defineHall(int id) throws MilliwaysException{
		if(hallsm.containsKey(id))
			throw new MilliwaysException();
		
		Hall hall = new Hall(id);
		hallsm.put(id, hall);
		halls.add(hall);
	    return hall;
	}

	public List<Hall> getHallList() {
		return halls;
	}

	public Hall seat(Party party, Hall hall) throws MilliwaysException {
        if(!hall.isSuitable(party))
        	throw new MilliwaysException();
        
        seatedParty.add(party);
        return hall;
	}

	public Hall seat(Party party) throws MilliwaysException {
        for(Hall hall : halls)
        	if(hall.isSuitable(party))
        		return seat(party,hall);
        
        throw new MilliwaysException();
	}

	// seatedParty: p1,p2,p3
	// flatMap -> Party.getComposition
	// <R1,2>,<R2,5>||<R1,3>,<R3,5>||<R2,3>,<R4,6>
	// <R1,[<R1,2>,<R1,3>],....
	// <R1,5>,<R2,8>,<R3,5>,<R4,6>
	public Map<Race, Integer> statComposition() {
        return seatedParty.stream()
        		.flatMap(e -> e.getComposition().entrySet().stream())
        		.collect(groupingBy(
        					Map.Entry::getKey,
        					summingInt(Map.Entry::getValue)
        				))
        		;
	}

	public List<String> statFacility() {
        return halls.stream()
        		.flatMap(f -> f.getFacilities().stream())
        		.collect(groupingBy(
        							x->x,
        							counting()
        							)
        				)
        		// Map: facility -> numero di saloni in cui è disponibile
        		.entrySet().stream()
        		.sorted(
        					comparing(Map.Entry<String,Long>::getValue,reverseOrder())
        					.thenComparing(Map.Entry::getKey)
        				)
        		.map(Map.Entry::getKey)
        		.collect(toList());
        		
	}
	
	public Map<Integer,List<Integer>> statHalls() {
//        return halls.stream()
//        		.sorted(comparingInt(Hall::getId))
//        		.collect(groupingBy(
//        							Hall::getNumFacilities,
//        							TreeMap::new,
//        							mapping(Hall::getId,toList())
//        				));
		
        return halls.stream()
        		.collect(groupingBy(
								Hall::getNumFacilities,
								TreeMap::new,        				
								mapping(Hall::getId,
										collectingAndThen(toList(),
												l->{
														Collections.sort(l);
														return l;
												}
												))
								));
		
	}

}
