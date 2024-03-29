package rs.ac.uns.student.view;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import rs.ac.uns.MainFrame;
import rs.ac.uns.ocena.view.OcenaJTable;
import rs.ac.uns.student.controller.StudentController;
import rs.ac.uns.student.model.BazaStudent;
import rs.ac.uns.student.model.Student;

public class PolozeniTab extends JPanel {

	private static JButton ponistiO;
	private static JLabel prosekL;
	private static JLabel espbL;
	
	
	
	public PolozeniTab(int row, StudentEditTabbedPane parent)
	{
		
		GridBagLayout gb=new GridBagLayout();
		setLayout(gb);
		
		Student student = BazaStudent.getInstance().getRow(row);
		
		OcenaJTable tabOcena = OcenaJTable.getInstance();
		JScrollPane sPane = new JScrollPane(tabOcena);
		
		
		
		GridBagConstraints gbc=new GridBagConstraints(0, 0, 1, 1, 0, 0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 30, 0, 0), 0, 0);
		ponistiO = new JButton("Poništi ocenu");
		this.add(ponistiO,gbc);
		
		
		gbc=new GridBagConstraints(0, 1, 1, 1, 100, 0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(30, 30, 10, 30), 0, 0);

		this.add(sPane,gbc);
		
		
		float prosek = BazaStudent.getInstance().getProsek(student);
		String prosekTxt = String.format("Prosečna ocena: %.2f", prosek);
		prosekL = new JLabel(prosekTxt);
		gbc=new GridBagConstraints(0, 2, 3, 1, 100, 0, GridBagConstraints.EAST, GridBagConstraints.NONE, new Insets(0, 0, 0, 10), 0, 0);
		this.add(prosekL,gbc);
		
		int espb = BazaStudent.getInstance().getESPB(student.getBrojIndeksa());
		String espbTxt = String.format("Ukupno ESPB: %d", espb);
		espbL = new JLabel(espbTxt);
		gbc=new GridBagConstraints(0, 3, 3, 1, 100, 0, GridBagConstraints.EAST, GridBagConstraints.NONE, new Insets(0, 0, 0, 10), 0, 0);
		this.add(espbL,gbc);
		
		
		ponistiO.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (tabOcena.getSelectedRow() != -1)
				{
					Student s = BazaStudent.getInstance().findStudentByRow(row);
					 
					int reply=JOptionPane.showOptionDialog(tabOcena, 
					        "Da li ste sigurni da želite da poništite ocenu?", 
					        "Poništavanje ocene", 
					        JOptionPane.OK_CANCEL_OPTION, 
					        JOptionPane.INFORMATION_MESSAGE, 
					        null, 
					        new String[]{"Da", "Ne"}, 
					        "default");
					if(reply==JOptionPane.YES_OPTION) {
						StudentController.getInstance().ponistiOcenu(student.getBrojIndeksa(), parent.getNepolozeniJTable());
						updateLabele(s);
						validate();
							
						}
				}
				
			}
		});
		
		
		
		
	}
	
	public static void updateLabele(Student s) {

		
		float prosek = BazaStudent.getInstance().getProsek(s); 
		
		
		
																														
		String prosekTxt = String.format("Prosečna ocena: %.2f", prosek);
		prosekL.setText(prosekTxt);
		
		int espb = BazaStudent.getInstance().getESPB(s.getBrojIndeksa());
																												
		String espbTxt = String.format("Ukupno ESPB: %d", espb);
		espbL.setText(espbTxt);
	}
	
}



