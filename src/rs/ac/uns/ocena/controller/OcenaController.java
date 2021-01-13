package rs.ac.uns.ocena.controller;

import java.util.List;

import rs.ac.uns.ocena.model.BazaOcena;
import rs.ac.uns.ocena.model.Ocena;
import rs.ac.uns.predmet.model.Predmet;
import rs.ac.uns.student.model.Student;

public class OcenaController {
private static OcenaController instance = null;
	
	public static OcenaController getInstance() {
		if (instance == null) {
			instance = new OcenaController();
		}
		return instance;
	}
	
	private OcenaController() {}
	
	public void dodajOcenu(Ocena oc) {
		List<Ocena>lista;
		lista=BazaOcena.getInstance().getOcene();
		lista.add(oc);
		BazaOcena.getInstance().setOcene(lista);
	}
	
	public void removeOcena(Student student, Predmet p) {
		int i=0;
		for (Ocena oc : BazaOcena.getInstance().getOcene()) {
			if (oc.getPredmet().getSifra().equals(p.getSifra()) && oc.getStudent().getBrojIndeksa().equals(student.getBrojIndeksa())) { //kljuc je par student-predmet
				BazaOcena.getInstance().getOcene().remove(i);
				break;
			}
			++i;
		}
	}
	public void removeOcena(Student student) {
		int i=0;
		for (Ocena oc : BazaOcena.getInstance().getOcene()) {
			if (oc.getStudent().getBrojIndeksa().equals(student.getBrojIndeksa())) {
				BazaOcena.getInstance().getOcene().remove(i);
				break;
			}
			++i;
		}
	}
}
