package controller;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.text.ParseException;

import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.border.LineBorder;
import javax.swing.table.TableModel;

import gui.GestionStock;
import model.Product;

public class StockController implements ActionListener {



		
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
				
			}
		}

	}

	

