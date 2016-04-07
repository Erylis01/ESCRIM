package gui;

import javax.swing.JFrame;

import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JPasswordField;
import javax.swing.BoxLayout;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Log extends JFrame {

	private int LARGEUR_FENETRE = 600, HAUTEUR_FENETRE = 600;
	private JPasswordField passwordField;

	public Log() {

		JPanel pan =new JPanel();
		this.setContentPane(pan);
		
		// Centrage de la fenêtre et choix de la taille de la fenêtre
		Dimension screenSize = new Dimension(Toolkit.getDefaultToolkit().getScreenSize());
		this.setPreferredSize(new Dimension(this.LARGEUR_FENETRE, this.HAUTEUR_FENETRE));
		int windowLeftPosition = screenSize.width / 2 - this.LARGEUR_FENETRE / 2;
		int windowRightPostion = screenSize.height / 2 - this.HAUTEUR_FENETRE / 2;
		this.setLocation(windowLeftPosition, windowRightPostion);

		// Choix du titre et de l'icone de la JFrame
		this.setTitle("Connexion");
		this.setIconImage(Toolkit.getDefaultToolkit().getImage(Log.class.getResource("/assets/icone.png")));

		//Ajout d'un Layout
		SpringLayout springLayout = new SpringLayout();
		this.getContentPane().setLayout(springLayout);
		
		//Ajout d'une zone de texte pour le nom d'utilisateur dans le layout
		JTextField textArea = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, textArea, 231, SpringLayout.NORTH, getContentPane());
		this.getContentPane().add(textArea);

		//Ajout d'une zone de texte pour le mot de passe dans le layout
		passwordField = new JPasswordField();
		springLayout.putConstraint(SpringLayout.WEST, textArea, 0, SpringLayout.WEST, passwordField);
		springLayout.putConstraint(SpringLayout.SOUTH, textArea, -6, SpringLayout.NORTH, passwordField);
		springLayout.putConstraint(SpringLayout.NORTH, passwordField, 259, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, textArea, 0, SpringLayout.EAST, passwordField);
		getContentPane().add(passwordField);

		//Ajout d'un boutton connexion dans le layout 
		Boutton btnConnexion = new Boutton("/assets/bouton_connexion.png");
		springLayout.putConstraint(SpringLayout.SOUTH, passwordField, -6, SpringLayout.NORTH, btnConnexion);
		springLayout.putConstraint(SpringLayout.NORTH, btnConnexion, 285, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, btnConnexion, -241, SpringLayout.SOUTH, getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, passwordField, 0, SpringLayout.WEST, btnConnexion);
		springLayout.putConstraint(SpringLayout.WEST, btnConnexion, 150, SpringLayout.WEST, getContentPane());
		getContentPane().add(btnConnexion);

		//Ajout d'une image dans le layout
		JLabel lblNewLabel = new JLabel("");
		springLayout.putConstraint(SpringLayout.NORTH, lblNewLabel, 60, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, lblNewLabel, -243, SpringLayout.EAST, textArea);
		springLayout.putConstraint(SpringLayout.SOUTH, lblNewLabel, -6, SpringLayout.NORTH, textArea);
		springLayout.putConstraint(SpringLayout.EAST, lblNewLabel, 0, SpringLayout.EAST, textArea);
		lblNewLabel.setIcon(new ImageIcon(Log.class.getResource("/assets/icone.png")));
		getContentPane().add(lblNewLabel);

		//Ajout d'un boutton inscription dans le layout 
		Boutton btnInscription = new Boutton("/assets/bouton_inscription.png");
		springLayout.putConstraint(SpringLayout.NORTH, btnInscription, 6, SpringLayout.SOUTH, passwordField);
		springLayout.putConstraint(SpringLayout.WEST, btnInscription, 280, SpringLayout.WEST, getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, btnInscription, -241, SpringLayout.SOUTH, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, btnInscription, -180, SpringLayout.EAST, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, passwordField, 0, SpringLayout.EAST, btnInscription);
		springLayout.putConstraint(SpringLayout.EAST, btnConnexion, -6, SpringLayout.WEST, btnInscription);
		getContentPane().add(btnInscription);

		// Packing et affichage de la JFrame
		this.pack();
		this.setVisible(true);

	}
}
