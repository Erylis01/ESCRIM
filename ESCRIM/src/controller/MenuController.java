package controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.SQLException;

import javax.swing.JLabel;
import javax.swing.JOptionPane;


import gui.Menu;

public class MenuController implements MouseListener {

	private Menu vue;
	private Connection conn;

	public MenuController(Menu vue) {
		this.vue = vue;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		String source = ((JLabel) e.getSource()).getName();
		if (source=="lblConfig"){
			
			
		}else if(source=="lblProduit"){
			JOptionPane jop = new JOptionPane();
			 String Lot = JOptionPane.showInputDialog(null, "N° de lot", JOptionPane.QUESTION_MESSAGE);
			 conn=Bdd.ConnectDB();
			 String[] Infos = new String[9];
			 try {
				Infos=Bdd.RecupInfoProduit(Integer.parseInt(Lot), conn);
			} catch (NumberFormatException | SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			 Product p = new Product();
			 ModifProduit mp = new ModifProduit(p);
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
