package rs.ac.uns.profesor.view;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import rs.ac.uns.MainFrame;
import rs.ac.uns.profesor.controller.ProfesorController;
import rs.ac.uns.profesor.model.BazaProfesora;
import rs.ac.uns.profesor.model.Profesor;
import rs.ac.uns.student.controller.StudentController;
import rs.ac.uns.student.model.BazaStudent;
import rs.ac.uns.student.model.Student;

public class ProfesoriPredmetiTab extends JPanel{
	
	
	private PredmetiZaProfesoraJTable predmetiZaProfesoraJTable;
	
	public ProfesoriPredmetiTab(int row) {
		super();
		
		GridBagLayout gb=new GridBagLayout();
		setLayout(gb);
		
		predmetiZaProfesoraJTable=new PredmetiZaProfesoraJTable();
		
		GridBagConstraints gbc=new GridBagConstraints(0, 0, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(10, 10, 10, 0), 0, 0);
		JButton dodajPredmet=new JButton("Dodaj predmet");
		this.add(dodajPredmet,gbc);
		
		gbc=new GridBagConstraints(1, 0, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0);
		JButton ukloniPredmet=new JButton("Ukloni predmet");
		this.add(ukloniPredmet,gbc);
		
		gbc=new GridBagConstraints(0, 1, 2, 1, 100, 100, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0);
		JScrollPane scrollPane = new JScrollPane(predmetiZaProfesoraJTable);
		this.add(scrollPane,gbc);
		
		JFrame jf=(JFrame) this.getParent();
		dodajPredmet.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				DodavanjePredmetaProfesoruDialog dodavanjePredmetaProfesoruDialog=new DodavanjePredmetaProfesoruDialog(jf, "Dodaj predmet", true,predmetiZaProfesoraJTable);
				dodavanjePredmetaProfesoruDialog.setVisible(true);
			}
		});
		ukloniPredmet.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (predmetiZaProfesoraJTable.getSelectedRow() != -1)
				{
					int reply=JOptionPane.showOptionDialog(null, 
					        "Da li ste sigurni?", 
					        "Ukloni Predmet", 
					        JOptionPane.OK_CANCEL_OPTION, 
					        JOptionPane.INFORMATION_MESSAGE, 
					        null, 
					        new String[]{"Potvrdi", "Odustani"}, 
					        "default");
					if(reply==JOptionPane.YES_OPTION) {
						ProfesorController.getInstance().ukloniPredmet(BazaProfesora.getInstance().getRow(row).getBrojLicneKarte(), predmetiZaProfesoraJTable);
							
						}
				}
				
			}
		});
	}
	
	
}
