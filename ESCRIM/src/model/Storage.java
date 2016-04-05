package model;

import java.util.ArrayList;

public class Storage {

	private int number,width,height,depth;
	private String type,localisation,state;
	private ArrayList<Product> list_product = new  ArrayList<Product>();
	
	/**
	 * @return the number
	 */
	public int getNumber() {
		return number;
	}
	/**
	 * @param number the number to set
	 */
	public void setNumber(int number) {
		this.number = number;
	}
	/**
	 * @return the width
	 */
	public int getWidth() {
		return width;
	}
	/**
	 * @param width the width to set
	 */
	public void setWidth(int width) {
		this.width = width;
	}
	/**
	 * @return the height
	 */
	public int getHeight() {
		return height;
	}
	/**
	 * @param height the height to set
	 */
	public void setHeight(int height) {
		this.height = height;
	}
	/**
	 * @return the depth
	 */
	public int getDepth() {
		return depth;
	}
	/**
	 * @param depth the depth to set
	 */
	public void setDepth(int depth) {
		this.depth = depth;
	}
	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}
	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}
	/**
	 * @return the localisation
	 */
	public String getLocalisation() {
		return localisation;
	}
	/**
	 * @param localisation the localisation to set
	 */
	public void setLocalisation(String localisation) {
		this.localisation = localisation;
	}
	/**
	 * @return the state
	 */
	public String getState() {
		return state;
	}
	/**
	 * @param state the state to set
	 */
	public void setState(String state) {
		this.state = state;
	}
	/**
	 * @return the list_product
	 */
	public ArrayList<Product> getList_product() {
		return list_product;
	}
	/**
	 * @param list_product the list_product to set
	 */
	public void setList_product(ArrayList<Product> list_product) {
		this.list_product = list_product;
	}
	
	/**
	 * Ajoute un produit � la liste courante
	 * @param produit : Produit que l'on souhaite ajouter � la liste
	 */
	public void ajouterProduit(Product produit){
		list_product.add(produit);
	}
	
	/**
	 * Supprime un produit (rep�rer par son num�ro de lot) de la liste courante
	 * @param produit : Produit que l'on souhaite supprimer de la liste
	 */
	public void supprimerProduit(Product produit){
		for(int i = 0;i<list_product.size();i++){
			if(list_product.get(i).getLot() == produit.getLot()){
				list_product.remove(i);
				i--;
			}				
		}
	}
	
	/**
	 * M�thode de modification d'un produit (rep�rer par son num�ro de lot)
	 * @param produit : Produit que l'on souhaite modifier
	 */
	public void modifierProduit(Product produit){
		for(int i = 0;i<list_product.size();i++){
			if(list_product.get(i).getLot() == produit.getLot()){
				list_product.set(i, produit);
			}				
		}
	}
}
