package rs.ac.uns.predmet.model;

import rs.ac.uns.student.model.GodinaStudiranja;

public enum PredmetGodina {
	PRVA("I(prva)",1),
	DRUGA("II(druga)",2),
	TRECA("III(treća)",3),
	CETVRTA("IV(četvrta)",4),
	PETA("V(peta)",5);
	
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
	
	
	public static int getPredmetGodina(PredmetGodina p)
	{
		int retval = 5;
		if (p == PredmetGodina.PRVA)
			retval = 1;
		else if (p == PredmetGodina.DRUGA)
			retval = 2;
		else if (p == PredmetGodina.TRECA)
			retval = 3;
		else if (p == PredmetGodina.CETVRTA)
			retval = 4;
		
		return retval;
	}
	
}
