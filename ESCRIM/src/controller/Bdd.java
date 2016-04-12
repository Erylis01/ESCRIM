package controller;

import java.sql.*;

public class Bdd {

	public static void ConnectDB(){
		
		//Récupérer le Driver
		try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
        } 
		catch (Exception e) {
        	
		}
		
		Connection conn = null;
		try {
		    conn =
		       DriverManager.getConnection("jdbc:mysql://51.254.124.54//ESCRIM_BDD?" +
		                                   "user=ESCRIM&password=w859uxZrvpBwb4Vt");


		   
		} catch (SQLException ex) {
		    // handle any errors
		    System.out.println("SQLException: " + ex.getMessage());
		    System.out.println("SQLState: " + ex.getSQLState());
		    System.out.println("VendorError: " + ex.getErrorCode());
		}
	}
}
