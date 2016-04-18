package gui;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JPanel;

import controller.ProduitController;
import model.Product;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.WindowConstants;
import javax.swing.border.LineBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.ImageIcon;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;

public class ModifProduit extends JFrame {

	private ProduitController controller;
	private Product modele;

	private JPanel panel;
	private final int LARGEUR_FENETRE = 600, HAUTEUR_FENETRE = 600;
	private JTextField txtQuant;
	private JTextField txtDCI;
	private JTextField txtDLU;
	private JTextField txtClasse;
	private JTextField txtNcaisse;
	private JTextField txtDosage;
	private JTextField txtDotation;
	private JTextField txtLot;
	private JTextField txtCaisse;
	private JTextField txtSeuil;

	public ModifProduit(Product modele) {

		this.modele = modele;
		controller = new ProduitController(this, modele);

		// Centrage de la fenêtre et choix de la taille de la fenêtre
		Dimension screenSize = new Dimension(Toolkit.getDefaultToolkit().getScreenSize());
		this.setPreferredSize(new Dimension(this.LARGEUR_FENETRE, this.HAUTEUR_FENETRE));
		int windowLeftPosition = screenSize.width / 2 - this.LARGEUR_FENETRE / 2;
		int windowRightPostion = screenSize.height / 2 - this.HAUTEUR_FENETRE / 2;
		this.setLocation(windowLeftPosition, windowRightPostion);

		// Empêche la fenêtre d'être redimensionnée
		setResizable(false);

		// Choix du titre et de l'icone de la JFrame
		this.setTitle("Modification produit");
		this.setIconImage(Toolkit.getDefaultToolkit().getImage(Log.class.getResource("/assets/icone.png")));

		// Enregistrement de l'option EXIT_ON_CLOSE lors de la fermeture de la
		// fenêtre (arrêt du procéssus)
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);

		// Ajout d'un panel qui contiendra tout
		panel = new JPanel();
		panel.setBounds(0, 0, 594, 571);
		getContentPane().add(panel);
		panel.setLayout(null);

		// Ajout d'un voyant
		JLabel lblvoyant = new JLabel("");
		if (modele.getQuantity()<modele.getCritical_threshold()){
			lblvoyant.setIcon(new ImageIcon(ModifProduit.class.getResource("/assets/rouget.png")));
		}else if (modele.getQuantity()>1.5*modele.getCritical_threshold()){
			lblvoyant.setIcon(new ImageIcon(ModifProduit.class.getResource("/assets/orange.png")));
		}else{
			lblvoyant.setIcon(new ImageIcon(ModifProduit.class.getResource("/assets/voyant_vert.png")));
		}

		lblvoyant.setBounds(534, 11, 50, 50);
		panel.add(lblvoyant);

		// Ajout d'un champ pour la quantité
		txtQuant = new JTextField();
		txtQuant.setBounds(441, 11, 86, 20);
		panel.add(txtQuant);
		txtQuant.setColumns(10);

		// Ajout du label "quantité"
		JLabel lblQuant = new JLabel("Quantité :");
		lblQuant.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblQuant.setBounds(375, 11, 62, 15);
		panel.add(lblQuant);

		// Ajout du label "Nom du produit"
		JLabel lblNom = new JLabel();
		if (modele.getName() != null) {
			lblNom.setText(modele.getName());
		} else {
			lblNom.setText("Nom du produit");
		}
		lblNom.setFont(new Font("AR ESSENCE", Font.BOLD, 30));
		lblNom.setBounds(10, 11, 201, 39);
		lblNom.setName("lblNom");
		lblNom.addMouseListener(controller);
		panel.add(lblNom);

		// Ajout du label "DCI"
		JLabel lblDCI = new JLabel("DCI :");
		lblDCI.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblDCI.setBounds(117, 140, 30, 15);
		panel.add(lblDCI);

		// Ajout du label "Forme de dosage"
		JLabel lblDosage = new JLabel("Forme dosage :");
		lblDosage.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblDosage.setBounds(311, 140, 93, 15);
		panel.add(lblDosage);

		// Ajout du label "DLU"
		JLabel lblDLU = new JLabel("DLU :");
		lblDLU.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblDLU.setBounds(115, 220, 32, 15);
		panel.add(lblDLU);

		// Ajout du label "Lot"
		JLabel lblLot = new JLabel("Lot :");
		lblLot.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblLot.setBounds(375, 300, 29, 15);
		panel.add(lblLot);

		// Ajout du label "Classe Therapeutique"
		JLabel lblClasse = new JLabel("Classe Therapeutique :");
		lblClasse.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblClasse.setBounds(9, 300, 138, 15);
		panel.add(lblClasse);

		// Ajout du label "N° Caisse"
		JLabel lblNCaisse = new JLabel("N° Caisse :");
		lblNCaisse.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNCaisse.setBounds(84, 380, 63, 15);
		panel.add(lblNCaisse);

		// Ajout du label "Caisse"
		JLabel lblCaisse = new JLabel("Caisse :");
		lblCaisse.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblCaisse.setBounds(358, 380, 46, 14);
		panel.add(lblCaisse);

		// Ajout du label "Dotation"
		JLabel lblDotation = new JLabel("Dotation U7 :");
		lblDotation.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblDotation.setBounds(321, 220, 83, 15);
		panel.add(lblDotation);

		// Ajout du label "Seuil Critique"
		JLabel lblSeuil = new JLabel("Seuil Critique :");
		lblSeuil.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblSeuil.setBounds(348, 44, 89, 15);
		panel.add(lblSeuil);

