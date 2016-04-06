package gui;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class StartMenu {

	private JPanel startpan = new JPanel();
	
	public StartMenu(JFrame frame){
		startpan.setLayout(mgr);
		frame.add(startpan);
		frame.setVisible(true);
	}
}
