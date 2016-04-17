package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.text.ParseException;

import javax.swing.JButton;

import gui.ChoisirConfig;
import model.Historique;

public class ConfigController implements ActionListener {

	private ChoisirConfig vue;
	private Historique modele;
	
	public ConfigController(ChoisirConfig vue,Historique modele){
		this.vue=vue;	
		this.modele=modele;
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
			
		}
	}

}
