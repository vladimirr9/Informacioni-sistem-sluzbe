package rs.ac.uns.ocena.controller;


public class OcenaController {
private static OcenaController instance = null;
	
	public static OcenaController getInstance() {
		if (instance == null) {
			instance = new OcenaController();
		}
		return instance;
	}
	
	private OcenaController() {}
}
