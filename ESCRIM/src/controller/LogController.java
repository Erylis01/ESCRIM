package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import model.User;
import gui.Log;

public class LogController implements ActionListener {

	private Log vue;
	private User modele;
	private Connection conn;

	public LogController(Log vue, User modele) {
		this.vue = vue;
		this.modele = modele;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		String source=((JButton) e.getSource()).getName();
		System.out.println(source);
		if (source == "btnConnection") {
			conn=Bdd.ConnectDB();
			modele.setUsername(vue.getUsername());
			try {
				Boolean authenticated=Bdd.Authenticate(modele.getUsername(), vue.getPwd(), conn);
				if (authenticated==true){
					vue.dispose();
					//Menu m = new Menu(Username);
				}else{
					JOptionPane.showMessageDialog(vue, "Le nom d'utilisateur ou le mot de passe ne sont pas valides");
				}
			} catch (NoSuchAlgorithmException | SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}}

}
