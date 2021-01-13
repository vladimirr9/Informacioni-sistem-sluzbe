package rs.ac.uns;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import rs.ac.uns.data.Deserialization;
import rs.ac.uns.data.Serialization;
import rs.ac.uns.ocena.view.AbstractTableOcena;
import rs.ac.uns.ocena.view.OcenaJTable;
import rs.ac.uns.predmet.controller.PredmetController;
import rs.ac.uns.predmet.model.Predmet;
import rs.ac.uns.predmet.view.AbstractTableModelPredmeti;
import rs.ac.uns.predmet.view.PredmetiJTable;
import rs.ac.uns.profesor.controller.ProfesorController;
import rs.ac.uns.profesor.model.Profesor;
import rs.ac.uns.profesor.view.AbstractTableModelProfesori;
import rs.ac.uns.profesor.view.ProfesoriJTable;
import rs.ac.uns.student.controller.StudentController;
import rs.ac.uns.student.model.BazaStudent;
import rs.ac.uns.student.model.Student;
import rs.ac.uns.student.view.AbstractTableModelStudent;
import rs.ac.uns.student.view.StudentJTable;

public class MainFrame extends JFrame{
	
	private JTable tabelaProfesora;
	private JTable tabelaStudent;
	private JTable tabelaPredmeta;
	public static JTabbedPaneMine tabbedPane;
	private static MainFrame instance = null;

	public static MainFrame getInstance() {
		if (instance == null) {
			instance = new MainFrame();
		}
		return instance;
	}
	
	public MainFrame() {
		super();
		Toolkit tk=Toolkit.getDefaultToolkit();
		Dimension dim=tk.getScreenSize();
		setSize(3*dim.width/4,3*dim.height/4);
		setTitle("Studentska Služba");
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(true);
		setVisible(true);
		
		addWindowListener(new WindowListener() {
			
			@Override
			public void windowOpened(WindowEvent e) {
				// TODO Auto-generated method stub
				System.out.println("aaja");
				Deserialization.getInstance().bazaStudenataDeserialization();
				Deserialization.getInstance().bazaProfesoraDeserialization();
				Deserialization.getInstance().bazaPredmetaDeserialization();
				Deserialization.getInstance().bazaOcenaDeserialization();
			}
			@Override
			public void windowIconified(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowDeiconified(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowDeactivated(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowClosing(WindowEvent e) {
				// TODO Auto-generated method stub
				Serialization.getInstance().BazaStudenataSerialization();
				Serialization.getInstance().BazaProfesoraSerialization();
				Serialization.getInstance().BazaPredmetaSerialization();
				Serialization.getInstance().BazaOcenaSerialization();
			}
			
			@Override
			public void windowClosed(WindowEvent e) {
				// TODO Auto-generated method stub
			
			}
			
			@Override
			public void windowActivated(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		MyMenuBar myMenu = new MyMenuBar(this);
		this.setJMenuBar(myMenu);
		StatusBar sBar = new StatusBar();
		this.add(sBar, BorderLayout.SOUTH);
		MyToolbar toolbar=new MyToolbar(this);
		this.add(toolbar,BorderLayout.NORTH);
		
		
		tabelaProfesora = new ProfesoriJTable();
		JScrollPane scrollPane = new JScrollPane(tabelaProfesora);
		tabelaStudent = new StudentJTable();
		JScrollPane scrollPane2 = new JScrollPane(tabelaStudent);
		tabelaPredmeta=new PredmetiJTable();
		JScrollPane scrollPane3=new JScrollPane(tabelaPredmeta);
		
		
		tabbedPane=new JTabbedPaneMine();
		tabbedPane.addTab("Studenti", scrollPane2);
		this.azurirajPrikazStudenta(null, -1);
		tabbedPane.addTab("Profesori", scrollPane);
		this.azurirajPrikazProfesora(null, -1);
		tabbedPane.addTab("Predmeti", scrollPane3);
		this.azurirajPrikazPredmeta(null, -1);
		this.add(tabbedPane,BorderLayout.CENTER);
		
		validate();
	}
	
	public void azurirajPrikazProfesora(String akcija, int vrednost) {
		AbstractTableModelProfesori model = (AbstractTableModelProfesori) tabelaProfesora.getModel();
		model.fireTableDataChanged();
		validate();
	}
	public void azurirajPrikazStudenta(String akcija, int vrednost) {
		AbstractTableModelStudent model = (AbstractTableModelStudent) tabelaStudent.getModel();
		model.fireTableDataChanged();
		validate();
	}
	public void azurirajPrikazPredmeta(String akcija, int vrednost) {
		AbstractTableModelPredmeti model=(AbstractTableModelPredmeti) tabelaPredmeta.getModel();
		model.fireTableDataChanged();
		validate();
	}
	
	public JTable getTabelaProfesora() {
		return tabelaProfesora;
	}
	public JTable getTabelaStudent() {
		return tabelaStudent;
	}
	
	public JTable getTabelaPredmeta() {
		return tabelaPredmeta;
	}
	
	public void azurirajPrikazOcene(String akcija, int vrednost) {
		JTable tabelaOcena=OcenaJTable.getInstance();
		AbstractTableOcena model=(AbstractTableOcena) tabelaOcena.getModel();
		model.fireTableDataChanged();
		validate();
	}
	
	
}
