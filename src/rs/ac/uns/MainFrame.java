package rs.ac.uns;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MainFrame extends JFrame{
	public MainFrame() {
		super();
		Toolkit tk=Toolkit.getDefaultToolkit();
		Dimension dim=tk.getScreenSize();
		setSize(3*dim.width/4,3*dim.height/4);
		setTitle("Studentska Služba");
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(true);
		
		JPanel panel1=new JPanel();
		JLabel labela1=new JLabel("TODO: Prikaz entiteta sistema");
		panel1.add(labela1);
		JPanel panel2=new JPanel();
		JLabel labela2=new JLabel("TODO: Prikaz entiteta sistema");
		panel2.add(labela2);
		JPanel panel3=new JPanel();
		JLabel labela3=new JLabel("TODO: Prikaz entiteta sistema");
		panel3.add(labela3);
		
		MyMenuBar myMenu = new MyMenuBar(this);
		this.setJMenuBar(myMenu);
		StatusBar sBar = new StatusBar();
		this.add(sBar, BorderLayout.SOUTH);
		MyToolbar toolbar=new MyToolbar();
		this.add(toolbar,BorderLayout.NORTH);
		
		JTabbedPaneMine tabbedPane=new JTabbedPaneMine();
		tabbedPane.addTab("Studenti", panel1);
		tabbedPane.addTab("Profesori", panel2);
		tabbedPane.addTab("Predmeti", panel3);
		this.add(tabbedPane,BorderLayout.CENTER);
	}
}
