package rs.ac.uns.abstractActions;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.JFrame;
import javax.swing.KeyStroke;

import rs.ac.uns.MainFrame;
import rs.ac.uns.student.view.StudentDialog;

public class EditAction extends AbstractAction {
	
	
	public EditAction() {
		putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_E, ActionEvent.CTRL_MASK));
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		/*if (MainFrame.tabbedPane.getSelectedIndex()==0) {
			StudentDialog studentDialog = new StudentDialog(parent, "Dodavanje studenta", true);
			studentDialog.setVisible(true);
		}*/
		
	}

}
