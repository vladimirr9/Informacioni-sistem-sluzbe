package rs.ac.uns.student.controller;

import java.util.Date;
import java.util.List;

import rs.ac.uns.MainFrame;
import rs.ac.uns.ocena.model.Ocena;
import rs.ac.uns.student.model.BazaStudent;
import rs.ac.uns.student.model.GodinaStudiranja;
import rs.ac.uns.student.model.StudentStatus;

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
	String emailAdresa, String brojIndeksa, String godinaUpisa, GodinaStudiranja trenutnaGodinaStudija, StudentStatus status,
	float prosecnaOcena, List<Ocena> polozeniIspiti, List<String> nepolozeniIspiti) {
		BazaStudent.getInstance().dodajStudenta(prezime, ime, datumRodjenja, adresaStanovanja, kontaktTelefon,
				emailAdresa, brojIndeksa, godinaUpisa, trenutnaGodinaStudija, status, prosecnaOcena,
				polozeniIspiti, nepolozeniIspiti);
		MainFrame.getInstance().azurirajPrikazStudenta("DODAT", -1);
	}
}
