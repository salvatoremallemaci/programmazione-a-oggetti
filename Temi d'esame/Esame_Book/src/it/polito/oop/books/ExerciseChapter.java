package it.polito.oop.books;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import static java.util.stream.Collectors.*;

public class ExerciseChapter {

	private String titolo;
	private int numPagine;
	private List<Question> domandeEsercizio;
	private List<Topic> argomentiDomandeEsercizio;

	public ExerciseChapter(String titolo, int numPagine) {
		super();
		this.titolo = titolo;
		this.numPagine = numPagine;
		this.domandeEsercizio = new ArrayList<>();
		this.argomentiDomandeEsercizio = new ArrayList<>();
	}

	public List<Topic> getTopics() {
		return argomentiDomandeEsercizio.stream()
				.distinct()
				.sorted(Comparator.comparing(Topic::getKeyword))
				.collect(toList());
	};

	public String getTitle() {
		return titolo;
	}

	public void setTitle(String newTitle) {
		this.titolo = newTitle;
	}

	public int getNumPages() {
		return numPagine;
	}

	public void setNumPages(int newPages) {
		this.numPagine = newPages;
	}

	public void addQuestion(Question question) {
		this.domandeEsercizio.add(question);
		this.argomentiDomandeEsercizio.add(question.getMainTopic());
	}
}
