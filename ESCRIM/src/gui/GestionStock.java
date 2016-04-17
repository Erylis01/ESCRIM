package gui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JMenuBar;
import javax.swing.JTextPane;
import javax.swing.JMenu;
import javax.swing.JSeparator;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JList;
import javax.swing.UIManager;
import javax.swing.AbstractListModel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class GestionStock extends JFrame {
	public GestionStock() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(GestionStock.class.getResource("/assets/icone.png")));
		setVisible(true);
		setPreferredSize(new Dimension(600, 600));
		setResizable(false);
		setTitle("Gestion des stocks");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
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
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 12));
		comboBox.setMaximumRowCount(60);
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"-1"}));
		comboBox.setSelectedIndex(0);
		comboBox.setBounds(298, 37, 123, 20);
		panel.add(comboBox);
		
		JLabel lblNDeStockage = new JLabel("N\u00B0 de stockage :");
		lblNDeStockage.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNDeStockage.setBounds(165, 40, 106, 14);
		panel.add(lblNDeStockage);
		lblNDeStockage.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel lblFond = new JLabel("New label");
		lblFond.setIcon(new ImageIcon(GestionStock.class.getResource("/assets/fond_logpan.jpg")));
		lblFond.setBounds(0, 0, 600, 561);
		panel.add(lblFond);
		
		JMenuBar menuBar = new JMenuBar();
		getContentPane().add(menuBar, BorderLayout.NORTH);
		
		JMenu mnUtilisateur = new JMenu("Utilisateur");
		menuBar.add(mnUtilisateur);
		
		JMenu mnAide = new JMenu("Aide");
		menuBar.add(mnAide);
	}
}
