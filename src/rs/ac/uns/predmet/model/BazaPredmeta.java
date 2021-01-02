package rs.ac.uns.predmet.model;


import java.util.ArrayList;
import java.util.List;





public class BazaPredmeta {
	private static BazaPredmeta instance = null;

	public static BazaPredmeta getInstance() {
		if (instance == null) {
			instance = new BazaPredmeta();
		}
		return instance;
	}


	private List<Predmet> predmeti;
	private List<String> kolone;

	private BazaPredmeta() {
	
	
		initPredmete();

		this.kolone = new ArrayList<String>();
		this.kolone.add("Šifra predmeta");
		this.kolone.add("Naziv predmeta");
		this.kolone.add("Broj ESPB bodova");
		this.kolone.add("Godina na kojoj se predmet izvodi");
		this.kolone.add("Semestar u kome se predmet izvodi");

	}

	private void initPredmete() {
		this.predmeti = new ArrayList<Predmet>();
		
			predmeti.add(new Predmet("E214", "PJISP", PredmetSemestar.ZIMSKI, PredmetGodina.PRVA,9));
			predmeti.add(new Predmet("E2N", "LPRS", PredmetSemestar.ZIMSKI, PredmetGodina.DRUGA,5));
			predmeti.add(new Predmet("E4JN", "SAU", PredmetSemestar.LETNJI, PredmetGodina.DRUGA,8));
	
	}

	public List<Predmet> getPredmeti() {
		return predmeti;
	}

	public void setPredmeti(List<Predmet> predmeti) {
		this.predmeti = predmeti;
	}

	public int getColumnCount() {
		return 5;
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
			return String.valueOf(predmet.getBodovi());
		case 3:
			return String.valueOf(predmet.getGodina().getBrojGodine());
		case 4:
			return predmet.getSemestar().toString();
		default:
			return null;
		}
	}
}
