package rs.ac.uns.student.view;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import java.awt.Insets;

import rs.ac.uns.MainFrame;
import rs.ac.uns.ocena.view.OcenaJTable;
import rs.ac.uns.student.model.BazaStudent;
import rs.ac.uns.student.model.Student;

public class PolozeniTab extends JPanel {

	private static JButton ponistiO;
	private static JLabel prosekL;
	private static JLabel espbL;
	
	
	
	public PolozeniTab(int row)
	{
		
		GridBagLayout gb=new GridBagLayout();
		setLayout(gb);
		
		Student student = BazaStudent.getInstance().getRow(row);
		
		OcenaJTable tabOcena = OcenaJTable.getInstance();
		JScrollPane sPane = new JScrollPane(tabOcena);
		
		
		
		GridBagConstraints gbc=new GridBagConstraints(0, 0, 1, 1, 0, 0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 30, 0, 0), 0, 0);
		ponistiO = new JButton("Poništi ocenu");
		this.add(ponistiO,gbc);
		
		
		gbc=new GridBagConstraints(0, 1, 1, 1, 100, 0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(30, 30, 0, 30), 0, 0);

		this.add(sPane,gbc);
		
		
		float prosek = BazaStudent.getInstance().getProsek(student.getBrojIndeksa());
		String prosekTxt = String.format("Prosečna ocena: %.2f", prosek);
		prosekL = new JLabel(prosekTxt);
		gbc=new GridBagConstraints(0, 2, 3, 1, 100, 0, GridBagConstraints.EAST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0);
		this.add(prosekL,gbc);
		
		int espb = BazaStudent.getInstance().getESPB(student.getBrojIndeksa());
		String espbTxt = String.format("Ukupno ESPB: %d", espb);
		espbL = new JLabel(espbTxt);
		gbc=new GridBagConstraints(0, 3, 3, 1, 100, 0, GridBagConstraints.EAST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0);
		this.add(espbL,gbc);
		
		
		
	}
}
