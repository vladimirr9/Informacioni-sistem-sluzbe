package rs.ac.uns.abstractActions;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.io.File;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.KeyStroke;

import rs.ac.uns.data.Serialization;

public class CloseFileAction extends AbstractAction {

	private String address;
	
	private static final long serialVersionUID = 6779859356672224534L;

	public CloseFileAction()
	{
		address = "images" + File.separator + "icons"  + File.separator + "close.png";
		putValue(NAME, "Close");
		putValue(MNEMONIC_KEY, KeyEvent.VK_C);
		putValue(SMALL_ICON, new ImageIcon(address));
		putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_C, ActionEvent.CTRL_MASK));
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Serialization.getInstance().BazaStudenataSerialization();
		Serialization.getInstance().BazaProfesoraSerialization();
		Serialization.getInstance().BazaPredmetaSerialization();
		Serialization.getInstance().BazaOcenaSerialization();
	}
}
