package it.polito.oop.arrayExamples;

import java.util.Arrays;
//import java.util.Comparator;
/* Poichè il metodo Arrays.qualcosa appartiene ad una altra classe, 
è necessario importarla. */

public class ArrayExamples {

	public static void main(String[] args) {
		{
			int[] array1 = { 1, 2 };
			int[] array2 = { 1, 2 };
			// Si confrontano i riferimenti,sono due OGGETTI DIVERSI --> false
			System.out.println(array1 == array2);
			// Così confronto i valori dei dui array.
			System.out.println(Arrays.equals(array1, array2));

			// Stesso concetto per array di caratteri.
			char[] arrayChar1 = { 'c', 'i', 'a', 'o' };
			char[] arrayChar2 = { 'c', 'i', 'a', 'o' };
			System.out.println(arrayChar1 == arrayChar2);
			System.out.println(Arrays.equals(arrayChar1, arrayChar2));
		}
		// Se divido in "blocchi"-> SCOPE , posso ridefinire roba con nomi che ho già
		// ho usato, GARBAGE COLLECTOR
		{
			int[] internalArray1 = { 1, 2 };
			int[] internalArray2 = { 1, 2 };
			int[][] array1 = { internalArray1, internalArray2 };
			int[][] array2 = { internalArray2, internalArray1 };
			// Si confrontano i riferimenti,sono due OGGETTI DIVERSI --> false
			// Stesso concetto per matrici
			System.out.println(array1 == array2);
			// L'ordine è diverso --> sono due OGGETTI dal contenuto DIVERSO.
			System.out.println(Arrays.equals(array1, array2));
			// Così invece li confronto indipendentemente dall'ordine dei contenuti.
			System.out.println(Arrays.deepEquals(array1, array2));
		}
		{
			// Ridefinisco la lunghezza della stringa, creandone delle copie
			// nel caso di aggiunta in lunghezza, campi null.
			String[] array = { "cinque", "sei", "sette", "otto" };
			String[] a = Arrays.copyOf(array, array.length);
			String[] b = Arrays.copyOf(array, array.length + 10);
			String[] c = Arrays.copyOf(array, array.length - 2);

			String temp = "";

			for (String stringa : a)
				temp += stringa + ",";
			System.out.println(temp);

			temp = "";
			for (String stringa : b)
				temp += stringa + ",";
			System.out.println(temp);

			temp = "";
			for (String stringa : c)
				temp += stringa + ",";
			System.out.println(temp);

			System.out.println(Arrays.equals(array, a));
		}
		{

			String[] a = { "quattro", "sei", "tre", "cinque", "dieci" };
			System.out.println("Array iniziale:" + Arrays.toString(a));
			Arrays.sort(a);
			System.out.println("Array ordinato:" + Arrays.toString(a));

			// Implementa interfaccia(?), Comparator con sorting in base ai numeri
			// Per farlo, dai un'occhiata all'SVN.

		}
		{
			String[] a = { "quattro", "sei", "tre", "cinque", "dieci" };
			System.out.println("Array iniziale:" + Arrays.toString(a));
			Arrays.sort(a);
			System.out.println("Array iniziale:" + Arrays.toString(a));
			int index1 = Arrays.binarySearch(a, "cinque");
			int index2 = Arrays.binarySearch(a, "tre");
			System.out.println("Ricerca cinque :" + index1);
			System.out.println("Ricerca tre :" + index2);
			
		}

	}

}
