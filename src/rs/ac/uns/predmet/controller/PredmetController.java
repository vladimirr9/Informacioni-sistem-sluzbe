package rs.ac.uns.predmet.controller;

import java.util.List;

import rs.ac.uns.MainFrame;
import rs.ac.uns.predmet.model.BazaPredmeta;
import rs.ac.uns.predmet.model.Predmet;
import rs.ac.uns.predmet.model.PredmetGodina;
import rs.ac.uns.predmet.model.PredmetSemestar;
import rs.ac.uns.profesor.model.BazaProfesora;
import rs.ac.uns.profesor.model.Profesor;

public class PredmetController {
	
	

private static PredmetController instance = null;
	
	
	public static PredmetController getInstance() {
		if (instance == null) {
			instance = new PredmetController();
		}
		return instance;
	}
	
	private PredmetController() {}
	
	public void dodajPredmet(String sifra, String naziv, PredmetSemestar semestar, PredmetGodina godina, int bodovi) {
		
		BazaPredmeta.getInstance().dodajPredmet(sifra, naziv, semestar, godina, bodovi);
		MainFrame.getInstance().azurirajPrikazPredmeta("DODAT", -1);
	}
	
	public List<Predmet> getPredmeti() {
		return BazaPredmeta.getInstance().getPredmeti();
	}
	
	public Predmet getPredmet(int rowIndex) {
		return BazaPredmeta.getInstance().getRow(rowIndex);
	}
	
	public void izbrisiPredmet(Predmet p) {
		BazaPredmeta.getInstance().obrisiPredmet(p);
	}
	public void editPredmet(String sifra, String naziv, PredmetSemestar semestar, PredmetGodina godina, int bodovi, int row)
	{
		
		Predmet predmet = BazaPredmeta.getInstance().getRow(row);
		predmet.setSifra(sifra);
		predmet.setNaziv(naziv);
		predmet.setSemestar(semestar);
		predmet.setGodina(godina);
		predmet.setBodovi(bodovi);
		MainFrame.getInstance().azurirajPrikazPredmeta("Izmena Predmeta", -1);
		
	}
	
}
