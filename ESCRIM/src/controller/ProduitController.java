package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

import javax.swing.JButton;

import gui.ModifProduit;
import model.Product;

public class ProduitController implements ActionListener{

	private ModifProduit vue;
	private Product modele;
	private Connection conn;
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		String source=((JButton) e.getSource()).getName();
		if (source=="btnAjouter"){
			
		}else if (source=="btnModifier"){
			
		}
		
	}

}
