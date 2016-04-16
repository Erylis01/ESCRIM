package model;

import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.SQLException;

import controller.Bdd;

public class User {

	private String Username, Nom, Prenom;

	/**
	 * Constructeur de User
	 */
	public User() {

	}

	/**
	 * Permet de rajouter un utilisateur
	 * 
	 * @param Nom
	 * @param Prenom
	 * @param Password
	 * @param Username
	 */
	public void AddUser(String Nom, String Prenom, String Password, String Username) {
		Connection conn = Bdd.ConnectDB();
		Bdd.Add_User(Username, Password, Nom, Prenom, conn);
	}

	/*
	 * public void removeUser(String Username,String Password){ Connection
	 * conn=Bdd.ConnectDB();
	 * 
	 * }
	 */

	public Boolean authentifier(String Username,String Password) throws NoSuchAlgorithmException, SQLException{
		Connection conn = Bdd.ConnectDB();
		Boolean authenticated=Bdd.Authenticate(Username, Password, conn);
		return authenticated;
	}

	public String getUsername() {
		return Username;
	}

	public void setUsername(String username) {
		Username = username;
	}

	public String getNom() {
		return Nom;
	}

	public void setNom(String nom) {
		Nom = nom;
	}

	public String getPrenom() {
		return Prenom;
	}

	public void setPrenom(String prenom) {
		Prenom = prenom;
	}
}
