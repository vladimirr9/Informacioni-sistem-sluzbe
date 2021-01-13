package rs.ac.uns.profesor.model;

public enum ProfesorZvanje {
	SARADNIK_U_NASTAVI {
	      public String toString() {
	          return "Saradnik u nastavi";
	      }
	  },

	  ASISTENT {
	      public String toString() {
	          return "Asistent";
	      }
	  },
	  ASISTENT_SA_DOKTORATOM {
	      public String toString() {
	          return "Asistent sa doktoratom";
	      }
	  },

	  DOCENT {
	      public String toString() {
	          return "Docent";
	      }
	  },
	  VANREDNI_PROFESOR {
	      public String toString() {
	          return "Vanredni profesor";
	      }
	  },
	  REDOVNI_PROFESOR {
	      public String toString() {
	          return "Redovni profesor";
	      }
	  },

	  PROFESOR_EMERITUS {
	      public String toString() {
	          return "Profesor emeritus";
	      }
	  },
	  DEKAN {
	      public String toString() {
	          return "Dekan";
	      }
	  }

	 
}
