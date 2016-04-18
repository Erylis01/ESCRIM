package gui;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

import controller.MenuController;
import model.User;

import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.ImageIcon;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Font;


public class Menu extends JFrame {

	private MenuController controller;
	private User modele;
	private final int LARGEUR_FENETRE = 600, HAUTEUR_FENETRE = 600;

	public Menu(User u) {
		
		this.modele=u;
		controller = new MenuController(this,u);

		// Centrage de la fenêtre et choix de la taille de la fenêtre
		Dimension screenSize = new Dimension(Toolkit.getDefaultToolkit().getScreenSize());
		this.setPreferredSize(new Dimension(this.LARGEUR_FENETRE, this.HAUTEUR_FENETRE));
		int windowLeftPosition = screenSize.width / 2 - this.LARGEUR_FENETRE / 2;
		int windowRightPostion = screenSize.height / 2 - this.HAUTEUR_FENETRE / 2;
		this.setLocation(windowLeftPosition, windowRightPostion);

		// Empêche la fenêtre d'être redimensionnée
		setResizable(false);

		// Choix du titre et de l'icone de la JFrame
		this.setTitle("Menu");
		this.setIconImage(Toolkit.getDefaultToolkit().getImage(Log.class.getResource("/assets/icone.png")));

		// Enregistrement de l'option EXIT_ON_CLOSE lors de la fermeture de la
		// fenêtre (arrêt du procéssus)
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);

		// Ajout d'un panel qui contiendra tout
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 594, 571);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		// Ajout du bouton "Choisir Configuration"
		JLabel lblConfig = new JLabel("");
		lblConfig.setIcon(new ImageIcon(Menu.class.getResource("/assets/choisir_config.png")));
		lblConfig.setBounds(199, 187, 180, 180);
		lblConfig.setName("lblConfig");
		lblConfig.addMouseListener(controller);
		panel.add(lblConfig);
		
		// Ajout du bouton "Modifier Produit"
		JLabel lblProduit = new JLabel("");
		lblProduit.setIcon(new ImageIcon(Menu.class.getResource("/assets/modif_produit.png")));
		lblProduit.setBounds(0, 0, 170, 170);
		lblProduit.setName("lblProduit");
		lblProduit.addMouseListener(controller);
		panel.add(lblProduit);
		
		//Ajout du bouton "Gestion des stocks"
		JLabel lblStock = new JLabel("");
		lblStock.setIcon(new ImageIcon(Menu.class.getResource("/assets/gestion_stock.png")));
		lblStock.setBounds(414, 369, 180, 180);
		lblStock.setName("lblStock");
		lblStock.addMouseListener(controller);
		panel.add(lblStock);
			
		// Ajout du panel contenant les infos utilisateur
		JPanel panel_user = new JPanel();
		panel_user.setForeground(Color.WHITE);
		panel_user.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panel_user.setBounds(0, 480, 170, 69);
		panel.add(panel_user);
		panel_user.setLayout(null);
		
		// Ajout de l'image utilisateur
		JLabel lblUser = new JLabel("");
		lblUser.setBounds(0, 11, 50, 50);
		panel_user.add(lblUser);
		lblUser.setIcon(new ImageIcon(Menu.class.getResource("/assets/utilisateur.png")));
		
		// Ajout du label avec information des droits
		JLabel lblAdmininfo = new JLabel();
		lblAdmininfo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblAdmininfo.setBounds(60, 11, 91, 29);
		if (modele.isAdmin()==true){
			lblAdmininfo.setText("Administrateur");
		}else{
			lblAdmininfo.setText("Utilisateur");
		}
		panel_user.add(lblAdmininfo);
		
		//Ajout du label username
		JLabel lblUsername = new JLabel(modele.getUsername());
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblUsername.setBounds(60, 32, 91, 29);
		panel_user.add(lblUsername);
		
		
		// Ajout du fond
		JLabel lblFond = new JLabel("");
		lblFond.setIcon(new ImageIcon(Menu.class.getResource("/assets/fond_logpan.jpg")));
		lblFond.setBounds(0, 0, 600, 600);
		panel.add(lblFond);

		
		// Ajout de la barre menu
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		// Ajout du menu utilisateur
		JMenu mnUtilisateur = new JMenu("Utilisateur");
		menuBar.add(mnUtilisateur);
		JMenuItem mntmInscription = new JMenuItem("Inscription");
		mnUtilisateur.add(mntmInscription);
		
		// Ajout du menu Aide
		JMenu mnAide = new JMenu("Aide");
		menuBar.add(mnAide);
		JMenuItem mntmGuide = new JMenuItem("Guide");
		mnAide.add(mntmGuide);
		JMenuItem mntmAPropos = new JMenuItem("A propos");
		mnAide.add(mntmAPropos);
		
		// Packing et affichage de la JFrame
		this.pack();
		this.setVisible(true);
	}
}
