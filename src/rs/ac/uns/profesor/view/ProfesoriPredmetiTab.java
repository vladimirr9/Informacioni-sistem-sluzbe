package rs.ac.uns.profesor.view;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import rs.ac.uns.MainFrame;
import rs.ac.uns.profesor.controller.ProfesorController;
import rs.ac.uns.profesor.model.Profesor;

public class ProfesoriPredmetiTab extends JPanel{
	
	
	
	
	public ProfesoriPredmetiTab() {
		super();
		
		GridBagLayout gb=new GridBagLayout();
		setLayout(gb);
		
		PredmetiZaProfesoraJTable predmetiZaProfesoraJTable=new PredmetiZaProfesoraJTable();
		
		GridBagConstraints gbc=new GridBagConstraints(0, 0, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(10, 10, 10, 0), 0, 0);
		JButton dodajPredmet=new JButton("Dodaj predmet");
		this.add(dodajPredmet,gbc);
		
		gbc=new GridBagConstraints(1, 0, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0);
		JButton ukloniPredmet=new JButton("Ukloni predmet");
		this.add(ukloniPredmet,gbc);
		
		gbc=new GridBagConstraints(0, 1, 2, 1, 100, 100, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0);
		JScrollPane scrollPane = new JScrollPane(predmetiZaProfesoraJTable);
		this.add(scrollPane,gbc);
	}
	
	
}
