package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.WindowConstants;


/**
 * La Classe Interface représente la JFrame générale du logiciel.
 * 
 * @author Pierre
 */
public class Interface extends JFrame {
	
	private String path_icon="src/assets/icone.png";
	private int width_window,height_window;
	private Color font_color=new Color(44,34,85);

	/**
	 * Permet de créer une fenetre;
	 */

	public void createwindow() {

		// Choix de la taille de la fenêtre
		Dimension screenSize = new Dimension(Toolkit.getDefaultToolkit().getScreenSize());
		width_window=screenSize.width*4/5;
		height_window=screenSize.height*4/5;
		this.setPreferredSize(new Dimension(width_window,height_window ));
		
		//Position de la fenêtre;
		int windowLeftPosition = screenSize.width / 2 - this.width_window /2;
		int windowRightPostion = screenSize.height / 2 - this.height_window / 2;
		this.setLocation(windowLeftPosition, windowRightPostion);
		
		// Donne le titre de la fenêtre
		this.setTitle("ESCRIM");

		// Choix de l'icône......
		ImageIcon icon = new ImageIcon(path_icon);
		this.setIconImage(icon.getImage());
		
		// Enregistrement de l'option EXIT_ON_CLOSE lors de la fermeture de la
		// fenêtre (arrêt du procéssus)
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		
		//Ajout d'une couleur de font
		this.getContentPane().setBackground(font_color);
		
		// Création du JMenu
		JMenuBar menu = new JMenuBar();
		
		
		// Ajout du Menu aide
		JMenu menuAide = new JMenu("Help");
		menuAide.getAccessibleContext().setAccessibleDescription("Menu d'aide");
		JMenuItem menuItemGuide=new JMenuItem("User guide");
		JMenuItem menuItemInfo=new JMenuItem("Info");
		menuAide.add(menuItemInfo);
		menuAide.add(menuItemGuide);
		menu.add(menuAide);
		this.setJMenuBar(menu);
		
		// Packing et affichage de la JFrame
		this.pack();
		this.setVisible(true);
	}


}
