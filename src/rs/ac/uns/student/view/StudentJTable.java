package rs.ac.uns.student.view;

import java.awt.Color;
import java.awt.Component;
import java.util.Arrays;
import java.util.List;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.RowFilter;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableRowSorter;

public class StudentJTable extends JTable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7500908696013392259L;
	private TableRowSorter<AbstractTableModelStudent> sorter;

	public StudentJTable() {
		this.setRowSelectionAllowed(true);
		this.setColumnSelectionAllowed(true);
		this.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		this.setModel(new AbstractTableModelStudent());
		this.setAutoCreateRowSorter(true);
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
	
	

}
