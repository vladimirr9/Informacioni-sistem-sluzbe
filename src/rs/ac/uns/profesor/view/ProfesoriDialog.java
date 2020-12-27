package rs.ac.uns.profesor.view;

import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Pattern;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import rs.ac.uns.profesor.controller.ProfesorController;
import rs.ac.uns.profesor.model.Profesor;
import rs.ac.uns.profesor.model.ProfesorTitula;
import rs.ac.uns.profesor.model.ProfesorZvanje;

public class ProfesoriDialog extends JDialog {
	public ProfesoriDialog(Frame parent, String title, boolean modal) {
		super(parent, title, modal);

		setSize(400, 400);
		setLocationRelativeTo(parent);
		
		GridBagLayout gb=new GridBagLayout();
		setLayout(gb);
		
		GridBagConstraints gbc=new GridBagConstraints(0, 0, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0);
		JLabel label2=new JLabel("Prezime*");
		this.add(label2,gbc);
		
		JTextField txtField1=new JTextField();
		gbc=new GridBagConstraints(1, 0, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(5, 30, 0, 0), 225, 0);
		this.add(txtField1,gbc);
		
		gbc=new GridBagConstraints(0, 1, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0);
		JLabel label1=new JLabel("Ime*");
		this.add(label1,gbc);
		
		JTextField txtField2=new JTextField();
		gbc=new GridBagConstraints(1, 1, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(5, 30, 0, 0), 225, 0);
		this.add(txtField2,gbc);
		
		gbc=new GridBagConstraints(0, 2, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0);
		JLabel label3=new JLabel("Datum rodjenja*");
		this.add(label3,gbc);
		
		JTextField txtField3=new JTextField();
		txtField3.setToolTipText("dd/mm/yyyy");
		gbc=new GridBagConstraints(1, 2, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(5, 30, 0, 0), 225, 0);
		this.add(txtField3,gbc);
		
		gbc=new GridBagConstraints(0, 3, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0);
		JLabel label4=new JLabel("Adresa stanovanja*");
		this.add(label4,gbc);
		
		JTextField txtField4=new JTextField();
		txtField4.setToolTipText("ulica broj, grad");
		gbc=new GridBagConstraints(1, 3, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(5, 30, 0, 0), 225, 0);
		this.add(txtField4,gbc);
		
		gbc=new GridBagConstraints(0, 4, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0);
		JLabel label5=new JLabel("Kontakt telefon*");
		this.add(label5,gbc);
		
		JTextField txtField5=new JTextField();
		gbc=new GridBagConstraints(1, 4, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(5, 30, 0, 0), 225, 0);
		this.add(txtField5,gbc);
		
		gbc=new GridBagConstraints(0, 5, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0);
		JLabel label6=new JLabel("E-mail adresa*");
		this.add(label6,gbc);
		
		JTextField txtField6=new JTextField();
		gbc=new GridBagConstraints(1, 5, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(5, 30, 0, 0), 225, 0);
		this.add(txtField6,gbc);
		
		gbc=new GridBagConstraints(0, 6, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0);
		JLabel label7=new JLabel("Adresa kancelarije*");
		this.add(label7,gbc);
		
		JTextField txtField7=new JTextField();
		txtField7.setToolTipText("ulica broj, grad");
		gbc=new GridBagConstraints(1, 6, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(5, 30, 0, 0), 225, 0);
		this.add(txtField7,gbc);
		
		gbc=new GridBagConstraints(0, 7, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0);
		JLabel label8=new JLabel("Broj lične karte*");
		this.add(label8,gbc);
		
		JTextField txtField8=new JTextField();
		gbc=new GridBagConstraints(1, 7, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(5, 30, 0, 0), 225, 0);
		this.add(txtField8,gbc);
		
		gbc=new GridBagConstraints(0, 8, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0);
		JLabel label9=new JLabel("Titula*");
		this.add(label9,gbc);
		
	
		final JComboBox<String> combo = new JComboBox(ProfesorTitula.values());
		gbc=new GridBagConstraints(1, 8, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(5, 30, 0, 0), 112, 0);
		this.add(combo,gbc);
		
		gbc=new GridBagConstraints(0, 9, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0);
		JLabel label10=new JLabel("Zvanje*");
		this.add(label10,gbc);
		
		
		final JComboBox<String> combo2 = new JComboBox(ProfesorZvanje.values());
		gbc=new GridBagConstraints(1, 9, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(5, 30, 0, 0), 70, 0);
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
				String getPrezime=txtField1.getText();
				String getIme=txtField2.getText();
				Date format;
				try {
					
					String getAdresaStanovanja=txtField4.getText();
					String getKontaktTelefon=txtField5.getText();
					
					String getEmailAdresa=txtField6.getText();
					String getAdresaKancelarije=txtField7.getText();
					
					String getBrojLicneKarte=txtField8.getText();
					ProfesorTitula getTitula=(ProfesorTitula) combo.getSelectedItem();
					ProfesorZvanje getZvanje=(ProfesorZvanje) combo2.getSelectedItem();
					if(!Pattern.matches("[a-zA-Z]+", getPrezime)) {
						JOptionPane.showMessageDialog(null, "Neispravno prezime!");
					} 
					else if(!Pattern.matches("[a-zA-Z]+", getIme)) {
						JOptionPane.showMessageDialog(null, "Neispravno ime!");
					} 
					else if(!Pattern.matches("[0-9]{1,2}/[0-9]{1,2}/[0-9]{4}", txtField3.getText())) {
						JOptionPane.showMessageDialog(null, "Neispravan datum!");
					} else if(!Pattern.matches("([\\w]+[\\s]+)+[0-9]+[\\s]*,[\\s]*([\\w]+[\\s]*)+", getAdresaStanovanja)) {
						JOptionPane.showMessageDialog(null, "Neispravna adresa stanovanja!");
					} else if(!Pattern.matches("[0-9]+", getKontaktTelefon)) {
						JOptionPane.showMessageDialog(null, "Neispravan kontakt telefon!");
					} else if(!Pattern.matches("^(.+)@(.+)$", getEmailAdresa)) {
						JOptionPane.showMessageDialog(null, "Neispravna email adresa!");
					} else if(!Pattern.matches("([\\w]+[\\s]+)+[0-9]+[\\s]*,[\\s]*([\\w]+[\\s]*)+", getAdresaKancelarije)) {
						JOptionPane.showMessageDialog(null, "Neispravna adresa kancelarije!");
					} else if(!Pattern.matches("[0-9]{9}", getBrojLicneKarte)) {
						JOptionPane.showMessageDialog(null, "Neispravan broj lične karte!");
					} else {
					format = new SimpleDateFormat("dd/MM/yyyy").parse(txtField3.getText());
					ProfesorController.getInstance().dodajProfesora(getPrezime,getIme,format,getAdresaStanovanja,getKontaktTelefon,getEmailAdresa,getAdresaKancelarije,getBrojLicneKarte,getTitula,getZvanje);
					}
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
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
