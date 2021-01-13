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

public class AboutHelpAction extends AbstractAction {

	private String address;
	private final JFrame parent;
	private String message;
	private static final long serialVersionUID = -5327381713211526108L;

	public AboutHelpAction(final JFrame parent)
	{
		address = "images" + File.separator + "icons"  + File.separator + "about.png";
		putValue(NAME, "About");
		putValue(MNEMONIC_KEY, KeyEvent.VK_A);
		putValue(SMALL_ICON, new ImageIcon(address));
		putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_A, ActionEvent.CTRL_MASK));
		this.parent = parent;
		String path = "text" + File.separator + "about.txt";
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
		String text = "Verzija: 1.0.3\n" + message;
		JOptionPane.showMessageDialog(parent, text, "About", JOptionPane.INFORMATION_MESSAGE);
	}

}
