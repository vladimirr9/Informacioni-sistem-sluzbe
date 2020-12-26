package rs.ac.uns;

import rs.ac.uns.profesor.controller.ProfesorController;
import rs.ac.uns.profesor.model.BazaProfesora;

public class MyApp {

	public static void main(String[] args) {
		BazaProfesora.getInstance();
		ProfesorController.getInstance();
		MainFrame.getInstance();

	}

}
