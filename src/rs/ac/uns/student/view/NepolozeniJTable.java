package rs.ac.uns.student.view;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.TableCellRenderer;

import rs.ac.uns.MainFrame;
import rs.ac.uns.student.controller.StudentController;
import rs.ac.uns.student.model.Student;


public class NepolozeniJTable extends JTable {
	
	
	
	public NepolozeniJTable() {
		this.setRowSelectionAllowed(true);
		this.setColumnSelectionAllowed(true);
		this.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		int row=MainFrame.getInstance().getTabelaStudent().getSelectedRow();
		Student s=StudentController.getInstance().getStudent(row);
		this.setModel(new AbstractTableModelNepolozeni(s));
		}

	public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
		Component c = super.prepareRenderer(renderer, row, column);
		if (isRowSelected(row)) {
			c.setBackground(Color.LIGHT_GRAY);
		} else {
			c.setBackground(Color.WHITE);
		}
		return c;
	}
	public void azuriraj() {
		AbstractTableModelNepolozeni model = (AbstractTableModelNepolozeni) this.getModel();
		model.fireTableDataChanged();
	}
}
