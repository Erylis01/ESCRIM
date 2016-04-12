package controller;

import java.sql.*;

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
		
		
		try {
			
			
		    conn = DriverManager.getConnection("jdbc:mysql://51.254.124.54:3306/ESCRIM_BDD","ESCRIM","w859uxZrvpBwb4Vt");
		    System.out.println("Okk !");

		   
		} catch (SQLException ex) {
		    // handle any errors
		    System.out.println("SQLException: " + ex.getMessage());
		    System.out.println("SQLState: " + ex.getSQLState());
		    System.out.println("VendorError: " + ex.getErrorCode());
		}
		return conn;
	}
	
	public static boolean Authenticate(String username, String password, Connection conn) throws SQLException{
		boolean authenticated = true;
		Statement stmt = null;
		
		System.out.println("Creating statement...");
	    stmt = conn.createStatement();
	    String sql;
	    sql = "SELECT Username, Password FROM Users";
	    ResultSet rs = stmt.executeQuery(sql);
	    while (rs.next()){
	    	String ndc=rs.getString("Username");
	    	String mdp=rs.getString("Password");
	    	
	    	if (ndc==username && mdp==password){
	    		authenticated=true;
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
}
