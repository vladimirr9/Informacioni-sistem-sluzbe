package rs.ac.uns.data;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

import rs.ac.uns.MainFrame;
import rs.ac.uns.ocena.model.BazaOcena;
import rs.ac.uns.ocena.model.Ocena;
import rs.ac.uns.predmet.model.BazaPredmeta;
import rs.ac.uns.predmet.model.Predmet;
import rs.ac.uns.profesor.model.BazaProfesora;
import rs.ac.uns.profesor.model.Profesor;
import rs.ac.uns.student.model.BazaStudent;
import rs.ac.uns.student.model.Student;

public class Deserialization {

	
private static Deserialization instance = null;
	
	public static Deserialization getInstance() {
		if (instance == null) {
			instance = new Deserialization();
		}
		return instance;
	}
	public  void bazaStudenataDeserialization() {
		File f=new File("data"+File.separator+"baza1");
		ObjectInputStream ois;
		try {
			ois=new ObjectInputStream(new BufferedInputStream(new FileInputStream(f)));
		 try {
			 BazaStudent bp=BazaStudent.getInstance();
			List<Student>student=(ArrayList<Student>)ois.readObject();
			bp.setStudenti(student);
		} catch(Exception e1){
			
		} finally {
			ois.close();
			//MainFrame.getInstance().azurirajPrikazStudenta("Azuriranje studenata", -1);
		}
	} catch(Exception e2) {
		e2.printStackTrace();
		
	}
	}
	
	public  void bazaProfesoraDeserialization() {
		File f=new File("data"+File.separator+"baza2");
		ObjectInputStream ois;
		try {
			ois=new ObjectInputStream(new BufferedInputStream(new FileInputStream(f)));
		 try {
			 BazaProfesora bp=BazaProfesora.getInstance();
			List<Profesor>profesor=(ArrayList<Profesor>)ois.readObject();
			bp.setProfesori(profesor);
		} catch(Exception e1){
			
		} finally {
			ois.close();
			//MainFrame.getInstance().azurirajPrikazPredmeta("Azuriranje profesora", -1);
		}
	} catch(Exception e2) {
		e2.printStackTrace();
		
	}
	}
	public  void bazaPredmetaDeserialization() {
		File f=new File("data"+File.separator+"baza3");
		ObjectInputStream ois;
		try {
			ois=new ObjectInputStream(new BufferedInputStream(new FileInputStream(f)));
		 try {
			 BazaPredmeta bp=BazaPredmeta.getInstance();
			List<Predmet>predmeti=(ArrayList<Predmet>)ois.readObject();
			bp.setPredmeti(predmeti);
		} catch(Exception e1){
			
		} finally {
			ois.close();
			//MainFrame.getInstance().azurirajPrikazPredmeta("Azuriranje predmeta", -1);
		}
	} catch(Exception e2) {
		e2.printStackTrace();
	}
	}
	public  void bazaOcenaDeserialization() {
		File f=new File("data"+File.separator+"baza4");
		ObjectInputStream ois;
		try {
			ois=new ObjectInputStream(new BufferedInputStream(new FileInputStream(f)));
		 try {
			 BazaOcena bp=BazaOcena.getInstance();
			List<Ocena>ocene=(ArrayList<Ocena>)ois.readObject();
			bp.setOcene(ocene);
		} catch(Exception e1){
			
		} finally {
			ois.close();
			//MainFrame.getInstance().azurirajPrikazOcene("Azuriranje ocena",-1);
		}
	} catch(Exception e2) {
		e2.printStackTrace();
	}
	}
	
	
}
