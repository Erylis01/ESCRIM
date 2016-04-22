package model;

import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.SQLException;

import controller.Bdd;

/**
 * Classe implémentant le modèle de l'objet Utilisateur
 * @author William
 *
 */
public class User {

	private String Username, Password, Nom, Prenom;
	private boolean admin;

	/**
	 * Constructeur de User
	 */
	public User(){
		
	}
	
	/**
	 * Constructeur complet de l'utilisateur
	 * @param Username - String
	 * @param Password - String
	 * @param Nom - String
	 * @param Prenom - String
	 * @param admin - boolean
	 */
	public User(String Username, String Password, String Nom, String Prenom, boolean admin) {
		this.Username=Username;
		this.Password=Password;
		this.Nom=Nom;
		this.Prenom=Prenom;
		this.admin=admin;
	}

	/**
	 * Permet de rajouter un utilisateur
	 * @param Nom - String
	 * @param Prenom - String
	 * @param Password - String
	 * @param Username - String
	 */
	public void AddUser(String Nom, String Prenom, String Password, String Username,boolean admin) {
		Connection conn = Bdd.ConnectDB();
		Bdd.Add_User(Username, Password, Nom, Prenom, admin, conn);
	}
	
	/**
	 * Permet d'afficher un utlisateur / fonction de test
	 */
	public void affichage(){
		System.out.println(Nom+" "+Prenom+" "+Username+" "+ Password);
	}


	/**
	 * Fonction d'authentification
	 * @param Username - String
	 * @param Password - String
	 * @return authenticated - boolean
	 * @throws NoSuchAlgorithmException
	 * @throws SQLException
	 */
	public Boolean authentifier(String Username,String Password) throws NoSuchAlgorithmException, SQLException{
		Connection conn = Bdd.ConnectDB();
		Boolean authenticated=Bdd.Authenticate(Username, Password, conn);
		return authenticated;
	}
	
	/**
	 * Permet de récupérer le nom d'utilisateur
	 * @return Username - String
	 */
	public String getUsername() {
		return Username;
	}

	/**
	 * Permet de modifier le nom d'utilisateur
	 * @param username - String
	 */
	public void setUsername(String username) {
		Username = username;
	}
	
	/**
	 * Permet de récupérer le nom 
	 * @return Nom - String
	 */
	public String getNom() {
		return Nom;
	}

	/**
	 * Permet de modifier le nom 
	 * @param nom - String
	 */
	public void setNom(String nom) {
		Nom = nom;
	}

	/**
	 * Permet de récupérer le prénom 
	 * @return Prenom - String
	 */
	public String getPrenom() {
		return Prenom;
	}

	/**
	 * Permet de modifier le prénom 
	 * @param prenom - String
	 */
	public void setPrenom(String prenom) {
		Prenom = prenom;
	}

	/**
	 * Vérifie que l'utilisateur est administrateur
	 * @return admin - boolean
	 */
	public boolean isAdmin() {
		return admin;
	}

	/**
	 * Permet de donner les droits d'administrateurs
	 * @param admin - boolean
	 */
	public void setAdmin(boolean admin) {
		this.admin = admin;
	}
}
