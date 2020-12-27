package rs.ac.uns.student.model;

public enum StudentStatus {
	B {
		public String toString() {
	          return "Budžet";
	      }
	},
	
	S {
		public String toString() {
	          return "Samofinansiranje";
	      }
	}
}
