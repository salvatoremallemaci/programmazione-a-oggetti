package orari;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

public class Percorso {
	private String codice;
	private String categoria;
	private boolean straordinario;
	
	private List<Fermata> fermate = new ArrayList<>();
	private SortedSet<Fermata> setFermate = new TreeSet<>(); // usa Comparable<>
	private SortedSet<Fermata> setFermate2 = // usa un comparator
			new TreeSet<>( Comparator.comparingInt(Fermata::getOre)
									 .thenComparingInt(Fermata::getMinuti));
	private List<Treno> treni = new ArrayList<>();
	
	
	Percorso(String codice, String categoria) {
		this.codice = codice;
		this.categoria = categoria;
		// controlli o codifica della categoria? NO: niente.
		// You Ain't Gonna Need It (YAGNI)
		this.straordinario = false;
	}

	public String getCodice() {
		return codice;
	}

	public String getCategoria() {
		return categoria;
	}

	public boolean isStraordinario() {
		return straordinario;
	}

	public void setStraordinario(boolean newValue) {
		straordinario = newValue;
	}

	public Fermata aggiungiFermata(String nomeStazione, int ore, int minuti) {
		Fermata f = new Fermata(nomeStazione,ore,minuti);
		fermate.add(f);
		return f;
	}

	public List<Treno> getTreni() {
		
		Comparator<Treno> cmp = Comparator.comparing(Treno::getAnno)
				.thenComparing(Treno::getMese)
				.thenComparing(Treno::getGiorno)
				.reversed();
		
		Collections.sort(treni);
		return treni;
	}

	public List<Fermata> getFermate() {
//		ArrayList<Fermata> ris = new ArrayList<>(fermate); // copia "difensiva"
//		Collections.sort(ris);
//		return ris;
		Collections.sort(fermate);  // se Fermata implements Comparable<>
		// Oppure con un comparatore:
		Collections.sort(fermate,
						Comparator.comparingInt(Fermata::getOre)
								 .thenComparingInt(Fermata::getMinuti));
		// oppure comparatore definito tramite una lambda
		Collections.sort(fermate, 
				(f1,f2) -> (f1.getOre()!=f2.getOre())?f1.getOre()-f2.getOre()
													 :f1.getMinuti()-f2.getMinuti()
				);
 		return Collections.unmodifiableList(fermate);
		// oppure utilizzando un SortedSet
		//return new ArrayList<>(setFermate);
	}

	public int ritardoMassimo() {
		return treni.stream()
				.mapToInt(Treno::ritardoFinale)
				.max().orElse(0)
				;
	}

	public int ritardoMedio() {
		return (int) treni.stream()
				.mapToInt(Treno::ritardoFinale)
				.average().orElse(0)
				;
	}

	void addTreno(Treno t) {
		treni.add(t);
	}

}

