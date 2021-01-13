package rs.ac.uns.student.controller;

import java.util.Date;
import java.util.List;

import rs.ac.uns.MainFrame;
import rs.ac.uns.ocena.controller.OcenaController;
import rs.ac.uns.ocena.model.BazaOcena;
import rs.ac.uns.ocena.model.Ocena;
import rs.ac.uns.ocena.view.OcenaJTable;
import rs.ac.uns.predmet.controller.PredmetController;
import rs.ac.uns.predmet.model.BazaPredmeta;
import rs.ac.uns.predmet.model.Predmet;
import rs.ac.uns.student.model.BazaStudent;
import rs.ac.uns.student.model.GodinaStudiranja;
import rs.ac.uns.student.model.Student;
import rs.ac.uns.student.model.StudentStatus;
import rs.ac.uns.student.view.NepolozeniJTable;

public class StudentController {

private static StudentController instance = null;
	
	public static StudentController getInstance() {
		if (instance == null) {
			instance = new StudentController();
		}
		return instance;
	}
	private StudentController() {}
	
	public void dodajStudenta(String prezime, String ime, Date datumRodjenja, String adresaStanovanja, String kontaktTelefon,
	String emailAdresa, String brojIndeksa, int godinaUpisa, GodinaStudiranja trenutnaGodinaStudija, StudentStatus status) {
		BazaStudent.getInstance().dodajStudenta(prezime, ime, datumRodjenja, adresaStanovanja, kontaktTelefon,
				emailAdresa, brojIndeksa, godinaUpisa, trenutnaGodinaStudija, status);
		MainFrame.getInstance().azurirajPrikazStudenta("DODAT", -1);
	}
	public void editStudent(String prezime, String ime, Date datumRodjenja, String adresaStanovanja, String kontaktTelefon,
			String emailAdresa, String brojIndeksa, int godinaUpisa, GodinaStudiranja trenutnaGodinaStudija, StudentStatus status, int row) {
		
		Student student = BazaStudent.getInstance().getRow(row);
		student.setIme(ime);
		student.setPrezime(prezime);
		student.setDatumRodjenja(datumRodjenja);
		student.setAdresaStanovanja(adresaStanovanja);
		student.setKontaktTelefon(kontaktTelefon);
		student.setEmailAdresa(emailAdresa);
		student.setBrojIndeksa(brojIndeksa);
		student.setGodinaUpisa(godinaUpisa);
		student.setTrenutnaGodinaStudija(trenutnaGodinaStudija);
		student.setS(status);
		MainFrame.getInstance().azurirajPrikazStudenta("Izmena Studenta", -1);
		
	}
	
	public void ponistiOcenu(String brojIndeksa, NepolozeniJTable nt) {
		Student student=BazaStudent.getInstance().getStudentByIndeks(brojIndeksa);
		int indeksPredmeta=OcenaJTable.getInstance().convertRowIndexToModel(OcenaJTable.getInstance().getSelectedRow());
		Predmet pred=student.getPolozeniIspiti().get(indeksPredmeta).getPredmet();
		student.getPolozeniIspiti().remove(indeksPredmeta); 
		student.getNepolozeniIspiti().add(pred);
		OcenaController.getInstance().removeOcena(student,pred);
		student.setProsecnaOcena((BazaStudent.getInstance().getProsek(student)));
		nt.azuriraj();
		MainFrame.getInstance().azurirajPrikazOcene("Azuriranje ocena", -1);
	}
	
	public List<Student> getStudenti(){
		return BazaStudent.getInstance().getStudenti();
	}
	public Student getStudent(int rowIndex) {
		return BazaStudent.getInstance().getRow(rowIndex);
	}
	public void izbrisiStudent(Student s) {
		for (Predmet p : PredmetController.getInstance().getPredmeti()) {
			if (p != null)
			{
				if (p.getPolozili() != null)
					for (Student s1 : p.getPolozili()) {
						if (s1.equals(s))
							p.getPolozili().remove(s);
					}
				if (p.getNisuPolozili() != null)
					for (Student s1 : p.getNisuPolozili()) {
						if (s1.equals(s))
							p.getNisuPolozili().remove(s);
					}
			}
			BazaStudent.getInstance().obrisiStudent(s);
			
			
	}
	}
}
