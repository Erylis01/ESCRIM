package gui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import controller.LogController;
import model.User;

public class Log extends JFrame {

	private LogController controller;
	private User modele;

	private final int LARGEUR_FENETRE = 600, HAUTEUR_FENETRE = 600;
	private JPanel panel;
	private JPasswordField pwd;
	private JTextField txtUsername;

	public Log(User modele) {

		this.modele = modele;
		controller = new LogController(this, modele);

		// Centrage de la fenêtre et choix de la taille de la fenêtre
		Dimension screenSize = new Dimension(Toolkit.getDefaultToolkit().getScreenSize());
		this.setPreferredSize(new Dimension(this.LARGEUR_FENETRE, this.HAUTEUR_FENETRE));
		int windowLeftPosition = screenSize.width / 2 - this.LARGEUR_FENETRE / 2;
		int windowRightPostion = screenSize.height / 2 - this.HAUTEUR_FENETRE / 2;
		this.setLocation(windowLeftPosition, windowRightPostion);

		// Empêche la fenêtre d'être redimensionnée
		setResizable(false);

		// Choix du titre et de l'icone de la JFrame
		this.setTitle("Connexion");
		this.setIconImage(Toolkit.getDefaultToolkit().getImage(Log.class.getResource("/assets/icone.png")));

		// Enregistrement de l'option EXIT_ON_CLOSE lors de la fermeture de la
		// fenêtre (arrêt du procéssus)
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);

		// Ajout d'un panel qui contiendra tout
		panel = new JPanel();
		panel.setBounds(0, 0, 594, 571);
		getContentPane().add(panel);
		panel.setLayout(null);

		// Ajout d'un bouton de connexion
		JButton btnConnexion = new JButton("Connexion");
		btnConnexion.setBounds(227, 330, 142, 23);
		btnConnexion.setBackground(Color.RED);
		btnConnexion.setForeground(Color.WHITE);
		btnConnexion.setName("btnConnection");
		btnConnexion.addActionListener(controller);
		panel.add(btnConnexion);

		// Ajout de l'image Escrim
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(181, 101, 231, 163);
		lblNewLabel.setIcon(new ImageIcon(Log.class.getResource("/assets/icone.png")));
		panel.add(lblNewLabel);

		// Ajout d'un champ de texte pour le mot de passe
		pwd = new JPasswordField();
		pwd.setText("mot de passe");
		pwd.setBounds(181, 304, 231, 20);
		pwd.setName("pwd");
		pwd.addMouseListener(controller);
		panel.add(pwd);

		// Ajout d'un champ de texte pour le nom d'utilisateur
		txtUsername = new JTextField();
		txtUsername.setText("Username");
		txtUsername.setBounds(181, 275, 231, 20);
		txtUsername.setColumns(10);
		txtUsername.setName("txtUsername");
		txtUsername.setFocusTraversalKeysEnabled(false);
		txtUsername.addMouseListener(controller);
		txtUsername.addKeyListener(controller);
		panel.add(txtUsername);

		// Ajout d'un fond
		JLabel lblFond = new JLabel("fond");
		lblFond.setIcon(new ImageIcon(Log.class.getResource("/assets/fond_logpan.jpg")));
		lblFond.setBounds(0, 0, 594, 571);
		panel.add(lblFond);

		// Packing et affichage de la JFrame
		this.pack();
		this.setVisible(true);
	}

	/**
	 * Permet de récupérer le contenu du champ mdp
	 * 
	 * @return Mot de passe
	 */
	public String getPwd() {
		String pass = pwd.getText();
		return pass;
	}

	/**
	 * Permet de récupérer le contenu du champ username
	 * 
	 * @return Username
	 */
	public String getUsername() {
		String user = txtUsername.getText();
		return user;
	}

	/**
	 * Permet de supprimer le texte du champ mdp
	 */
	public void deletepwd() {
		pwd.setText("");
	}

	/**
	 * Permet de supprimer le texte du champ username
	 */
	public void deleteUsername() {
		txtUsername.setText("");
	}


	/**
	 * Permet de rajouter le focus à un composant
	 * 
	 * @param nameitem
	 */
	public void addfocus(String nameitem) {
		
		int n = panel.getComponentCount();

		for (int i = 1; i < n-1; i++) {
			if (nameitem == this.getContentPane().getComponent(i).getName()) {
				this.getContentPane().getComponent(i).requestFocus();
			}

		}
	}
}
