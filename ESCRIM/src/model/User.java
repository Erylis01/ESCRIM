package model;

import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.SQLException;

import controller.Bdd;

public class User {

	private String Username, Password, Nom, Prenom;
	private boolean admin;

	/**
	 * Constructeur de User
	 */
	
	public User(){
		
	}
	
	public User(String Username, String Password, String Nom, String Prenom, boolean admin) {
		this.Username=Username;
		this.Password=Password;
		this.Nom=Nom;
		this.Prenom=Prenom;
		this.admin=admin;
	}

	/**
	 * Permet de rajouter un utilisateur
	 * 
	 * @param Nom
	 * @param Prenom
	 * @param Password
	 * @param Username
	 */
	public void AddUser(String Nom, String Prenom, String Password, String Username,boolean admin) {
		Connection conn = Bdd.ConnectDB();
		Bdd.Add_User(Username, Password, Nom, Prenom, admin, conn);
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

	/**
	 * @return the admin
	 */
	public boolean isAdmin() {
		return admin;
	}

	/**
	 * @param admin the admin to set
	 */
	public void setAdmin(boolean admin) {
		this.admin = admin;
	}
}
