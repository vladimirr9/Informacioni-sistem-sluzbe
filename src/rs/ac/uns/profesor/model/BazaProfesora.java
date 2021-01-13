package rs.ac.uns.profesor.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import rs.ac.uns.predmet.model.Predmet;
import rs.ac.uns.predmet.model.PredmetGodina;
import rs.ac.uns.predmet.model.PredmetSemestar;
import rs.ac.uns.student.model.Student;

public class BazaProfesora {
	private static BazaProfesora instance = null;

	public static BazaProfesora getInstance() {
		if (instance == null) {
			instance = new BazaProfesora();
		}
		return instance;
	}


	private List<Profesor> profesori;
	private List<String> kolone;

	private BazaProfesora() {
	
	
		initProfesore();

		this.kolone = new ArrayList<String>();
		this.kolone.add("Ime");
		this.kolone.add("Prezime");
		this.kolone.add("Titula");
		this.kolone.add("Zvanje");

	}

	private void initProfesore() {
		this.profesori = new ArrayList<Profesor>();
	/*	try {
			List<Predmet>lista=new ArrayList<Predmet>();
			lista.add(new Predmet("E2N", "LPRS", PredmetSemestar.ZIMSKI, PredmetGodina.DRUGA,5));
			profesori.add(new Profesor("Petrović", "Petar",new SimpleDateFormat("dd.MM.yyyy.").parse("01.12.1963."),"Bulevar oslobođenja 100, Novi Sad ","0601112221","Petar@gmail.com","Bulevar oslobođenja 133, Novi Sad","000000001", ProfesorTitula.BSC, ProfesorZvanje.ASISTENT,lista));
			profesori.add(new Profesor("Žikić", "Žika",new SimpleDateFormat("dd.MM.yyyy.").parse("08.02.1961."),"Bulevar oslobođenja 101, Novi Sad ","0601112222","Zika@gmail.com","Bulevar oslobođenja 133, Novi Sad","000000002", ProfesorTitula.BSC, ProfesorZvanje.ASISTENT));
			profesori.add(new Profesor("Perić", "Pera",new SimpleDateFormat("dd.MM.yyyy.").parse("18.10.1968."),"Bulevar oslobođenja 102, Novi Sad ","0601112223","Pera@gmail.com","Bulevar oslobođenja 133, Novi Sad","000000003" ,ProfesorTitula.DOKTOR,ProfesorZvanje.REDOVNI_PROFESOR)); 
		profesori.add(new Profesor("Nikolic", "Milos",new SimpleDateFormat("dd.MM.yyyy.").parse("12.12.1965."),"Temerinska 15, Novi Sad ","021/356-785","milos.nikolic@mailinator.com","Dositeja Obradovića 6, Novi Sad, NTP 600","123123123", ProfesorTitula.DOKTOR, ProfesorZvanje.REDOVNI_PROFESOR));
		profesori.add(new Profesor("Mirkovic", "Nikola",new SimpleDateFormat("dd.MM.yyyy.").parse("01.01.1978."),"Jovana Cvjića 25, Subotica","021/368-456","nikola.mirkovic@mailinator.com","Dositeja Obradovića 6, Novi Sad, NTP 601","321321321", ProfesorTitula.DOKTOR, ProfesorZvanje.REDOVNI_PROFESOR));
		profesori.add(new Profesor("Petkovic", "Ilija",new SimpleDateFormat("dd.MM.yyyy.").parse("03.09.1988."),"Gogoljeva 1, Novi Sad","021/215-314","ilija.petkovic@mailinator.com","Dositeja Obradovića 6, Novi Sad, NTP 602","456456456", ProfesorTitula.PROFESOR_DOKTOR, ProfesorZvanje.VANREDNI_PROFESOR));
		profesori.add(new Profesor("Petrovic", "Mitar",new SimpleDateFormat("dd.MM.yyyy.").parse("25.07.1976."),"Marka Kraljevića 102, Beograd","021/884-640","mitar.petrovic@mailinator.com","Dositeja Obradovića 6, Novi Sad, NTP 603","789789789", ProfesorTitula.DOKTOR, ProfesorZvanje.VANREDNI_PROFESOR));
		profesori.add(new Profesor("Micic", "Vasa",new SimpleDateFormat("dd.MM.yyyy.").parse("14.02.1970."),"Tolstojeva 55, Novi Sad","021/212-114","vasa.micic@mailinator.com","Dositeja Obradovića 6, Novi Sad, NTP 604","001001001", ProfesorTitula.DOKTOR, ProfesorZvanje.DOCENT));
		profesori.add(new Profesor("Miletic", "Srdjan",new SimpleDateFormat("dd.MM.yyyy.").parse("20.04.1966."),"Šekspirova 12, Novi Sad","021/978-225","srdjan.miletic@mailinator.com","Dositeja Obradovića 6, Novi Sad, NTP 605","002002002", ProfesorTitula.DOKTOR, ProfesorZvanje.DOCENT));
		profesori.add(new Profesor("Mihajlovic", "Branislav",new SimpleDateFormat("dd.MM.yyyy.").parse("28.06.1980."),"Jovana Subotića 99, Novi Sad","021/778-323","branislav.mihajlovic@mailinator.com","Dositeja Obradovića 6, Novi Sad, NTP 606","559585632", ProfesorTitula.DOKTOR, ProfesorZvanje.REDOVNI_PROFESOR));
		profesori.add(new Profesor("Marković", "Marko",new SimpleDateFormat("dd.MM.yyyy.").parse("31.01.1985."),"Mirka Markovića 101, Kraljevo","021/899-659","marko.markovic@mailinator.com","Dositeja Obradovića 6, Novi Sad, NTP 607","334968855", ProfesorTitula.PROFESOR_DOKTOR, ProfesorZvanje.REDOVNI_PROFESOR));
		profesori.add(new Profesor("Milaković", "Miloš",new SimpleDateFormat("dd.MM.yyyy.").parse("21.09.1975."),"Braće Jugović 1, Kragujevac","021/122-326","milos.milakovic@mailinator.com","Dositeja Obradovića 6, Novi Sad, NTP 608","073070365", ProfesorTitula.PROFESOR_DOKTOR, ProfesorZvanje.VANREDNI_PROFESOR));
		profesori.add(new Profesor("Bratić", "Lazar",new SimpleDateFormat("dd.MM.yyyy.").parse("13.11.1973."),"Jovanke Orleanke 3, Niš","021/156-326","lazar.bratic@mailinator.com","Dositeja Obradovića 6, Novi Sad, NTP 609","006003786", ProfesorTitula.DOKTOR, ProfesorZvanje.VANREDNI_PROFESOR));
		profesori.add(new Profesor("Dražić", "Ljeposava",new SimpleDateFormat("dd.MM.yyyy.").parse("11.08.1964."),"Vojvode Stepe 1100, Beograd","021/888-156","ljeposava.drazic@mailinator.com","Dositeja Obradovića 6, Novi Sad, NTP 610","158496152", ProfesorTitula.DOKTOR, ProfesorZvanje.DOCENT));
		profesori.add(new Profesor("Dragić", "Miroljub",new SimpleDateFormat("dd.MM.yyyy.").parse("02.03.1959."),"Miše Ljubibratiće 123, Aleksandrovac","021/456-125","miroljub.dragic@mailinator.com","Dositeja Obradovića 6, Novi Sad, NTP 611","777348595", ProfesorTitula.DOKTOR, ProfesorZvanje.DOCENT));
		profesori.add(new Profesor("Rekavić", "Bogdan",new SimpleDateFormat("dd.MM.yyyy.").parse("23.06.1977."),"Resavska 12, Beograd","021/886-455","bogdan.rekavic@mailinator.com","Dositeja Obradovića 6, Novi Sad, NTP 612","721254363", ProfesorTitula.DOKTOR, ProfesorZvanje.VANREDNI_PROFESOR));
		profesori.add(new Profesor("Milić", "Stanka",new SimpleDateFormat("dd.MM.yyyy.").parse("03.03.1990."),"Vidakovićeva 90, Novi Sad","021/945-255","stanka.milic@mailinator.com","Dositeja Obradovića 6, Novi Sad, NTP 613","225533448", ProfesorTitula.DOKTOR, ProfesorZvanje.DOCENT));
		profesori.add(new Profesor("Vuković", "Milica",new SimpleDateFormat("dd.MM.yyyy.").parse("18.10.1967."),"Nikolićeva 12, Novi Sad","021/746-659","milica.vukovic@mailinator.com","Dositeja Obradovića 6, Novi Sad, NTP 614","111555888", ProfesorTitula.PROFESOR_DOKTOR, ProfesorZvanje.VANREDNI_PROFESOR));
		profesori.add(new Profesor("Mišić", "Miša",new SimpleDateFormat("dd.MM.yyyy.").parse("20.10.1969."),"Šojićeva 10, Subotica","021/489-326","misa.misic@mailinator.com","Dositeja Obradovića 6, Novi Sad, NTP 615","003003003", ProfesorTitula.DOKTOR, ProfesorZvanje.DOCENT));
		profesori.add(new Profesor("Maricic", "Branko",new SimpleDateFormat("dd.MM.yyyy.").parse("18.01.1973."),"Nikole Tesle 25, Sombor","021/487-265","branko.maricic@mailinator.com","Dositeja Obradovića 6, Novi Sad, NTP 616","004004004", ProfesorTitula.PROFESOR_DOKTOR, ProfesorZvanje.DOCENT));
		profesori.add(new Profesor("Lukovic", "Branislav",new SimpleDateFormat("dd.MM.yyyy.").parse("08.04.1982."),"Živojina Mišića 7, Apatin","021/159-478","branislav.lukovic@mailinator.com","Dositeja Obradovića 6, Novi Sad, NTP 617","005005005", ProfesorTitula.DOKTOR, ProfesorZvanje.REDOVNI_PROFESOR));
		profesori.add(new Profesor("Obradovic", "Branimir",new SimpleDateFormat("dd.MM.yyyy.").parse("07.01.1979."),"Stari šor 18, Sremska Mitrovica","021/922-333","branimir.obradovic@mailinator.com","Dositeja Obradovića 6, Novi Sad, NTP 618","006006006", ProfesorTitula.PROFESOR_DOKTOR, ProfesorZvanje.DOCENT));


		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} */
	}

