package rs.ac.uns.ocena.controller;

import java.util.List;

import rs.ac.uns.ocena.model.BazaOcena;
import rs.ac.uns.ocena.model.Ocena;

public class OcenaController {
private static OcenaController instance = null;
	
	public static OcenaController getInstance() {
		if (instance == null) {
			instance = new OcenaController();
		}
		return instance;
	}
	
	private OcenaController() {}
	
	public void dodajOcenu(Ocena oc) {
		List<Ocena>lista;
		lista=BazaOcena.getInstance().getOcene();
		lista.add(oc);
		BazaOcena.getInstance().setOcene(lista);
	}
}
