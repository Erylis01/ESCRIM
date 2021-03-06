package controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.SQLException;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import gui.ChoisirConfig;
import gui.GestionStock;
import gui.Menu;
import gui.ModifProduit;
import model.Historique;
import model.Product;
import model.User;

/**
 * Controleur d�di� � la fen�tre de menu
 */
public class MenuController implements MouseListener {
	
	//Attributs de la classe
	private Menu vue;
	private Connection conn;
	private Product p;
	private User u;
	private Historique h;
	
	/**
	 * Constructeur de la classe 
	 * @param vue - Menu
	 * @param info - User
	 */
	public MenuController(Menu vue,User info) {
		this.vue = vue;
		this.u=info;
	}
	
	/**
	 * M�thode permettant de se d�placer dans les diverses fen�tre � l'aide des images
	 * @param e - MouseEvent
	 */
	@SuppressWarnings("unused")
	@Override
	public void mouseClicked(MouseEvent e) {
		String source = ((JLabel) e.getSource()).getName();
		if (source=="lblConfig"){
			vue.dispose();
			h=new Historique();
			h.getList();
			ChoisirConfig cc = new ChoisirConfig(h,u);
			}else if(source=="lblProduit"){
			 JOptionPane jop = new JOptionPane();
			 String Lot = JOptionPane.showInputDialog(null, "N� de lot", JOptionPane.QUESTION_MESSAGE);
			 conn=Bdd.ConnectDB();
			 try {
				p = Bdd.RecupInfoProduit(Lot, conn);
			} catch (NumberFormatException | SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			 vue.dispose();
			 u.affichage();
			 ModifProduit mp = new ModifProduit(p,u);
		}else if(source=="lblStock"){
			vue.dispose();
			GestionStock gs = new GestionStock(u);
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
