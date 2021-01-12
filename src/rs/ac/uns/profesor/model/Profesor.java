package rs.ac.uns.profesor.model;

import java.util.Date;
import java.util.List;

import rs.ac.uns.predmet.model.Predmet;

public class Profesor {
	
	private String prezime;
	private String ime;
	private Date datumRodjenja;
	private String adresaStanovanja;
	private String kontaktTelefon;
	private String emailAdresa;
	private String adresaKancelarije;
	private String brojLicneKarte;
	private ProfesorTitula titula;
	private ProfesorZvanje zvanje;
	private List<Predmet>predmeti;
	

	public Profesor() {
		super();
	}


	public Profesor(String prezime, String ime, Date datumRodjenja, String adresaStanovanja, String kontaktTelefon,
			String emailAdresa, String adresaKancelarije, String brojLicneKarte, ProfesorTitula titula,
			ProfesorZvanje zvanje, List<Predmet> predmeti) {
		super();
		this.prezime = prezime;
		this.ime = ime;
		this.datumRodjenja = datumRodjenja;
		this.adresaStanovanja = adresaStanovanja;
		this.kontaktTelefon = kontaktTelefon;
		this.emailAdresa = emailAdresa;
		this.adresaKancelarije = adresaKancelarije;
		this.brojLicneKarte = brojLicneKarte;
		this.titula = titula;
		this.zvanje = zvanje;
		this.predmeti = predmeti;
	}


	public Profesor(String prezime, String ime, Date datumRodjenja, String adresaStanovanja, String kontaktTelefon,
			String emailAdresa, String adresaKancelarije, String brojLicneKarte, ProfesorTitula titula,
			ProfesorZvanje zvanje) {
		super();
		this.prezime = prezime;
		this.ime = ime;
		this.datumRodjenja = datumRodjenja;
		this.adresaStanovanja = adresaStanovanja;
		this.kontaktTelefon = kontaktTelefon;
		this.emailAdresa = emailAdresa;
		this.adresaKancelarije = adresaKancelarije;
		this.brojLicneKarte = brojLicneKarte;
		this.titula = titula;
		this.zvanje = zvanje;
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


	public String getAdresaKancelarije() {
		return adresaKancelarije;
	}


	public void setAdresaKancelarije(String adresaKancelarije) {
		this.adresaKancelarije = adresaKancelarije;
	}


	public String getBrojLicneKarte() {
		return brojLicneKarte;
	}


	public void setBrojLicneKarte(String brojLicneKarte) {
		this.brojLicneKarte = brojLicneKarte;
	}


	public ProfesorTitula getTitula() {
		return titula;
	}


	public void setTitula(ProfesorTitula titula) {
		this.titula = titula;
	}


	public ProfesorZvanje getZvanje() {
		return zvanje;
	}


	public void setZvanje(ProfesorZvanje zvanje) {
		this.zvanje = zvanje;
	}


	public List<Predmet> getPredmeti() {
		return predmeti;
	}


	public void setPredmeti(List<Predmet> predmeti) {
		this.predmeti = predmeti;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((brojLicneKarte == null) ? 0 : brojLicneKarte.hashCode());
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
		Profesor other = (Profesor) obj;
		if (brojLicneKarte == null) {
			if (other.brojLicneKarte != null)
				return false;
		} else if (!brojLicneKarte.equals(other.brojLicneKarte))
			return false;
		return true;
	}
	
	
	
}
