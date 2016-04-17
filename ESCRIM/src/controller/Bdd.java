package controller;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.*;
import java.util.ArrayList;

import model.Historique;

public class Bdd {
	
	public static Connection ConnectDB(){
		
		Connection conn = null;
		//Récupérer le Driver
		try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            System.out.println("Ok !");
        } 
		catch (Exception e) {
        	System.out.println("erreur");
		}
		
		if (conn==null){
		try {
		     conn= DriverManager.getConnection("jdbc:mysql://51.254.124.54:3306/ESCRIM_BDD","ESCRIM","w859uxZrvpBwb4Vt");
		    System.out.println("Okk !");
   
		} catch (SQLException ex) {
		    
		    System.out.println("SQLException: " + ex.getMessage());
		    System.out.println("SQLState: " + ex.getSQLState());
		    System.out.println("VendorError: " + ex.getErrorCode());
		}
	}
		return conn;
	}
	
	public static boolean Authenticate(String username, String password, Connection conn) throws SQLException, NoSuchAlgorithmException{
		boolean authenticated = false;
		Statement stmt = null;
		password=CryptMD5(password);
		
		System.out.println("Creating statement...");
	    stmt = conn.createStatement();
	    String sql;
	    sql = "SELECT Username, Password FROM Users";
	    ResultSet rs = stmt.executeQuery(sql);
	    while (rs.next()){
	    	String ndc=rs.getString("Username");
	    	String mdp=rs.getString("Password");
	    	
	    	if (ndc.equals(username) && mdp.equals(password)){
	    		authenticated=true;
	    		break;
	    	}
	    	
	    }
		return authenticated;
	}
	public static String[] RecupInfoProduit(int Lot, Connection conn) throws SQLException{
		String[] Infos = new String[9];
		Statement stmt=null;
		stmt=conn.createStatement();
		
		String sql;
		sql="SELECT Id, designation, dlu, reference, quantite, dosage, lot, dci, seuil_critique FROM Produits WHERE lot="+Lot;
		
		ResultSet rs = stmt.executeQuery(sql);
		int id=rs.getInt("Id");
		String designation=rs.getString("designation");
		Date dlu=rs.getDate("dlu");
		String reference=rs.getString("reference");
		int quantite=rs.getInt("quantite");
		int dosage=rs.getInt("dosage");
		Date dci=rs.getDate("dci");
		int seuil_critique=rs.getInt("seuil_critique");
		
		Infos[0]=String.valueOf(id);
		Infos[1]=designation;
		Infos[2]=String.valueOf(dlu);
		Infos[3]=reference;
		Infos[4]=String.valueOf(quantite);
		Infos[5]=String.valueOf(dosage);
		Infos[6]=String.valueOf(Lot);
		Infos[7]=String.valueOf(dci);
		Infos[8]=String.valueOf(seuil_critique);
		
		return Infos;
	}
	
	public static ArrayList<Historique> RecupHisto(Connection conn){
		ArrayList<Historique> Configs = new ArrayList<Historique>();
		Statement stmt=null;
		try {
			stmt=conn.createStatement();
		} catch (SQLException e) {

			e.printStackTrace();
		}
		
		String sql;
		sql="SELECT Date, Pays, Id, Config, Avion FROM Historique";
		
		ResultSet rs;
		try {
			rs = stmt.executeQuery(sql);
			while (rs.next()){
				Date date=rs.getDate("Date");
				String Pays=rs.getString("Pays");
				int id = rs.getInt("Id");
				String Config = rs.getString("Config");
				String Avion = rs.getString("Avion");
				Historique h = new Historique(String.valueOf(id),String.valueOf(date),Pays,String.valueOf(Config),Avion);
				Configs.add(h);
				}
		} catch (SQLException e) {

			e.printStackTrace();
		}
		
		return Configs;
	}
	
	public static ArrayList<String[]> RecupHisto(Date date, Connection conn){
		ArrayList<String[]> Configs = new ArrayList<String[]>();
		String[] config = new String[5];
		Statement stmt=null;
		try {
			stmt=conn.createStatement();
		} catch (SQLException e) {

			e.printStackTrace();
		}
		
		String sql;
		sql="SELECT Date, Pays, Id, Config, Avion FROM Historique WHERE Date="+date;
		
		ResultSet rs;
		try {
			rs = stmt.executeQuery(sql);
			while (rs.next()){
				String Pays=rs.getString("Pays");
				int id = rs.getInt("Id");
				String Config = rs.getString("Config");
				String Avion = rs.getString("Avion");
				
				config[0]=String.valueOf(date);
				config[1]=Pays;
				config[2]=String.valueOf(id);
				config[3]=String.valueOf(Config);
				config[4]=Avion;
				Configs.add(config);
				}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
		return Configs;
	}
	
	public static ArrayList<String[]> RecupHisto(String Pays, Connection conn){
		ArrayList<String[]> Configs = new ArrayList<String[]>();
		String[] config = new String[5];
		Statement stmt=null;
		try {
			stmt=conn.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String sql;
		sql="SELECT Date, Pays, Id, Config, Avion FROM Historique WHERE Pays="+Pays;
		
		ResultSet rs;
		try {
			rs = stmt.executeQuery(sql);
			while (rs.next()){
				Date date = rs.getDate("Date");
				int id = rs.getInt("Id");
				String Config = rs.getString("Config");
				String Avion = rs.getString("Avion");
				
				config[0]=String.valueOf(date);
				config[1]=Pays;
				config[2]=String.valueOf(id);
				config[3]=String.valueOf(Config);
				config[4]=Avion;
				Configs.add(config);
				}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return Configs;
	}
	
	public static void Add_User(String Username,String Password,String Nom, String Prenom, Connection conn){
		Statement stmt=null;
		try {
			stmt=conn.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String sql;
		Password=CryptMD5(Password);
		sql="INSERT INTO Users (Username,Password,Nom,Prenom) VALUES ('"+Username+"','"+Password+"','"+Nom+"','"+Prenom+"')";
		
		try {
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void Add_Histo(Date date,String pays,String config, String avion, Connection conn){
		Statement stmt=null;
		try {
			stmt=conn.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String sql;
		sql="INSERT INTO Users (Date,Pays,Config,Avion) VALUES ('"+date+"','"+pays+"','"+config+"','"+avion+"')";
		
		try {
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static String CryptMD5(String password){
		MessageDigest Digest = null;
		
		try {
			Digest = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Digest.update(password.getBytes());
		byte[] hash=Digest.digest();
		StringBuffer hexString = new StringBuffer();
		
		for (int i = 0; i < hash.length; i++) {
            if ((0xff & hash[i]) < 0x10) {
                hexString.append("0" + Integer.toHexString((0xFF & hash[i])));
            }
            else {
                hexString.append(Integer.toHexString(0xFF & hash[i]));
            }
        }
		
		
		return hexString.toString();
	}
	
}

