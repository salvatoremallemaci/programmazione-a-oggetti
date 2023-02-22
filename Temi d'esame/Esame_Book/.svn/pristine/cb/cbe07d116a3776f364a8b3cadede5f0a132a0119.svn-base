package it.polito.oop.books;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import static java.util.stream.Collectors.*;

public class TheoryChapter {

	private String titolo;
	private int numeroPagine;
	private String testo;
	private List<Topic> argomentiCapitolo;

	public TheoryChapter(String titolo, int numeroPagine, String testo) {
		super();
		this.titolo = titolo;
		this.numeroPagine = numeroPagine;
		this.testo = testo;
		this.argomentiCapitolo = new ArrayList<>();
	}

	public String getText() {
		return testo;
	}

	public void setText(String newText) {
		this.testo = newText;
	}

	public List<Topic> getTopics() {
		return argomentiCapitolo.stream()
				.distinct()
				.sorted(Comparator.comparing(Topic::getKeyword))
				.collect(toList());
	}

	public String getTitle() {
		return titolo;
	}

	public void setTitle(String newTitle) {
		this.titolo = newTitle;
	}

	public int getNumPages() {
		return numeroPagine;
	}

	public void setNumPages(int newPages) {
		this.numeroPagine = newPages;
	}

	public void addTopic(Topic topic) {
		this.argomentiCapitolo.add(topic);
			for (Topic t : topic.getSubTopics()) {
				argomentiCapitolo.add(t);
				addTopic(t);
			}
	}
}
