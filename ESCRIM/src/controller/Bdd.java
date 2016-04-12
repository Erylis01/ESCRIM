package controller;

import java.sql.*;

public class Bdd {

	public static void ConnectDB(){
		
		//Récupérer le Driver
		try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            System.out.println("Ok !");
        } 
		catch (Exception e) {
        	System.out.println("erreur");
		}
		
		Connection conn = null;
		try {
		    conn = DriverManager.getConnection("jdbc:mysql://51.254.124.54:465/ESCRIM_BDD","ESCRIM","w859uxZrvpBwb4Vt");
		    System.out.println("Okk !");

		   
		} catch (SQLException ex) {
		    // handle any errors
		    System.out.println("SQLException: " + ex.getMessage());
		    System.out.println("SQLState: " + ex.getSQLState());
		    System.out.println("VendorError: " + ex.getErrorCode());
		}
	}
}
