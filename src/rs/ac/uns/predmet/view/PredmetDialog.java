package rs.ac.uns.predmet.view;

import java.awt.Frame;
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
import javax.swing.JTextField;

import rs.ac.uns.predmet.controller.PredmetController;
import rs.ac.uns.predmet.model.Predmet;
import rs.ac.uns.predmet.model.PredmetGodina;
import rs.ac.uns.predmet.model.PredmetSemestar;
import rs.ac.uns.student.controller.StudentController;
import rs.ac.uns.student.model.GodinaStudiranja;
import rs.ac.uns.student.model.Student;
import rs.ac.uns.student.model.StudentStatus;

public class PredmetDialog extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6093839239688325639L;

	public PredmetDialog(Frame parent, String title, boolean modal) {
		
		super(parent, title, modal);
		
		setSize(600, 300);
		setLocationRelativeTo(parent);
		
		
		GridBagLayout gb=new GridBagLayout();
		setLayout(gb);
		GridBagConstraints gbc;
		
		gbc=new GridBagConstraints(0, 0, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0);
		JLabel label1 = new JLabel("Šifra Predmeta*");
		this.add(label1,gbc);
		
		JTextField txtField1=new JTextField();
		gbc=new GridBagConstraints(1, 0, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(5, 30, 0, 0), 225, 0);
		this.add(txtField1,gbc);
		
		gbc=new GridBagConstraints(0, 1, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0);
		JLabel label2 = new JLabel("Naziv Predmeta*");
		this.add(label2,gbc);
		
		JTextField txtField2 = new JTextField();
		gbc=new GridBagConstraints(1, 1, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(5, 30, 0, 0), 225, 0);
		this.add(txtField2,gbc);
		
		gbc=new GridBagConstraints(0, 2, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0);
		JLabel label3=new JLabel("Broj ESPB bodova*");
		this.add(label3,gbc);
		
		JTextField txtField3=new JTextField();
		gbc=new GridBagConstraints(1, 2, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(5, 30, 0, 0), 225, 0);
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
		gbc=new GridBagConstraints(1, 3, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(5, 30, 0, 0), 112, 0);
		this.add(combo,gbc);
		
		
		gbc=new GridBagConstraints(0, 4, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0);
		JLabel label5=new JLabel("Semestar u kome se predmet izvodi*");
		this.add(label5,gbc);
		
		ArrayList<String> valsStatus = new ArrayList<String>();
		valsStatus.add("Letnji");
		valsStatus.add("Zimski");
		
		
		final JComboBox<String> combo2 = new JComboBox(valsStatus.toArray());
		gbc=new GridBagConstraints(1, 4, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(5, 30, 0, 0), 70, 0);
		this.add(combo2,gbc);
		
		
		
		JButton jbtnPotvrdi=new JButton("Potvrdi");
		gbc=new GridBagConstraints(0, 10, 1, 1, 0, 0, GridBagConstraints.EAST, GridBagConstraints.NONE, new Insets(5, 0, 0, 0), 0, 0);
		this.add(jbtnPotvrdi,gbc);
		
		JButton jbtnOdustani=new JButton("Odustani");
		gbc=new GridBagConstraints(1, 10, 1, 1, 0, 0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(5, 30, 0, 0), 0, 0);
		this.add(jbtnOdustani,gbc);
		
		jbtnPotvrdi.addActionListener(new ActionListener() {

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
					if (p.getSifra().equals(sifraPredmeta))
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
					PredmetController.getInstance().dodajPredmet(sifraPredmeta, nazivPredmeta, predmetSemestar, predmetGodina, bodovi);
				}
				
				
			}
			
			
			
		
		});
		jbtnOdustani.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				
			}
		});
		
		
	}

}
