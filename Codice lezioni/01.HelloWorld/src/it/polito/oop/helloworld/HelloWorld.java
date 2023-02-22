package it.polito.oop.helloworld;

public class HelloWorld {

	Object o;
	String s = "A";
	StringBuffer b = new StringBuffer();
	Integer i = 1;
	int j = 2;

	static int square(int x) {
		int squareResult = x * x;
		return squareResult;

	}

	static int factorial(int x) {
		int factorialResult = 1;
		for (int i = 1; i <= x; i++) {
			factorialResult = factorialResult * i;
		}
		return factorialResult;
	}

	public static void main(String[] args) {
		System.out.println(args[0] + " Today is sunny!");
		// per "tradurre una stringa in intero, segue:"
		int N;
		N = Integer.parseInt(args[1]);
		for (int i = 0; i < N; i++) {
			int res = square(i);
			System.out.print(res + " ");

		}

		/*
		 * Calcolo del fattoriale: System.out.println();
		 *
		 * System.out.println(factorial(Integer.parseInt(args[2])));
		 */

	}

}