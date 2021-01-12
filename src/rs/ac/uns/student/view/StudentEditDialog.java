package rs.ac.uns.student.view;

import java.awt.BorderLayout;
import java.awt.Frame;

import javax.swing.JDialog;

public class StudentEditDialog extends JDialog {

	
	
	public StudentEditDialog(Frame parent, String title, boolean modal) {
		super(parent, title, modal);

		setSize(600, 600);
		setLocationRelativeTo(parent);
		setLayout(new BorderLayout());
		this.add(new StudentEditTabbedPane());
		
	}
}
