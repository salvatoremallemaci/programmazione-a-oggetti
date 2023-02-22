package it.polito.po.fileexamples;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FileExamples {
	
	private static final int EOF = -1;
	
	public static void main(String[] args) throws IOException
	{
		{
//	//		try {
//				Reader r = new FileReader("input.txt");
//	//		} catch (FileNotFoundException e) {
//	//			System.err.println("File input.txt not found!");
//	//		}
//			
//			//LEGGI TUTTO IL FILE UN CARATTERE ALLA VOLTA
//			while(true) {
//				int ch = r.read();
//	//			r.skip(2); // per saltare caratteri
//				if(ch == EOF)
//					break;
//				char carattere = (char)ch;
//				System.out.print(carattere);
//	//			System.out.println(ch+"->"+carattere);
//			}
//			r.close();
		}
		
		{
			//LEGGI TUTTO IL FILE CON UN BUFFER DI 16 CARATTERI
//			Reader r = new FileReader("input.txt");
//			char[] buffer = new char[16];
//			
//			while(true) {
//				
//				int readChars = r.read(buffer);
//				if(readChars == EOF)
//					break;
//				String s = new String(buffer,0,readChars);
//				System.out.println(s);
//				System.out.println("read chars: "+readChars);
//			}
//			
//			r.close();
		}
		
		{
			//LEGGI TUTTO IL FILE CON UN BUFFEREDREADER, UNA RIGA ALLA VOLTA
//			Reader r = new FileReader("input.txt");
//			BufferedReader br = new BufferedReader(r);
//			BufferedReader br = new BufferedReader(new FileReader("input.txt"));
//			
//			String line;
//			int i = 1;
//			while((line = br.readLine()) != null)
//			{
////				System.out.println(line);
//				System.out.println("Riga "+i+": "+line.length()+" chars");
//				i++;
//			}
//			br.close();
		}
		
		{
			//LEGGI TUTTO IL FILE CON UN BUFFEREDREADER, UNA RIGA ALLA VOLTA
			//VERSIONE CON STREAM
//			BufferedReader br = new BufferedReader(new FileReader("input.txt"));
////			br.lines().filter(l -> l.length()>0).forEach(System.out::println); //stampo solo righe non vuote
//			br.lines().forEach(line -> System.out.println(line.length()+" chars"));
//			br.close();
		}
		
		{
			//LEGGI TUTTO IL FILE CON UN BUFFEREDREADER, UNA RIGA ALLA VOLTA
			//VERSIONE CON STREAM
			//RISULTATO: LISTA DELLE PAROLE
			BufferedReader br = new BufferedReader(new FileReader("input.txt"));
//			br.lines().forEach(System.out::println);
			// split(" "): "parola1 parola2 parola3" -> ["parola1","parola2","parola3"]
			List<String> parole = br.lines().flatMap(line -> Arrays.stream(line.split(" ")))
									.collect(Collectors.toList());
			// line.split: String -> String[]
			// map(line.split): Stream<String> -> Stream<String[]>
			// flatMap(line -> Arrays.stream(line.split(" "))): Stream<String> -> Stream<String>
				// 1) line.split: Stream<String> -> Stream<String[]>
				// 2) Arrays.stream: Stream<String[]> -> Stream<Stream<String>>
				// 3) flatMap: Stream<Stream<String>> -> Stream<String>
			parole.stream().forEach(System.out::println);
//			br.close();
		}
		
		{
			//SCRITTURA SU FILE
//			String line = "ciao";
////			Writer w = new FileWriter("output.txt"); //SE OUTPUT.TXT ESISTE SOVRASCRIVE
////			Writer w = new FileWriter("output.txt",false); //SE OUTPUT.TXT ESISTE SOVRASCRIVE
//			Writer w = new FileWriter("output.txt",true); //SE OUTPUT.TXT ESISTE SCRIVE ALLA FINE DEL FILE
//			w.write(line+"\n");
//			w.write(line+"\n");
//			w.close();
			
//			CREARE FILE VUOTO (SE ESISTE LO SOVRASCRIVE)
//			w = new FileWriter("output.txt");
//			w.write("");
//			w.close();
		}
		
		{
			//LEGGO INPUT.TXT E SCRIVO LE RIGHE NON VUOTE IN OUTPUT.TXT
//			BufferedReader br = new BufferedReader(new FileReader("input.txt"));
//			Writer w = new FileWriter("output.txt");
//			br.lines().filter(l -> l.length()>0)
//					  .forEach(l -> {
//						try {
//							w.write(l+"\n");
//						} catch (IOException e) {
//							// TODO Auto-generated catch block
//							e.printStackTrace();
//						}
//					});
//			w.close();
		}
		
		{
			Writer w = new FileWriter("output.txt");
			for(int j=0;j<5;j++)
			{
				for(int i=0;i<1000;i++)
					w.write("\n");
				w.flush();
				BufferedReader br = new BufferedReader(new FileReader("output.txt"));
				System.out.println("File lines: "+br.lines().count());
				br.close();
			}
			w.close();
		}
	}
	
}
