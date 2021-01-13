package rs.ac.uns.profesor.controller;

import java.util.Date;
import java.util.List;

import rs.ac.uns.MainFrame;
import rs.ac.uns.predmet.controller.PredmetController;
import rs.ac.uns.predmet.model.Predmet;
import rs.ac.uns.profesor.model.BazaProfesora;
import rs.ac.uns.profesor.model.Profesor;
import rs.ac.uns.profesor.model.ProfesorTitula;
import rs.ac.uns.profesor.model.ProfesorZvanje;
import rs.ac.uns.profesor.view.PredmetiZaProfesoraJTable;
import rs.ac.uns.student.model.BazaStudent;
import rs.ac.uns.student.model.Student;

public class ProfesorController {
private static ProfesorController instance = null;
	
	public static ProfesorController getInstance() {
		if (instance == null) {
			instance = new ProfesorController();
		}
		return instance;
	}
	
	private ProfesorController() {}
	
	public void dodajProfesora(String prezime, String ime, Date datumRodjenja, String adresaStanovanja, String kontaktTelefon,
			String emailAdresa, String adresaKancelarije, String brojLicneKarte, ProfesorTitula titula,
			ProfesorZvanje zvanje) {
		BazaProfesora.getInstance().dodajProfesora(ime, prezime, datumRodjenja,adresaStanovanja,kontaktTelefon,emailAdresa,adresaKancelarije,brojLicneKarte,titula, zvanje);
		MainFrame.getInstance().azurirajPrikazProfesora("DODAT", -1);
	}
	
	public List<Profesor> getProfesori(){
		return BazaProfesora.getInstance().getProfesori();
	}
	
	public Profesor getProfesor(int rowIndex) {
		return BazaProfesora.getInstance().getRow(rowIndex);
	}
	public void izbrisiProfesor(Profesor p) {
		for (Predmet pr : PredmetController.getInstance().getPredmeti()) {
			if (pr.getProfesor() == p) {
				pr.setProfesor(null);
			}
		}
		BazaProfesora.getInstance().obrisiProfesora(p);
	}
	
	
	public void ukloniPredmet(String brojLicne, PredmetiZaProfesoraJTable table) {
		int row=table.convertRowIndexToModel(table.getSelectedRow());
		Profesor profesor=BazaProfesora.getInstance().getProfByLicna(brojLicne);
		profesor.getPredmeti().get(row).setProfesor(null);
		profesor.getPredmeti().remove(row);
		
		table.azuriraj();
	}
}
