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
				JTable remp = new JTable(pTab,new String[]{"Nom","Quantité","DLU"});
				remp.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
				remp.setToolTipText("");
				remp.setFont(new Font("Tahoma", Font.PLAIN, 12));
				remp.setBorder(new LineBorder(new Color(0, 0, 0)));
				remp.setBounds(26, 373, 529, -265);
				GestionStock.setTabProduit(remp);
				GestionStock.getGestionStock().repaint();
				GestionStock.getGestionStock().revalidate();
				GestionStock.getGestionStock().pack();
			}
		}

	}

	

