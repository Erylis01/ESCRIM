package application;

import controller.Bdd;
import gui.Log;
import gui.Menu;
import gui.ModifProduit;

public class Application {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//PierreTests();
		CharlieTests();
		//WilliamTests();
	}

	private static void PierreTests() {
		//Log l = new Log();
		//Menu m=new Menu();
		ModifProduit mp= new ModifProduit();

	}

	private static void CharlieTests() {
         Bdd.ConnectDB();
         
	}
	
	private static void WilliamTests() {

	}
}
