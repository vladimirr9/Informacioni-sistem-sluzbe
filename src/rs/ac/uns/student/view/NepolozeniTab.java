package rs.ac.uns.student.view;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class NepolozeniTab extends JPanel {

	public NepolozeniTab() {
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
		JTable nepolozeniJTable=new NepolozeniJTable();
		JScrollPane scrollPane = new JScrollPane(nepolozeniJTable);
		this.add(scrollPane,gbc);
	}
	
}