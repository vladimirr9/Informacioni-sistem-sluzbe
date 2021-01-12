package rs.ac.uns.predmet.view;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import rs.ac.uns.student.view.InformacijeTab;



public class PredmetEditTabbedPane extends JTabbedPane {
	
	
	public PredmetEditTabbedPane() {
	JPanel informacije = new JPanel();
	
	//setSize(600, 300);
	informacije.setLayout(new BorderLayout());
	this.add(informacije, "Informacije");
	informacije.add(new PredmetInformacijeTab());
	}
}
