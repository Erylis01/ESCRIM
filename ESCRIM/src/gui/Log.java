package gui;

import javax.swing.JFrame;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

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
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Log extends JFrame implements ActionListener, KeyListener {

	private final int LARGEUR_FENETRE = 600, HAUTEUR_FENETRE = 600;
	private JButton btnConnexion, btnInscription;
	private JPasswordField passwordField;
	private JTextField UserField;
	private String Username = null;

	public Log() {

		
		// Enregistrement de l'option EXIT_ON_CLOSE lors de la fermeture de la
		// fenêtre (arrêt du procéssus)
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
		btnConnexion.addKeyListener(this);
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
		passwordField.addKeyListener(this);
		passwordField.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				passwordField.setText("");
			}
		});
		this.getContentPane().add(passwordField);

		// Ajout du champ pour le nom d'utilisateur
		UserField = new JTextField("Utilisateur");
		springLayout.putConstraint(SpringLayout.WEST, UserField, 166, SpringLayout.WEST, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, UserField, -176, SpringLayout.EAST, getContentPane());
		springLayout.putConstraint(SpringLayout.NORTH, passwordField, 6, SpringLayout.SOUTH, UserField);
		springLayout.putConstraint(SpringLayout.SOUTH, UserField, -248, SpringLayout.SOUTH, getContentPane());
		UserField.setFocusTraversalKeysEnabled(false);
		UserField.addKeyListener(this);
		UserField.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				UserField.setText("");
			}
		});
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
				Username = UserField.getText();
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
		} else if (source == btnInscription) {
			JPanel panel = new JPanel(new GridLayout(0, 1));
			JTextField field1 = new JTextField("");
			JTextField field2 = new JTextField("");
			JTextField field3 = new JTextField("");
			JTextField field4 = new JTextField("");
			panel.add(new JLabel("Nom"));
			panel.add(field1);
			panel.add(new JLabel("Prénom"));
			panel.add(field2);
			panel.add(new JLabel("Username"));
			panel.add(field3);
			panel.add(new JLabel("Mot de passe"));
			panel.add(field4);
			int result = JOptionPane.showConfirmDialog(null, panel, "Inscription", JOptionPane.OK_CANCEL_OPTION,
					JOptionPane.PLAIN_MESSAGE);
			if (result == 0) {
				Connection conn = Bdd.ConnectDB();
				Bdd.Add_User(field3.getText(), field4.getText(), field1.getText(), field2.getText(), conn);
				this.dispose();
				Menu m = new Menu();
			}

		}
	}

	@Override
	public void keyPressed(KeyEvent e) {
		
		System.out.println(e.getKeyCode());
		// TODO Auto-generated method stub
		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			Connection conn = Bdd.ConnectDB();
			boolean authenticated = false;
			try {
				authenticated = Bdd.Authenticate(UserField.getText(), passwordField.getText(), conn);
			} catch (NoSuchAlgorithmException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			Username = UserField.getText();
			if (authenticated == true) {
				this.dispose();
				Menu m = new Menu();
			} else {
				JOptionPane.showMessageDialog(this, "Le nom d'utilisateur ou le mot de passe ne sont pas valides");
			}
		}else if (e.getKeyCode()==KeyEvent.VK_TAB){
			passwordField.requestFocus();
			passwordField.setText("");
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

}
