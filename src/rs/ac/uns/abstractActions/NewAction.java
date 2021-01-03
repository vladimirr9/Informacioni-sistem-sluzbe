package rs.ac.uns.abstractActions;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.JFrame;
import javax.swing.KeyStroke;

import rs.ac.uns.MainFrame;
import rs.ac.uns.predmet.view.PredmetDialog;
import rs.ac.uns.profesor.view.ProfesoriDialog;
import rs.ac.uns.student.view.StudentDialog;

public class NewAction extends AbstractAction{
	
	private final JFrame parent;
	
	public NewAction(final JFrame parent) {
		this.parent=parent;
		putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(MainFrame.tabbedPane.getSelectedIndex()==1) {
			ProfesoriDialog profesoriDialog=new ProfesoriDialog(parent, "Dodavanje profesora", true);
			profesoriDialog.setVisible(true);
		}
		else if (MainFrame.tabbedPane.getSelectedIndex()==0) {
			StudentDialog studentDialog = new StudentDialog(parent, "Dodavanje studenta", true);
			studentDialog.setVisible(true);
		}
		else if (MainFrame.tabbedPane.getSelectedIndex()==2) {
			PredmetDialog predmetDialog = new PredmetDialog(parent, "Dodavanje predmeta", true);
			predmetDialog.setVisible(true);
		}
	}
 
}
