package gui;

import javax.swing.JFrame;

import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import controller.Bdd;
import javax.swing.SpringLayout;
import javax.swing.WindowConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JPasswordField;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Log extends JFrame implements ActionListener {

	private final int LARGEUR_FENETRE = 600, HAUTEUR_FENETRE = 600;
	private JButton btnConnexion, btnInscription;
	private JPasswordField passwordField;
	private JTextField UserField;

	public Log() {

		// Enregistrement de l'option EXIT_ON_CLOSE lors de la fermeture de la fenêtre (arrêt du procéssus)
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

		// Empêcher agrandissement fenêtre
		this.setResizable(false);

		// Centrage de la fenêtre et choix de la taille de la fenêtre
		Dimension screenSize = new Dimension(Toolkit.getDefaultToolkit().getScreenSize());
		this.setPreferredSize(new Dimension(this.LARGEUR_FENETRE, this.HAUTEUR_FENETRE));
		int windowLeftPosition = screenSize.width / 2 - this.LARGEUR_FENETRE / 2;
		int windowRightPostion = screenSize.height / 2 - this.HAUTEUR_FENETRE / 2;
		this.setLocation(windowLeftPosition, windowRightPostion);

		// Choix du titre et de l'icone de la JFrame
		this.setTitle("Connexion");
		this.setIconImage(Toolkit.getDefaultToolkit().getImage(Log.class.getResource("/assets/icone.png")));

		// Ajout d'un layout à la JFrame
		this.getContentPane().setEnabled(false);
		SpringLayout springLayout = new SpringLayout();
		this.getContentPane().setLayout(springLayout);

		// Ajout du bouton de Connexion
		btnConnexion = new JButton("Connexion");
		btnConnexion.setForeground(Color.WHITE);
		btnConnexion.setBackground(new Color(255, 0, 0));
		springLayout.putConstraint(SpringLayout.WEST, btnConnexion, 166, SpringLayout.WEST, getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, btnConnexion, -190, SpringLayout.SOUTH, getContentPane());
		btnConnexion.addActionListener(this);
		this.getContentPane().add(btnConnexion);

		// Ajout du bouton d'Inscription
		btnInscription = new JButton("Inscription");
		btnInscription.setForeground(Color.WHITE);
		btnInscription.setBackground(new Color(0, 51, 204));
		springLayout.putConstraint(SpringLayout.NORTH, btnConnexion, 0, SpringLayout.NORTH, btnInscription);
		springLayout.putConstraint(SpringLayout.EAST, btnConnexion, -6, SpringLayout.WEST, btnInscription);
		springLayout.putConstraint(SpringLayout.WEST, btnInscription, 290, SpringLayout.WEST, getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, btnInscription, -190, SpringLayout.SOUTH, getContentPane());
		btnInscription.addActionListener(this);
		this.getContentPane().add(btnInscription);

		// Ajout du champ pour le mot de passe
		passwordField = new JPasswordField("mot de passe");
		springLayout.putConstraint(SpringLayout.WEST, passwordField, 166, SpringLayout.WEST, getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, passwordField, -219, SpringLayout.SOUTH, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, passwordField, -176, SpringLayout.EAST, getContentPane());
		springLayout.putConstraint(SpringLayout.NORTH, btnInscription, 6, SpringLayout.SOUTH, passwordField);
		springLayout.putConstraint(SpringLayout.EAST, btnInscription, 0, SpringLayout.EAST, passwordField);
		passwordField.addActionListener(this);
		this.getContentPane().add(passwordField);

		// Ajout du champ pour le nom d'utilisateur
		UserField = new JTextField("Utilisateur");
		springLayout.putConstraint(SpringLayout.WEST, UserField, 166, SpringLayout.WEST, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, UserField, -176, SpringLayout.EAST, getContentPane());
		springLayout.putConstraint(SpringLayout.NORTH, passwordField, 6, SpringLayout.SOUTH, UserField);
		springLayout.putConstraint(SpringLayout.SOUTH, UserField, -248, SpringLayout.SOUTH, getContentPane());
		this.getContentPane().add(UserField);

		// Ajout de l'image ESCRIM
		JLabel imgEscrim = new JLabel("");
		springLayout.putConstraint(SpringLayout.SOUTH, imgEscrim, -277, SpringLayout.SOUTH, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, imgEscrim, -176, SpringLayout.EAST, getContentPane());
		springLayout.putConstraint(SpringLayout.NORTH, UserField, 6, SpringLayout.SOUTH, imgEscrim);
		imgEscrim.setIcon(new ImageIcon(Log.class.getResource("/assets/icone.png")));
		this.getContentPane().add(imgEscrim);

		// Ajout du fond
		JLabel imgFond = new JLabel("");
		imgFond.setIcon(new ImageIcon(Log.class.getResource("/assets/fond_logpan.jpg")));
		springLayout.putConstraint(SpringLayout.NORTH, imgFond, 0, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, imgFond, 0, SpringLayout.WEST, getContentPane());
		this.getContentPane().add(imgFond);

		// Packing et affichage de la JFrame
		this.pack();
		this.setVisible(true);

	}

	public void actionPerformed(ActionEvent e) {

		Object source = e.getSource();

		if (source == btnConnexion) {
			Connection conn = Bdd.ConnectDB();
			try {
				boolean authenticated = Bdd.Authenticate(UserField.getText(), passwordField.getText(), conn);
				if (authenticated == true) {
					this.dispose();
					Menu m = new Menu();
				} else {
					JOptionPane.showMessageDialog(this, "Le nom d'utilisateur ou le mot de passe ne sont pas valides");
				}

			} catch (NoSuchAlgorithmException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}else if (source==btnInscription){
			JOptionPane.showMessageDialog(this, "Pas d'action sur le bouton");
		}else if (source==passwordField){
			passwordField.setText("");
		}
	}
}
