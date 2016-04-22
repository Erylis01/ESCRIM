package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import gui.GestionStock;
import gui.Menu;
import model.Product;
import model.User;

/**
 * Controleur li� aux actions de la fen�tre de gestion des stocks
 * @author William
 *
 */
public class StockController implements ActionListener, MouseListener {
	
		/**
		 * Deux attributs uniquement n�cessaire aux op�artions de contr�le
		 */
		@SuppressWarnings("unused")
		private GestionStock vue;
		private User user;
		
		/**
		 * Constructeur de la classe, permet d'initialiser le controleur
		 * @param vue - GestionStock
		 * @param user - User
		 */
		public StockController(GestionStock vue,User user){
			this.vue=vue;	
			this.user=user;
		}
		
		/**
		 * M�thode de contr�le des boutons, filtrage sur l'origine de l'action
		 * @param e - ActionEvent
		 */
		@Override
		public void actionPerformed(ActionEvent e) {
			String source=((JButton) e.getSource()).getText();
			//Remplir le tableau avec les produits contenu dans la caisse s�lectionn�e
			if(source.equals("Afficher")){
				Product p =new Product();
				String[][] pTab = p.getList(Integer.parseInt(GestionStock.getcBoxNStockage().getSelectedItem().toString()));
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
			
			//Modifie le num�ro de caisse du produit correspondant au num�ro de lot s�lectionn�
			if(source.equals("Ajouter")){
				String lot = GestionStock.getcBoxNLot().getSelectedItem().toString();
				int caisse = Integer.parseInt(GestionStock.getcBoxNStockage().getSelectedItem().toString());
				Bdd.deplacerProduit(lot, caisse, Bdd.ConnectDB());	
			}
			
			//Reset le num�ro de caisse du produit correspondant au num�ro de lot s�lectionn�
			if(source.equals("Supprimer")){
				String lot = GestionStock.getnLotASupprimer().getText().toString();
				Bdd.deplacerProduit(lot, 0, Bdd.ConnectDB());
			}
		}
		
		
		/**
		 * Impl�mente l'action � la souris - Retour au menu par clique sur l'ic�ne
		 * @param e - MouseEvent
		 */
		@Override
		public void mouseClicked(MouseEvent e) {
				
				String source = ((JLabel)e.getSource()).getName().toString();
				System.out.println(source);
				if (source=="lblMenu"){
					@SuppressWarnings("unused")
					Menu m = new Menu(user);
					GestionStock.getGestionStock().dispose();
					GestionStock.getGestionStock().repaint();
					GestionStock.getGestionStock().revalidate();
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

	

