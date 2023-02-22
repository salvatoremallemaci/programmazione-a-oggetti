package it.polito.oop.books;

import java.util.HashSet;
import java.util.Set;

public class Question {

	private String domanda;
	private Topic argomentoPrincipale;
	private long numRisposte = 0;
	private Set<String> risposteCorrette;
	private Set<String> risposteErrate;
	
	public Question(String domanda, Topic argomentoPrincipale) {
		super();
		this.domanda = domanda;
		this.argomentoPrincipale = argomentoPrincipale;
		this.risposteCorrette = new HashSet<>();
		this.risposteErrate = new HashSet<>();
	}

	public String getQuestion() {
		return domanda;
	}

	public Topic getMainTopic() {
		return argomentoPrincipale;
	}

	public void addAnswer(String answer, boolean correct) {
		if(correct)
			this.risposteCorrette.add(answer);
		if(!correct)
			this.risposteErrate.add(answer);
	}

	@Override
	public String toString() {
		return this.domanda + " (" + this.getMainTopic() + ")";
	}

	public long numAnswers() {
		numRisposte = this.risposteCorrette.size() + this.risposteErrate.size();
		return numRisposte;
	}

	public Set<String> getCorrectAnswers() {
		return this.risposteCorrette;
	}

	public Set<String> getIncorrectAnswers() {
		return this.risposteErrate;
	}
}
