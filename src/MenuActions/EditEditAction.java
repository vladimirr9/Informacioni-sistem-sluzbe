package MenuActions;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.KeyStroke;

public class EditEditAction extends AbstractAction{

	private static final long serialVersionUID = -1040805383069705155L;

	public EditEditAction()
	{
		putValue(NAME, "Edit");
		putValue(MNEMONIC_KEY, KeyEvent.VK_E);
		putValue(SMALL_ICON, new ImageIcon("images/icons/edit.png"));
		putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_E, ActionEvent.CTRL_MASK));
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
	}

}
