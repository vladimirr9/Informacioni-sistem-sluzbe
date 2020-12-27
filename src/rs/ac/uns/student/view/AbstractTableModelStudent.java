package rs.ac.uns.student.view;

import javax.swing.table.AbstractTableModel;

import rs.ac.uns.student.model.BazaStudent;

public class AbstractTableModelStudent extends AbstractTableModel {

	@Override
	public int getRowCount() {
		return BazaStudent.getInstance().getStudenti().size();
	}

	@Override
	public int getColumnCount() {
		return BazaStudent.getInstance().getColumnCount();
	}
	public String getColumnName(int column) {
		return BazaStudent.getInstance().getColumnName(column);
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		return BazaStudent.getInstance().getValueAt(rowIndex, columnIndex);
	}

}
