package rs.ac.uns.student.view;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class StudentEditTabbedPane extends JTabbedPane {
	

	
	
	public StudentEditTabbedPane() {
		JPanel informacije = new JPanel();
		JPanel polozeni = new JPanel();
		JPanel nepolozeni = new JPanel();

		informacije.setLayout(new BorderLayout());
		this.add(informacije, "Informacije");
		informacije.add(new InformacijeTab());

		polozeni.setLayout(new BorderLayout());
		this.add(polozeni, "Položeni");
		//polozeni.add(new PolozeniTab());
		
		NepolozeniTab nepolozeniTab=new NepolozeniTab();
		nepolozeni.setLayout(new BorderLayout());
		this.add(nepolozeniTab, "Nepoloženi");
		//nepolozeni.add(new NepolozeniTab());
		
		//this.setBorder(BorderFactory.createEmptyBorder(20, 0, 10, 0));
	}
	

}
