package rs.ac.uns.student.view;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.regex.Pattern;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import rs.ac.uns.MainFrame;
import rs.ac.uns.student.controller.StudentController;
import rs.ac.uns.student.model.BazaStudent;
import rs.ac.uns.student.model.GodinaStudiranja;
import rs.ac.uns.student.model.Student;
import rs.ac.uns.student.model.StudentStatus;

public class InformacijeTab extends JPanel {
	
	DateFormat format;
	
	private JTextField txtField1;
	private JTextField txtField2;
	private JTextField txtField3;
	private JTextField txtField4;
	private JTextField txtField5;
	private JTextField txtField6;
	private JTextField txtField7;
	private JTextField txtField8;
	private JButton btnPotvrdi;
	private Student student;
	
	
	public InformacijeTab(int row) {
		super();
		InformacijeTab si =this;
		
		//int row = MainFrame.getInstance().getTabelaStudent().convertRowIndexToModel(MainFrame.getInstance().getTabelaStudent().getSelectedRow());
		//System.out.println(row);
		student = BazaStudent.getInstance().getRow(row);
		
		GridBagLayout gb=new GridBagLayout();
		setLayout(gb);
		GridBagConstraints gbc;
		
		
		class MyDocListener implements DocumentListener
		  {
			
		 
		

			@Override
			public void changedUpdate(DocumentEvent arg0) {
				// TODO Auto-generated method stub
				provera();
			}


			@Override
			public void insertUpdate(DocumentEvent arg0) {
				// TODO Auto-generated method stub
				provera();
			}

			@Override
			public void removeUpdate(DocumentEvent arg0) {
				// TODO Auto-generated method stub
				provera();
			}
		 
		  }
		
		
		DocumentListener myDocumentListener=new MyDocListener();
		
		gbc=new GridBagConstraints(0, 0, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0);
		JLabel label1 = new JLabel("Ime*");
		this.add(label1,gbc);
		
		txtField1=new JTextField();
		txtField1.setText(student.getIme());
		gbc=new GridBagConstraints(1, 0, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(5, 30, 0, 0), 225, 0);
		this.add(txtField1,gbc);
		txtField1.getDocument().addDocumentListener(myDocumentListener);
		
		gbc=new GridBagConstraints(0, 1, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0);
		JLabel label2 = new JLabel("Prezime*");
		this.add(label2,gbc);
		
		txtField2 = new JTextField();
		txtField2.setText(student.getPrezime());
		gbc=new GridBagConstraints(1, 1, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(5, 30, 0, 0), 225, 0);
		this.add(txtField2,gbc);
		txtField2.getDocument().addDocumentListener(myDocumentListener);
		
		gbc=new GridBagConstraints(0, 2, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0);
		JLabel label3=new JLabel("Datum rođenja*");
		this.add(label3,gbc);
		
		txtField3=new JTextField();
		txtField3.setToolTipText("dd.mm.yyyy.");
		format = new SimpleDateFormat("dd.MM.yyyy.");
		txtField3.setText(format.format(student.getDatumRodjenja()));
		gbc=new GridBagConstraints(1, 2, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(5, 30, 0, 0), 225, 0);
		this.add(txtField3,gbc);
		txtField3.getDocument().addDocumentListener(myDocumentListener);
		

		gbc=new GridBagConstraints(0, 3, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0);
		JLabel label4=new JLabel("Adresa stanovanja*");
		this.add(label4,gbc);
		
		txtField4=new JTextField();
		txtField4.setToolTipText("ulica broj, grad");
		txtField4.setText(student.getAdresaStanovanja());
		gbc=new GridBagConstraints(1, 3, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(5, 30, 0, 0), 225, 0);
		this.add(txtField4,gbc);
		txtField4.getDocument().addDocumentListener(myDocumentListener);
		
		gbc=new GridBagConstraints(0, 4, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0);
		JLabel label5=new JLabel("Broj telefona*");
		this.add(label5,gbc);
		
		txtField5=new JTextField();
		txtField5.setText(student.getKontaktTelefon());
		gbc=new GridBagConstraints(1, 4, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(5, 30, 0, 0), 225, 0);
		this.add(txtField5,gbc);
		txtField5.getDocument().addDocumentListener(myDocumentListener);
		
		gbc=new GridBagConstraints(0, 5, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0);
		JLabel label6=new JLabel("E-mail adresa*");
		this.add(label6,gbc);
		
		txtField6=new JTextField();
		txtField6.setText(student.getEmailAdresa());
		gbc=new GridBagConstraints(1, 5, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(5, 30, 0, 0), 225, 0);
		this.add(txtField6,gbc);
		txtField6.getDocument().addDocumentListener(myDocumentListener);
		
		gbc=new GridBagConstraints(0, 6, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0);
		JLabel label7=new JLabel("Broj indeksa*");
		this.add(label7,gbc);
		
		txtField7=new JTextField();
		txtField7.setText(student.getBrojIndeksa());
		gbc=new GridBagConstraints(1, 6, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(5, 30, 0, 0), 225, 0);
		this.add(txtField7,gbc);
		txtField7.getDocument().addDocumentListener(myDocumentListener);
		
		gbc=new GridBagConstraints(0, 7, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0);
		JLabel label8=new JLabel("Godina upisa*");
		this.add(label8,gbc);
		
		txtField8=new JTextField();
		txtField8.setText(String.valueOf(student.getGodinaUpisa()));
		gbc=new GridBagConstraints(1, 7, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(5, 30, 0, 0), 225, 0);
		this.add(txtField8,gbc);
		txtField8.getDocument().addDocumentListener(myDocumentListener);
		
		gbc=new GridBagConstraints(0, 8, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0);
		JLabel label9=new JLabel("Trenutna godina studija*");
		this.add(label9,gbc);
		
	
		ArrayList<String> valsGS = new ArrayList<String>();
		valsGS.add("I (prva)");
		valsGS.add("II (druga)");
		valsGS.add("III (treća)");
		valsGS.add("IV (četvrta)");
		valsGS.add("V (peta)");
		final JComboBox<String> combo = new JComboBox(valsGS.toArray()) ;
		gbc=new GridBagConstraints(1, 8, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(5, 30, 0, 0), 112, 0);
		if (student.getTrenutnaGodinaStudija() == GodinaStudiranja.I)
			combo.setSelectedIndex(0);
		else if (student.getTrenutnaGodinaStudija() == GodinaStudiranja.II)
			combo.setSelectedIndex(1);
		else if (student.getTrenutnaGodinaStudija() == GodinaStudiranja.III)
			combo.setSelectedIndex(2);
		else if (student.getTrenutnaGodinaStudija() == GodinaStudiranja.IV)
			combo.setSelectedIndex(3);
		else combo.setSelectedIndex(4);
		
		this.add(combo,gbc);
		
		
		
		gbc=new GridBagConstraints(0, 9, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0);
		JLabel label10=new JLabel("Način finansiranja*");
		this.add(label10,gbc);
		
		ArrayList<String> valsStatus = new ArrayList<String>();
		valsStatus.add("Budžet");
		valsStatus.add("Samofinansiranje");
		
		
		final JComboBox<String> combo2 = new JComboBox(valsStatus.toArray());
		if (student.getStatus() == StudentStatus.B)
			combo2.setSelectedIndex(0);
		else
			combo2.setSelectedIndex(1);
		gbc=new GridBagConstraints(1, 9, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(5, 30, 0, 0), 70, 0);
		this.add(combo2,gbc);
		
		btnPotvrdi=new JButton("Potvrdi");
		gbc=new GridBagConstraints(0, 10, 1, 1, 0, 0, GridBagConstraints.EAST, GridBagConstraints.NONE, new Insets(5, 0, 0, 0), 0, 0);
		this.add(btnPotvrdi,gbc);
		btnPotvrdi.setEnabled(false);
		
		JButton btnOdustani=new JButton("Odustani");
		gbc=new GridBagConstraints(1, 10, 1, 1, 0, 0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(5, 30, 0, 0), 0, 0);
		this.add(btnOdustani,gbc);
		
		
		btnPotvrdi.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String prezime=txtField2.getText();
				String ime=txtField1.getText();
				Date format;
				try {
					
					String adresaStanovanja=txtField4.getText();
					String brojTelefona=txtField5.getText();
					
					String emailAdresa=txtField6.getText();
					String brojIndeksa=txtField7.getText();
					
					String godinaUpisa=txtField8.getText();
					
					GodinaStudiranja godinaStudiranja;
					if (combo.getSelectedItem().toString().equals("I (prva)"))
						 godinaStudiranja = GodinaStudiranja.I;
					else if (combo.getSelectedItem().toString().equals("II (druga)"))
						 godinaStudiranja = GodinaStudiranja.II;
					else if (combo.getSelectedItem().toString().equals("III (treća)"))
						 godinaStudiranja = GodinaStudiranja.III;
					else if (combo.getSelectedItem().toString().equals("IV (četvrta)"))
						 godinaStudiranja = GodinaStudiranja.IV;
					else godinaStudiranja = GodinaStudiranja.V;
					
					
					boolean postoji = false;
					for (Student s : StudentController.getInstance().getStudenti())
					{
						if (s.getBrojIndeksa().equals(brojIndeksa) && !s.getBrojIndeksa().equals(student.getBrojIndeksa()) )
							postoji = true;
					}
					

					StudentStatus status;
					if (combo2.getSelectedItem().toString().equals("Budžet"))
						status = StudentStatus.B;
					else
						status = StudentStatus.S;
					if(!Pattern.matches("([a-zA-ZšđčćžŠĐČĆŽ]+[\\s]*)+", ime)) {
						JOptionPane.showMessageDialog(null, "Neispravno uneto ime!");
					} 
					else if(!Pattern.matches("([a-zA-ZšđčćžŠĐČĆŽ]+[\\s]*)+", prezime)) {
						JOptionPane.showMessageDialog(null, "Neispravno uneto prezime!");
					} 
					else if(!Pattern.matches("[0-9]{1,2}[.][0-9]{1,2}[.][0-9]{4}[.]", txtField3.getText())) {
						JOptionPane.showMessageDialog(null, "Neispravan datum!\n Format: dd.mm.yyyy.");
					} else if(!Pattern.matches("([\\wšđčćžŠĐČĆŽ]+[\\s]+)+[0-9]+[\\s]*,[\\s]*([\\wšđčćžŠĐČĆŽ]+[\\s]*)+", adresaStanovanja)) {
						JOptionPane.showMessageDialog(null, "Neispravno uneta adresa stanovanja!\n Format: ulica broj, grad");
					} else if(!Pattern.matches("[+]?[0-9]+", brojTelefona)) {
						JOptionPane.showMessageDialog(null, "Neispravno unet broj telefona!");
					} else if(!Pattern.matches("^(.+)@(.+)$", emailAdresa)) {
						JOptionPane.showMessageDialog(null, "Neispravno uneta email adresa!");
					} else if (postoji) {
						JOptionPane.showMessageDialog(null, "Broj indeksa već postoji!");
					}
						else if(!Pattern.matches("[0-9]{4}", godinaUpisa)) {
						JOptionPane.showMessageDialog(null, "Neispravno uneta godina upisa!");
					} else {
					format = new SimpleDateFormat("dd.MM.yyyy.").parse(txtField3.getText());
					
					
					StudentController.getInstance().editStudent(prezime, ime, format, adresaStanovanja, brojTelefona, emailAdresa, brojIndeksa, Integer.parseInt(godinaUpisa), godinaStudiranja, status, row);
					provera();
					}
				} catch (ParseException e1) {
					e1.printStackTrace();
				}
				
		
			}
		});
		btnOdustani.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JDialog parent1 = (JDialog) SwingUtilities.getWindowAncestor(si);
			    parent1.dispose();
				
			}
		});
		
		
	}
	
	public void provera() {
		String prezime=txtField2.getText();
		String ime=txtField1.getText();
		String adresaStanovanja=txtField4.getText();
		String brojTelefona=txtField5.getText();
		
		String emailAdresa=txtField6.getText();
		String brojIndeksa=txtField7.getText();
		
		//int godinaUpisa=Integer.parseInt(txtField8.getText());
		boolean postoji = false;
		for (Student s : StudentController.getInstance().getStudenti())
		{
			if (s.getBrojIndeksa().equals(brojIndeksa) && !s.getBrojIndeksa().equals(student.getBrojIndeksa()))
				postoji = true;
		}
		
		if((Pattern.matches("([a-zA-ZšđčćžŠĐČĆŽ]+[\\s]*)+", ime)) 
			&& (Pattern.matches("([a-zA-ZšđčćžŠĐČĆŽ]+[\\s]*)+", prezime))
			&&(Pattern.matches("[0-9]{1,2}[.][0-9]{1,2}[.][0-9]{4}[.]", txtField3.getText()))
			&&(Pattern.matches("([\\wšđčćžŠĐČĆŽ]+[\\s]+)+[0-9]+[\\s]*,[\\s]*([\\wšđčćžŠĐČĆŽ]+[\\s]*)+", adresaStanovanja))
			&&(Pattern.matches("[0-9]{3}[/][0-9]+[-][0-9]+", brojTelefona))
			&&(Pattern.matches("^(.+)@(.+)$", emailAdresa))
			&&(Pattern.matches("[0-9]{4}", txtField8.getText())) && !postoji)
		{
			btnPotvrdi.setEnabled(true);
		}else {
			btnPotvrdi.setEnabled(false);
		}
	}

}
