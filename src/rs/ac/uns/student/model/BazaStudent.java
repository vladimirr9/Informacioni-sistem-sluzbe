package rs.ac.uns.student.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import rs.ac.uns.MainFrame;
import rs.ac.uns.data.Deserialization;
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
	/*	try {
		//	List<Predmet>predmetiproba=new ArrayList<Predmet>();
			
		//	
		//	predmetiproba.add(new Predmet("E214", "PJISP", PredmetSemestar.ZIMSKI, PredmetGodina.PRVA,9));
		//	studenti.add(new Student("Prezimic", "Imenko", new SimpleDateFormat("dd.MM.yyyy.").parse("01.02.1990."), "Bulevar Kralja Petra 100, Novi Kneževac",
		//			"0634723723" ,"imenkoprezimic@gmail.com"  , "RA-230-2001", 2011,
		//			GodinaStudiranja.I, StudentStatus.S, (float) 9.32, new ArrayList<Ocena>(),predmetiproba));
		//	studenti.add(new Student("Jerizic", "Neko", new SimpleDateFormat("dd.MM.yyyy.").parse("01.01.1992."), "Bulevar Kralja Petra 101, Novi Kneževac",
		//			"0647623223" ,"JerizicNeko@gmail.com"  , "RA-20-2012", 2016,
		//			GodinaStudiranja.II, StudentStatus.S, (float) 9.53, new ArrayList<Ocena>(),new ArrayList<Predmet>()));
		//	studenti.add(new Student("Rokvic", "Vladimir", new SimpleDateFormat("dd.MM.yyyy.").parse("09.05.1999."), "Bulevar Kralja Petra 123, Novi Kneževac",
		//			"064765653" ,"nekonestic@gmail.com"  , "RA-69-2018", 2018,
		//			GodinaStudiranja.III, StudentStatus.B, (float) 7.32, new ArrayList<Ocena>(),new ArrayList<Predmet>()));
			studenti.add(new Student("Milosevic","Marko", new SimpleDateFormat("dd.MM.yyyy.").parse("12.03.2001."), "Karađorđeva 83, Novi Sad", "021/333-555", "marko.milosevic@mailinator.com", "RA 2/2020", 2020, GodinaStudiranja.I, StudentStatus.B));
			studenti.add(new Student("Milić","Marija", new SimpleDateFormat("dd.MM.yyyy.").parse("12.01.2000."), "Stražilovska 12, Novi Sad", "021/555-2222", "marija.milic@mailinator.com", "RA 3/2019", 2019, GodinaStudiranja.II, StudentStatus.S));
			studenti.add(new Student("Nikolic","Nikola", new SimpleDateFormat("dd.MM.yyyy.").parse("30.08.2001."), "Knez Mihajlova 16, Beograd", "021/135-463", "nikola.nikolic@mailinator.com", "RA 3/2017", 2017, GodinaStudiranja.I, StudentStatus.B));
			studenti.add(new Student("Peric","Pera", new SimpleDateFormat("dd.MM.yyyy.").parse("07.06.1995."), "Gogoljeva 3, Novi Sad", "021/903-463", "pera.peric@mailinator.com", "RA 134/2015", 2015, GodinaStudiranja.III, StudentStatus.S));
			studenti.add(new Student("Ilic","Sofija", new SimpleDateFormat("dd.MM.yyyy.").parse("06.05.1999."), "Miše Dimitrijevića 44, Novi Sad", "021/731-067", "sofija.ilic@mailinator.com", "RA 5/2019", 2019, GodinaStudiranja.III, StudentStatus.B));
			studenti.add(new Student("Lukic","Martina", new SimpleDateFormat("dd.MM.yyyy.").parse("16.05.1999."), "Vojvode Stepe 180, Beograd", "011/4333-800", "martina.lukic@mailinator.com", "RA 8/2018", 2018, GodinaStudiranja.III, StudentStatus.S));
			studenti.add(new Student("Stojakovic","Stojan", new SimpleDateFormat("dd.MM.yyyy.").parse("19.10.2001."), "1300 Kaplara, Šabac", "011/3130-007", "stojan.stojakovic@mailinator.com", "RA 10/2017", 2017, GodinaStudiranja.I, StudentStatus.B));
			studenti.add(new Student("Milanovic","Milan", new SimpleDateFormat("dd.MM.yyyy.").parse("02.11.2000."), "Surepova 12, Šabac", "015/313-061", "milan.milanovic@mailinator.com", "RA 12/2017", 2017, GodinaStudiranja.II, StudentStatus.S));
			studenti.add(new Student("Milic","Miroslav", new SimpleDateFormat("dd.MM.yyyy.").parse("11.10.2000."), "Milovana Glišića, Valjevo", "021/351-091", "miroslav.milic@mailinator.com", "RA 16/2019", 2019, GodinaStudiranja.II, StudentStatus.B));
			studenti.add(new Student("Gojic","Stefan", new SimpleDateFormat("dd.MM.yyyy.").parse("01.05.1999."), "Bulevar Mihajla Pupina, Novi Sad", "015/324-500", "stefan.gojic@mailinator.com", "RA 21/2015", 2015, GodinaStudiranja.III, StudentStatus.S));
			studenti.add(new Student("Jokic","Anastasija", new SimpleDateFormat("dd.MM.yyyy.").parse("11.07.1999."), "Braće Ribnikar 12, Novi Sad", "011/2333-900", "anastasija.jokic@mailinator.com", "RA 9/2020", 2020, GodinaStudiranja.III, StudentStatus.B));
			studenti.add(new Student("Bogdanovic","Bogdan", new SimpleDateFormat("dd.MM.yyyy.").parse("23.07.1999."), "Cara Dušana 42, Subotica", "021/231-114", "bogdan.bogdanovic@mailinator.com", "RA 4/2017", 2017, GodinaStudiranja.III, StudentStatus.S));
			studenti.add(new Student("Dabovic","Ana", new SimpleDateFormat("dd.MM.yyyy.").parse("12.12.2001."), "Marka Kraljevića 1, Kikinda", "014/303-007", "ana.dabovic@mailinator.com", "RA 30/2019", 2019, GodinaStudiranja.I, StudentStatus.B));
			studenti.add(new Student("Mikic","Mika", new SimpleDateFormat("dd.MM.yyyy.").parse("05.11.2001."), "Nikole Stojanovića 2, Kraljevo", "015/101-909", "mika.mikic@mailinator.com", "RA 1/2020", 2020, GodinaStudiranja.I, StudentStatus.S));
			studenti.add(new Student("Deretic","Jovan", new SimpleDateFormat("dd.MM.yyyy.").parse("10.09.1998."), "Marka Bratića 99, Niš", "002/200-300", "jovan.deretic@mailinator.com", "RA 11/2018", 2018, GodinaStudiranja.IV, StudentStatus.B));
			studenti.add(new Student("Miskovic","Nikola", new SimpleDateFormat("dd.MM.yyyy.").parse("03.08.1998."), "Cara Dušana 12, Banja Luka", "022/123-456", "nikola.miskovic@mailinator.com", "RA 12/2018", 2018, GodinaStudiranja.IV, StudentStatus.S));
			studenti.add(new Student("Stojanovic","Martin", new SimpleDateFormat("dd.MM.yyyy.").parse("01.05.1998."), "Borisa Bačkog 1, Bijeljina", "024/321-775", "martin.stojanovic@mailinator.com", "RA 13/2018", 2018, GodinaStudiranja.IV, StudentStatus.S));
			studenti.add(new Student("Novakovic","Tomislav", new SimpleDateFormat("dd.MM.yyyy.").parse("25.02.1996."), "Mirka Maksića 10, Kruševac", "011/1188-379", "tomislav.novakovic@mailinator.com", "RA 14/2018", 2018, GodinaStudiranja.IV, StudentStatus.B));
			studenti.add(new Student("Ivic","Lena", new SimpleDateFormat("dd.MM.yyyy.").parse("11.05.1998."), "Stari Most 6, Sremska Mitrovica", "024/333-555", "lena.ivic@mailinator.com", "RA 154/2016", 2016, GodinaStudiranja.IV, StudentStatus.B));
			studenti.add(new Student("Lazic","Jovan", new SimpleDateFormat("dd.MM.yyyy.").parse("22.01.2001."), "Nevesinjskih ustanika 10, Nevesinje", "025/1189-479", "jovan.lazic@mailinator.com", "RA 23/2020", 2020, GodinaStudiranja.I, StudentStatus.B));
			studenti.add(new Student("Mikic","Isidora", new SimpleDateFormat("dd.MM.yyyy.").parse("31.12.2000."), "Radnička 11, Novi Sad", "011/1122-366", "isidora.mikic@mailinator.com", "RA 1/2019", 2019, GodinaStudiranja.II, StudentStatus.B));
			studenti.add(new Student("Ilic","Vladimir", new SimpleDateFormat("dd.MM.yyyy.").parse("31.08.1998."), "Miloša Obilića 1, Beograd", "021/1122-367", "vladimir.ilic@mailinator.com", "SW 4/2014", 2014, GodinaStudiranja.IV, StudentStatus.B));
			studenti.add(new Student("Alicic","Mirko", new SimpleDateFormat("dd.MM.yyyy.").parse("21.07.1999."), "Heroja Pinkija 112, Novi Sad", "012/1122-368", "mirko.alicic@mailinator.com", "SW 17/2015", 2015, GodinaStudiranja.III, StudentStatus.S));
			studenti.add(new Student("Perkovic","Milisav", new SimpleDateFormat("dd.MM.yyyy.").parse("28.09.1998."), "Pavla Bakića 26, Novi Sad", "012/1122-369", "milisav.pejkovic@mailinator.com", "SW 17/2016", 2016, GodinaStudiranja.IV, StudentStatus.S));
			studenti.add(new Student("Djordjevic","Purisa", new SimpleDateFormat("dd.MM.yyyy.").parse("29.02.2000."), "Pavla Papa 1, Novi Sad", "011/1543-370", "purisa.djordjevic@mailinator.com", "SW 27/2018", 2018, GodinaStudiranja.II, StudentStatus.B));
			studenti.add(new Student("Kovacevic","Mikica", new SimpleDateFormat("dd.MM.yyyy.").parse("23.03.1999."), "Valentina Vodnika 112, Novi Sad", "011/1992-371", "mikica.kovacevic@mailinator.com", "RA 226/2017", 2017, GodinaStudiranja.III, StudentStatus.S));
			studenti.add(new Student("Milić","Miloš", new SimpleDateFormat("dd.MM.yyyy.").parse("21.10.2001."), "Neznanog junaka 12, Beograd", "011/8172-372", "milos.milic@mailinator.com", "SW 12/2020", 2020, GodinaStudiranja.I, StudentStatus.S));

		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
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
	public float getProsek(Student s)
	{
		float prosek = 0;
			for (Ocena o : s.getPolozeniIspiti())
			{
				prosek += o.getOcena();
			}
			if (s.getPolozeniIspiti().size() > 0)
			{
				prosek = prosek / s.getPolozeniIspiti().size();
			}
		s.setProsecnaOcena(prosek);
		return prosek;
	}
	public void dodajStudenta(String prezime, String ime, Date datumRodjenja, String adresaStanovanja, String kontaktTelefon,
			String emailAdresa, String brojIndeksa, int godinaUpisa, GodinaStudiranja trenutnaGodinaStudija, StudentStatus status)  {
		this.studenti.add(new Student(prezime, ime, datumRodjenja, adresaStanovanja, kontaktTelefon, emailAdresa, brojIndeksa, godinaUpisa, trenutnaGodinaStudija, status));
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
