package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.ParseException;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import gui.ChoisirConfig;
import gui.Menu;

import model.Historique;
import model.Plane;
import model.User;

/**
 * Controleur d�di� � la page de configuration
 * @author William
 *
 */
public class ConfigController implements ActionListener,MouseListener {
	
	/**
	 * Attributs de la classe
	 */
	private ChoisirConfig vue;
	private Historique modele;
	@SuppressWarnings("unused")
	private Plane plane;
	private User user;
	
	/**
	 * Constructeur de la classe 
	 * @param vue - ChoisirConfig
	 * @param modele - Historique
	 * @param user - User
	 */
	public ConfigController(ChoisirConfig vue,Historique modele,User user){
		this.vue=vue;	
		this.modele=modele;
		this.user=user;
	}
	
	/**
	 * M�thode permettant de configurer les actions li�es aux diff�rents boutons
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		
		String source=((JButton) e.getSource()).getName();
		
		//Filtrage des configurations suviant les param�tres renseign�s
		if(source=="btnFiltrer"){
			try {
				if(vue.getdate()!=null){
					try {
						modele.getListDate(vue.getdate());
					} catch (ParseException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				}else if(vue.getPays()!=""){
					modele.getListPays(vue.getPays());
				}
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}else if (source=="btnChoisir"){	
			//Ce bouton avait pour but de v�rifier qu'une config rentrer dans un avion
			//Non impl�ment� par manque de temps
			JOptionPane.showMessageDialog(vue,"L'action de ce bouton n'est pas impl�ment�e");
		}
	}
	
	/**
	 * Action de la souris permettant de retourner au menu principal en cliquant sur l'image
	 */
	@SuppressWarnings("unused")
	@Override
	public void mouseClicked(MouseEvent e) {
		String source = ((JLabel)e.getSource()).getName();
		if (source=="lblMenu"){
			Menu m = new Menu(user);
			vue.dispose();
		}
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
