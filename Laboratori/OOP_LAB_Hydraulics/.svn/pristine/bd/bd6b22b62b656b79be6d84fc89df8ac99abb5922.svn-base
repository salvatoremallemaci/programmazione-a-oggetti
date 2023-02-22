package hydraulic;

/**
 * Represents a split element, a.k.a. T element
 * 
 * During the simulation each downstream element will receive a stream that is
 * half the input stream of the split.
 */

public class Split extends Element {

	private static final int N_FLUSSI = 2;
	private Element flusso[] = new Element[N_FLUSSI];

	/**
	 * Constructor
	 * 
	 * @param name
	 */
	public Split(String name) {
		super(name);
		// TODO: complete
	}

	/**
	 * returns the downstream elements
	 * 
	 * @return array containing the two downstream element
	 */
	public Element[] getOutputs() {
		return flusso;
	}

	public String toString() {

		String nomePezzo = this.getName() + " : ";

		return nomePezzo + "Uscita 0 = " + flusso[0].getName() + " Uscita 1 = " + " " + flusso[1].getName() + "\n";
	}

	/**
	 * connect one of the outputs of this split to a downstream component.
	 * 
	 * @param elem
	 *            the element to be connected downstream
	 * @param noutput
	 *            the output number to be used to connect the element
	 */
	public void connect(Element elem, int noutput) {

		if (noutput == 0)
			flusso[noutput] = elem;
		else if (noutput == 1)
			flusso[noutput] = elem;
		else {
			System.out.println("Num di output errato.");
			return;
		}
	}
}
