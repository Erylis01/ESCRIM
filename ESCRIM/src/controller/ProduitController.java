package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.text.ParseException;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JLabel;

import gui.ModifProduit;
import model.Product;

public class ProduitController implements ActionListener,MouseListener{

	private ModifProduit vue;
	private Product modele;
	private Connection conn;
	
	public ProduitController(ModifProduit vue,Product modele){
		this.vue=vue;
		this.modele=modele;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		String source=((JButton) e.getSource()).getName();
		if (source=="btnAjouter"){
			conn=Bdd.ConnectDB();
			try {
				Bdd.Add_Produit(vue.getName(), vue.getDLU(), vue.getref(), vue.getquant(), vue.getDosage(), vue.getLot(), vue.getDCI(), vue.getSeuil(), vue.getClasse(), vue.getNcaisse(),vue.getCaisse(), vue.getDotation(), conn);
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}else if (source=="btnModifier"){
			
		}
		
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		
		String source = ((JLabel)e.getSource()).getName();
		if (source=="lblNom"){
			String Nom = JOptionPane.showInputDialog(null, "Nom du produit", JOptionPane.QUESTION_MESSAGE);
			modele.setName(Nom);
			vue.setName(Nom);
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
