package gui;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class Boutton extends JButton{
	
    private Image img;
    private String imageName;
     
    //Un constructeur pour choisir plus simplement l'image
    public Boutton(String imageName) {
        img = new ImageIcon(getClass().getResource(imageName)).getImage();
    }
     
    //On doit red�finir la m�thode paintComponent() pour les composant swing et paint() pour awt
	@Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (img == null) return;
        g.drawImage(img, 0, 0, getWidth(), getHeight(), this); //ici on adapte l'image � la taille du composant(getWidth(), getHeight())...

     
    }
}
