package model;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.util.ArrayList;
import controller.Bdd;

public class Product{

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
	 * 
	 * @param DLU
	 * @param quantity
	 * @param lot
	 * @param critical_threshold
	 * @param DCI
	 * @param dosage
	 * @param reference
	 * @param name
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
	 * @return the DLU
	 */
	public Date getDLU() {
		return DLU;
	}

	/**
	 * @param DLU
	 *            the DLU to set
	 */
	public void setDLU(Date DLU) {
		this.DLU = DLU;
	}

	/**
	 * @return the quantity
	 */
	public int getQuantity() {
		return quantity;
	}

	/**
	 * @param quantity
	 *            the quantity to set
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	/**
	 * @return the lot
	 */
	public String getLot() {
		return lot;
	}

	/**
	 * @param lot
	 *            the lot to set
	 */
	public void setLot(String lot) {
		this.lot = lot;
	}

	/**
	 * @return the critical_threshold
	 */
	public int getCritical_threshold() {
		return critical_threshold;
	}

	/**
	 * @param critical_threshold
	 *            the critical_threshold to set
	 */
	public void setCritical_threshold(int critical_threshold) {
		this.critical_threshold = critical_threshold;
	}

	/**
	 * @return the DCI
	 */
	public String getDCI() {
		return DCI;
	}

	/**
	 * @param DCI
	 *            the DCI to set
	 */
	public void setDCI(String DCI) {
		this.DCI = DCI;
	}

	/**
	 * @return the dosage
	 */
	public String getDosage() {
		return dosage;
	}

	/**
	 * @param dosage
	 *            the dosage to set
	 */
	public void setDosage(String dosage) {
		this.dosage = dosage;
	}

	/**
	 * @return the reference
	 */
	public String getReference() {
		return reference;
	}

	/**
	 * @param reference
	 *            the reference to set
	 */
	public void setReference(String reference) {
		this.reference = reference;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Méthode permettant de vérifier l'état de criticité du stock de produit
	 * 
	 * @return test_quantite
	 */
	public boolean etatCritique() {
		boolean test_quantite = false;
		if (quantity <= critical_threshold)
			test_quantite = true;
		return test_quantite;
	}

	/**
	 * Fonction appeller pour la génération d'un fichier texte simple de
	 * récapitulatif des informations
	 * 
	 * @throws IOException
	 */
	public void printFile() throws IOException {
		BufferedWriter writer = new BufferedWriter(new FileWriter(new File("assets/produit" + name + ".txt")));
		String toWrite = "Fiche du produit :" + name + "\n" + "\n" + "Le produit composé de " + DCI + " et de dosage "
				+ dosage + " dans le lot n° " + lot + " est disponible dans la quantité " + quantity + ".\n\n"
				+ "Son seuil critique est fixé à " + critical_threshold;
		writer.write(toWrite);
		writer.close();
	}

	public int getNcaisse() {
		return Ncaisse;
	}

	public void setNcaisse(int ncaisse) {
		Ncaisse = ncaisse;
	}

	public String getClasse() {
		return classe;
	}

	public void setClasse(String classe) {
		this.classe = classe;
	}

	public String getCaisse() {
		return caisse;
	}

	public void setCaisse(String caisse) {
		this.caisse = caisse;
	}

	public String getDotation() {
		return dotation;
	}

	public void setDotation(String dotation) {
		this.dotation = dotation;
	}
	
	public void affichage(){
		System.out.println(name+" "+DCI+" "+dosage+" "+DLU+" "+quantity+" "+lot+" "+classe+" "+Ncaisse+" "+caisse+" "+dotation);
	}
}
