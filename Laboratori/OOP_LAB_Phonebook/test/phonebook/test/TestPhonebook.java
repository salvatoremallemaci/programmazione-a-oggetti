package phonebook.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import phonebook.PhoneBook;

public class TestPhonebook {

	private PhoneBook rubrica;
	
	@Before
	public void setUp() {
		// FASE 1: SETUP si creano oggetti e si eseguono operazioni
		rubrica = new PhoneBook("Titolo");
		
		// ATTENZIONE ai side-effect, in particolare gli attributi 'static'
	}
	
	@Test
	public void test1() {
		// FASE 2: RISULTATI si ottengono dei risultati
		String titolo = rubrica.getName();
		
		// FASE 3: VERIFICA si verifica la corrispondenza dei risultati con le aspettative
		assertEquals("Titolo", // valore atteso
					 titolo);  // valore effettivo
	}

	@Test
	public void test2() {
		// FASE 1a: ... si eseguono operazioni
		
		rubrica.add("Lara", "Rossi", "333 444555666");
		
		
		// FASE 2: RISULTATI si ottengono dei risultati
		String primo = rubrica.first();
	
		
		
		// FASE 3: VERIFICA si verifica la corrispondenza dei risultati con le aspettative
		assertNotNull(primo);
		
		assertEquals("Lara Rossi 333 444555666",primo);
		//org.junit.ComparisonFailure: expected:<Lara Rossi[:] 333 444555666> but was:<Lara Rossi[] 333 444555666>



		
	}

}







