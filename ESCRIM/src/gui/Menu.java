package gui;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.SpringLayout;

public class Menu extends JFrame {

	private final int LARGEUR_FENETRE = 1200, HAUTEUR_FENETRE = 600;
	
	public Menu() {

		// Centrage de la fenêtre et choix de la taille de la fenêtre
		Dimension screenSize = new Dimension(Toolkit.getDefaultToolkit().getScreenSize());
		this.setPreferredSize(new Dimension(this.LARGEUR_FENETRE, this.HAUTEUR_FENETRE));
		int windowLeftPosition = screenSize.width / 2 - this.LARGEUR_FENETRE / 2;
		int windowRightPostion = screenSize.height / 2 - this.HAUTEUR_FENETRE / 2;
		this.setLocation(windowLeftPosition, windowRightPostion);

		// Affichage de la JFrame
		this.pack();
		getContentPane().setLayout(new SpringLayout());
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

}
