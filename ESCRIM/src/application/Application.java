package application;

import java.sql.Connection;

import controller.Bdd;
import gui.Log;
import gui.Menu;
import gui.ModifProduit;

public class Application {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PierreTests();
		//CharlieTests();
		//WilliamTests();
	}

	private static void PierreTests() {
		/*Connection conn;
		conn=Bdd.ConnectDB();
		Bdd.Add_User("pierre.coquerel", "azertyui", "Coquerel", "Pierre", conn);*/
		
		Log l = new Log();
		//Menu m=new Menu();
		//ModifProduit mp= new ModifProduit();

	}

	private static void CharlieTests() {
         Bdd.ConnectDB();
         
	}
	
	private static void WilliamTests() {

	}
}
