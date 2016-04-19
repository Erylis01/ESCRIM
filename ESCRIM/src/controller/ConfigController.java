package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.text.ParseException;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import gui.ChoisirConfig;
import gui.Menu;
import model.Historique;
import model.Plane;
import model.User;

public class ConfigController implements ActionListener,MouseListener {

	private ChoisirConfig vue;
	private Historique modele;
	private Plane plane;
	private User user;
	
	public ConfigController(ChoisirConfig vue,Historique modele,User user){
		this.vue=vue;	
		this.modele=modele;
		this.plane=plane;
		this.user=user;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		String source=((JButton) e.getSource()).getName();
		
		if(source=="btnFiltrer"){
			if(vue.getdate()!=""){
				try {
					modele.getListDate(vue.getdate());
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}else if(vue.getPays()!=""){

			}
		}else if (source=="btnChoisir"){
			JOptionPane.showMessageDialog(vue,"L'action de ce bouton n'est pas implémentée");
		}
	}

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
