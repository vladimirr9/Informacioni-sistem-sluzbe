package rs.ac.uns.student.view;

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
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import rs.ac.uns.MainFrame;
import rs.ac.uns.ocena.controller.OcenaController;
import rs.ac.uns.ocena.model.Ocena;
import rs.ac.uns.predmet.model.Predmet;
import rs.ac.uns.profesor.model.ProfesorTitula;
import rs.ac.uns.student.controller.StudentController;
import rs.ac.uns.student.model.BazaStudent;
import rs.ac.uns.student.model.Student;

public class PolaganjeDialog extends JDialog {
	
	private JTextField jtxt1=new JTextField();
	private JButton potvrdi=new JButton("Potvrdi");
	private JTextField jtxt2=new JTextField();
	private JTextField jtxt3=new JTextField();
	private NepolozeniJTable npTable;
	
	public PolaganjeDialog(Frame owner, String title, boolean modal,Student st,NepolozeniTab parent) {
		super(owner, title, modal);
		
		setSize(400, 400);
		setLocationRelativeTo(owner);
		
		npTable=this.npTable;
		
		
		int row1=MainFrame.getInstance().getTabelaStudent().convertRowIndexToModel(MainFrame.getInstance().getTabelaStudent().getSelectedRow());
		//Student st=StudentController.getInstance().getStudent(row1);
		Predmet p=st.getNepolozeniIspiti().get(parent.getNepolozeniJTable().getSelectedRow());
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
		
		GridBagLayout gb=new GridBagLayout();
		setLayout(gb);
		
		GridBagConstraints gbc=new GridBagConstraints(0, 0, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 50, 0), 0, 0);
		JLabel sifra=new JLabel("Šifra*");
		this.add(sifra,gbc);
		
		gbc=new GridBagConstraints(1, 0, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 50, 0), 200, 0);
		jtxt1.setText(p.getSifra());
		jtxt1.setEditable(false);
		this.add(jtxt1,gbc);
		
		
		gbc=new GridBagConstraints(0, 1, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 50, 0), 0, 0);
		JLabel naziv=new JLabel("Naziv*");
		this.add(naziv,gbc);
		
		gbc=new GridBagConstraints(1, 1, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 50, 0), 200, 0);
		jtxt2.setText(p.getNaziv());
		jtxt2.setEditable(false);
		this.add(jtxt2,gbc);
		
		
		gbc=new GridBagConstraints(0, 2, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 50, 0), 0, 0);
		JLabel ocena=new JLabel("Ocena*");
		this.add(ocena,gbc);
		
		gbc=new GridBagConstraints(1, 2, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 50, 0), 160, 0);
		Integer niz[]= {6,7,8,9,10};
		final JComboBox<Integer> combo = new JComboBox<Integer>(niz);
		this.add(combo,gbc);
		
		gbc=new GridBagConstraints(0, 3, 1, 1,0, 0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 50, 0), 0, 0);
		JLabel datum=new JLabel("Datum*");
		this.add(datum,gbc);
		
		gbc=new GridBagConstraints(1, 3, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 50, 0), 200, 0);
		//JTextField jtxt3=new JTextField();
		this.add(jtxt3,gbc);
		jtxt3.getDocument().addDocumentListener(myDocumentListener);
		
		gbc=new GridBagConstraints(0, 4, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0);
		//JButton potvrdi=new JButton("Potvrdi");
		this.add(potvrdi,gbc);
		potvrdi.setEnabled(false);
		
		gbc=new GridBagConstraints(1, 4, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0);
		JButton odustani=new JButton("Odustani");
		this.add(odustani,gbc);
		
		odustani.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				
			}
		});
		
		potvrdi.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				Date format;
				try {
					format = new SimpleDateFormat("dd.MM.yyyy.").parse(jtxt3.getText());
					BazaStudent.getInstance().ukloniPredmet(st.getBrojIndeksa(), parent.getNepolozeniJTable());
					Ocena oc=new Ocena(st,p,(int)combo.getSelectedItem(),format);
					BazaStudent.getInstance().dodajOcenu(st.getBrojIndeksa(), oc);
					OcenaController.getInstance().dodajOcenu(oc);
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		
		
	}
	
	public void provera() {
		if(Pattern.matches("[0-9]{1,2}[.][0-9]{1,2}[.][0-9]{4}[.]", jtxt3.getText())) {
			potvrdi.setEnabled(true);
		}else {
			potvrdi.setEnabled(false);
		}
	}
	
	
}
