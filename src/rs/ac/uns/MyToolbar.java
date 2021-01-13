package rs.ac.uns;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.swing.Action;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.KeyStroke;
import javax.swing.RowFilter;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.table.TableRowSorter;

import rs.ac.uns.abstractActions.DeleteAction;
import rs.ac.uns.abstractActions.EditAction;
import rs.ac.uns.abstractActions.NewAction;
import rs.ac.uns.predmet.view.AbstractTableModelPredmeti;
import rs.ac.uns.profesor.view.AbstractTableModelProfesori;

public class MyToolbar extends JToolBar {
	public MyToolbar(final JFrame parent) {
		super(SwingConstants.HORIZONTAL);
		setBorder(new LineBorder(Color.BLACK));
		setFloatable(false);
	
		GridBagLayout gb=new GridBagLayout();
		setLayout(gb);
		GridBagConstraints gbc=new GridBagConstraints(0, 0, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0);
		
		NewAction newA=new NewAction(parent);
		EditAction editA=new EditAction(parent);
		DeleteAction delA=new DeleteAction(parent);
		
		JButton btn1 = new JButton(newA);
		btn1.getActionMap().put("newAction", newA);
        btn1.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put((KeyStroke) newA.getValue(Action.ACCELERATOR_KEY), "newAction");
		btn1.setIcon(new ImageIcon("images"+File.separator+"icons"+File.separator+"add.png"));
		btn1.setToolTipText("Kreiranje entiteta");
		btn1.setBorderPainted(false);
		this.add(btn1,gbc);
		
		JButton btn2 = new JButton(editA);
		btn2.getActionMap().put("editAction", editA);
        btn2.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put((KeyStroke) editA.getValue(Action.ACCELERATOR_KEY), "editAction");
		btn2.setIcon(new ImageIcon("images"+File.separator+"icons"+File.separator+"edit.png"));
		btn2.setToolTipText("Izmena entiteta");
		btn2.setBorderPainted(false);
		gbc=new GridBagConstraints(1, 0, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0);
		this.add(btn2,gbc);
	
		
	
		JButton btn3 = new JButton(delA);
		btn3.getActionMap().put("deleteAction", delA);
        btn3.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put((KeyStroke) delA.getValue(Action.ACCELERATOR_KEY), "deleteAction");
		btn3.setIcon(new ImageIcon("images"+File.separator+"icons"+File.separator+"delete.png"));
		btn3.setToolTipText("Brisanje entiteta");
		btn3.setBorderPainted(false);
		gbc=new GridBagConstraints(2, 0, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0);
		this.add(btn3,gbc);
	
		gbc=new GridBagConstraints(3, 0, 1, 1, 100, 0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0);
		JPanel jp1=new JPanel();
		add(jp1,gbc);
		
		
		JTextField txtField=new JTextField();
		gbc=new GridBagConstraints(4, 0, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 250, 0);
		add(txtField,gbc);
		
		
		JButton btn4 = new JButton();
		btn4.setIcon(new ImageIcon("images"+File.separator+"icons"+File.separator+"search.png"));
		btn4.setToolTipText("Pretraga");
		btn4.setBorderPainted(false);
		gbc=new GridBagConstraints(5, 0, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0);
		this.add(btn4,gbc);
		
		btn4.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(MainFrame.tabbedPane.getSelectedIndex()==1) {
					String unesenTekst=txtField.getText();
					String delovi[]=unesenTekst.split(" ");
					AbstractTableModelProfesori model = (AbstractTableModelProfesori) MainFrame.getInstance().getTabelaProfesora().getModel();
					final TableRowSorter< AbstractTableModelProfesori> sorter = new TableRowSorter< AbstractTableModelProfesori>(model);
					MainFrame.getInstance().getTabelaProfesora().setRowSorter(sorter);
					if(delovi.length==1) {
					sorter.setRowFilter(RowFilter.regexFilter("(?i)" + unesenTekst,1));
					} else if(delovi.length==2) {
						 List<RowFilter<Object, Object>> filteri = new ArrayList<RowFilter<Object, Object>>(2);
			                filteri.add(RowFilter.regexFilter("(?i)" + delovi[0], 1));
			                filteri.add(RowFilter.regexFilter("(?i)" + delovi[1], 0));
			                RowFilter filter=RowFilter.andFilter(filteri);
			                sorter.setRowFilter(filter);
					}
				} else if(MainFrame.tabbedPane.getSelectedIndex()==2)   {
					String unesenTekst=txtField.getText();
					String delovi[]=unesenTekst.split(" ");
					AbstractTableModelPredmeti model = (AbstractTableModelPredmeti) MainFrame.getInstance().getTabelaPredmeta().getModel();
					final TableRowSorter< AbstractTableModelPredmeti> sorter = new TableRowSorter< AbstractTableModelPredmeti>(model);
					MainFrame.getInstance().getTabelaPredmeta().setRowSorter(sorter);
					if(delovi.length==1) {
					sorter.setRowFilter(RowFilter.regexFilter("(?i)" + unesenTekst,1));
					}
					
				}
				
			}
		});
		
	}
}
