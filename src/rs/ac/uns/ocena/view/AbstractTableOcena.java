package rs.ac.uns.ocena.view;

import javax.swing.table.AbstractTableModel;

import rs.ac.uns.MainFrame;
import rs.ac.uns.ocena.model.BazaOcena;
import rs.ac.uns.student.model.BazaStudent;
import rs.ac.uns.student.model.Student;
import rs.ac.uns.student.view.StudentJTable;

public class AbstractTableOcena extends AbstractTableModel {

	public AbstractTableOcena(){}
	@Override
	public int getRowCount() {
		int row = MainFrame.getInstance().getTabelaStudent().convertRowIndexToModel(MainFrame.getInstance().getTabelaStudent().getSelectedRow());
		Student s=BazaStudent.getInstance().findStudentByRow(row);
		int brojPredmeta=s.getPolozeniIspiti().size();
		return brojPredmeta;
	}

	@Override
	public int getColumnCount() {
		return BazaOcena.getInstance().getNumberOfColumns();
		
	}
	@Override
	public String getColumnName(int column) {
		return BazaOcena.getInstance().getColumnName(column);
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		int row = MainFrame.getInstance().getTabelaStudent().convertRowIndexToModel(MainFrame.getInstance().getTabelaStudent().getSelectedRow());
		return BazaOcena.getInstance().getValueAt(rowIndex,columnIndex,BazaStudent.getInstance().findStudentByRow(row).getBrojIndeksa());
	}

}
