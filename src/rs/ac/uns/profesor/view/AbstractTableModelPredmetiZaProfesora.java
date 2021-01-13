package rs.ac.uns.profesor.view;

import javax.swing.table.AbstractTableModel;


import rs.ac.uns.predmet.model.BazaPredmetiZaProfesora;
import rs.ac.uns.profesor.model.Profesor;
import rs.ac.uns.student.model.Student;

public class AbstractTableModelPredmetiZaProfesora extends AbstractTableModel {
	
	BazaPredmetiZaProfesora bazaPredmetiZaProfesora;
	 public AbstractTableModelPredmetiZaProfesora(Profesor p) {
		bazaPredmetiZaProfesora=new BazaPredmetiZaProfesora(p);
	}
	@Override
	public int getColumnCount() {
		return bazaPredmetiZaProfesora.getColumnCount();
	}

	@Override
	public int getRowCount() {
		return bazaPredmetiZaProfesora.getPredmeti().size();
	}
	
	public String getColumnName(int column) {
		return bazaPredmetiZaProfesora.getColumnName(column);
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		return bazaPredmetiZaProfesora.getValueAt(rowIndex, columnIndex);
	}

}
