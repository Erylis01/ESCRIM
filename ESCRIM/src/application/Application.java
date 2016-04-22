package application;


import gui.Log;
import model.User;

/**
 * Classe principale de lancement de l'application, lance la fenetre de login.
 * @author William
 *
 */
public class Application {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PierreTests();
	}

	@SuppressWarnings("unused")
	private static void PierreTests() {
		User u = new User();
		Log l = new Log(u);
	}


}
