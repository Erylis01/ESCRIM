package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.WindowConstants;
import javax.swing.border.LineBorder;

import controller.ConfigController;
import controller.LogController;
import model.Config;
import model.Historique;

import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JTable;
import javax.swing.JComboBox;

public class ChoisirConfig extends JFrame {

	private ConfigController controller;
	private Config modele;
	private JPanel panel;
	private JTextField txtDate;
	private JTextField txtPays;
	private JTable tableHistorique;
	private String [] choix_config =  {"Base chaud","Base froid","Complet chaud","Complet froid"};

	public ChoisirConfig(String Username) {

		// this.modele = modele;
		// controller = new ConfigController(this, modele);

		// Choix de la taille de la fenêtre
		Dimension screenSize = new Dimension(Toolkit.getDefaultToolkit().getScreenSize());
		this.setPreferredSize(new Dimension(screenSize.width, screenSize.height));

		// Empêche la fenêtre d'être redimensionnée
		setResizable(false);

		// Choix du titre et de l'icone de la JFrame
		this.setTitle("Choisir une configuration");
		this.setIconImage(Toolkit.getDefaultToolkit().getImage(Log.class.getResource("/assets/icone.png")));

		// Enregistrement de l'option EXIT_ON_CLOSE lors de la fermeture de la
		// fenêtre (arrêt du procéssus)
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);

		// Ajout d'un panel qui contiendra tout
		panel = new JPanel();
		panel.setBounds(0, 0, 1360, 739);
		getContentPane().add(panel);
		panel.setLayout(null);

		// Ajout du panel contenant les infos utilisateur
		JPanel panel_user = new JPanel();
		panel_user.setForeground(Color.WHITE);
		panel_user.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panel_user.setBounds(0, 654, 161, 62);
		panel.add(panel_user);
		panel_user.setLayout(null);

		// Ajout de l'image utilisateur
		JLabel lblUser = new JLabel("");
		lblUser.setBounds(0, 11, 50, 50);
		panel_user.add(lblUser);
		lblUser.setIcon(new ImageIcon(Menu.class.getResource("/assets/utilisateur.png")));

		// Ajout du label username
		JLabel lblUsername = new JLabel(Username);
		lblUsername.setBounds(60, 11, 48, 14);
		panel_user.add(lblUsername);

		// Ajout du label avec information des droits
		JLabel lblAdmininfo = new JLabel("AdminInfo");
		lblAdmininfo.setBounds(60, 36, 49, 14);
		panel_user.add(lblAdmininfo);
		
		// Ajout du label "Choisir Avion"
		JLabel lblAvion = new JLabel("Choisir Avion :");
		lblAvion.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblAvion.setBounds(114, 45, 88, 15);
		panel.add(lblAvion);
		
		// Ajout d'une liste de choix d'avions
		JComboBox listAvion = new JComboBox();
		listAvion.setBackground(Color.WHITE);
		listAvion.setBounds(212, 45, 121, 20);
		panel.add(listAvion);
		
		// Ajout du label "Choisir Configuration"
		JLabel lblConfiguration = new JLabel("Choisir Configuration :");
		lblConfiguration.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblConfiguration.setBounds(64, 105, 138, 15);
		panel.add(lblConfiguration);
		
		// Ajout d'une liste de choix de configuration
		JComboBox listConfig = new JComboBox(choix_config);
		listConfig.setBackground(Color.WHITE);
		listConfig.setBounds(213, 105, 120, 20);
		panel.add(listConfig);
		
		// Ajout du bouton Choisir
		JButton btnChoisir = new JButton("Choisir");
		btnChoisir.setBackground(Color.RED);
		btnChoisir.setForeground(Color.WHITE);
		btnChoisir.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnChoisir.setBounds(450, 70, 89, 23);
		panel.add(btnChoisir);
		
		// Ajout du label "Date"
		JLabel lblDate = new JLabel("Date :");
		lblDate.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblDate.setBounds(1229, 246, 37, 15);
		panel.add(lblDate);
		
		// Ajout d'un champ de texte pour la date
		txtDate = new JTextField();
		txtDate.setBounds(1229, 265, 121, 20);
		panel.add(txtDate);
		txtDate.setColumns(10);
		
		// Ajout d'un label pour le pays
		JLabel lblPays = new JLabel("Pays :");
		lblPays.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblPays.setBounds(1229, 344, 46, 14);
		panel.add(lblPays);
		
		// Ajout d'un champ de texte pour le pays
		txtPays = new JTextField();
		txtPays.setBounds(1229, 361, 121, 20);
		panel.add(txtPays);
		txtPays.setColumns(10);
		
		// Ajout du bouton filtrer
		JButton btnFiltrer = new JButton("Filtrer");
		btnFiltrer.setBackground(Color.BLUE);
		btnFiltrer.setForeground(Color.WHITE);
		btnFiltrer.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnFiltrer.setBounds(1249, 425, 89, 23);
		btnFiltrer.setName("btnFiltrer");
		panel.add(btnFiltrer);
		
		// Ajout du tableau d'historique
		
		Historique h =new Historique ();
		h.getList();
		JTable table = new JTable();
		JScrollPane tableHistorique=new JScrollPane(table);
		tableHistorique.setLocation(41, 185);
		tableHistorique.setSize(600, 400);
		panel.add(tableHistorique);

		// Ajout du fond
		JLabel lblFond = new JLabel("");
		lblFond.setIcon(new ImageIcon(ChoisirConfig.class.getResource("/assets/fond_logpan.jpg")));
		lblFond.setBounds(0, 0, screenSize.width, screenSize.height);
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
