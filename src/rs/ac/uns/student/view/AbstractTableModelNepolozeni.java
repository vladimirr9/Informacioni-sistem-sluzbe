package rs.ac.uns.student.view;

import javax.swing.table.AbstractTableModel;

import rs.ac.uns.predmet.model.BazaNepolozenih;
import rs.ac.uns.predmet.model.BazaPredmeta;
import rs.ac.uns.student.model.Student;

public class AbstractTableModelNepolozeni extends AbstractTableModel {
	
	BazaNepolozenih bazaNepolozenih;
	 public AbstractTableModelNepolozeni(Student s) {
		bazaNepolozenih=new BazaNepolozenih(s);
	}
	@Override
	public int getColumnCount() {
		return bazaNepolozenih.getColumnCount();
	}

	@Override
	public int getRowCount() {
		return bazaNepolozenih.getPredmeti().size();
	}
	
	public String getColumnName(int column) {
		return bazaNepolozenih.getColumnName(column);
	}
	
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		return bazaNepolozenih.getValueAt(rowIndex, columnIndex);
	}

}
