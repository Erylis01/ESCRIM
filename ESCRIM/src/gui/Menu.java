package gui;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.SpringLayout;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTabbedPane;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.Box;
import java.awt.Canvas;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Container;

import javax.swing.JPanel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.border.EtchedBorder;

public class Menu extends JFrame {

	private final int LARGEUR_FENETRE = 600, HAUTEUR_FENETRE = 600;
	JFrame f = this;

	public Menu() {

		// Empêcher agrandissement fenêtre
		this.setResizable(false);

		// Change l'icone de la fenêtre
		setIconImage(Toolkit.getDefaultToolkit().getImage(Menu.class.getResource("/assets/icone.png")));

		// Centrage de la fenêtre et choix de la taille de la fenêtre
		Dimension screenSize = new Dimension(Toolkit.getDefaultToolkit().getScreenSize());
		this.setPreferredSize(new Dimension(this.LARGEUR_FENETRE, this.HAUTEUR_FENETRE));
		int windowLeftPosition = screenSize.width / 2 - this.LARGEUR_FENETRE / 2;
		int windowRightPostion = screenSize.height / 2 - this.HAUTEUR_FENETRE / 2;
		this.setLocation(windowLeftPosition, windowRightPostion);

		// Ajout d'un Layout
		SpringLayout springLayout = new SpringLayout();
		getContentPane().setLayout(springLayout);

		// Ajout de l'image choisir configuration
		JLabel choisir_config = new JLabel("");
		choisir_config.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {

			}
		});
		springLayout.putConstraint(SpringLayout.NORTH, choisir_config, 180, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, choisir_config, 185, SpringLayout.WEST, getContentPane());
		choisir_config.setIcon(new ImageIcon(Menu.class.getResource("/assets/choisir_config.png")));
		getContentPane().add(choisir_config);

		// Ajout de l'image gestion des stocks
		JLabel gestion_stock = new JLabel("");
		gestion_stock.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

			}
		});
		springLayout.putConstraint(SpringLayout.SOUTH, gestion_stock, 0, SpringLayout.SOUTH, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, gestion_stock, 0, SpringLayout.EAST, getContentPane());
		gestion_stock.setIcon(new ImageIcon(Menu.class.getResource("/assets/gestion_stock.png")));
		this.getContentPane().add(gestion_stock);

		// Ajout de l'image modification de produit
		JLabel modif_produit = new JLabel("");
		modif_produit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JPanel panel = new JPanel(new GridLayout(0, 1));
				JTextField field1 = new JTextField("");
		        JTextField field2 = new JTextField("");
		        panel.add(new JLabel("Nom du produit"));
		        panel.add(field1);
		        panel.add(new JLabel("N° de lot"));
		        panel.add(field2);
		        int result = JOptionPane.showConfirmDialog(null, panel, "Test",
		            JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
				//ModifProduit mp = new ModifProduit(f);
			}
		});
		springLayout.putConstraint(SpringLayout.NORTH, modif_produit, 0, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, modif_produit, 0, SpringLayout.WEST, getContentPane());
		modif_produit.setIcon(new ImageIcon(Menu.class.getResource("/assets/modif_produit.png")));
		this.getContentPane().add(modif_produit);

		// Ajout d'un JPanel
		JPanel panel = new JPanel();
		springLayout.putConstraint(SpringLayout.NORTH, panel, 113, SpringLayout.SOUTH, choisir_config);
		springLayout.putConstraint(SpringLayout.WEST, panel, 0, SpringLayout.WEST, getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, panel, 0, SpringLayout.SOUTH, gestion_stock);
		springLayout.putConstraint(SpringLayout.EAST, panel, -212, SpringLayout.WEST, gestion_stock);
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		this.getContentPane().add(panel);
		panel.setLayout(null);

		// Ajout d'une l'image utilisateur
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//cp.removeAll();
				//cp.repaint();
			}
		});
		lblNewLabel.setIcon(new ImageIcon(Menu.class.getResource("/assets/utilisateur.png")));
		lblNewLabel.setBounds(10, 11, 50, 49);
		panel.add(lblNewLabel);

		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setBounds(61, 17, 46, 14);
		panel.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.setBounds(61, 42, 46, 14);
		panel.add(lblNewLabel_3);

		// Ajout d'un fond
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(Menu.class.getResource("/assets/fond_logpan.jpg")));
		getContentPane().add(lblNewLabel_1);

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
