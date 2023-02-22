import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import phonebook.PhoneBook;

public class InterfacciaUtente {

	public static void main(String[] args) {
		
		// 1. CLI - Command Line Interface
		// 2. Text-bases UI
		// 3. GUI
		//		- AWT (Abstract Window Toolkit) 
		//		- Swing (JFC)
		//		- JavaFX
		// 4. WebUI
		
		// **Framework swing** / JavaFX
		
		// VIEW
		JFrame finestra = new JFrame();
		// titolo
		finestra.setTitle("Esempio di finestra");
		
		// dimensioni
		finestra.setSize(600,600); // pixel
		
		// terminazione
		finestra.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		JLabel eNome = new JLabel("Nome: ");
		JTextField nome = new JTextField(20);
		
		JLabel eCognome = new JLabel("Cognome: ");
		JTextField cognome = new JTextField(20);
		
		JLabel eTel = new JLabel("Telefono: ");
		JTextField tel = new JTextField(20);
		
		JButton inserisci = new JButton("Inserisci");
		
		JTextArea contenuto = new JTextArea(30,20);
		
		finestra.setLayout(new FlowLayout());
		
		finestra.add(eNome);
		finestra.add(nome);
		finestra.add(eCognome);
		finestra.add(cognome);
		finestra.add(eTel);
		finestra.add(tel);
		finestra.add(inserisci);
		finestra.add(contenuto);

		
		finestra.setVisible(true);
		

		// MODELLO
		
		PhoneBook rubrica = new PhoneBook("esempio");
		
		
		ExecutorService esecutore = Executors.newCachedThreadPool();
		// Controller
		
		inserisci.addActionListener( (ActionEvent e) -> {
			System.out.println("Cliccato sul pulsante!");
			esecutore.submit(()->{
				String valoreNome = nome.getText(); // quanto scritto nel text-field nome
				String valoreCognome = cognome.getText();
				String valoreTel = tel.getText();
				
				try {
					Thread.sleep(15000);
				} catch (InterruptedException e1) {
					// ignoro...
				}
				rubrica.add(valoreNome, valoreCognome, valoreTel);
				
				contenuto.setText( rubrica.toString() );
			});
			//System.out.println(rubrica.toString());
		});
		
		
	}

}
