package rs.ac.uns.student.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import rs.ac.uns.ocena.model.Ocena;
import rs.ac.uns.predmet.model.Predmet;

public class Student {
	private String prezime;
	private String ime;
	private Date datumRodjenja;
	private String adresaStanovanja;
	private String kontaktTelefon;
	private String emailAdresa;
	private String brojIndeksa;
	private int godinaUpisa;
	private GodinaStudiranja trenutnaGodinaStudija;
	private StudentStatus status;
	private float prosecnaOcena;
	private List<Ocena> polozeniIspiti;
	private List<Predmet> nepolozeniIspiti;
	
	
	
	
	public Student() {
		super();
	}

	
	public Student(String prezime, String ime, Date datumRodjenja, String adresaStanovanja, String kontaktTelefon,
			String emailAdresa, String brojIndeksa, int godinaUpisa, GodinaStudiranja trenutnaGodinaStudija, StudentStatus s,
			float prosecnaOcena, List<Ocena> polozeniIspiti, List<Predmet> nepolozeniIspiti) {
		super();
		this.prezime = prezime;
		this.ime = ime;
		this.datumRodjenja = datumRodjenja;
		this.adresaStanovanja = adresaStanovanja;
		this.kontaktTelefon = kontaktTelefon;
		this.emailAdresa = emailAdresa;
		this.brojIndeksa = brojIndeksa;
		this.godinaUpisa = godinaUpisa;
		this.trenutnaGodinaStudija = trenutnaGodinaStudija;
		this.status = s;
		this.prosecnaOcena = prosecnaOcena;
		this.polozeniIspiti = polozeniIspiti;
		this.nepolozeniIspiti = nepolozeniIspiti;
	}
	
	
	public Student(String prezime, String ime, Date datumRodjenja, String adresaStanovanja, String kontaktTelefon,
			String emailAdresa, String brojIndeksa, int godinaUpisa, GodinaStudiranja trenutnaGodinaStudija,
			StudentStatus status) {
		super();
		this.prezime = prezime;
		this.ime = ime;
		this.datumRodjenja = datumRodjenja;
		this.adresaStanovanja = adresaStanovanja;
		this.kontaktTelefon = kontaktTelefon;
		this.emailAdresa = emailAdresa;
		this.brojIndeksa = brojIndeksa;
		this.godinaUpisa = godinaUpisa;
		this.trenutnaGodinaStudija = trenutnaGodinaStudija;
		this.status = status;
		this.prosecnaOcena = (float) 0;
		this.polozeniIspiti = new ArrayList<Ocena>();
		this.nepolozeniIspiti = new ArrayList<Predmet>();
	}


	public String getPrezime() {
		return prezime;
	}
	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}
	public String getIme() {
		return ime;
	}
	public void setIme(String ime) {
		this.ime = ime;
	}
	public Date getDatumRodjenja() {
		return datumRodjenja;
	}
	public void setDatumRodjenja(Date datumRodjenja) {
		this.datumRodjenja = datumRodjenja;
	}
	public String getAdresaStanovanja() {
		return adresaStanovanja;
	}
	public void setAdresaStanovanja(String adresaStanovanja) {
		this.adresaStanovanja = adresaStanovanja;
	}
	public String getKontaktTelefon() {
		return kontaktTelefon;
	}
	public void setKontaktTelefon(String kontaktTelefon) {
		this.kontaktTelefon = kontaktTelefon;
	}
	public String getEmailAdresa() {
		return emailAdresa;
	}
	public void setEmailAdresa(String emailAdresa) {
		this.emailAdresa = emailAdresa;
	}
	public String getBrojIndeksa() {
		return brojIndeksa;
	}
	public void setBrojIndeksa(String brojIndeksa) {
		this.brojIndeksa = brojIndeksa;
	}
	public int getGodinaUpisa() {
		return godinaUpisa;
	}
	public void setGodinaUpisa(int godinaUpisa) {
		this.godinaUpisa = godinaUpisa;
	}
	public GodinaStudiranja getTrenutnaGodinaStudija() {
		return trenutnaGodinaStudija;
	}
	public void setTrenutnaGodinaStudija(GodinaStudiranja trenutnaGodinaStudija) {
		this.trenutnaGodinaStudija = trenutnaGodinaStudija;
	}
	public StudentStatus getStatus() {
		return status;
	}
	public void setS(StudentStatus s) {
		this.status = s;
	}
	
	public float getProsecnaOcena() {
		return prosecnaOcena;
	}
	public void setProsecnaOcena(float prosecnaOcena) {
		this.prosecnaOcena = prosecnaOcena;
	}
	public List<Ocena> getPolozeniIspiti() {
		return polozeniIspiti;
	}
	public void setPolozeniIspiti(List<Ocena> polozeniIspiti) {
		this.polozeniIspiti = polozeniIspiti;
	}
	public List<Predmet> getNepolozeniIspiti() {
		return nepolozeniIspiti;
	}
	public void setNepolozeniIspiti(List<Predmet> nepolozeniIspiti) {
		this.nepolozeniIspiti = nepolozeniIspiti;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((brojIndeksa == null) ? 0 : brojIndeksa.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		if (brojIndeksa == null) {
			if (other.brojIndeksa != null)
				return false;
		} else if (!brojIndeksa.equals(other.brojIndeksa))
			return false;
		return true;
	}
	
	
	

}
