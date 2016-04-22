package controller;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.text.ParseException;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.border.LineBorder;
import javax.swing.table.TableModel;

import gui.ChoisirConfig;
import gui.GestionStock;
import gui.Menu;
import model.Historique;
import model.Product;
import model.User;

public class StockController implements ActionListener, MouseListener {

		private GestionStock vue;
		private User user;
		
		public StockController(GestionStock vue,User user){
			this.vue=vue;	
			this.user=user;
		}
		
		@Override
		public void actionPerformed(ActionEvent e) {
			String source=((JButton) e.getSource()).getText();
			
			if(source.equals("Afficher")){
				Product p =new Product();
				String[][] pTab = p.getList(Integer.parseInt(GestionStock.getcBoxNStockage().getSelectedItem().toString()));
				//JTable remp = new JTable(pTab,new String[]{"Nom","Quantité","DLU"});
				//remp.setLocation(41,185);
				//GestionStock.getScrollTab().remove(0);
				//GestionStock.getScrollTab().add(remp);
				for(int i = 0;i<GestionStock.getTabProduit().getRowCount()-1;i++){
					GestionStock.getTabProduit().getModel().setValueAt("", i, 0);
					GestionStock.getTabProduit().getModel().setValueAt("", i, 1);
					GestionStock.getTabProduit().getModel().setValueAt("", i, 2);
					GestionStock.getTabProduit().getModel().setValueAt("", i, 3);
				}
				for(int i =0;i<pTab.length;i++){
					GestionStock.getTabProduit().getModel().setValueAt(pTab[i][0], i, 0);
					GestionStock.getTabProduit().getModel().setValueAt(pTab[i][1], i, 1);
					GestionStock.getTabProduit().getModel().setValueAt(pTab[i][2], i, 2);
					GestionStock.getTabProduit().getModel().setValueAt(pTab[i][3], i, 3);
				}
				GestionStock.getGestionStock().getContentPane().repaint();
				GestionStock.getGestionStock().getContentPane().revalidate();
				
			}
			
			if(source.equals("Ajouter")){
				String lot = GestionStock.getcBoxNLot().getSelectedItem().toString();
				int caisse = Integer.parseInt(GestionStock.getcBoxNStockage().getSelectedItem().toString());
				Bdd.deplacerProduit(lot, caisse, Bdd.ConnectDB());	
			}
			
			if(source.equals("Supprimer")){
				String lot = GestionStock.getnLotASupprimer().getText().toString();
				Bdd.deplacerProduit(lot, 0, Bdd.ConnectDB());
			}
		}
		
	
		@Override
		public void mouseClicked(MouseEvent e) {
				
				String source = ((JLabel)e.getSource()).getName().toString();
				System.out.println(source);
				if (source=="lblMenu"){
					Menu m = new Menu(user);
					GestionStock.getGestionStock().dispose();
				}
	
			}



		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}



		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}



		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}



		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		
}

	

