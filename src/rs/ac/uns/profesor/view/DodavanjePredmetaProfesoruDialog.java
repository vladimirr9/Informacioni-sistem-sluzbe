package rs.ac.uns.profesor.view;

import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import rs.ac.uns.MainFrame;
import rs.ac.uns.predmet.controller.PredmetController;
import rs.ac.uns.predmet.model.Predmet;
import rs.ac.uns.predmet.view.AbstractTableModelPredmeti;
import rs.ac.uns.profesor.controller.ProfesorController;
import rs.ac.uns.profesor.model.Profesor;

public class DodavanjePredmetaProfesoruDialog extends JDialog {

	public DodavanjePredmetaProfesoruDialog(Frame owner, String title, boolean modal,PredmetiZaProfesoraJTable tabela) {
		super(owner, title, modal);
		
		setSize(400, 400);
		setLocationRelativeTo(owner);
		
		GridBagLayout gb=new GridBagLayout();
		setLayout(gb);
		
		GridBagConstraints gbc=new GridBagConstraints(0, 0, 1, 1, 0, 0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(10, 10, 10, 0), 0, 0);
		JLabel predmeti=new JLabel("Predmeti:");
		this.add(predmeti,gbc);
		
		List<Predmet>predmetiSvi=PredmetController.getInstance().getPredmeti();
		int row=MainFrame.getInstance().getTabelaProfesora().convertRowIndexToModel(MainFrame.getInstance().getTabelaProfesora().getSelectedRow());
		List<Predmet>predmetiProfesora=ProfesorController.getInstance().getProfesor(row).getPredmeti();
		

		
		DefaultListModel<String> listaVal = new DefaultListModel<>();
		for(Predmet p:predmetiSvi) {
			Boolean b=true;
			
				if(p.getProfesor()!=null ) {
					b=false;
				}
		
			if(b) {
				String tekst=p.getSifra()+" - "+p.getNaziv();
				listaVal.addElement(tekst);
			}
		}
		
		
		JList list = new JList<>(listaVal);
        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane scroll = new JScrollPane(list);
        
       
        
         gbc=new GridBagConstraints(0, 1, 3, 1, 100,100, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(20, 20, 20, 20), 0, 0);
		this.add(scroll,gbc);
		
		JPanel jpanel=new JPanel();
	    gbc=new GridBagConstraints(0, 2, 1, 1, 100, 0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0);
	    this.add(jpanel,gbc);
		
		JButton potvrdi=new JButton("Potvrdi");
	    gbc=new GridBagConstraints(1, 2, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 10, 10), 0, 0);
	    this.add(potvrdi,gbc);
	    potvrdi.setEnabled(false);
	    
	    JButton odustani=new JButton("Odustani");
	    gbc=new GridBagConstraints(2, 2, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 10, 10), 0, 0);
	    this.add(odustani,gbc);
	    
 list.addListSelectionListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent e) {
				if(!list.isSelectionEmpty()) {
					potvrdi.setEnabled(true);
				} else {
					potvrdi.setEnabled(false);
				}
				
			}
		});
	    
	    potvrdi.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String selektovano=(String)list.getSelectedValue();
				String delovi[]=selektovano.split(" ");
				for(Predmet pp:predmetiSvi) {
					if(pp.getSifra().equals(delovi[0])) {
						Profesor p=ProfesorController.getInstance().getProfesor(row);
						List<Predmet>lista=p.getPredmeti();
						lista.add(pp);
						p.setPredmeti(lista);
						pp.setProfesor(p);
						AbstractTableModelPredmetiZaProfesora model=(AbstractTableModelPredmetiZaProfesora) tabela.getModel();
						model.fireTableDataChanged();
						validate();
						
						dispose();
						break;
					}
				}
				
			}
		});
	    
	    odustani.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				
			}
		});
	}
	
	
}
