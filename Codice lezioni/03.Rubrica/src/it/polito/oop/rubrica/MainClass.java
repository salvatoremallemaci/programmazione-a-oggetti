package it.polito.oop.rubrica;

/*
Singolarmente farei cos�:
import it.polito.oop.rubrica.classi.Rubrica;
import it.polito.oop.rubrica.classi.Voce;
*/
//Includo tutte le classi del package in questione:
import it.polito.oop.rubrica.classi.*;

public class MainClass {

	public static void main(String[] args) {

		/*
		 * Sono riferimenti,"simili" ai puntatori. Crea un nuovo OGGETTO voce (come se
		 * lo allocassi )
		 */

		Voce a = new Voce("Leonardo", "Regano", "01234567");
		Rubrica r = new Rubrica("la mia rubrica");
		r.aggiungi("Esmeralda", "Calabr�", "034839");
		r.aggiungi("Giovanni", "Sabihi", "1498349");
		r.aggiungi("Riccardo", "Martino", "23789");
		r.aggiungi("Silvia", "Perdichizzi", "3456789");
		r.aggiungi("Romeo", "Gatto", "130123456789");
		System.out.println(r.primo());
		System.out.println(r.voce(3));
		System.out.println(r.voce(4));
		System.out.println(r.elenco());
		System.out.println(r.ricerca("Gatto"));
	}

}
