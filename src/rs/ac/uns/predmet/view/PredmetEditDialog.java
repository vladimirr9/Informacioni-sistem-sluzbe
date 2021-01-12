package rs.ac.uns.predmet.view;

import java.awt.BorderLayout;
import java.awt.Frame;

import javax.swing.JDialog;


public class PredmetEditDialog extends JDialog {

	public PredmetEditDialog(Frame parent, String title, boolean modal) {
		super(parent, title, modal);

		setSize(600, 300);
		setLocationRelativeTo(parent);
		setLayout(new BorderLayout());
		this.add(new PredmetEditTabbedPane());
		
	}
}
