package rs.ac.uns.abstractActions;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;

public class HelpHelpAction extends AbstractAction {

	private String address;
	private String message;
	private final JFrame parent;
	private static final long serialVersionUID = -1503522959045651498L;

	public HelpHelpAction(JFrame parent)
	{
		address = "images" + File.separator + "icons"  + File.separator + "help.png";
		putValue(NAME, "Help");
		putValue(MNEMONIC_KEY, KeyEvent.VK_H);
		putValue(SMALL_ICON, new ImageIcon(address));
		putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_H, ActionEvent.CTRL_MASK));
		this.parent = parent;
		String path = "text" + File.separator + "help.txt";
		try (Stream<String> lines = Files.lines(Paths.get(path))) 
		{
			message = lines.collect(Collectors.joining(System.lineSeparator()));
	    } 
		catch (IOException e) 
		{
	    	e.printStackTrace();
	    }
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JOptionPane.showMessageDialog(parent, message, "Help", JOptionPane.INFORMATION_MESSAGE);
		
	}
}
