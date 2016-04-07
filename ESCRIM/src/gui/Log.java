package gui;

import javax.swing.JFrame;

import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.SwingConstants;
import javax.swing.SpringLayout;
import javax.swing.JTextField;
import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.FlowLayout;
import java.awt.Color;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import java.awt.SystemColor;


public class Log extends JFrame {

	private final int LARGEUR_FENETRE = 600, HAUTEUR_FENETRE = 600;
	private JPasswordField passwordField;
	private JTextField textField;

	public Log() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setEnabled(false);

		
		// Centrage de la fenêtre et choix de la taille de la fenêtre
		Dimension screenSize = new Dimension(Toolkit.getDefaultToolkit().getScreenSize());
		this.setPreferredSize(new Dimension(this.LARGEUR_FENETRE, this.HAUTEUR_FENETRE));
		int windowLeftPosition = screenSize.width / 2 - this.LARGEUR_FENETRE / 2;
		int windowRightPostion = screenSize.height / 2 - this.HAUTEUR_FENETRE / 2;
		this.setLocation(windowLeftPosition, windowRightPostion);

		// Choix du titre et de l'icone de la JFrame
		this.setTitle("Connexion");
		this.setIconImage(Toolkit.getDefaultToolkit().getImage(Log.class.getResource("/assets/icone.png")));
		
			
		// Packing et affichage de la JFrame
		this.pack();
		SpringLayout springLayout = new SpringLayout();
		getContentPane().setLayout(springLayout);
		
		JButton btnNewButton = new JButton("Connexion");
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBackground(new Color(255, 0, 0));
		springLayout.putConstraint(SpringLayout.WEST, btnNewButton, 166, SpringLayout.WEST, getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, btnNewButton, -190, SpringLayout.SOUTH, getContentPane());
		getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Inscription");
		btnNewButton_1.setForeground(Color.WHITE);
		btnNewButton_1.setBackground(new Color(0, 51, 204));
		springLayout.putConstraint(SpringLayout.NORTH, btnNewButton, 0, SpringLayout.NORTH, btnNewButton_1);
		springLayout.putConstraint(SpringLayout.EAST, btnNewButton, -6, SpringLayout.WEST, btnNewButton_1);
		springLayout.putConstraint(SpringLayout.WEST, btnNewButton_1, 290, SpringLayout.WEST, getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, btnNewButton_1, -190, SpringLayout.SOUTH, getContentPane());
		getContentPane().add(btnNewButton_1);
		
		passwordField = new JPasswordField("mot de passe");
		springLayout.putConstraint(SpringLayout.WEST, passwordField, 166, SpringLayout.WEST, getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, passwordField, -219, SpringLayout.SOUTH, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, passwordField, -176, SpringLayout.EAST, getContentPane());
		springLayout.putConstraint(SpringLayout.NORTH, btnNewButton_1, 6, SpringLayout.SOUTH, passwordField);
		springLayout.putConstraint(SpringLayout.EAST, btnNewButton_1, 0, SpringLayout.EAST, passwordField);
		getContentPane().add(passwordField);
		
		textField = new JTextField("Utilisateur");
		springLayout.putConstraint(SpringLayout.WEST, textField, 166, SpringLayout.WEST, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, textField, -176, SpringLayout.EAST, getContentPane());
		springLayout.putConstraint(SpringLayout.NORTH, passwordField, 6, SpringLayout.SOUTH, textField);
		springLayout.putConstraint(SpringLayout.SOUTH, textField, -248, SpringLayout.SOUTH, getContentPane());
		getContentPane().add(textField);
		
		JLabel lblNewLabel = new JLabel("");
		springLayout.putConstraint(SpringLayout.SOUTH, lblNewLabel, -277, SpringLayout.SOUTH, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, lblNewLabel, -176, SpringLayout.EAST, getContentPane());
		springLayout.putConstraint(SpringLayout.NORTH, textField, 6, SpringLayout.SOUTH, lblNewLabel);
		lblNewLabel.setIcon(new ImageIcon(Log.class.getResource("/assets/icone.png")));
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(Log.class.getResource("/assets/fond_logpan.jpg")));
		springLayout.putConstraint(SpringLayout.NORTH, lblNewLabel_1, 0, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, lblNewLabel_1, 0, SpringLayout.WEST, getContentPane());
		getContentPane().add(lblNewLabel_1);
		this.setVisible(true);

	}
}
