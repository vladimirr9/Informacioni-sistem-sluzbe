package rs.ac.uns.student.view;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import rs.ac.uns.MainFrame;
import rs.ac.uns.ocena.model.Ocena;
import rs.ac.uns.predmet.model.BazaPredmeta;
import rs.ac.uns.predmet.model.Predmet;
import rs.ac.uns.predmet.model.PredmetGodina;
import rs.ac.uns.student.model.BazaStudent;
import rs.ac.uns.student.model.GodinaStudiranja;
import rs.ac.uns.student.model.Student;

public class DodavanjePredmetaStudentu extends JDialog {

	
	List<Predmet> predmetiZaDodavanje;
	private static Student s;
	
	
	public DodavanjePredmetaStudentu(NepolozeniTab parent, String brojIndeksa) {
		
		
		super();
		setSize(400,500);
		setLocationRelativeTo(parent);
		
		s = BazaStudent.getInstance().getStudentByIndeks(brojIndeksa);
		GridBagLayout gb=new GridBagLayout();
		setLayout(gb);
		GridBagConstraints gbc;
		setModal(true);
		setTitle("Dodavanje predmeta");
		DefaultListModel<String> lista = new DefaultListModel<>(); 
		ArrayList<Predmet> polozeniPredmeti = getPredmeti(s, s.getPolozeniIspiti());
		predmetiZaDodavanje =new ArrayList<Predmet>(BazaPredmeta.getInstance().getPredmeti());
		int index=0;
		ArrayList<Predmet> tmpList=new ArrayList<Predmet>(predmetiZaDodavanje);
		
	
		for (Predmet p:tmpList) {
			if (GodinaStudiranja.getGodinaStudiranja(s.getTrenutnaGodinaStudija())<PredmetGodina.getPredmetGodina(p.getGodina())) {
				predmetiZaDodavanje.remove(index);
				index--;
			}
			index++;
		}

		for (int i = 0; i < s.getNepolozeniIspiti().size(); i++) {
			for (int j = 0; j < predmetiZaDodavanje.size(); j++) {
				if (predmetiZaDodavanje.get(j).getSifra().equals(s.getNepolozeniIspiti().get(i).getSifra())) {
					predmetiZaDodavanje.remove(j);
				}
			}
		}

		for (int i=0;i<polozeniPredmeti.size();i++) {
			for (int j=0;j<predmetiZaDodavanje.size();j++) {
				if (polozeniPredmeti.get(i).getSifra().equalsIgnoreCase(predmetiZaDodavanje.get(j).getSifra())) {
					predmetiZaDodavanje.remove(j);
				}
			}
		}
		for (Predmet p : predmetiZaDodavanje)
			System.out.println(p.getNaziv());
		
		for (Predmet p:predmetiZaDodavanje) {
			String naziv=p.getSifra()+"-"+p.getNaziv();
			lista.addElement(naziv);
		}
		JList<String> list=new JList<>(lista);
		JScrollPane scrollP=new JScrollPane(list);
		
		gbc=new GridBagConstraints(0, 0, 2, 1, 100, 100, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(30, 20, 40, 20), 0, 0);
		this.add(scrollP,gbc);
		
		
		
		
		JButton btnDodaj=new JButton("Dodaj");
		gbc=new GridBagConstraints(0, 1, 1, 1, 0, 0, GridBagConstraints.EAST, GridBagConstraints.NONE, new Insets(5, 100, 20, 0), 0, 0);
		this.add(btnDodaj,gbc);
		
		JButton btnOdustani=new JButton("Odustani");
		gbc=new GridBagConstraints(1, 1, 1, 1, 0, 0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(5, 30, 20, 0), 0, 0);
		this.add(btnOdustani,gbc);
		
		
		btnDodaj.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				Predmet p=predmetiZaDodavanje.get(list.getSelectedIndex());
				predmetiZaDodavanje.remove(list.getSelectedIndex());
				s.getNepolozeniIspiti().add(p);
				parent.getNepolozeniJTable().azuriraj();
				validate();
				dispose();
			}
		});
		
		
		
		
		
		
		btnOdustani.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				
			}
			
		});
		
		
		
		
	
	}
	private ArrayList<Predmet> getPredmeti(Student s, List<Ocena> ocene) {
		ArrayList<Predmet> predmeti = new ArrayList<Predmet>(); 
		for (Ocena o : ocene) {
			if (o.getStudent().getBrojIndeksa().equals(s.getBrojIndeksa())) {
				predmeti.add(o.getPredmet());
			}
		}
		return predmeti;
	}
}
