package model;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.util.ArrayList;
import controller.Bdd;

/**
 * Classe permettant de mettre en place le mod�le d'un objet Produit
 * @author William
 *
 */
public class Product{
	/**
	 * Attributs de la classe
	 */
	private Date DLU=null;
	private int quantity=0, critical_threshold=0,Ncaisse=0;
	private String[][] Produits;
	private String DCI=null, dosage=null, reference=null, name=null,classe=null,caisse=null,dotation=null,lot=null;

	
	/**
	 * Constructeur par default
	 */
	public Product() {

	}
	
	/**
	 * Constructeur de la classe Product
	 * @param DLU - Date
	 * @param quantity - int
	 * @param lot - String
	 * @param critical_threshold - int
	 * @param DCI - String
	 * @param dosage - String
	 * @param reference - String
	 * @param name - String
	 */

	public Product(String name,String DCI,String dosage,Date DLU,int quantity,String lot,String classe, int Ncaisse,String caisse,String dotation,int threshold,String reference) {
		this.DLU = DLU;
		this.quantity = quantity;
		this.lot = lot;
		this.critical_threshold = threshold;
		this.DCI = DCI;
		this.dosage = dosage;
		this.reference = reference;
		this.name = name;
		this.classe=classe;
		this.caisse=caisse;
		this.Ncaisse=Ncaisse;
		this.dotation=dotation;
	}
	
	/**
	 * Permet de transformer l'arraylist des produits contenu dans un stockage en double tableaux de String pour affichage
	 * @param nStockage - int
	 * @return Produits - String[][]
	 */
	public String[][] getList(int nStockage) {
		Connection conn = Bdd.ConnectDB();
		ArrayList<Product> liste_Produits = Bdd.RecupProduits(nStockage,conn);
		Produits = new String[liste_Produits.size()][4];
		for (int i = 0; i < liste_Produits.size(); i++) {
			Produits[i][0] = liste_Produits.get(i).getName();
			Produits[i][1] = ""+liste_Produits.get(i).getQuantity();
			Produits[i][2] = ""+liste_Produits.get(i).getDLU();
			Produits[i][3] = ""+liste_Produits.get(i).getLot();
		}
		return Produits;
	}
	
	/**
	 * Permet de r�cup�rer la DLU
	 * @return DLU - Date
	 */
	public Date getDLU() {
		return DLU;
	}

	/**
	 * Permet de modifier la DLU
	 * @param DLU - Date
	 */
	public void setDLU(Date DLU) {
		this.DLU = DLU;
	}

	/**
	 * Permet de r�cup�rer la quantit�
	 * @return quantity - int
	 */
	public int getQuantity() {
		return quantity;
	}

	/**
	 * Permet de modifier la quantit�
	 * @param quantity - int
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	/**
	 * Permet de r�cup�rer le lot
	 * @return lot - String
	 */
	public String getLot() {
		return lot;
	}

	/**
	 * Permet de modifier le lot
	 * @param lot - String
	 */
	public void setLot(String lot) {
		this.lot = lot;
	}

	/**
	 * Permet de r�cup�rer le seuil critique
	 * @return critical_threshold - int
	 */
	public int getCritical_threshold() {
		return critical_threshold;
	}

	/**
	 * Permet de modifier le seuil critique
	 * @param critical_threshold - int
	 */
	public void setCritical_threshold(int critical_threshold) {
		this.critical_threshold = critical_threshold;
	}

	/**
	 * Permet de r�cup�rer le DCI
	 * @return DCI - String
	 */
	public String getDCI() {
		return DCI;
	}

	/**
	 * Permet de modifier la DCI
	 * @param DCI - String
	 */
	public void setDCI(String DCI) {
		this.DCI = DCI;
	}

	/**
	 * Permet de r�cup�rer le dosage
	 * @return dosage - String
	 */
	public String getDosage() {
		return dosage;
	}

	/**
	 * Permet de odifier le dosage
	 * @param dosage - String
	 */
	public void setDosage(String dosage) {
		this.dosage = dosage;
	}

	/**
	 * Permer de r�cup�rer la r�f�rence
	 * @return reference - String
	 */
	public String getReference() {
		return reference;
	}

	/**
	 * Permet de modifier la r�f�rence
	 * @param reference - String
	 */
	public void setReference(String reference) {
		this.reference = reference;
	}

	/**
	 * Permet de r�cup�rer le nom
	 * @return name - String
	 */
	public String getName() {
		return name;
	}

	/**
	 * Permet de modifier le nom
	 * @param name - String
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * M�thode permettant de v�rifier l'�tat de criticit� du stock de produit
	 * @return test_quantite - boolean
	 */
	public boolean etatCritique() {
		boolean test_quantite = false;
		if (quantity <= critical_threshold)
			test_quantite = true;
		return test_quantite;
	}

	/**
	 * Fonction appeller pour la g�n�ration d'un fichier texte simple de
	 * r�capitulatif des informations
	 * @throws IOException
	 */
	public void printFile() throws IOException {
		BufferedWriter writer = new BufferedWriter(new FileWriter(new File("assets/produit" + name + ".txt")));
		String toWrite = "Fiche du produit :" + name + "\n" + "\n" + "Le produit compos� de " + DCI + " et de dosage "
				+ dosage + " dans le lot n� " + lot + " est disponible dans la quantit� " + quantity + ".\n\n"
				+ "Son seuil critique est fix� � " + critical_threshold;
		writer.write(toWrite);
		writer.close();
	}

	/**
	 * Permet de r�cup�rer le num�ro de caisse 
	 * @return Ncaisse - int
	 */
	public int getNcaisse() {
		return Ncaisse;
	}

	/**
	 * Permet de modifier le num�ro de caisse
	 * @param ncaisse - int
	 */
	public void setNcaisse(int ncaisse) {
		Ncaisse = ncaisse;
	}
	
	/**
	 * Permet de r�cup�rer la classe th�rapeutique
	 * @return classe - String
	 */
	public String getClasse() {
		return classe;
	}
	
	/**
	 * Permet de modifier la classe th�rapeutique
	 * @param classe - String
	 */
	public void setClasse(String classe) {
		this.classe = classe;
	}

	/**
	 * Permet de r�cup�rer la caisse
	 * @return caisse - String
	 */
	public String getCaisse() {
		return caisse;
	}
	
	/**
	 * Permet de modifier la caisse
	 * @param caisse - String
	 */
	public void setCaisse(String caisse) {
		this.caisse = caisse;
	}
	
	/**
	 * Permet de r�cup�rer la dotation
	 * @return dotation - String
	 */
	public String getDotation() {
		return dotation;
	}
	
	/**
	 * Permet de modifier la dotation
	 * @param dotation - String
	 */
	public void setDotation(String dotation) {
		this.dotation = dotation;
	}
	
	/**
	 * Permet d'afficher toutes les infos d'un produit / Fonction de test
	 */
	public void affichage(){
		System.out.println(name+" "+DCI+" "+dosage+" "+DLU+" "+quantity+" "+lot+" "+classe+" "+Ncaisse+" "+caisse+" "+dotation);
	}
}
