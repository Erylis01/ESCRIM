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

public class ModifProduit extends JFrame {

	Dimension screenSize = new Dimension(Toolkit.getDefaultToolkit().getScreenSize());
	private final int LARGEUR_FENETRE = screenSize.width, HAUTEUR_FENETRE = screenSize.height;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;

	public ModifProduit() {
		
		getContentPane().setEnabled(false);

		/*
		 * // Efface le contenu de la Jframe f.getContentPane().removeAll();
		 * f.getContentPane().repaint();
		 */

		// Centrage de la fenêtre et choix de la taille de la fenêtre
		this.setPreferredSize(new Dimension(this.LARGEUR_FENETRE, this.HAUTEUR_FENETRE));
		int windowLeftPosition = screenSize.width / 2 - this.LARGEUR_FENETRE / 2;
		int windowRightPostion = screenSize.height / 2 - this.HAUTEUR_FENETRE / 2;
		this.setLocation(windowLeftPosition, windowRightPostion);

		// Change l'icone de la fenêtre
		setIconImage(Toolkit.getDefaultToolkit().getImage(Menu.class.getResource("/assets/icone.png")));

		SpringLayout springLayout = new SpringLayout();
		getContentPane().setLayout(springLayout);
		
		JPanel panel = new JPanel();
		springLayout.putConstraint(SpringLayout.NORTH, panel, 630, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, panel, 0, SpringLayout.WEST, getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, panel, 0, SpringLayout.SOUTH, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, panel, -1182, SpringLayout.EAST, getContentPane());
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(ModifProduit.class.getResource("/assets/utilisateur.png")));
		lblNewLabel.setBounds(10, 11, 50, 50);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setBounds(69, 11, 46, 14);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setBounds(70, 47, 46, 14);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon(ModifProduit.class.getResource("/assets/voyant_vert.png")));
		getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Nom du produit");
		springLayout.putConstraint(SpringLayout.WEST, lblNewLabel_4, 40, SpringLayout.WEST, getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, lblNewLabel_4, -659, SpringLayout.SOUTH, getContentPane());
		lblNewLabel_4.setFont(new Font("AR ESSENCE", Font.BOLD, 20));
		getContentPane().add(lblNewLabel_4);
		
		JLabel lblDci = new JLabel("DCI :");
		getContentPane().add(lblDci);
		
		textField = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, textField, 70, SpringLayout.SOUTH, lblNewLabel_4);
		springLayout.putConstraint(SpringLayout.EAST, lblNewLabel_4, 0, SpringLayout.EAST, textField);
		springLayout.putConstraint(SpringLayout.NORTH, lblDci, 3, SpringLayout.NORTH, textField);
		springLayout.putConstraint(SpringLayout.EAST, lblDci, -6, SpringLayout.WEST, textField);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		springLayout.putConstraint(SpringLayout.WEST, textField_1, 0, SpringLayout.WEST, textField);
		getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Forme Dosage :");
		springLayout.putConstraint(SpringLayout.WEST, lblNewLabel_5, 359, SpringLayout.WEST, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, textField, -115, SpringLayout.WEST, lblNewLabel_5);
		getContentPane().add(lblNewLabel_5);
		
		JLabel lblDateLimiteDutilisation = new JLabel("Date limite d'utilisation :");
		springLayout.putConstraint(SpringLayout.EAST, lblDateLimiteDutilisation, 0, SpringLayout.EAST, lblNewLabel_5);
		getContentPane().add(lblDateLimiteDutilisation);
		
		textField_2 = new JTextField();
		springLayout.putConstraint(SpringLayout.SOUTH, lblNewLabel_3, -60, SpringLayout.NORTH, textField_2);
		springLayout.putConstraint(SpringLayout.EAST, lblNewLabel_3, 0, SpringLayout.EAST, textField_2);
		springLayout.putConstraint(SpringLayout.NORTH, textField_2, 119, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, textField_2, 6, SpringLayout.EAST, lblNewLabel_5);
		getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblQuantit = new JLabel("Quantit\u00E9 :");
		springLayout.putConstraint(SpringLayout.NORTH, lblQuantit, 28, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.NORTH, lblNewLabel_4, -10, SpringLayout.NORTH, lblQuantit);
		getContentPane().add(lblQuantit);
		
		JLabel lblNLot = new JLabel("N\u00B0 lot :");
		springLayout.putConstraint(SpringLayout.NORTH, lblDateLimiteDutilisation, 0, SpringLayout.NORTH, lblNLot);
		springLayout.putConstraint(SpringLayout.NORTH, lblNLot, 47, SpringLayout.SOUTH, lblDci);
		getContentPane().add(lblNLot);
		
		JLabel lblClasseT = new JLabel("Classe th\u00E9rapeutique :");
		springLayout.putConstraint(SpringLayout.EAST, lblClasseT, 0, SpringLayout.EAST, lblDci);
		getContentPane().add(lblClasseT);
		
		JLabel lblN = new JLabel("N\u00B0 Caisse :");
		springLayout.putConstraint(SpringLayout.NORTH, lblClasseT, 38, SpringLayout.SOUTH, lblN);
		springLayout.putConstraint(SpringLayout.NORTH, textField_1, -3, SpringLayout.NORTH, lblN);
		springLayout.putConstraint(SpringLayout.NORTH, lblN, 44, SpringLayout.SOUTH, lblNLot);
		springLayout.putConstraint(SpringLayout.EAST, lblN, -1198, SpringLayout.EAST, getContentPane());
		getContentPane().add(lblN);
		
		JLabel lblNewLabel_6 = new JLabel("Caisse :");
		springLayout.putConstraint(SpringLayout.SOUTH, lblNewLabel_5, -105, SpringLayout.NORTH, lblNewLabel_6);
		springLayout.putConstraint(SpringLayout.NORTH, lblNewLabel_6, 3, SpringLayout.NORTH, textField_1);
		springLayout.putConstraint(SpringLayout.EAST, lblNewLabel_6, 0, SpringLayout.EAST, lblNewLabel_5);
		getContentPane().add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Dotation U7 :");
		springLayout.putConstraint(SpringLayout.NORTH, lblNewLabel_7, 0, SpringLayout.NORTH, lblClasseT);
		getContentPane().add(lblNewLabel_7);
		
		textField_3 = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, textField_3, 41, SpringLayout.SOUTH, textField);
		springLayout.putConstraint(SpringLayout.EAST, lblNLot, -6, SpringLayout.WEST, textField_3);
		springLayout.putConstraint(SpringLayout.WEST, textField_3, 0, SpringLayout.WEST, textField);
		getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		springLayout.putConstraint(SpringLayout.EAST, lblQuantit, -6, SpringLayout.WEST, textField_4);
		springLayout.putConstraint(SpringLayout.NORTH, textField_4, 24, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, textField_4, -23, SpringLayout.WEST, lblNewLabel_3);
		getContentPane().add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		springLayout.putConstraint(SpringLayout.WEST, textField_5, 0, SpringLayout.WEST, textField_2);
		springLayout.putConstraint(SpringLayout.SOUTH, textField_5, 0, SpringLayout.SOUTH, textField_1);
		getContentPane().add(textField_5);
		textField_5.setColumns(10);
		
		textField_6 = new JTextField();
		springLayout.putConstraint(SpringLayout.EAST, textField_6, -1106, SpringLayout.EAST, getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, lblNewLabel_7, 130, SpringLayout.EAST, textField_6);
		springLayout.putConstraint(SpringLayout.NORTH, textField_6, 0, SpringLayout.NORTH, lblClasseT);
		getContentPane().add(textField_6);
		textField_6.setColumns(10);
		
		textField_7 = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, textField_7, -3, SpringLayout.NORTH, lblDateLimiteDutilisation);
		springLayout.putConstraint(SpringLayout.WEST, textField_7, 6, SpringLayout.EAST, lblDateLimiteDutilisation);
		getContentPane().add(textField_7);
		textField_7.setColumns(10);
		
		textField_8 = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, textField_8, -3, SpringLayout.NORTH, lblClasseT);
		springLayout.putConstraint(SpringLayout.EAST, textField_8, 0, SpringLayout.EAST, lblNewLabel_3);
		getContentPane().add(textField_8);
		textField_8.setColumns(10);

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
