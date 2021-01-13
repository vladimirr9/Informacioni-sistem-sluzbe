package rs.ac.uns.abstractActions;

import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.Locale;

import javax.swing.AbstractAction;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;
import javax.swing.SwingUtilities;

import rs.ac.uns.MainFrame;
import rs.ac.uns.predmet.controller.PredmetController;
import rs.ac.uns.predmet.model.Predmet;
import rs.ac.uns.profesor.controller.ProfesorController;
import rs.ac.uns.profesor.model.Profesor;
import rs.ac.uns.profesor.view.ProfesoriEditDialog;
import rs.ac.uns.student.controller.StudentController;
import rs.ac.uns.student.model.Student;

public class DeleteAction extends AbstractAction {
	private final JFrame parent;
	
public DeleteAction(final JFrame parent) {
	this.parent=parent;
	putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_D, ActionEvent.CTRL_MASK));
}
	@Override
	public void actionPerformed(ActionEvent e) {
		if (MainFrame.tabbedPane.getSelectedIndex()==2 && MainFrame.getInstance().getTabelaPredmeta().getSelectedRow()!=-1) {
			int reply=JOptionPane.showOptionDialog(parent, 
			        "Da li ste sigurni da želite da obrišete predmet?", 
			        "Brisanje predmeta", 
			        JOptionPane.OK_CANCEL_OPTION, 
			        JOptionPane.INFORMATION_MESSAGE, 
			        null, 
			        new String[]{"Da", "Ne"}, 
			        "default");
			if(reply==JOptionPane.YES_OPTION) {
				int row=MainFrame.getInstance().getTabelaPredmeta().convertRowIndexToModel(MainFrame.getInstance().getTabelaPredmeta().getSelectedRow());
				Predmet p=PredmetController.getInstance().getPredmet(row);
				PredmetController.getInstance().izbrisiPredmet(p);
				MainFrame.getInstance().azurirajPrikazPredmeta("Brisanje predmeta", -1);
			}
		}
		else if (MainFrame.tabbedPane.getSelectedIndex()==0 && MainFrame.getInstance().getTabelaStudent().getSelectedRow()!=-1) {
			int reply=JOptionPane.showOptionDialog(parent, 
			        "Da li ste sigurni da želite da obrišete studenta?", 
			        "Brisanje studenta", 
			        JOptionPane.OK_CANCEL_OPTION, 
			        JOptionPane.INFORMATION_MESSAGE, 
			        null, 
			        new String[]{"Da", "Ne"}, 
			        "default");
			if(reply==JOptionPane.YES_OPTION) {
				int row=MainFrame.getInstance().getTabelaStudent().convertRowIndexToModel(MainFrame.getInstance().getTabelaStudent().getSelectedRow());
				Student s=StudentController.getInstance().getStudent(row);
				StudentController.getInstance().izbrisiStudent(s);
				MainFrame.getInstance().azurirajPrikazStudenta("Brisanje Studenta", -1);
			}
		} else if (MainFrame.tabbedPane.getSelectedIndex()==1 && MainFrame.getInstance().getTabelaProfesora().getSelectedRow()!=-1) {
			int reply=JOptionPane.showOptionDialog(parent, 
			        "Da li ste sigurni da želite da obrišete profesora?", 
			        "Brisanje profesora", 
			        JOptionPane.OK_CANCEL_OPTION, 
			        JOptionPane.INFORMATION_MESSAGE, 
			        null, 
			        new String[]{"Da", "Ne"}, 
			        "default");
			if(reply==JOptionPane.YES_OPTION) {
				int row=MainFrame.getInstance().getTabelaProfesora().convertRowIndexToModel(MainFrame.getInstance().getTabelaProfesora().getSelectedRow());
				Profesor p=ProfesorController.getInstance().getProfesor(row);
				ProfesorController.getInstance().izbrisiProfesor(p);
				MainFrame.getInstance().azurirajPrikazProfesora("Brisanje Profesora", -1);
			}
		}
		
	}
	
}
