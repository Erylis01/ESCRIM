package gui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import javax.swing.border.LineBorder;
import controller.Bdd;
import controller.StockController;
import model.User;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.WindowConstants;
import javax.swing.JComboBox;
import javax.swing.JTable;
import java.awt.TextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
/**
 * Classe implémentant la fenêtre de gestion des stocks 
 * @author William
 *
 */
public class GestionStock extends JFrame {
	
	/**
	 * Ensemble des attributs de la classe
	 */
	private static final long serialVersionUID = 1L;
	private static String [] choix_stockage = Bdd.RecupNStockage(Bdd.ConnectDB());
	private static String [] choix_lot = Bdd.RecupNLot(Bdd.ConnectDB());
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private static JComboBox cBoxNStockage = new JComboBox(choix_stockage);
	private static JTable tabProduit = new JTable(new String[][]{{"","","",""},{"","","",""},{"","","",""},{"","","",""},{"","","",""},{"","","",""},{"","","",""},{"","","",""},{"","","",""},{"","","",""},{"","","",""},{"","","",""},{"","","",""},{"","","",""},{"","","",""},{"","","",""},{"","","",""},{"","","",""},{"","","",""},{"","","",""},{"","","",""},{"","","",""},{"","","",""},{"","","",""},{"","","",""},{"","","",""},{"","","",""},{"","","",""},{"","","",""},{"","","",""},{"","","",""},{"","","",""},{"","","",""},{"","","",""},{"","","",""},{"","","",""},{"","","",""},{"","","",""},{"","","",""},{"","","",""},{"","","",""},{"","","",""},{"","","",""},{"","","",""},{"","","",""},{"","","",""},{"","","",""},{"","","",""},{"","","",""},{"","","",""},{"","","",""},{"","","",""},{"","","",""},{"","","",""},{"","","",""},{"","","",""},{"","","",""},{"","","",""},{"","","",""},{"","","",""},{"","","",""},{"","","",""},{"","","",""},{"","","",""},{"","","",""},{"","","",""},{"","","",""},{"","","",""},{"","","",""}},new String[]{"Nom","Quantité","DLU","Lot"});
	private static JFrame gestionStock = new JFrame("Gestion Stock");
	private static JScrollPane scrollTab = new JScrollPane(tabProduit);
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private static JComboBox cBoxNLot = new JComboBox(choix_lot);
	private static TextField nLotASupprimer = new TextField();
	private final int LARGEUR_FENETRE = 600, HAUTEUR_FENETRE = 600;
	
	/**
	 * Constructeur général permettant la création et la mise en place de tous les éléments de la fenêtre
	 * @param user - utilisateur s'étant connecté
	 */
	public GestionStock(User user) {
		
		//Déclaration du contrôleur lié à la classe	
		StockController ecouteur = new StockController(this, user);
		
		//Mise en place de la fenêtre et de ses paramètres généraux
		gestionStock.setIconImage(Toolkit.getDefaultToolkit().getImage(GestionStock.class.getResource("/assets/icone.png")));
		Dimension screenSize = new Dimension(Toolkit.getDefaultToolkit().getScreenSize());
		gestionStock.setPreferredSize(new Dimension(this.LARGEUR_FENETRE, this.HAUTEUR_FENETRE));
		int windowLeftPosition = screenSize.width / 2 - this.LARGEUR_FENETRE / 2;
		int windowRightPostion = screenSize.height / 2 - this.HAUTEUR_FENETRE / 2;
		gestionStock.setLocation(windowLeftPosition, windowRightPostion);
		gestionStock.setResizable(false);
		gestionStock.setTitle("Gestion des stocks");
		gestionStock.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);	
		JPanel panel = new JPanel();
		gestionStock.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		//Déclaration du Panel qui contiendra les informations utilisateurs
		JPanel panel_user = new JPanel();
		panel_user.setLayout(null);
		panel_user.setForeground(Color.WHITE);
		panel_user.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panel_user.setBounds(0, 487, 161, 62);
		panel.add(panel_user);
		
