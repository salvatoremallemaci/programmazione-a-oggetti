package hydraulic;

/**
 * Represents the generic abstract element of an hydraulics system. It is the
 * base class for all elements.
 *
 * Any element can be connect to a downstream element using the method
 * {@link #connect(Element) connect()}.
 */
public class Element {

	private String nome;
	private Element eOutput;

	/**
	 * Constructor
	 * 
	 * @param name
	 *            the name of the element
	 */
	public Element(String name) {
		this.nome = name;
	}

	/**
	 * getter method
	 * 
	 * @return the name of the element
	 */
	public String getName() {
		return this.nome;
	}

	/**
	 * Connects this element to a given element. The given element will be connected
	 * downstream of this element
	 * 
	 * @param elem
	 *            the element that will be placed downstream
	 */
	public void connect(Element elem) {

		if (this instanceof Sink)
			return;
		eOutput = elem;
		this.eOutput = elem;

	}

	/**
	 * Retrieves the element connected downstream of this
	 * 
	 * @return downstream element
	 */
	public Element getOutput() {
		return this.eOutput;
	}

}
