package rs.ac.uns.ocena.model;

import java.io.Serializable;
import java.util.Date;

import rs.ac.uns.predmet.model.Predmet;
import rs.ac.uns.student.model.Student;

public class Ocena implements Serializable {

	private Student student;
	Predmet predmet; 
	private int ocena;
	private Date datumPolaganja;
	
	
	
	
	
	
	
	public Ocena() {
		super();
	}
	public Ocena(Student student, Predmet predmet, int ocena, Date datumPolaganja) {
		super();
		this.student = student;
		this.predmet = predmet;
		this.ocena = ocena;
		this.datumPolaganja = datumPolaganja;
		
	}
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	public Predmet getPredmet() {
		return predmet;
	}
	public void setPredmet(Predmet predmet) {
		this.predmet = predmet;
	}
	public int getOcena() {
		return ocena;
	}
	public void setOcena(int ocena) {
		this.ocena = ocena;
	}
	public Date getDatumPolaganja() {
		return datumPolaganja;
	}
	public void setDatumPolaganja(Date datumPolaganja) {
		this.datumPolaganja = datumPolaganja;
	}
	
	
	
}
