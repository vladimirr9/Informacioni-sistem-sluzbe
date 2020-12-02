package ToolbarActions;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.KeyStroke;

public class DeleteAction extends AbstractAction {
public DeleteAction() {
	putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_D, ActionEvent.CTRL_MASK));
}
	@Override
	public void actionPerformed(ActionEvent e) {
		
		
	}
	
}
