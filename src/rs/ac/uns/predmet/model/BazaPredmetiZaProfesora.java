package rs.ac.uns.predmet.model;

import java.util.ArrayList;
import java.util.List;

import rs.ac.uns.profesor.model.Profesor;

public class BazaPredmetiZaProfesora {
	
	private List<Predmet> predmeti;
	private List<String> kolone;

	public BazaPredmetiZaProfesora(Profesor p) {
	
	
		this.predmeti=p.getPredmeti();

		this.kolone = new ArrayList<String>();
		this.kolone.add("Šifra");
		this.kolone.add("Naziv");
		this.kolone.add("Godina studija");
		this.kolone.add("Semestar");
		

	}


	public List<Predmet> getPredmeti() {
		return predmeti;
	}

	public void setPredmeti(List<Predmet> predmeti) {
		this.predmeti = predmeti;
	}

	public int getColumnCount() {
		return 4;
	}

	public String getColumnName(int index) {
		return this.kolone.get(index);
	}

	public Predmet getRow(int rowIndex) {
		return this.predmeti.get(rowIndex);
	}

	public String getValueAt(int row, int column) {
		Predmet predmet = this.predmeti.get(row);
		switch (column) {
		case 0:
			return predmet.getSifra();
		case 1:
			return predmet.getNaziv();
		case 2:
			return String.valueOf(predmet.getGodina().getBrojGodine());
		case 3:
			return predmet.getSemestar().toString();
		default:
			return null;
		}
	}
	
	public void dodajPredmet(String sifra, String naziv, PredmetSemestar semestar, PredmetGodina godina, int bodovi) {
		this.predmeti.add(new Predmet(sifra, naziv, semestar, godina, bodovi));
	}
	
	public void obrisiPredmet(Predmet p) {
		for(Predmet pp:this.predmeti) {
			if(pp.equals(p)) {
				this.predmeti.remove(pp);
				break;
			}
		}
	}
}


