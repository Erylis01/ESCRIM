package controller;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.*;
import java.util.ArrayList;

import model.*;

public class Bdd {

	public static Connection ConnectDB() {

		Connection conn = null;
		// Récupérer le Driver
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			System.out.println("Ok !");
		} catch (Exception e) {
			System.out.println("erreur");
		}

		if (conn == null) {
			try {
				conn = DriverManager.getConnection("jdbc:mysql://51.254.124.54:3306/ESCRIM_BDD", "ESCRIM",
						"w859uxZrvpBwb4Vt");
				System.out.println("Okk !");

			} catch (SQLException ex) {

				System.out.println("SQLException: " + ex.getMessage());
				System.out.println("SQLState: " + ex.getSQLState());
				System.out.println("VendorError: " + ex.getErrorCode());
			}
		}
		return conn;
	}

	public static boolean Authenticate(String username, String password, Connection conn)
			throws SQLException, NoSuchAlgorithmException {
		boolean authenticated = false;
		Statement stmt = null;
		password = CryptMD5(password);

		System.out.println("Creating statement...");
		stmt = conn.createStatement();
		String sql;
		sql = "SELECT Username, Password FROM Users";
		ResultSet rs = stmt.executeQuery(sql);
		while (rs.next()) {
			String ndc = rs.getString("Username");
			String mdp = rs.getString("Password");

			if (ndc.equals(username) && mdp.equals(password)) {
				authenticated = true;
				break;
			}

		}
		return authenticated;
	}

	/**
	 * Permet de récupérer les infos d'un produit
	 * 
	 * @param Lot
	 * @param conn
	 * @return
	 * @throws SQLException
	 */
	public static Product RecupInfoProduit(String Lot, Connection conn) throws SQLException {
		Statement stmt = null;
		stmt = conn.createStatement();
		Product Infos = new Product(null, null, null, null, 0, Lot, null, 0, null, null, 0, null);

		String sql;
		sql = "SELECT Id, designation, dlu, reference, quantite, dosage, lot, dci, seuil_critique,Classe_Therapeutique,NumCaisse,Caisse,Dotation_U7 FROM Produits WHERE lot="
				+ Lot;

		ResultSet rs = stmt.executeQuery(sql);
		while (rs.next()) {
			String designation = rs.getString("designation");
			Date dlu = rs.getDate("dlu");
			String reference = rs.getString("reference");
			int quantite = rs.getInt("quantite");
			String dosage = rs.getString("dosage");
			String dci = rs.getString("dci");
			int seuil_critique = rs.getInt("seuil_critique");
			String Classe_Therapeutique = rs.getString("Classe_Therapeutique");
			int NumCaisse = rs.getInt("NumCaisse");
			String Caisse = rs.getString("Caisse");
			String Dotation_U7 = rs.getString("Dotation_U7");

			Infos = new Product(designation, dci, dosage, dlu, quantite, Lot, Classe_Therapeutique, NumCaisse, Caisse,
					Dotation_U7, seuil_critique, reference);
		}
		return Infos;
	}

	public static User RecupUser(String ndc, String password, Connection conn) {
		Statement stmt = null;
		User user = null;
		try {
			stmt = conn.createStatement();
		} catch (SQLException e) {

			e.printStackTrace();
		}
		password=CryptMD5(password);
		String sql;
		sql = "SELECT Username, Password, Nom, Prenom, admin FROM Users WHERE Username='" + ndc + "' AND Password='"
				+ password+"'";

		try {
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				String Nom = rs.getString("Nom");
				String Prenom = rs.getString("Prenom");
				boolean admin = rs.getBoolean("admin");
				
				user = new User(ndc, password, Nom, Prenom, admin);
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return user;

	}

	public static ArrayList<Historique> RecupHisto(Connection conn) {
		ArrayList<Historique> Configs = new ArrayList<Historique>();
		Statement stmt = null;
		try {
			stmt = conn.createStatement();
		} catch (SQLException e) {

			e.printStackTrace();
		}

		String sql;
		sql = "SELECT Date, Pays, Id, Config, Avion FROM Historique";

		ResultSet rs;
		try {
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				Date date = rs.getDate("Date");
				String Pays = rs.getString("Pays");
				int id = rs.getInt("Id");
				String Config = rs.getString("Config");
				String Avion = rs.getString("Avion");
				Historique h = new Historique(String.valueOf(id), String.valueOf(date), Pays, String.valueOf(Config),
						Avion);
				Configs.add(h);
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return Configs;
	}
	
	public static ArrayList<Product> RecupProduits(int nStockage, Connection conn){
		ArrayList<Product> Produits = new ArrayList<Product>();
		
		Statement stmt = null;
		try {
			stmt = conn.createStatement();
		} catch (SQLException e) {

			e.printStackTrace();
		}
		
		String sql;
		sql = "SELECT * FROM Produits WHERE NumCaisse=" + nStockage;
		
		ResultSet rs;
		try {
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				String designation = rs.getString("designation");
				Date dlu = rs.getDate("dlu");
				String reference = rs.getString("reference");
				int quantite = rs.getInt("quantite");
				String dosage = rs.getString("dosage");
				String lot = rs.getString("lot");
				String dci = rs.getString("dci");
				int seuil_critique = rs.getInt("seuil_critique");
				String Classe_Therapeutique = rs.getString("Classe_Therapeutique");
				String Caisse = rs.getString("Caisse");
				Product p = new Product(designation,dci,dosage,dlu,quantite,lot,Classe_Therapeutique,nStockage,Caisse,"",seuil_critique,reference);

				Produits.add(p);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return Produits;
	}
	
	public static ArrayList<Historique> RecupHisto(Date date, Connection conn) {
		ArrayList<Historique> Configs = new ArrayList<Historique>();

		Statement stmt = null;
		try {
			stmt = conn.createStatement();
		} catch (SQLException e) {

			e.printStackTrace();
		}

		String sql;
		sql = "SELECT Date, Pays, Id, Config, Avion FROM Historique WHERE Date=" + date;

		ResultSet rs;
		try {
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				String Pays = rs.getString("Pays");
				int id = rs.getInt("Id");
				String Config = rs.getString("Config");
				String Avion = rs.getString("Avion");
				Historique h = new Historique(String.valueOf(id), String.valueOf(date), Pays, Config, Avion);

				Configs.add(h);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return Configs;
	}

	public static ArrayList<Historique> RecupHisto(String Pays, Connection conn) {
		ArrayList<Historique> Configs = new ArrayList<Historique>();

		Statement stmt = null;
		try {
			stmt = conn.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String sql;
		sql = "SELECT Date, Pays, Id, Config, Avion FROM Historique WHERE Pays=" + Pays;

		ResultSet rs;
		try {
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				Date date = rs.getDate("Date");
				int id = rs.getInt("Id");
				String Config = rs.getString("Config");
				String Avion = rs.getString("Avion");
				Historique h = new Historique(String.valueOf(id), String.valueOf(date), Pays, Config, Avion);
				Configs.add(h);
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}

		return Configs;
	}

	public static String[] RecupNStockage(Connection conn) {
		ArrayList<String> listStockage = new ArrayList<String>();

		Statement stmt = null;
		try {
			stmt = conn.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String sql;
		sql = "SELECT numero FROM Stockage";

		ResultSet rs;
		try {
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				String id = "" + rs.getInt("numero");
				listStockage.add(id);
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}

		String[] listeStockage = new String[listStockage.size()];
		for (int i = 0; i < listStockage.size(); i++) {
			listeStockage[i] = "" + listStockage.get(i);
		}

		return listeStockage;
	}
	
	public static String[] RecupNLot(Connection conn) {
		ArrayList<String> listLot = new ArrayList<String>();

		Statement stmt = null;
		try {
			stmt = conn.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String sql;
		sql = "SELECT lot FROM Produits";

		ResultSet rs;
		try {
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				String id = "" + rs.getInt("lot");
				listLot.add(id);
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}

		String[] listeLot = new String[listLot.size()];
		for (int i = 0; i < listLot.size(); i++) {
			listeLot[i] = "" + listLot.get(i);
		}

		return listeLot;
	}

	public static void Add_User(String Username, String Password, String Nom, String Prenom, boolean admin,
			Connection conn) {
		Statement stmt = null;
		try {
			stmt = conn.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String sql;
		int i;
		if (admin==true){i=1;}else{i=0;}

		Password = CryptMD5(Password);
		sql = "INSERT INTO Users (Username,Password,Nom,Prenom,admin) VALUES ('" + Username + "','" + Password + "','"
				+ Nom + "','" + Prenom + "','" + i + "')";

		try {
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void Add_Histo(Date date, String pays, String config, String avion, Connection conn) {
		Statement stmt = null;
		try {
			stmt = conn.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String sql;
		sql = "INSERT INTO Historique (Date,Pays,Config,Avion) VALUES ('" + date + "','" + pays + "','" + config + "','"
				+ avion + "')";

		try {
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void Add_Produit(String designation, Date dlu, String reference, int quantite, String dosage,
			String lot, String dci, int seuil_critique, String classe_therapeutique, int NumCaisse, String caisse,
			String dotation_U7, Connection conn) {
		Statement stmt = null;
		try {
			stmt = conn.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String sql;
		sql = "INSERT INTO Produits (designation,dlu,reference,quantite,dosage,lot,dci,seuil_critique, Classe_Therapeutique,NumCaisse,Caisse,Dotation_U7) VALUES ('"
				+ designation + "','" + dlu + "','" + reference + "','" + quantite + "','" + dosage + "','" + lot
				+ "','" + dci + "','" + seuil_critique + "','" + classe_therapeutique + "','" + NumCaisse + "','"
				+ caisse + "','" + dotation_U7 + "')";

		try {
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static String CryptMD5(String password) {
		MessageDigest Digest = null;

		try {
			Digest = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Digest.update(password.getBytes());
		byte[] hash = Digest.digest();
		StringBuffer hexString = new StringBuffer();

		for (int i = 0; i < hash.length; i++) {
			if ((0xff & hash[i]) < 0x10) {
				hexString.append("0" + Integer.toHexString((0xFF & hash[i])));
			} else {
				hexString.append(Integer.toHexString(0xFF & hash[i]));
			}
		}

		return hexString.toString();
	}

}
