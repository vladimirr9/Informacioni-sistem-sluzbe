package rs.ac.uns.student.model;

import java.util.Date;
import java.util.List;

import rs.ac.uns.ocena.model.Ocena;

public class Student {
	private String prezime;
	private String ime;
	private Date datumRodjenja;
	private String adresaStanovanja;
	private String kontaktTelefon;
	private String emailAdresa;
	private String brojIndeksa;
	private String godinaUpisa;
	private String trenutnaGodinaStudija;
	private StudentStatus status;
	private float prosecnaOcena;
	private List<Ocena> polozeniIspiti;
	private List<String> nepolozeniIspiti;
	
	
	
	
	
	
	
	public Student() {
		super();
	}


	public Student(String prezime, String ime, String brojIndeksa, String trenutnaGodinaStudija, StudentStatus status,
			float prosecnaOcena) {
		super();
		this.prezime = prezime;
		this.ime = ime;
		this.brojIndeksa = brojIndeksa;
		this.trenutnaGodinaStudija = trenutnaGodinaStudija;
		this.status = status;
		this.prosecnaOcena = prosecnaOcena;
	}
	
	
	public Student(String prezime, String ime, Date datumRodjenja, String adresaStanovanja, String kontaktTelefon,
			String emailAdresa, String brojIndeksa, String godinaUpisa, String trenutnaGodinaStudija, StudentStatus s,
			float prosecnaOcena, List<Ocena> polozeniIspiti, List<String> nepolozeniIspiti) {
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
	public String getGodinaUpisa() {
		return godinaUpisa;
	}
	public void setGodinaUpisa(String godinaUpisa) {
		this.godinaUpisa = godinaUpisa;
	}
	public String getTrenutnaGodinaStudija() {
		return trenutnaGodinaStudija;
	}
	public void setTrenutnaGodinaStudija(String trenutnaGodinaStudija) {
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
	public List<String> getNepolozeniIspiti() {
		return nepolozeniIspiti;
	}
	public void setNepolozeniIspiti(List<String> nepolozeniIspiti) {
		this.nepolozeniIspiti = nepolozeniIspiti;
	}
	
	
	

}