		//Mise en place de l'icone du pane utilisateur
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(GestionStock.class.getResource("/assets/utilisateur.png")));
		label.setBounds(0, 11, 50, 50);
		panel_user.add(label);
		
		//Déclaration du premier champs du panel utiisateur
		JLabel label_1 = new JLabel("<dynamic>");
		if (user.isAdmin() == true) {
			label_1.setText("Administrateur");
		} else {
			label_1.setText("Utilisateur");
		}
		label_1.setBounds(60, 11, 48, 14);
		panel_user.add(label_1);
		
		//Déclaration du second champs du panel utilisateur
		JLabel label_2 = new JLabel(user.getUsername());
		label_2.setBounds(60, 36, 49, 14);
		panel_user.add(label_2);
	
		//Paramètrag du tableau de produit
		tabProduit.setLocation(41,185);
		
		//Mise en place su scrolling sur le tableau
		scrollTab.setSize(511, 297);
		scrollTab.setLocation(41,120);
		panel.add(scrollTab);
		
		//Mise en place du bouton Ajouter
		JButton btnAdd = new JButton("Ajouter");
		btnAdd.addActionListener(ecouteur);
		btnAdd.setBounds(108, 459, 139, 23);
		panel.add(btnAdd);
		
		//Mise en place du premier champs affichant le texte "N° de lot"
		JLabel lblNDeLot = new JLabel("N\u00B0 de lot :");
		lblNDeLot.setHorizontalAlignment(SwingConstants.CENTER);
		lblNDeLot.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNDeLot.setBounds(26, 431, 77, 14);
		panel.add(lblNDeLot);
		
		//Mise en place de la liste déroulante pour choisir le numéro de lot a ajouter
		//ComboBox passé en variable pour l'écouteur
		cBoxNLot.setFont(new Font("Tahoma", Font.PLAIN, 12));
		cBoxNLot.setMaximumRowCount(60);
		cBoxNLot.setBounds(108, 428, 138, 20);
		panel.add(cBoxNLot);
		
		//Mise en place de la liste déroulante pour choisir le numéro de stockage à afficher
		//ComboBox passé en variable pour l'écouteur
		cBoxNStockage.setFont(new Font("Tahoma", Font.PLAIN, 12));
		cBoxNStockage.setMaximumRowCount(60);
		cBoxNStockage.setBounds(304, 37, 123, 20);
		panel.add(cBoxNStockage);
		
		//Mise en place du premier champs affichant le texte "N° de stockage"
		JLabel lblNDeStockage = new JLabel("N\u00B0 de stockage :");
		lblNDeStockage.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNDeStockage.setBounds(171, 40, 106, 14);
		panel.add(lblNDeStockage);
		lblNDeStockage.setHorizontalAlignment(SwingConstants.CENTER);
	
		//Mise en place du bouton Afficher
		JButton btnAfficher = new JButton("Afficher");
		btnAfficher.addActionListener(ecouteur);
		btnAfficher.setBounds(304, 68, 123, 23);
		panel.add(btnAfficher);
		
		//Mise en place du bouton Supprimer
		JButton delSelect = new JButton("Supprimer");
		delSelect.addActionListener(ecouteur);
		delSelect.setBounds(388, 459, 123, 23);
		panel.add(delSelect);
		
		//Mise en place du deuxième champs affichant le texte "N° de lot"
		JLabel labelNDeLot2 = new JLabel("N\u00B0 de lot :");
		labelNDeLot2.setHorizontalAlignment(SwingConstants.CENTER);
		labelNDeLot2.setFont(new Font("Tahoma", Font.BOLD, 12));
		labelNDeLot2.setBounds(304, 431, 77, 14);
		panel.add(labelNDeLot2);
		
		//Mise en place du champs de texte contenant le lot a supprimer
		//TextField passé en variable pour écouteur
		nLotASupprimer.setBounds(390, 430, 121, 22);
		panel.add(nLotASupprimer);
		
		//Ajout du bouton Menu
		JLabel lblMenu = new JLabel("");
		lblMenu.setIcon(new ImageIcon(ChoisirConfig.class.getResource("/assets/menu.png")));
		lblMenu.setBounds(171, 502, 50, 50);
		lblMenu.setName("lblMenu");
		lblMenu.addMouseListener(ecouteur);
		panel.add(lblMenu);
		
		//Mise en place du fond de la fenêtre
		JLabel lblFond = new JLabel("New label");
		lblFond.setIcon(new ImageIcon(GestionStock.class.getResource("/assets/fond_logpan.jpg")));
		lblFond.setBounds(0, 0, 600, 561);
		panel.add(lblFond);
		
		//Mise en place de la barre de menu
		JMenuBar menuBar = new JMenuBar();
		gestionStock.getContentPane().add(menuBar, BorderLayout.NORTH);
		
		//Mise en place des boutons du premier onglet de la barre de menu
		JMenu mnUtilisateur = new JMenu("Utilisateur");
		menuBar.add(mnUtilisateur);
		JMenuItem mntmInscription = new JMenuItem("Inscription");
		mnUtilisateur.add(mntmInscription);

		//Mise en place du second onglet de la barre de menu
		JMenu mnAide = new JMenu("Aide");
		menuBar.add(mnAide);
		JMenuItem mntmGuide = new JMenuItem("Guide");
		mnAide.add(mntmGuide);
		JMenuItem mntmAPropos = new JMenuItem("A propos");
		mnAide.add(mntmAPropos);
		
		//Concaténation de toutes les informations
		gestionStock.pack();
		gestionStock.setVisible(true);
	}
	
	/**
	 * Renvoie la liste déroulante du numéro de stockage
	 * @return cBoxNStockage - JComboBox
	 */
	@SuppressWarnings("rawtypes")
	public static JComboBox getcBoxNStockage() {
		return cBoxNStockage;
	}
	
	/**
	 * Modifier la liste déroulante du numéro de stockage
	 * @param cBoxNStockage - JComboBox
	 */
	@SuppressWarnings("rawtypes")
	public static void setcBoxNStockage(JComboBox cBoxNStockage) {
		GestionStock.cBoxNStockage = cBoxNStockage;
	}
	
	/**
	 * Renvoie le tableau des produits
	 * @return tabProduit - JTable
	 */
	public static JTable getTabProduit() {
		return tabProduit;
	}
	
	
	/**
	 * Modifie le tableau des produits
	 * @param tabProduit - JTable
	 */
	public static void setTabProduit(JTable tabProduit) {
		GestionStock.tabProduit = tabProduit;
	}
	
	/**
	 * Renvoie la fenetre
	 * @return gestionStock - JFrame
	 */
	public static JFrame getGestionStock() {
		return gestionStock;
	}
	
	/**
	 * Modifie la fenêtre
	 * @param gestionStock - JFrame
	 */
	public static void setGestionStock(JFrame gestionStock) {
		GestionStock.gestionStock = gestionStock;
	}
	
	/**
	 * Renvoie le scrolling du tableau
	 * @return scrollTab - JScrollPane
	 */
	public static JScrollPane getScrollTab() {
		return scrollTab;
	}
	
	/**
	 * Modifie le scrolling du tableau
	 * @param scrollTab - JScrollPane
	 */
	public static void setScrollTab(JScrollPane scrollTab) {
		GestionStock.scrollTab = scrollTab;
	}
	
	/**
	 * Renvoie la liste déroulante du numéro de lot
	 * @return cBoxNLot - JComboBox
	 */
	@SuppressWarnings("rawtypes")
	public static JComboBox getcBoxNLot() {
		return cBoxNLot;
	}
	
	/**
	 * Modifie la liste déroulante du numéro de lot
	 * @param cBoxNLot - JComboBox
	 */
	@SuppressWarnings("rawtypes")
	public static void setcBoxNLot(JComboBox cBoxNLot) {
		GestionStock.cBoxNLot = cBoxNLot;
	}
	
	/**
	 *  Renvoie le champs de texte contenant le numéro de lot à supprimer
	 * @return nLotASupprimer - TextField
	 */
	public static TextField getnLotASupprimer() {
		return nLotASupprimer;
	}
	
	/**
	 * Modifie le champs de texte contenant le numéro de lot à supprimer
	 * @param nLotASupprimer - TextField
	 */
	public static void setnLotASupprimer(TextField nLotASupprimer) {
		GestionStock.nLotASupprimer = nLotASupprimer;
	}
	
	
}
