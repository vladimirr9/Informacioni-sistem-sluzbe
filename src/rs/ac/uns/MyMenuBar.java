package rs.ac.uns;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JToolBar.Separator;
import javax.swing.KeyStroke;

import MenuActions.AboutHelpAction;
import MenuActions.CloseFileAction;
import MenuActions.DeleteEditAction;
import MenuActions.EditEditAction;
import MenuActions.HelpHelpAction;
import MenuActions.NewFileAction;

public class MyMenuBar extends JMenuBar 
{
	
	public MyMenuBar(final JFrame parent)
	{
		JMenu mFile = new JMenu("File");				// file podmeni
		mFile.setMnemonic(KeyEvent.VK_F);
	
		NewFileAction newEntity = new NewFileAction();
		CloseFileAction closeFile = new CloseFileAction();
		
		mFile.add(newEntity);
		mFile.addSeparator();
		mFile.add(closeFile);

		
		JMenu mEdit = new JMenu("Edit");				// edit podmeni
		mEdit.setMnemonic(KeyEvent.VK_E);
		
		EditEditAction editEntity = new EditEditAction();
		DeleteEditAction deleteEntity = new DeleteEditAction();
		
		
		mEdit.add(editEntity);
		mEdit.addSeparator();
		mEdit.add(deleteEntity);

		
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
