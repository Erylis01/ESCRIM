package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

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
import model.Historique;
import model.Plane;
import model.User;

import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JComboBox;

/**
 * Classe d'implémentation de la fenêtre de choix de configuration
 * @author William
 *
 */
public class ChoisirConfig extends JFrame {

	/**
	 * Attributs de la classe
	 */
	private static final long serialVersionUID = 1L;
	private ConfigController controller;
	@SuppressWarnings("unused")
	private Historique modele;
	private JPanel panel;
	private JTextField txtDate;
	private JTextField txtPays;
	@SuppressWarnings("unused")
	private JTable tableHistorique;
	private String[] choix_config = { "Base chaud", "Base froid", "Complet chaud", "Complet froid" };
	
	/**
	 * Méthode principal construisant la fenêtre 
	 * @param modele - Historique
	 * @param user - User
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public ChoisirConfig(Historique modele, User user) {

		this.modele = modele;
		controller = new ConfigController(this, modele, user);

		// Choix de la taille de la fenêtre
		Dimension screenSize = new Dimension(Toolkit.getDefaultToolkit().getScreenSize());
		this.setPreferredSize(new Dimension(screenSize.width * 4 / 5, screenSize.height * 4 / 5));
		int windowLeftPosition = screenSize.width / 2 - screenSize.width * 2 / 5;
		int windowRightPostion = screenSize.height / 2 - screenSize.height * 2 / 5;
		this.setLocation(windowLeftPosition, windowRightPostion);

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
		panel_user.setBounds(0, 501, 161, 62);
		panel.add(panel_user);
		panel_user.setLayout(null);

		// Ajout de l'image utilisateur
		JLabel lblUser = new JLabel("");
		lblUser.setBounds(0, 11, 50, 50);
		panel_user.add(lblUser);
		lblUser.setIcon(new ImageIcon(Menu.class.getResource("/assets/utilisateur.png")));

		// Ajout du label username
		JLabel lblUsername = new JLabel(user.getUsername());
		lblUsername.setBounds(60, 11, 91, 14);
		panel_user.add(lblUsername);

		// Ajout du label avec information des droits
		JLabel lblAdmininfo = new JLabel();
		if (user.isAdmin() == true) {
			lblAdmininfo.setText("Administrateur");
		} else {
			lblAdmininfo.setText("Utilisateur");
		}
		lblAdmininfo.setBounds(60, 36, 91, 14);
		panel_user.add(lblAdmininfo);

		// Ajout du label "Choisir Avion"
		JLabel lblAvion = new JLabel("Choisir Avion :");
		lblAvion.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblAvion.setBounds(114, 45, 88, 15);
		panel.add(lblAvion);

		// Ajout d'une liste de choix d'avions
		Plane p = new Plane();
		p.getList();
		p.affichage();
		JComboBox listAvion = new JComboBox(p.getListType());
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
		btnChoisir.setName("btnChoisir");
		btnChoisir.addActionListener(controller);
		panel.add(btnChoisir);

		// Ajout du label "Date"
		JLabel lblDate = new JLabel("Date (yyyy-mm-dd) :");
		lblDate.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblDate.setBounds(811, 205, 127, 15);
		panel.add(lblDate);

		// Ajout d'un champ de texte pour la date
		txtDate = new JTextField();
		txtDate.setBounds(811, 228, 121, 20);
		panel.add(txtDate);
		txtDate.setColumns(10);

		// Ajout d'un label pour le pays
		JLabel lblPays = new JLabel("Pays :");
		lblPays.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblPays.setBounds(811, 301, 46, 14);
		panel.add(lblPays);

		// Ajout d'un champ de texte pour le pays
		txtPays = new JTextField();
		txtPays.setBounds(811, 326, 121, 20);
		panel.add(txtPays);
		txtPays.setColumns(10);

		// Ajout du bouton filtrer
		JButton btnFiltrer = new JButton("Filtrer");
		btnFiltrer.setBackground(Color.BLUE);
		btnFiltrer.setForeground(Color.WHITE);
		btnFiltrer.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnFiltrer.setBounds(828, 403, 89, 23);
		btnFiltrer.setName("btnFiltrer");
		btnFiltrer.addActionListener(controller);
		panel.add(btnFiltrer);

		// Ajout du tableau d'historique
		JTable table = new JTable(modele);
		JScrollPane tableHistorique = new JScrollPane(table);
		tableHistorique.setLocation(41, 185);
		tableHistorique.setSize(600, 241);
		panel.add(tableHistorique);

		// Ajout du bouton Menu
		JLabel lblMenu = new JLabel("");
		lblMenu.setIcon(new ImageIcon(ChoisirConfig.class.getResource("/assets/menu.png")));
		lblMenu.setBounds(171, 502, 50, 50);
		lblMenu.setName("lblMenu");
		lblMenu.addMouseListener(controller);
		panel.add(lblMenu);

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

	/**
	 * Permet de récupérer la date rentrer par l'utilisateur
	 * @return sqlDate - Date
	 * @throws ParseException
	 */
	public Date getdate() throws ParseException {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-mm-dd");
		java.sql.Date sqlDate;
		System.out.println(txtDate.getText());
		if (txtDate.getText() != "") {
			java.util.Date date = formatter.parse(txtDate.getText());
			sqlDate = new Date(date.getTime());
		} else {
			sqlDate = null;
		}
		return sqlDate;
	}
	
	/**
	 * Getters du text contenant le pays
	 * @return txtPays - String
	 */
	public String getPays() {
		return txtPays.getText();
	}
}
