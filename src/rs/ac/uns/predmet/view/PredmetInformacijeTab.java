package rs.ac.uns.predmet.view;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.regex.Pattern;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import rs.ac.uns.MainFrame;
import rs.ac.uns.predmet.controller.PredmetController;
import rs.ac.uns.predmet.model.BazaPredmeta;
import rs.ac.uns.predmet.model.Predmet;
import rs.ac.uns.predmet.model.PredmetGodina;
import rs.ac.uns.predmet.model.PredmetSemestar;
import rs.ac.uns.profesor.model.Profesor;
import rs.ac.uns.student.controller.StudentController;




public class PredmetInformacijeTab  extends JPanel {
	
	private static Profesor tekuciProfesor;
	private static Profesor profesor;
	private PredmetInformacijeTab pt;
	private JTextField txtField4; //za profesora
	private JButton plus;
	
	public PredmetInformacijeTab()
	{
		super();
		
		
		//setSize(600, 300);
		PredmetInformacijeTab pi =this;
		
		int row = MainFrame.getInstance().getTabelaPredmeta().convertRowIndexToModel(MainFrame.getInstance().getTabelaPredmeta().getSelectedRow());
		Predmet predmet = BazaPredmeta.getInstance().getRow(row);
		profesor = predmet.getProfesor();
		
		GridBagLayout gb=new GridBagLayout();
		setLayout(gb);
		GridBagConstraints gbc;
		
		gbc=new GridBagConstraints(0, 0, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0);
		JLabel label1 = new JLabel("Šifra Predmeta*");
		this.add(label1,gbc);
		
		JTextField txtField1=new JTextField();
		txtField1.setText(predmet.getSifra());
		gbc=new GridBagConstraints(1, 0, 3, 1, 100, 0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(5, 30, 0, 10), 225, 0);
		this.add(txtField1,gbc);
		
		gbc=new GridBagConstraints(0, 1, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0);
		JLabel label2 = new JLabel("Naziv Predmeta*");
		this.add(label2,gbc);
		
		JTextField txtField2 = new JTextField();
		txtField2.setText(predmet.getNaziv());
		gbc=new GridBagConstraints(1, 1, 3, 1, 100, 0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(5, 30, 0, 10), 225, 0);
		this.add(txtField2,gbc);
		
		gbc=new GridBagConstraints(0, 2, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0);
		JLabel label3=new JLabel("Broj ESPB bodova*");
		this.add(label3,gbc);
		
		JTextField txtField3=new JTextField();
		txtField3.setText(String.valueOf(predmet.getBodovi()));
		gbc=new GridBagConstraints(1, 2, 3, 1, 100, 0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(5, 30, 0, 10), 225, 0);
		this.add(txtField3,gbc);
		
		gbc=new GridBagConstraints(0, 3, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0);
		JLabel label4=new JLabel("Godina na kojoj se predmet izvodi*");
		this.add(label4,gbc);
		
		ArrayList<String> valsPGS = new ArrayList<String>();
		valsPGS.add("I (prva)");
		valsPGS.add("II (druga)");
		valsPGS.add("III (treća)");
		valsPGS.add("IV (četvrta)");
		valsPGS.add("V (peta)");
		final JComboBox<String> combo = new JComboBox(valsPGS.toArray()) ;
		gbc=new GridBagConstraints(1, 3, 3, 1, 100, 0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(5, 30, 0, 10), 112, 0);
		this.add(combo,gbc);
		
		if (predmet.getGodina().toString().equals("I (prva)"))
			combo.setSelectedIndex(0);
		else if (predmet.getGodina().toString().equals("II (druga)"))
			combo.setSelectedIndex(1);
		else if (predmet.getGodina().toString().equals("III (treća)"))
			combo.setSelectedIndex(2);
		else if (predmet.getGodina().toString().equals("IV (četvrta)"))
			combo.setSelectedIndex(3);
		else combo.setSelectedIndex(4);
		
		//this.add(combo,gbc);
		
		gbc=new GridBagConstraints(0, 4, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0);
		JLabel label5=new JLabel("Semestar u kome se predmet izvodi*");
		this.add(label5,gbc);
		
		ArrayList<String> valsStatus = new ArrayList<String>();
		valsStatus.add("Letnji");
		valsStatus.add("Zimski");
		
		
		final JComboBox<String> combo2 = new JComboBox(valsStatus.toArray());
		gbc=new GridBagConstraints(1, 4, 3, 1, 100, 0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(5, 30, 0, 10), 70, 0);
		this.add(combo2,gbc);
		
		if (predmet.getSemestar().toString().equals("Letnji"))
			combo2.setSelectedIndex(0);
		else
			combo2.setSelectedIndex(1);
		
		
		gbc=new GridBagConstraints(0, 5, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(5, 30, 0, 0), 70, 0);
		JLabel label6=new JLabel("Profesor*");
		this.add(label6,gbc);
		
		txtField4=new JTextField();
		gbc=new GridBagConstraints(1, 5, 1, 1, 100, 0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(5, 30, 0, 10), 225, 0);
		this.add(txtField4,gbc);
		txtField4.setEnabled(false);
		
		
		plus=new JButton("+");
		gbc=new GridBagConstraints(2, 5, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(5, 10, 0, 10), 0, 0);
		this.add(plus,gbc);
		JButton minus=new JButton("-");
		gbc=new GridBagConstraints(3, 5, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(5, 10, 0, 10), 0, 0);
		this.add(minus,gbc);
		if (profesor == null) {
			plus.setEnabled(true);
			minus.setEnabled(false);
		} else {
			plus.setEnabled(false);
			minus.setEnabled(true);
			txtField4.setText(predmet.getProfesor().getIme() + " " + predmet.getProfesor().getPrezime());
		}
		
		JButton btnPotvrdi=new JButton("Potvrdi");
		gbc=new GridBagConstraints(0, 10, 1, 1, 0, 0, GridBagConstraints.EAST, GridBagConstraints.NONE, new Insets(20, 0, 0, 0), 0, 0);
		this.add(btnPotvrdi,gbc);
		
		JButton btnOdustani=new JButton("Odustani");
		gbc=new GridBagConstraints(1, 10, 1, 1, 0, 0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(20, 30, 0, 0), 0, 0);
		this.add(btnOdustani,gbc);
		
		btnPotvrdi.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				String sifraPredmeta = txtField1.getText();
				String nazivPredmeta = txtField2.getText();
				String bodoviStr = txtField3.getText();
				
				PredmetGodina predmetGodina;
				
				if (combo.getSelectedItem().toString().equals("I (prva)"))
					 predmetGodina = PredmetGodina.PRVA;
				else if (combo.getSelectedItem().toString().equals("II (druga)"))
					predmetGodina = PredmetGodina.DRUGA;
				else if (combo.getSelectedItem().toString().equals("III (treća)"))
					predmetGodina = PredmetGodina.TRECA;
				else if (combo.getSelectedItem().toString().equals("IV (četvrta)"))
					predmetGodina = PredmetGodina.CETVRTA;
				else predmetGodina = PredmetGodina.PETA;
				
				
				
				boolean postoji = false;
				for (Predmet p : PredmetController.getInstance().getPredmeti())
				{
					if (p.getSifra().equals(sifraPredmeta) && !p.getSifra().equals(predmet.getSifra()))
						postoji = true;
				}
				PredmetSemestar predmetSemestar;
				if (combo2.getSelectedItem().toString().equals("Zimski"))
					 predmetSemestar = PredmetSemestar.ZIMSKI;
				else
					predmetSemestar = PredmetSemestar.LETNJI;
				
				 if(!Pattern.matches("[0-9]+", bodoviStr)) {
					JOptionPane.showMessageDialog(null, "Neispravno unet broj bodova!");
				} else if (postoji) {
					JOptionPane.showMessageDialog(null, "Predmet sa tom šifrom već postoji!");
				} else {
					
					int bodovi = Integer.parseInt(bodoviStr);
					PredmetController.getInstance().editPredmet(sifraPredmeta, nazivPredmeta, predmetSemestar, predmetGodina, bodovi, row);
					predmet.setProfesor(tekuciProfesor);
					if (tekuciProfesor != null && tekuciProfesor != profesor) {
						tekuciProfesor.getPredmeti().add(predmet);
					}
					if (tekuciProfesor == null && profesor != null) {
						profesor.getPredmeti().remove(predmet);
					}
				}
				
				
			}
			
			
			
		
		});
		btnOdustani.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JDialog parent1 = (JDialog) SwingUtilities.getWindowAncestor(pi);
			    parent1.dispose();
				
			}
		});
		
		
		
		plus.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				OdaberiProfesoraDialog opd = new OdaberiProfesoraDialog(pi);
				opd.setVisible(true);
				minus.setEnabled(true);

			}

		});
		
		
		
		
	}

	public JTextField getTxtField4() {
		return txtField4;
	}

	public JButton getPlus() {
		return plus;
	}

	public void setTekuciProfesor(Profesor tekProf) {
		tekuciProfesor = tekProf;
		
	}
	

}
