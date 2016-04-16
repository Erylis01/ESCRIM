package controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JLabel;
import gui.Menu;

public class MenuController implements MouseListener {

	private Menu vue;

	public MenuController(Menu vue) {
		this.vue = vue;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		String source = ((JLabel) e.getSource()).getName();

		if (source=="lblConfig"){
			
		}else if(source=="lblProduit"){
			
		}else if(source=="lblStock"){
			
		}
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}
}
