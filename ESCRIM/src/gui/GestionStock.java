package gui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JMenuBar;
import javax.swing.JTextPane;
import javax.swing.JMenu;
import javax.swing.JSeparator;
import javax.swing.border.LineBorder;

import controller.Bdd;
import controller.StockController;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JList;
import javax.swing.UIManager;
import javax.swing.AbstractListModel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import java.awt.TextField;
import javax.swing.JButton;
import javax.swing.JTextField;

public class GestionStock extends JFrame {
	
	private static String [] choix_stockage = Bdd.RecupNStockage(Bdd.ConnectDB());
	private String [] choix_lot = Bdd.RecupNLot(Bdd.ConnectDB());
	private StockController ecouteur = new StockController();
	private static JComboBox cBoxNStockage = new JComboBox(choix_stockage);
	private static JTable tabProduit = new JTable();
	private static JFrame gestionStock = new JFrame("Gestion Stock");
	
	public GestionStock() {
		gestionStock.setIconImage(Toolkit.getDefaultToolkit().getImage(GestionStock.class.getResource("/assets/icone.png")));
		
		gestionStock.setPreferredSize(new Dimension(600, 600));
		gestionStock.setResizable(false);
		gestionStock.setTitle("Gestion des stocks");
		gestionStock.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		gestionStock.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JPanel panel_user = new JPanel();
		panel_user.setLayout(null);
		panel_user.setForeground(Color.WHITE);
		panel_user.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panel_user.setBounds(0, 487, 161, 62);
		panel.add(panel_user);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(GestionStock.class.getResource("/assets/utilisateur.png")));
		label.setBounds(0, 11, 50, 50);
		panel_user.add(label);
		
		JLabel label_1 = new JLabel("<dynamic>");
		label_1.setBounds(60, 11, 48, 14);
		panel_user.add(label_1);
		
		JLabel label_2 = new JLabel("AdminInfo");
		label_2.setBounds(60, 36, 49, 14);
		panel_user.add(label_2);
		
		JButton btnAdd = new JButton("Ajouter");
		btnAdd.setBounds(108, 459, 139, 23);
		panel.add(btnAdd);
		
		JLabel lblQuantit = new JLabel("Quantit\u00E9 :");
		lblQuantit.setHorizontalAlignment(SwingConstants.CENTER);
		lblQuantit.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblQuantit.setBounds(26, 430, 77, 14);
		panel.add(lblQuantit);
		
		JLabel lblNDeLot = new JLabel("N\u00B0 de lot :");
		lblNDeLot.setHorizontalAlignment(SwingConstants.CENTER);
		lblNDeLot.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNDeLot.setBounds(26, 405, 77, 14);
		panel.add(lblNDeLot);
		
		JComboBox cBoxNLot = new JComboBox(choix_lot);
		cBoxNLot.setFont(new Font("Tahoma", Font.PLAIN, 12));
		cBoxNLot.setMaximumRowCount(60);
		cBoxNLot.setBounds(109, 403, 138, 20);
		panel.add(cBoxNLot);
		
		//Pass� en variable pour l'�couteur
		tabProduit.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tabProduit.setToolTipText("");
		tabProduit.setFont(new Font("Tahoma", Font.PLAIN, 12));
		tabProduit.setBorder(new LineBorder(new Color(0, 0, 0)));
		tabProduit.setBounds(26, 373, 529, -265);
		panel.add(tabProduit);
		
		//ComboBox pass� en variable pour l'�couteur
		cBoxNStockage.setFont(new Font("Tahoma", Font.PLAIN, 12));
		cBoxNStockage.setMaximumRowCount(60);
		cBoxNStockage.setBounds(304, 37, 123, 20);
		panel.add(cBoxNStockage);
		
		JLabel lblNDeStockage = new JLabel("N\u00B0 de stockage :");
		lblNDeStockage.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNDeStockage.setBounds(171, 40, 106, 14);
		panel.add(lblNDeStockage);
		lblNDeStockage.setHorizontalAlignment(SwingConstants.CENTER);
		
		TextField quantiteAAjouter = new TextField();
		quantiteAAjouter.setBounds(109, 428, 138, 22);
		panel.add(quantiteAAjouter);
	
		JButton btnAfficher = new JButton("Afficher");
		btnAfficher.addActionListener(ecouteur);
		btnAfficher.setBounds(304, 68, 123, 23);
		panel.add(btnAfficher);
		
		JButton delSelect = new JButton("Supprimer");
		delSelect.setBounds(388, 459, 123, 23);
		panel.add(delSelect);
		
		JLabel labelNDeLot2 = new JLabel("N\u00B0 de lot :");
		labelNDeLot2.setHorizontalAlignment(SwingConstants.CENTER);
		labelNDeLot2.setFont(new Font("Tahoma", Font.BOLD, 12));
		labelNDeLot2.setBounds(304, 431, 77, 14);
		panel.add(labelNDeLot2);
		
		TextField nLotASupprimer = new TextField();
		nLotASupprimer.setBounds(390, 430, 121, 22);
		panel.add(nLotASupprimer);
		
		JLabel lblFond = new JLabel("New label");
		lblFond.setIcon(new ImageIcon(GestionStock.class.getResource("/assets/fond_logpan.jpg")));
		lblFond.setBounds(0, 0, 600, 561);
		panel.add(lblFond);
		
		JMenuBar menuBar = new JMenuBar();
		gestionStock.getContentPane().add(menuBar, BorderLayout.NORTH);
		
		JMenu mnUtilisateur = new JMenu("Utilisateur");
		menuBar.add(mnUtilisateur);
		
		JMenu mnAide = new JMenu("Aide");
		menuBar.add(mnAide);
		
		gestionStock.pack();
		gestionStock.setVisible(true);
	}

	public static JComboBox getcBoxNStockage() {
		return cBoxNStockage;
	}

	public static void setcBoxNStockage(JComboBox cBoxNStockage) {
		GestionStock.cBoxNStockage = cBoxNStockage;
	}

	public static JTable getTabProduit() {
		return tabProduit;
	}

	public static void setTabProduit(JTable tabProduit) {
		GestionStock.tabProduit = tabProduit;
	}

	public static JFrame getGestionStock() {
		return gestionStock;
	}

	public static void setGestionStock(JFrame gestionStock) {
		GestionStock.gestionStock = gestionStock;
	}
	
	
	
}
