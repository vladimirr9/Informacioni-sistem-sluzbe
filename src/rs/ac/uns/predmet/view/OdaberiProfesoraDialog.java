package rs.ac.uns.predmet.view;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

import rs.ac.uns.profesor.model.BazaProfesora;
import rs.ac.uns.profesor.model.Profesor;

public class OdaberiProfesoraDialog extends JDialog {

	private JList<String> list;
	
	public OdaberiProfesoraDialog(PredmetInformacijeTab parent) {
		setModal(true);
		setTitle("Odaberi profesora");
		setSize(400,400);
		setLocationRelativeTo(parent);
		GridBagLayout gb=new GridBagLayout();
		setLayout(gb);
		GridBagConstraints gbc;
		
		DefaultListModel<String> listaVal = new DefaultListModel<>();
		for (Profesor p : BazaProfesora.getInstance().getProfesori()) {
			String naziv = p.getIme() + " " + p.getPrezime();
			listaVal.addElement(naziv);
		}
		list = new JList<>(listaVal);
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		JScrollPane scroll = new JScrollPane(list);
		
		gbc=new GridBagConstraints(0, 0, 2,2 , 100, 100, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(20, 15, 30, 15), 0, 0);
		this.add(scroll,gbc);
		
		JButton btnPotvrdi=new JButton("Potvrdi");
		gbc=new GridBagConstraints(0, 10, 1, 1, 0, 0, GridBagConstraints.EAST, GridBagConstraints.NONE, new Insets(20, 20, 20, 0), 0, 0);
		this.add(btnPotvrdi,gbc);
		if (BazaProfesora.getInstance().getProfesori().isEmpty()) {
			btnPotvrdi.setEnabled(false);
		}
		
		JButton btnOdustani=new JButton("Odustani");
		gbc=new GridBagConstraints(1, 10, 1, 1, 0, 0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(20, 30, 20, 0), 0, 0);
		this.add(btnOdustani,gbc);
		
		

		
		
		btnPotvrdi.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (list.getSelectedIndex() != -1)
				{
					Profesor tekProf;
					tekProf=BazaProfesora.getInstance().getProfesori()
							.get(list.getSelectedIndex());
					parent.setTekuciProfesor(tekProf);
					String textVal = tekProf.getIme() + " " + tekProf.getPrezime();
					parent.getTxtField4().setText(textVal);
					parent.getPlus().setEnabled(false);
					dispose();
				}

			}

		});
		btnOdustani.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				dispose();

			}

		});
		
	}
}