package rs.ac.uns.student.model;

public enum GodinaStudiranja {
	I {
		public String toString() {
	          return "1.";
	      }
	},
	
	II {
		public String toString() {
	          return "2.";
	      }
	},
	III {
		public String toString() {
	          return "3.";
	      }
	},
	IV {
		public String toString() {
	          return "4.";
	      }
	},
	V {
		public String toString() {
	          return "5.";
	      }
	};
	
	public static int getGodinaStudiranja(GodinaStudiranja g)
	{
		int retval = 5;
		if (g == GodinaStudiranja.I)
			retval = 1;
		else if (g == GodinaStudiranja.II)
			retval = 2;
		else if (g == GodinaStudiranja.III)
			retval = 3;
		else if (g == GodinaStudiranja.IV)
			retval = 4;
		
		return retval;
	}
	
	
	
	

}
