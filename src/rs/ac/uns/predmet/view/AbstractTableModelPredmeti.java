package rs.ac.uns.predmet.view;

import javax.swing.table.AbstractTableModel;

import rs.ac.uns.predmet.model.BazaPredmeta;



public class AbstractTableModelPredmeti extends AbstractTableModel{

	@Override
	public int getColumnCount() {
		return BazaPredmeta.getInstance().getColumnCount();
	}

	@Override
	public int getRowCount() {
		return BazaPredmeta.getInstance().getPredmeti().size();
	}
	
	public String getColumnName(int column) {
		return BazaPredmeta.getInstance().getColumnName(column);
	}
	
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		return BazaPredmeta.getInstance().getValueAt(rowIndex, columnIndex);
	}

}
