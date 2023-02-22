package it.polito.oop.books;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Topic {

	private String parolaChiave;
	private List<Topic> sottoArgomenti;

	public Topic(String parolaChiave) {
		super();
		this.parolaChiave = parolaChiave;
		this.sottoArgomenti = new ArrayList<>();
	}

	public String getKeyword() {
		return parolaChiave;
	}

	@Override
	public String toString() {
		return parolaChiave;
	}

	public boolean addSubTopic(Topic topic) {
		if(this.sottoArgomenti.contains(topic))
			return false;
		this.sottoArgomenti.add(topic);
		return true;
	}

	/*
	 * Returns a sorted list of subtopics. Topics in the list *MAY* be modified
	 * without affecting any of the Book topic.
	 */
	public List<Topic> getSubTopics() {
		List<Topic> sottoArgomentiPerNome = new ArrayList<>(this.sottoArgomenti);
		Collections.sort(sottoArgomentiPerNome,
				Comparator.comparing(Topic::getKeyword)
				);
		return sottoArgomentiPerNome;
	}
}
