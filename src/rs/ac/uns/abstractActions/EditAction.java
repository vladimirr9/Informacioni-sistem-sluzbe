package rs.ac.uns.abstractActions;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.JFrame;
import javax.swing.KeyStroke;

import rs.ac.uns.MainFrame;
import rs.ac.uns.predmet.view.PredmetEditDialog;
import rs.ac.uns.profesor.view.ProfesoriEditDialog;
import rs.ac.uns.student.view.StudentDialog;
import rs.ac.uns.student.view.StudentEditDialog;

public class EditAction extends AbstractAction {
	
	private final JFrame parent;
	
	public EditAction(final JFrame parent) {
		this.parent=parent;
		putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_E, ActionEvent.CTRL_MASK));
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if (MainFrame.tabbedPane.getSelectedIndex()==1 && MainFrame.getInstance().getTabelaProfesora().getSelectedRow()!=-1) {
			ProfesoriEditDialog profesoriEditDialog=new ProfesoriEditDialog(parent, "Izmeni profesora", true);
			profesoriEditDialog.setVisible(true);
		}
		else if (MainFrame.tabbedPane.getSelectedIndex()==0 && MainFrame.getInstance().getTabelaStudent().getSelectedRow()!=-1) {
			StudentEditDialog studentEditDialog = new StudentEditDialog(parent, "Izmena studenta", true);
			studentEditDialog.setVisible(true);
		}
		if (MainFrame.tabbedPane.getSelectedIndex()==2 && MainFrame.getInstance().getTabelaPredmeta().getSelectedRow() != -1) {
			PredmetEditDialog predmetEditDialog = new PredmetEditDialog(parent, "Izmena predmeta", true);
			predmetEditDialog.setVisible(true);
		}
		
	}

}
