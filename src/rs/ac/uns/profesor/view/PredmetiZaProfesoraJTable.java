package rs.ac.uns.profesor.view;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.TableCellRenderer;

import rs.ac.uns.MainFrame;
import rs.ac.uns.profesor.controller.ProfesorController;
import rs.ac.uns.profesor.model.Profesor;


public class PredmetiZaProfesoraJTable extends JTable{
	
	public PredmetiZaProfesoraJTable() {
		this.setRowSelectionAllowed(true);
		this.setColumnSelectionAllowed(true);
		this.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		int row=MainFrame.getInstance().getTabelaProfesora().convertRowIndexToModel(MainFrame.getInstance().getTabelaProfesora().getSelectedRow());
		Profesor p=ProfesorController.getInstance().getProfesor(row);
		this.setModel(new AbstractTableModelPredmetiZaProfesora(p));
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
		AbstractTableModelPredmetiZaProfesora model = (AbstractTableModelPredmetiZaProfesora) this.getModel();
		model.fireTableDataChanged();
	}
}
