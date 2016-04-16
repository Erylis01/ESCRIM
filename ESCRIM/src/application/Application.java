package application;

import controller.Bdd;
import gui.Log;

import model.User;

public class Application {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PierreTests();
		//CharlieTests();
		//WilliamTests();
	}

	private static void PierreTests() {
		User u = new User();
		Log l = new Log(u);

	}

	private static void CharlieTests() {
         Bdd.ConnectDB();
         
	}
	
	private static void WilliamTests() {

	}
}