	public List<Profesor> getProfesori() {
		return profesori;
	}

	public void setProfesori(List<Profesor> profesori) {
		this.profesori = profesori;
	}

	public int getColumnCount() {
		return 4;
	}

	public String getColumnName(int index) {
		return this.kolone.get(index);
	}

	public Profesor getRow(int rowIndex) {
		return this.profesori.get(rowIndex);
	}

	public String getValueAt(int row, int column) {
		Profesor profesor = this.profesori.get(row);
		switch (column) {
		case 0:
			return profesor.getIme();
		case 1:
			return profesor.getPrezime();
		case 2:
			return profesor.getTitula().toString();
		case 3:
			return profesor.getZvanje().toString();
		default:
			return null;
		}
	}

	public void dodajProfesora(String prezime, String ime, Date datumRodjenja, String adresaStanovanja, String kontaktTelefon,
			String emailAdresa, String adresaKancelarije, String brojLicneKarte, ProfesorTitula titula,
			ProfesorZvanje zvanje) {
		this.profesori.add(new Profesor(ime, prezime, datumRodjenja,adresaStanovanja,kontaktTelefon,emailAdresa,adresaKancelarije,brojLicneKarte,titula, zvanje));
	}
	public void obrisiProfesora(Profesor p) {
		for(Profesor pp:this.profesori) {
			if(pp.equals(p)) {
				this.profesori.remove(pp);
				break;
			}
		}
	}
	public Profesor getProfByLicna(String licna) {
		for (Profesor p : profesori) {
			if (p.getBrojLicneKarte().equals(licna)) {
				return p;
			}
		}
		return null;
	}

	
}
