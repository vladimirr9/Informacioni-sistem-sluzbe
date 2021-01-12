package rs.ac.uns.ocena.model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import rs.ac.uns.predmet.model.BazaPredmeta;
import rs.ac.uns.predmet.model.Predmet;
import rs.ac.uns.student.model.BazaStudent;
import rs.ac.uns.student.model.Student;

public class BazaOcena {
	
	private static BazaOcena instance = null;
	private List<Ocena> ocene;
	private List<String> kolone;
	
	
	public static BazaOcena getInstance() {
		if (instance == null) {
			instance = new BazaOcena();
		}
		return instance;
	}
	
	
	
	private BazaOcena() {

		ocene = new ArrayList<Ocena>();
		initOcene();
		kolone = new ArrayList<String>();
		
		kolone.add("Šifra predmeta");
		kolone.add("Naziv predmeta");
		kolone.add("ESPB");
		kolone.add("Ocena");
		kolone.add("Datum");
	}
	
		public void initOcene() {
			DateFormat datum = new SimpleDateFormat("dd.MM.yyyy.");
			Student s = BazaStudent.getInstance().getStudenti().get(0);
			Predmet p = BazaPredmeta.getInstance().getPredmeti().get(0);
	
			try {
				Ocena o1 = new Ocena(s, p, 9, datum.parse("1.1.2018."));
				ocene.add(o1);
				s.getPolozeniIspiti().add(o1);
				//p.getPolozili().add(s);
				Predmet p2 = BazaPredmeta.getInstance().getPredmeti().get(2);
				Ocena o2 = new Ocena(s, p2, 10, datum.parse("6.5.2017."));
				ocene.add(o2);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
			
			public int getNumberOfColumns() {
				return kolone.size();
			}

			public int getNumberOfRows() {
				return ocene.size();
			}

			public String getColumnName(int indeks) {
				return kolone.get(indeks);
			}

			public Ocena getRow(int rowIndex) {
				return ocene.get(rowIndex);
			}

			public String getValueAt(int row, int column, String brojIndeksa) {
				Ocena ocena = BazaStudent.getInstance().getStudentByIndeks(brojIndeksa).getPolozeniIspiti().get(row);
				switch (column) {
				case 0:
					return ocena.getPredmet().getSifra();
				case 1:
					return ocena.getPredmet().getNaziv();
				case 2:
					return String.valueOf(ocena.getPredmet().getBodovi());
				case 3:
					return Integer.toString(ocena.getOcena());
				case 4:
					return formatDatum(ocena.getDatumPolaganja());
				default:
					return null;
				}
			}

			public List<Ocena> getOcene() {
				return ocene;
			}

			public void setOcene(List<Ocena> ocene) {
				this.ocene = ocene;
			}

			private String formatDatum(Date date) {
				DateFormat formatDatuma = new SimpleDateFormat("dd.MM.yyyy.");
				return formatDatuma.format(date);
			}

}
