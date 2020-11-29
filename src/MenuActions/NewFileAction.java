package MenuActions;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.KeyStroke;

public class NewFileAction extends AbstractAction {
	
	private static final long serialVersionUID = 8480095600632816376L;

	public NewFileAction()
	{
		putValue(NAME, "New");
		putValue(MNEMONIC_KEY, KeyEvent.VK_N);
		putValue(SMALL_ICON, new ImageIcon("images/icons/add.png"));
		putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
	}

}
