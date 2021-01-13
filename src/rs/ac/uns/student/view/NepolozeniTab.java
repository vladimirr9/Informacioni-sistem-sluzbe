package rs.ac.uns.student.view;

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
import javax.swing.JTable;

import rs.ac.uns.MainFrame;
import rs.ac.uns.student.model.BazaStudent;
import rs.ac.uns.student.model.Student;

public class NepolozeniTab extends JPanel {
	
	private NepolozeniTab nt = this;
	private NepolozeniJTable nepolozeniJTable;

	public NepolozeniTab(int row, StudentEditTabbedPane parent) {
		super();
		
		GridBagLayout gb=new GridBagLayout();
		setLayout(gb);
		
		GridBagConstraints gbc=new GridBagConstraints(0, 0, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 30, 0, 0), 0, 0);
		JButton dodaj=new JButton("Dodaj");
		this.add(dodaj,gbc);
		
		gbc=new GridBagConstraints(1, 0, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 10, 0, 0), 0, 0);
		JButton obrisi=new JButton("Obriši");
		this.add(obrisi,gbc);
		
		gbc=new GridBagConstraints(2, 0, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 10, 0, 0), 0, 0);
		JButton polaganje=new JButton("Polaganje");
		this.add(polaganje,gbc);
		
		gbc=new GridBagConstraints(3, 0, 3, 1, 100, 0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0);
		JPanel jpanel=new JPanel();
		this.add(jpanel,gbc);
		
		gbc=new GridBagConstraints(0, 1, 6, 6, 100, 0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(30, 30, 0, 30), 0, 0);
		nepolozeniJTable= parent.getNepolozeniJTable();
		JScrollPane scrollPane = new JScrollPane(nepolozeniJTable);
		this.add(scrollPane,gbc);
		
		
		
		
		dodaj.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				DodavanjePredmetaStudentu dps = new DodavanjePredmetaStudentu(nt, BazaStudent.getInstance().findStudentByRow(row).getBrojIndeksa());
				dps.setVisible(true);
			}
		});
		obrisi.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (nepolozeniJTable.getSelectedRow() != -1)
				{
					Student s = BazaStudent.getInstance().findStudentByRow(row);
					int reply=JOptionPane.showOptionDialog(nt, 
					        "Da li ste sigurni da želite da uklonite predmet?", 
					        "Uklanjanje predmeta", 
					        JOptionPane.OK_CANCEL_OPTION, 
					        JOptionPane.INFORMATION_MESSAGE, 
					        null, 
					        new String[]{"Da", "Ne"}, 
					        "default");
					if(reply==JOptionPane.YES_OPTION) {
						BazaStudent.getInstance().ukloniPredmet(s.getBrojIndeksa(), nt.getNepolozeniJTable());
						//validate();
						
						}
					
					//upd.setVisible(true);
				}
				
			}
		});
		JFrame jf=(JFrame) this.getParent();
polaganje.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(nepolozeniJTable.getSelectedRow()!=-1) {
					PolaganjeDialog polaganjeDialog=new PolaganjeDialog(jf, "Unos ocene", true,BazaStudent.getInstance().findStudentByRow(row),nt);
					polaganjeDialog.setVisible(true);
				}
				
			}
		});
	}

	public NepolozeniJTable getNepolozeniJTable() {
		return nepolozeniJTable;
	}
	
	
	
}
