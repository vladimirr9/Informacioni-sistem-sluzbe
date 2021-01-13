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
		/*
			predmeti.add(new Predmet("E214", "PJISP", PredmetSemestar.ZIMSKI, PredmetGodina.PRVA,9));
			predmeti.add(new Predmet("E2N", "LPRS", PredmetSemestar.ZIMSKI, PredmetGodina.DRUGA,5));
			predmeti.add(new Predmet("E4JN", "SAU", PredmetSemestar.LETNJI, PredmetGodina.DRUGA,8));
	*/
	/*	predmeti.add(new Predmet("p1", "osnove programiranja", PredmetSemestar.ZIMSKI, PredmetGodina.PRVA,7));
		predmeti.add(new Predmet("p2", "statistika", PredmetSemestar.LETNJI, PredmetGodina.TRECA,8));
		predmeti.add(new Predmet("p3", "algoritmi i strukture podataka", PredmetSemestar.LETNJI, PredmetGodina.DRUGA,9));
		predmeti.add(new Predmet("p4", "LPRS", PredmetSemestar.ZIMSKI, PredmetGodina.TRECA,7));
		predmeti.add(new Predmet("p5", "matematika", PredmetSemestar.LETNJI, PredmetGodina.PRVA,11));
		predmeti.add(new Predmet("p6", "xml i web servisi", PredmetSemestar.LETNJI, PredmetGodina.CETVRTA,6));
		predmeti.add(new Predmet("p7", "Metode optimizacije", PredmetSemestar.ZIMSKI, PredmetGodina.TRECA,6));
		predmeti.add(new Predmet("p8", "osnove elektrotehnike", PredmetSemestar.LETNJI, PredmetGodina.PRVA,11));
		predmeti.add(new Predmet("p9", "Sociologija", PredmetSemestar.ZIMSKI, PredmetGodina.PRVA,10));
		predmeti.add(new Predmet("p10", "Filozofija", PredmetSemestar.ZIMSKI, PredmetGodina.PRVA,4));
		predmeti.add(new Predmet("p11", "ORT", PredmetSemestar.LETNJI, PredmetGodina.DRUGA,7));
		predmeti.add(new Predmet("p12", "NANS", PredmetSemestar.LETNJI, PredmetGodina.DRUGA,5));
		predmeti.add(new Predmet("p13", "Organizacija podataka", PredmetSemestar.ZIMSKI, PredmetGodina.DRUGA,7));
		predmeti.add(new Predmet("p14", "Baze podataka", PredmetSemestar.ZIMSKI, PredmetGodina.DRUGA,6));
		predmeti.add(new Predmet("p15", "paralelno programiranje", PredmetSemestar.ZIMSKI, PredmetGodina.DRUGA,8));
		predmeti.add(new Predmet("p16", "konkurentno programiranje", PredmetSemestar.LETNJI, PredmetGodina.DRUGA,9));
		predmeti.add(new Predmet("p17", "Operativni sistemi", PredmetSemestar.LETNJI, PredmetGodina.DRUGA,8));
		predmeti.add(new Predmet("p18", "Algebra", PredmetSemestar.ZIMSKI, PredmetGodina.PRVA,15));
		predmeti.add(new Predmet("p19", "Verovatnoca", PredmetSemestar.LETNJI, PredmetGodina.TRECA,14));
		predmeti.add(new Predmet("ps20", "Upravljacki sistemi", PredmetSemestar.LETNJI, PredmetGodina.TRECA,8));
		predmeti.add(new Predmet("ps21", "Osnovi elektronike", PredmetSemestar.ZIMSKI, PredmetGodina.DRUGA,7));
		predmeti.add(new Predmet("ps22", "Slucajni procesi", PredmetSemestar.LETNJI, PredmetGodina.CETVRTA,9));
		predmeti.add(new Predmet("ps23", "Racunarstvo visokih performansi", PredmetSemestar.LETNJI, PredmetGodina.CETVRTA,10));
		predmeti.add(new Predmet("p24", "Analiza 1", PredmetSemestar.ZIMSKI, PredmetGodina.PRVA,20));
		predmeti.add(new Predmet("it25", "Informaciona bezbednost", PredmetSemestar.LETNJI, PredmetGodina.CETVRTA,9));
		predmeti.add(new Predmet("it26", "Elektronsko placanje", PredmetSemestar.ZIMSKI, PredmetGodina.TRECA,8));
		predmeti.add(new Predmet("it27", "Distribuirani sistemi", PredmetSemestar.ZIMSKI, PredmetGodina.CETVRTA,6));
		predmeti.add(new Predmet("p28", "Projektovanje softvera", PredmetSemestar.ZIMSKI, PredmetGodina.TRECA,5));
		predmeti.add(new Predmet("p29", "Informacioni sistemi", PredmetSemestar.ZIMSKI, PredmetGodina.CETVRTA,6));
		predmeti.add(new Predmet("p30", "Masinsko ucenje", PredmetSemestar.LETNJI, PredmetGodina.CETVRTA,7));*/
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
