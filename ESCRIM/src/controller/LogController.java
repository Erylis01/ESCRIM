package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import model.User;
import gui.Log;
import gui.Menu;

/**
 * Controleur dédié à la fenêtre des logins
 * @author William
 *
 */
public class LogController implements ActionListener,MouseListener,KeyListener{
	
	/**
	 * Attributs de la classe
	 */
	private Log vue;
	private User modele;
	private Connection conn;
	
	/**
	 * Constructeur de la classe 
	 * @param vue - Log
	 * @param modele - User
	 */
	public LogController(Log vue, User modele) {
		this.vue = vue;
		this.modele = modele;
	}

	/**
	 * Méthode d'action du bouton afficher, vérifie les accès à l'aide de la base de donnée
	 */
	@SuppressWarnings("unused")
	@Override
	public void actionPerformed(ActionEvent e) {
		
		String source=((JButton) e.getSource()).getName();
		System.out.println(source);
		if (source == "btnConnection") {
			conn=Bdd.ConnectDB();
			try {
				Boolean authenticated=Bdd.Authenticate(vue.getUsername(), vue.getPwd(), conn);
				if (authenticated==true){
					modele=Bdd.RecupUser(vue.getUsername(), vue.getPwd(), conn);
					vue.dispose();
					Menu m = new Menu(modele);
				}else{
					JOptionPane.showMessageDialog(vue, "Le nom d'utilisateur ou le mot de passe ne sont pas valides");
				}
			} catch (NoSuchAlgorithmException | SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}}
	
	/**
	 * Méthode permettant d'effacer le contenu courant des champs lors du clic
	 */
	@Override
	public void mouseClicked(MouseEvent e) {
		String source = ((JTextField)e.getSource()).getName();
		
		if (source=="pwd"){
			vue.deletepwd();
		}else if(source=="txtUsername"){
			vue.deleteUsername();
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
	
	/**
	 * Méthode permettant de changer de champs avec shift
	 */
	@Override
	public void keyPressed(KeyEvent e) {
		
		int key = e.getKeyCode();
		
		if (key==KeyEvent.VK_TAB){
			vue.deletepwd();
			vue.addfocus("pwd");
		}
		
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
