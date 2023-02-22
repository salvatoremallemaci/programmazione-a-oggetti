package hydraulic;

import java.util.Arrays;

/**
 * Main class that act as a container of the elements for the simulation of an
 * hydraulics system
 * 
 */
public class HSystem {

	private static final int MAX_ELEMENTI = 100;
	private static final int COST_ZERO = 0;

	private int counter = 0;

	private Element magazzino[] = new Element[MAX_ELEMENTI];
	private Element sistema[] = new Element[COST_ZERO];

	/**
	 * Adds a new element to the system
	 * 
	 * @param elem
	 */
	public void addElement(Element elem) {
		magazzino[counter++] = elem;
	}

	/**
	 * returns the element added so far to the system. If no element is present in
	 * the system an empty array (length==0) is returned.
	 * 
	 * @return an array of the elements added to the hydraulic system
	 */
	public Element[] getElements() {

		sistema = Arrays.copyOf(magazzino, counter);
		return sistema;
	}

	// /**
	// * Prints the layout of the system starting at each Source
	// */
	// public String layout() {
	// // TODO: to be implemented
	// return null;
	// }
	//

	/**
	 * starts the simulation of the system
	 */
	public void simulate(SimulationObserver observer) {

	}

}