		// Ajout du boutton "Ajouter"
		JButton btnAjouter = new JButton("Ajouter");
		btnAjouter.setForeground(Color.WHITE);
		btnAjouter.setBackground(Color.BLUE);
		btnAjouter.setBounds(166, 449, 89, 23);
		btnAjouter.setName("btnAjouter");
		btnAjouter.addActionListener(controller);
		panel.add(btnAjouter);

		// Ajout du boutton "Modifier"
		JButton btnModifier = new JButton("Modifier");
		btnModifier.setForeground(Color.WHITE);
		btnModifier.setBackground(Color.RED);
		btnModifier.setBounds(330, 449, 89, 23);
		btnModifier.setName("btnModifier");
		btnModifier.addActionListener(controller);
		panel.add(btnModifier);

		// Ajout du champ de texte "DCI"
		txtDCI = new JTextField();
		if (modele.getDCI() != null) {
			txtDCI.setText(modele.getDCI());
		}
		txtDCI.setBounds(149, 138, 141, 20);
		panel.add(txtDCI);
		txtDCI.setColumns(10);

		// Ajout du champ de texte "DLU"
		DateFormat df = new SimpleDateFormat("dd-MMM-yyyy");
		txtDLU = new JTextField();
		if (modele.getDLU() != null) {
			txtDLU.setText(df.format(modele.getDLU()));
		} 
		txtDLU.setBounds(150, 218, 140, 20);
		panel.add(txtDLU);
		txtDLU.setColumns(10);

		// Ajout du champ de texte "Classe"
		txtClasse = new JTextField();
		if (modele.getClasse()!=null){
			txtClasse.setText(modele.getClasse());
		}
		txtClasse.setBounds(149, 298, 140, 20);
		panel.add(txtClasse);
		txtClasse.setColumns(10);

		// Ajout du champ de texte "N° Caisse"
		txtNcaisse = new JTextField();
		if (modele.getNcaisse()!=0){
			txtNcaisse.setText(Integer.toString((modele.getNcaisse())));
		}
		txtNcaisse.setBounds(149, 378, 140, 20);
		panel.add(txtNcaisse);
		txtNcaisse.setColumns(10);

		// Ajout du champ de texte "Dosage"
		txtDosage = new JTextField();
		if(modele.getDosage()!=null){
			txtDosage.setText(modele.getDosage());
		}
		txtDosage.setBounds(409, 138, 141, 20);
		panel.add(txtDosage);
		txtDosage.setColumns(10);

		// Ajout du champ de texte "Dotation"
		txtDotation = new JTextField();
		if (modele.getDotation()!=null){
			txtDotation.setText(modele.getDotation());
		}
		txtDotation.setBounds(409, 218, 141, 20);
		panel.add(txtDotation);
		txtDotation.setColumns(10);

		// Ajout du champ de texte "Lot"
		txtLot = new JTextField(modele.getLot());
		txtLot.setEditable(false);
		txtLot.setBounds(409, 298, 141, 20);
		panel.add(txtLot);
		txtLot.setColumns(10);

		// Ajout du champ de texte "Caisse"
		txtCaisse = new JTextField();
		if (modele.getCaisse()!=null){
			txtCaisse.setText(modele.getCaisse());
		}
		txtCaisse.setBounds(409, 378, 141, 20);
		panel.add(txtCaisse);
		txtCaisse.setColumns(10);

		// Ajout du champ de texte "Seuil Critique"
		txtSeuil = new JTextField();
		if (modele.getCritical_threshold()!=0){
			txtSeuil.setText(Integer.toString(modele.getCritical_threshold()));
		}
		txtSeuil.setBounds(441, 41, 86, 20);
		panel.add(txtSeuil);
		txtSeuil.setColumns(10);

		// Ajout du panel contenant les infos utilisateur
		JPanel panel_user = new JPanel();
		panel_user.setForeground(Color.WHITE);
		panel_user.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panel_user.setBounds(0, 487, 161, 62);
		panel.add(panel_user);
		panel_user.setLayout(null);

		// Ajout de l'image utilisateur
		JLabel lblUser = new JLabel("");
		lblUser.setBounds(0, 11, 50, 50);
		panel_user.add(lblUser);
		lblUser.setIcon(new ImageIcon(Menu.class.getResource("/assets/utilisateur.png")));

		// Ajout du label username
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setBounds(60, 11, 48, 14);
		panel_user.add(lblUsername);

		// Ajout du label avec information des droits
		JLabel lblAdmininfo = new JLabel("AdminInfo");
		lblAdmininfo.setBounds(60, 36, 49, 14);
		panel_user.add(lblAdmininfo);

		// Ajout d'un fond
		JLabel lblFond = new JLabel("");
		lblFond.setIcon(new ImageIcon(ModifProduit.class.getResource("/assets/fond_logpan.jpg")));
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

	public int getquant() {
		return Integer.parseInt(txtQuant.getText());
	}

	public int getSeuil() {
		return Integer.parseInt(txtSeuil.getText());
	}

	public String getDCI() {
		return txtDCI.getText();
	}

	public Date getDLU() throws ParseException {
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy");
		return formatter.parse(txtDLU.getText());

	}

	public String getCaisse() {
		return txtCaisse.getText();
	}

	public int getNcaisse() {
		return Integer.parseInt(txtNcaisse.getText());
	}

	public String getDosage() {
		return txtDosage.getText();
	}

	public String getDotation() {
		return txtDotation.getText();
	}

	public int getLot() {
		return Integer.parseInt(txtLot.getText());
	}

	public String getClasse() {
		return txtClasse.getText();
	}
}
