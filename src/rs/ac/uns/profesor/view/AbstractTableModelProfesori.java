package rs.ac.uns.profesor.view;

import javax.swing.table.AbstractTableModel;

import rs.ac.uns.profesor.model.BazaProfesora;

public class AbstractTableModelProfesori extends AbstractTableModel {

	@Override
	public int getColumnCount() {
		return BazaProfesora.getInstance().getColumnCount();
	}

	@Override
	public int getRowCount() {
		return BazaProfesora.getInstance().getProfesori().size();
	}

	public String getColumnName(int column) {
		return BazaProfesora.getInstance().getColumnName(column);
	}
	
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		return BazaProfesora.getInstance().getValueAt(rowIndex, columnIndex);
	}

}
