package rs.ac.uns.student.model;

import java.util.ArrayList;
import java.util.List;

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
		studenti.add(new Student("Prezimic", "Imenko", "RA-23023", "3", StudentStatus.S, (float) 9.32));
		studenti.add(new Student("Jerizic", "Neko", "RA-20223", "2", StudentStatus.B, (float) 9.53));
		studenti.add(new Student("Rokvic", "Vladimir", "RA-69/2018", "3", StudentStatus.B, (float) 7.32));
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
			return student.getTrenutnaGodinaStudija();
		case 4:
			return student.getStatus().toString();
		case 5:
			return String.valueOf(student.getProsecnaOcena());
		default:
			return null;
		}
	}
	public void dodajStudenta(String prezime, String ime, String brojIndeksa, String trenutnaGodinaStudija, StudentStatus status,
			float prosecnaOcena) {
		this.studenti.add(new Student(prezime, ime, brojIndeksa, trenutnaGodinaStudija,status, prosecnaOcena));
	}
}
