package rs.ac.uns.profesor.view;

import java.awt.Frame;

import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import rs.ac.uns.JTabbedPaneMine;
import rs.ac.uns.MainFrame;

public class ProfesoriEditDialog extends JDialog {

	public ProfesoriEditDialog(Frame owner, String title, boolean modal) {
		super(owner, title, modal);
		
		int row = MainFrame.getInstance().getTabelaProfesora().convertRowIndexToModel(MainFrame.getInstance().getTabelaProfesora().getSelectedRow());
		
		setSize(400, 400);
		setLocationRelativeTo(owner);
		JTabbedPaneMine tabbedPane=new JTabbedPaneMine();
		ProfesoriInfoTab profesoriInfoTab=new ProfesoriInfoTab();
		tabbedPane.addTab("Info", profesoriInfoTab);
		ProfesoriPredmetiTab profesoriPredmetiTab=new ProfesoriPredmetiTab(row);
		tabbedPane.addTab("Predmeti", profesoriPredmetiTab);
		this.add(tabbedPane);
	}
	
}
