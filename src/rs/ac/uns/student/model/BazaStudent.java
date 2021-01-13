package rs.ac.uns.student.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import rs.ac.uns.MainFrame;
import rs.ac.uns.ocena.model.Ocena;
import rs.ac.uns.ocena.view.OcenaJTable;
import rs.ac.uns.predmet.model.Predmet;
import rs.ac.uns.predmet.model.PredmetGodina;
import rs.ac.uns.predmet.model.PredmetSemestar;
import rs.ac.uns.student.view.NepolozeniJTable;

public class BazaStudent {
	private static BazaStudent instance = null;

	public static BazaStudent getInstance() {
		if (instance == null) {
			instance = new BazaStudent();
		}
		return instance;
	}
	
	
	
	
	private List<Student> studenti;
	private List<String> kolone;

	
	
	private BazaStudent()
	{
		initStudente();
		
		this.kolone = new ArrayList<String>();
		this.kolone.add("Indeks");
		this.kolone.add("Ime");
		this.kolone.add("Prezime");
		this.kolone.add("Godina studija");
		this.kolone.add("Status");
		this.kolone.add("Prosek");
		
		
		
	}
	private void initStudente() {
		this.studenti = new ArrayList<Student>();
		try {
			List<Predmet>predmetiproba=new ArrayList<Predmet>();
			
			
			predmetiproba.add(new Predmet("E214", "PJISP", PredmetSemestar.ZIMSKI, PredmetGodina.PRVA,9));
			studenti.add(new Student("Prezimic", "Imenko", new SimpleDateFormat("dd.MM.yyyy.").parse("01.02.1990."), "Bulevar Kralja Petra 100, Novi Kneževac",
					"0634723723" ,"imenkoprezimic@gmail.com"  , "RA-230-2001", 2011,
					GodinaStudiranja.I, StudentStatus.S, (float) 9.32, new ArrayList<Ocena>(),predmetiproba));
			studenti.add(new Student("Jerizic", "Neko", new SimpleDateFormat("dd.MM.yyyy.").parse("01.01.1992."), "Bulevar Kralja Petra 101, Novi Kneževac",
					"0647623223" ,"JerizicNeko@gmail.com"  , "RA-20-2012", 2016,
					GodinaStudiranja.II, StudentStatus.S, (float) 9.53, new ArrayList<Ocena>(),new ArrayList<Predmet>()));
			studenti.add(new Student("Rokvic", "Vladimir", new SimpleDateFormat("dd.MM.yyyy.").parse("09.05.1999."), "Bulevar Kralja Petra 123, Novi Kneževac",
					"064765653" ,"nekonestic@gmail.com"  , "RA-69-2018", 2018,
					GodinaStudiranja.III, StudentStatus.B, (float) 7.32, new ArrayList<Ocena>(),new ArrayList<Predmet>()));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public Student getStudentByIndeks(String brojIndeksa) {
		for (Student s : studenti) {
			if (s.getBrojIndeksa().equals(brojIndeksa) ) {
				return s;
			}
		}
		return null;
	}
	public Student findStudentByRow(int row) {
		return studenti.get(row);
	}
	
	
	public List<Student> getStudenti() {
		return studenti;
	}
	
	public void setStudenti(List<Student> studenti) {
		this.studenti = studenti;
	}
	public int getColumnCount() {
		return 6;
	}
	
	public String getColumnName(int index) {
		return this.kolone.get(index);
	}
	
	
	public Student getRow(int rowIndex) {
		return this.studenti.get(rowIndex);
	}
	
	public String getValueAt(int row, int column) {
		Student student = this.studenti.get(row);
		switch (column) {
		case 0:
			return student.getBrojIndeksa();
		case 1:
			return student.getIme();
		case 2:
			return student.getPrezime();
		case 3:
			return student.getTrenutnaGodinaStudija().toString();
		case 4:
			return student.getStatus().toString();
		case 5:
			return String.valueOf(student.getProsecnaOcena());
		default:
			return null;
		}
	}
	public int getESPB(String indeks) {
		int espb = 0;
		for (Student s : studenti) {
			if (s.getBrojIndeksa().equals(indeks)) {
				for (Ocena o : s.getPolozeniIspiti()) {
					espb += o.getPredmet().getBodovi();
				}
				break;
			}

		}
		return espb;
	}
	
	public float getProsek(String indeks)
	{
		float prosek = 0;
		for (Student s : studenti)
		{
			if (s.getBrojIndeksa().equalsIgnoreCase(indeks))
			for (Ocena o : s.getPolozeniIspiti())
			{
				System.out.println("ocena:" + o.getOcena());
				prosek += o.getOcena();
			}
			if (s.getPolozeniIspiti().size() > 0)
			{
				prosek = prosek / s.getPolozeniIspiti().size();
			}
			break;
		}
		return prosek;
	}
	public float getProsek(Student s)
	{
		float prosek = 0;
			for (Ocena o : s.getPolozeniIspiti())
			{
				System.out.println("ocena:" + o.getOcena());
				prosek += o.getOcena();
			}
			if (s.getPolozeniIspiti().size() > 0)
			{
				prosek = prosek / s.getPolozeniIspiti().size();
			}
		
		return prosek;
	}
	public void dodajStudenta(String prezime, String ime, Date datumRodjenja, String adresaStanovanja, String kontaktTelefon,
			String emailAdresa, String brojIndeksa, int godinaUpisa, GodinaStudiranja trenutnaGodinaStudija, StudentStatus status,
			float prosecnaOcena, List<Ocena> polozeniIspiti, List<Predmet> nepolozeniIspiti)  {
		this.studenti.add(new Student(prezime, ime, datumRodjenja, adresaStanovanja, kontaktTelefon, emailAdresa, brojIndeksa, godinaUpisa, trenutnaGodinaStudija, status, prosecnaOcena, polozeniIspiti, nepolozeniIspiti));
	}
	public void obrisiStudent(Student s) {
		for(Student ss:this.studenti) {
			if(ss.equals(s)) {
				this.studenti.remove(ss);
				break;
			}
		}
	}
	public void ukloniPredmet(String brojIndeksa, NepolozeniJTable t) {
		Student student=this.getStudentByIndeks(brojIndeksa);
		int indeksPredmetaZaUk=t.convertRowIndexToModel(t.getSelectedRow());
		student.getNepolozeniIspiti().remove(indeksPredmetaZaUk);
		t.azuriraj();
	}
	
	public void dodajOcenu(String brojIndeksa,Ocena oc) {
		Student student=this.getStudentByIndeks(brojIndeksa);
		//student.getPolozeniIspiti().add(oc);
		List<Ocena>lista=student.getPolozeniIspiti();
		lista.add(oc);
		student.setPolozeniIspiti(lista);
		MainFrame.getInstance().azurirajPrikazOcene("Dodavanje polozenog, brisanje nepolozenog", -1);
	}
}
