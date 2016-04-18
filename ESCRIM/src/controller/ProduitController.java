package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;

import javax.swing.JButton;
import javax.swing.JTextField;

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
			Bdd.Add_Produit(designation, dlu, reference, quantite, dosage, lot, dci, seuil_critique, classe_therapeutique, NumCaisse, caisse, dotation_U7, conn);
		}else if (source=="btnModifier"){
			
		}
		
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		
		String source = ((JTextField)e.getSource()).getName();
		if (source=="lblNom"){
			
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
