package gui;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import javax.swing.JPanel;
import java.awt.GridBagConstraints;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.SpringLayout;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.ImageIcon;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.Insets;
import javax.swing.JButton;

public class ModifProduit extends JFrame {

	private final int LARGEUR_FENETRE = 600, HAUTEUR_FENETRE = 600;
	private JTextField textFieldQuant;
	private JTextField textFieldDCI;
	private JTextField textFieldDosage;
	private JTextField textFieldNCaisse;
	private JTextField textFieldClasse;
	private JTextField textFieldLot;
	private JTextField textFieldDLU;
	private JTextField textFieldCaisse;
	private JTextField textFieldDotation;

	public ModifProduit() {
		getContentPane().setEnabled(false);
		getContentPane().setLayout(null);
		
		JLabel lblNomDuProduit = new JLabel("Nom du produit ");
		lblNomDuProduit.setFont(new Font("AR ESSENCE", Font.BOLD, 25));
		lblNomDuProduit.setBounds(10, 15, 210, 39);
		getContentPane().add(lblNomDuProduit);
		
		JLabel lblQuant = new JLabel("Quantit\u00E9 :");
		lblQuant.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblQuant.setBounds(358, 28, 61, 17);
		getContentPane().add(lblQuant);
		
		textFieldQuant = new JTextField();
		textFieldQuant.setBounds(430, 27, 86, 20);
		getContentPane().add(textFieldQuant);
		textFieldQuant.setColumns(10);
		
		JLabel imgVoyant = new JLabel("");
		imgVoyant.setIcon(new ImageIcon(ModifProduit.class.getResource("/assets/voyant_vert.png")));
		imgVoyant.setBounds(524, 11, 50, 50);
		getContentPane().add(imgVoyant);
		
		JButton btnAjouter = new JButton("Ajouter");
		btnAjouter.setForeground(new Color(255, 255, 255));
		btnAjouter.setBackground(new Color(0, 0, 255));
		btnAjouter.setBounds(144, 485, 89, 23);
		getContentPane().add(btnAjouter);
		
		JButton btnModifier = new JButton("Modifier");
		btnModifier.setBackground(new Color(255, 0, 0));
		btnModifier.setForeground(new Color(255, 255, 255));
		btnModifier.setBounds(339, 485, 89, 23);
		getContentPane().add(btnModifier);
		
		JLabel lblDCI = new JLabel("DCI :");
		lblDCI.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblDCI.setBounds(104, 140, 27, 15);
		getContentPane().add(lblDCI);
		
		JLabel lblDosage = new JLabel("Dosage :");
		lblDosage.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblDosage.setBounds(83, 219, 48, 15);
		getContentPane().add(lblDosage);
		
		JLabel lblCaisse = new JLabel("Caisse :");
		lblCaisse.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblCaisse.setBounds(379, 299, 40, 15);
		getContentPane().add(lblCaisse);
		
		JLabel lblNCaisse = new JLabel("N\u00B0 Caisse :");
		lblNCaisse.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNCaisse.setBounds(73, 299, 58, 15);
		getContentPane().add(lblNCaisse);
		
		JLabel lblNLot = new JLabel("N\u00B0 Lot :");
		lblNLot.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNLot.setBounds(376, 140, 44, 15);
		getContentPane().add(lblNLot);
		
		JLabel lblClasse = new JLabel("Classe th\u00E9rapeutique :");
		lblClasse.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblClasse.setBounds(9, 379, 122, 15);
		getContentPane().add(lblClasse);
		
		JLabel lblDotation = new JLabel("Dotation U7 :");
		lblDotation.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblDotation.setBounds(345, 379, 74, 15);
		getContentPane().add(lblDotation);
		
		JLabel lblDateLimiteDutilisation = new JLabel("Date limite d'utilisation :");
		lblDateLimiteDutilisation.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblDateLimiteDutilisation.setBounds(289, 219, 130, 15);
		getContentPane().add(lblDateLimiteDutilisation);
		
		textFieldDCI = new JTextField();
		textFieldDCI.setBounds(134, 137, 109, 20);
		getContentPane().add(textFieldDCI);
		textFieldDCI.setColumns(10);
		
		textFieldDosage = new JTextField();
		textFieldDosage.setBounds(134, 217, 109, 20);
		getContentPane().add(textFieldDosage);
		textFieldDosage.setColumns(10);
		
		textFieldNCaisse = new JTextField();
		textFieldNCaisse.setBounds(134, 297, 109, 20);
		getContentPane().add(textFieldNCaisse);
		textFieldNCaisse.setColumns(10);
		
		textFieldClasse = new JTextField();
		textFieldClasse.setText("");
		textFieldClasse.setBounds(134, 377, 109, 20);
		getContentPane().add(textFieldClasse);
		textFieldClasse.setColumns(10);
		
		textFieldLot = new JTextField();
		textFieldLot.setBounds(424, 137, 109, 20);
		getContentPane().add(textFieldLot);
		textFieldLot.setColumns(10);
		
		textFieldDLU = new JTextField();
		textFieldDLU.setText("");
		textFieldDLU.setBounds(424, 217, 109, 20);
		getContentPane().add(textFieldDLU);
		textFieldDLU.setColumns(10);
		
		textFieldCaisse = new JTextField();
		textFieldCaisse.setBounds(424, 297, 109, 20);
		getContentPane().add(textFieldCaisse);
		textFieldCaisse.setColumns(10);
		
		textFieldDotation = new JTextField();
		textFieldDotation.setBounds(424, 377, 109, 20);
		getContentPane().add(textFieldDotation);
		textFieldDotation.setColumns(10);
		
		JLabel imgFond = new JLabel("");
		imgFond.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		imgFond.setIcon(new ImageIcon(ModifProduit.class.getResource("/assets/fond_logpan.jpg")));
		imgFond.setBounds(0, 0, 600, 600);
		getContentPane().add(imgFond);
		


		/*
		 * // Efface le contenu de la Jframe f.getContentPane().removeAll();
		 * f.getContentPane().repaint();
		 */

		// Centrage de la fenêtre et choix de la taille de la fenêtre
		Dimension screenSize = new Dimension(Toolkit.getDefaultToolkit().getScreenSize());
		this.setPreferredSize(new Dimension(this.LARGEUR_FENETRE, this.HAUTEUR_FENETRE));
		int windowLeftPosition = screenSize.width / 2 - this.LARGEUR_FENETRE / 2;
		int windowRightPostion = screenSize.height / 2 - this.HAUTEUR_FENETRE / 2;
		this.setLocation(windowLeftPosition, windowRightPostion);

		// Change l'icone de la fenêtre
		setIconImage(Toolkit.getDefaultToolkit().getImage(Menu.class.getResource("/assets/icone.png")));

		// Ajout d'un menu
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnHelp = new JMenu("Help");
		menuBar.add(mnHelp);

		JMenuItem mntmGuide = new JMenuItem("Guide");
		mnHelp.add(mntmGuide);

		JMenuItem mntmAPropos = new JMenuItem("A Propos");
		mnHelp.add(mntmAPropos);

		// Packing et affichage de la JFrame
		this.pack();
		this.setVisible(true);
		
		
	}
}
