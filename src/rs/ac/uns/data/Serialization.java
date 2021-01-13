package rs.ac.uns.data;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import rs.ac.uns.ocena.model.BazaOcena;
import rs.ac.uns.predmet.model.BazaPredmeta;
import rs.ac.uns.profesor.model.BazaProfesora;
import rs.ac.uns.student.model.BazaStudent;

public class Serialization {
	
	private static Serialization instance = null;
	
	public static Serialization getInstance() {
		if (instance == null) {
			instance = new Serialization();
		}
		return instance;
	}
	
	public  void BazaStudenataSerialization() {
		try {
            File f=new File("data"+File.separator+"baza1.txt");
            ObjectOutputStream oos=new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(f)));
            try{oos.writeObject(BazaStudent.getInstance().getStudenti());}
            finally {
                oos.close();
            }
        } catch (FileNotFoundException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        } catch (IOException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }

	}
	
	public  void BazaProfesoraSerialization() {
		try {
            File f=new File("data"+File.separator+"baza2.txt");
            ObjectOutputStream oos=new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(f)));
            try{oos.writeObject(BazaProfesora.getInstance().getProfesori());}
            finally {
                oos.close();
            }
        } catch (FileNotFoundException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        } catch (IOException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }

	}
	
	public  void BazaPredmetaSerialization() {
		try {
            File f=new File("data"+File.separator+"baza3.txt");
            ObjectOutputStream oos=new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(f)));
            try{oos.writeObject(BazaPredmeta.getInstance().getPredmeti());}
            finally {
                oos.close();
            }
        } catch (FileNotFoundException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        } catch (IOException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }

	}
	
	public  void BazaOcenaSerialization() {
		try {
            File f=new File("data"+File.separator+"baza4.txt");
            ObjectOutputStream oos=new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(f)));
            try{oos.writeObject(BazaOcena.getInstance().getOcene());}
            finally {
                oos.close();
            }
        } catch (FileNotFoundException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        } catch (IOException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }

	}
}
