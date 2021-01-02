package rs.ac.uns.predmet.model;

import java.util.List;

import rs.ac.uns.profesor.model.Profesor;
import rs.ac.uns.student.model.Student;

public class Predmet {
	
	private String sifra;
	private String naziv;
	private PredmetSemestar semestar;
	private PredmetGodina godina;
	private Profesor profesor;
	private int bodovi;
	List<Student>polozili;
	List<Student>nisuPolozili;
	
	public Predmet() {
		super();
		
	}

	public Predmet(String sifra, String naziv, PredmetSemestar semestar, PredmetGodina godina, Profesor profesor, int bodovi,
			List<Student> polozili, List<Student> nisuPolozili) {
		super();
		this.sifra = sifra;
		this.naziv = naziv;
		this.semestar = semestar;
		this.godina = godina;
		this.profesor = profesor;
		this.bodovi = bodovi;
		this.polozili = polozili;
		this.nisuPolozili = nisuPolozili;
	}
	
	

	public Predmet(String sifra, String naziv, PredmetSemestar semestar, PredmetGodina godina, int bodovi) {
		super();
		this.sifra = sifra;
		this.naziv = naziv;
		this.semestar = semestar;
		this.godina = godina;
		this.bodovi = bodovi;
	}

	public String getSifra() {
		return sifra;
	}

	public void setSifra(String sifra) {
		this.sifra = sifra;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public PredmetSemestar getSemestar() {
		return semestar;
	}

	public void setSemestar(PredmetSemestar semestar) {
		this.semestar = semestar;
	}

	public PredmetGodina getGodina() {
		return godina;
	}

	public void setGodina(PredmetGodina godina) {
		this.godina = godina;
	}

	public Profesor getProfesor() {
		return profesor;
	}

	public void setProfesor(Profesor profesor) {
		this.profesor = profesor;
	}

	public int getBodovi() {
		return bodovi;
	}

	public void setBodovi(int bodovi) {
		this.bodovi = bodovi;
	}

	public List<Student> getPolozili() {
		return polozili;
	}

	public void setPolozili(List<Student> polozili) {
		this.polozili = polozili;
	}

	public List<Student> getNisuPolozili() {
		return nisuPolozili;
	}

	public void setNisuPolozili(List<Student> nisuPolozili) {
		this.nisuPolozili = nisuPolozili;
	}
	
	
}
