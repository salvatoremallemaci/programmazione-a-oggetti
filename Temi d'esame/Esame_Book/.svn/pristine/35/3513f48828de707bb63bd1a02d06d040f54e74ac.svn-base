package it.polito.oop.books;

import java.util.List;


public class Assignment {
	
	private String ID;
	private ExerciseChapter capitoloEsercizi;
	double punteggioTotale = 0;

    public Assignment(String iD, ExerciseChapter capitoloEsercizi) {
		super();
		this.ID = iD;
		this.capitoloEsercizi = capitoloEsercizi;
	}

	public String getID() {
        return ID;
    }

    public ExerciseChapter getChapter() {
        return capitoloEsercizi;
    }

    public double addResponse(Question q,List<String> answers) {
    	
    	int N = (int) q.numAnswers();
    	int FP = 0;
    	int FN = 0;
    	
    	for (String a : answers) {
    		if(!q.getCorrectAnswers().contains(a))
    			FP++;
    	}
    	
    	for (String a : q.getCorrectAnswers()) {
    		if(!answers.contains(a))
    			FN++;
    	}
    	
    	double punteggio = (double) (N - FP - FN) / N;
    	
    	punteggioTotale += punteggio;
    	
        return punteggio;
    }
    
    public double totalScore() {
        return punteggioTotale;
    }

}
