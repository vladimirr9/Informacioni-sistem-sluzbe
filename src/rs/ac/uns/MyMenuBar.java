package rs.ac.uns;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JToolBar.Separator;
import javax.swing.KeyStroke;


import rs.ac.uns.abstractActions.AboutHelpAction;
import rs.ac.uns.abstractActions.CloseFileAction;
import rs.ac.uns.abstractActions.DeleteAction;
import rs.ac.uns.abstractActions.EditAction;
import rs.ac.uns.abstractActions.HelpHelpAction;
import rs.ac.uns.abstractActions.NewAction;

public class MyMenuBar extends JMenuBar 
{
	
	public MyMenuBar(final JFrame parent)
	{
		String address;
		JMenu mFile = new JMenu("File");				// file podmeni
		mFile.setMnemonic(KeyEvent.VK_F);
		
		CloseFileAction closeFile = new CloseFileAction();
		
		NewAction newEntity = new NewAction(parent);
		JMenuItem newActionItem = new JMenuItem(newEntity);
		
		newActionItem.setText("New");
		newActionItem.setMnemonic(KeyEvent.VK_N);
		address = "images" + File.separator + "icons"  + File.separator + "add.png";
		newActionItem.setIcon( new ImageIcon(address));
		
		
		
		mFile.add(newActionItem);
		mFile.addSeparator();
		mFile.add(closeFile);

		
		JMenu mEdit = new JMenu("Edit");				// edit podmeni
		mEdit.setMnemonic(KeyEvent.VK_E);
		
		EditAction editEntity = new EditAction(parent);
		DeleteAction deleteEntity = new DeleteAction();
		
		
		JMenuItem editItem = new JMenuItem(editEntity);
		editItem.setText("Edit");
		editItem.setMnemonic(KeyEvent.VK_E);
		address = "images" + File.separator + "icons"  + File.separator + "edit.png";
		editItem.setIcon( new ImageIcon(address));
		
		JMenuItem deleteItem = new JMenuItem(deleteEntity);
		
		deleteItem.setText("Edit");
		deleteItem.setMnemonic(KeyEvent.VK_E);
		address = "images" + File.separator + "icons"  + File.separator + "delete.png";
		deleteItem.setIcon( new ImageIcon(address));
		
		mEdit.add(editItem);
		mEdit.addSeparator();
		mEdit.add(deleteItem);

		
		JMenu mHelp = new JMenu("Help");				// help podmeni
		mHelp.setMnemonic(KeyEvent.VK_H);
		
		HelpHelpAction helpApp = new HelpHelpAction(parent);
		AboutHelpAction aboutApp = new AboutHelpAction(parent);
		

		mHelp.add(helpApp);
		mHelp.addSeparator();
		mHelp.add(aboutApp);
		
		
		
		add(mFile);
		add(mEdit);
		add(mHelp);
	}

}
