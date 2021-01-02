package rs.ac.uns.predmet.model;

public enum PredmetGodina {
	PRVA("I(prva)",1),
	DRUGA("II(druga)",2),
	TRECA("III(treća)",3),
	CETVRTA("IV(četvrta",4),
	PETA("peta",5);
	
	private final String nazivGodine;
	private final int brojGodine;
	
	private PredmetGodina(String nazivGodine, int brojGodine) {
		this.nazivGodine=nazivGodine;
		this.brojGodine=brojGodine;
	}

	public String getNazivGodine() {
		return nazivGodine;
	}

	public int getBrojGodine() {
		return brojGodine;
	}
	
	
}
