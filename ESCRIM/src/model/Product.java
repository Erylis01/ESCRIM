package model;

import java.sql.Date;

public class Product {

	private Date dlu;
	private int quantity,lot,critical_threshold;
	private String dcl,dosage,reference,name;
	
	/**
	 * @return the dlu
	 */
	public Date getDlu() {
		return dlu;
	}
	/**
	 * @param dlu the dlu to set
	 */
	public void setDlu(Date dlu) {
		this.dlu = dlu;
	}
	/**
	 * @return the quantity
	 */
	public int getQuantity() {
		return quantity;
	}
	/**
	 * @param quantity the quantity to set
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
	 * @param lot the lot to set
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
	 * @param critical_threshold the critical_threshold to set
	 */
	public void setCritical_threshold(int critical_threshold) {
		this.critical_threshold = critical_threshold;
	}
	/**
	 * @return the dcl
	 */
	public String getDcl() {
		return dcl;
	}
	/**
	 * @param dcl the dcl to set
	 */
	public void setDcl(String dcl) {
		this.dcl = dcl;
	}
	/**
	 * @return the dosage
	 */
	public String getDosage() {
		return dosage;
	}
	/**
	 * @param dosage the dosage to set
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
	 * @param reference the reference to set
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
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

}
