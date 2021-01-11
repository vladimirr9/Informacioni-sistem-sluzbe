package rs.ac.uns.profesor.view;

import java.awt.Frame;

import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import rs.ac.uns.JTabbedPaneMine;

public class ProfesoriEditDialog extends JDialog {

	public ProfesoriEditDialog(Frame owner, String title, boolean modal) {
		super(owner, title, modal);
		
		setSize(400, 400);
		setLocationRelativeTo(owner);
		JTabbedPaneMine tabbedPane=new JTabbedPaneMine();
		ProfesoriInfoTab profesoriInfoTab=new ProfesoriInfoTab();
		tabbedPane.addTab("Info", profesoriInfoTab);
		JPanel predmeti=new JPanel();
		tabbedPane.addTab("Predmeti", predmeti);
		this.add(tabbedPane);
	}
	
}
