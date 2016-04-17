package model;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Date;

public class Product {

	private Date DLU;
	private int quantity, lot, critical_threshold,Ncaisse;
	private String DCI, dosage, reference, name,classe,caisse,dotation;

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

	public Product(String name,String DCI,String dosage,Date DLU,int quantity,int lot,String classe, int Ncaisse,String caisse,String dotation,int threshold,String reference) {
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
	public int getLot() {
		return lot;
	}

	/**
	 * @param lot
	 *            the lot to set
	 */
	public void setLot(int lot) {
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
	 * M�thode permettant de v�rifier l'�tat de criticit� du stock de produit
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
	 * Fonction appeller pour la g�n�ration d'un fichier texte simple de
	 * r�capitulatif des informations
	 * 
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
}
