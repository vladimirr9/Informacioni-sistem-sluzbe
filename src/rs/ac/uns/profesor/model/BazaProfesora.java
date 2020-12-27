package rs.ac.uns.profesor.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
		try {
			profesori.add(new Profesor("Petrović", "Petar",new SimpleDateFormat("dd.MM.yyyy.").parse("01.12.1963."),"Bulevar oslobođenja 100, Novi Sad ","0601112221","Petar@gmail.com","Bulevar oslobođenja 133, Novi Sad","000000001", ProfesorTitula.BSC, ProfesorZvanje.ASISTENT));
			profesori.add(new Profesor("Žikić", "Žika",new SimpleDateFormat("dd.MM.yyyy.").parse("08.02.1961."),"Bulevar oslobođenja 101, Novi Sad ","0601112222","Zika@gmail.com","Bulevar oslobođenja 133, Novi Sad","000000002", ProfesorTitula.BSC, ProfesorZvanje.ASISTENT));
			profesori.add(new Profesor("Perić", "Pera",new SimpleDateFormat("dd.MM.yyyy.").parse("18.10.1968."),"Bulevar oslobođenja 102, Novi Sad ","0601112223","Pera@gmail.com","Bulevar oslobođenja 133, Novi Sad","000000003" ,ProfesorTitula.DOKTOR,ProfesorZvanje.REDOVNI_PROFESOR));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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

	
}
