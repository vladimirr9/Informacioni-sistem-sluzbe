package rs.ac.uns.student.view;

import javax.swing.JDialog;
import javax.swing.JOptionPane;

import rs.ac.uns.MainFrame;
import rs.ac.uns.predmet.controller.PredmetController;
import rs.ac.uns.predmet.model.Predmet;
import rs.ac.uns.student.model.BazaStudent;
import rs.ac.uns.student.model.Student;

public class UklanjanjePredmetaDialog extends JDialog {
	
	public UklanjanjePredmetaDialog(NepolozeniTab parent, Student s)
	{
	
	
	if (parent.getNepolozeniJTable().getSelectedRow() !=-1) {
		int reply=JOptionPane.showOptionDialog(parent, 
		        "Da li ste sigurni da želite da uklonite predmet?", 
		        "Uklanjanje predmeta", 
		        JOptionPane.OK_CANCEL_OPTION, 
		        JOptionPane.INFORMATION_MESSAGE, 
		        null, 
		        new String[]{"Da", "Ne"}, 
		        "default");
		if(reply==JOptionPane.YES_OPTION) {
			BazaStudent.getInstance().ukloniPredmet(s.getBrojIndeksa(), parent.getNepolozeniJTable());
			//validate();
			
		}
	}
	}

}
