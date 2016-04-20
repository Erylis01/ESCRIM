package application;

import controller.Bdd;
import gui.ChoisirConfig;
import gui.GestionStock;
import gui.Log;
import gui.Menu;
import gui.ModifProduit;
import model.Config;
import model.Historique;
import model.User;

public class Application {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PierreTests();
		//CharlieTests();
		//WilliamTests();
	}

	private static void PierreTests() {
		//User u = new User();
		//Log l = new Log(u);
		//ChoisirConfig cc= new ChoisirConfig();
		GestionStock gs = new GestionStock();

	}

	private static void CharlieTests() {
         Bdd.ConnectDB();
         
	}
	
	private static void WilliamTests() {

	}
}
