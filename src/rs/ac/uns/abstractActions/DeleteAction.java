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
import rs.ac.uns.profesor.view.ProfesoriEditDialog;

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
				int row=MainFrame.getInstance().getTabelaPredmeta().getSelectedRow();
				Predmet p=PredmetController.getInstance().getPredmet(row);
				System.out.println(p.getSifra());
				PredmetController.getInstance().izbrisiPredmet(p);
				MainFrame.getInstance().azurirajPrikazPredmeta("Brisanje predmeta", -1);
			}
		}
		
	}
	
}
