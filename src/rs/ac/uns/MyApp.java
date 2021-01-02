package rs.ac.uns;

import rs.ac.uns.predmet.model.BazaPredmeta;
import rs.ac.uns.profesor.controller.ProfesorController;
import rs.ac.uns.profesor.model.BazaProfesora;
import rs.ac.uns.student.controller.StudentController;
import rs.ac.uns.student.model.BazaStudent;

public class MyApp {

	public static void main(String[] args) {
		BazaProfesora.getInstance();
		ProfesorController.getInstance();
		BazaStudent.getInstance();
		StudentController.getInstance();
		BazaPredmeta.getInstance();
		MainFrame.getInstance();

	}

}
