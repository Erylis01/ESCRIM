package model;

import java.util.ArrayList;

public class Storage {

	private float number,width,height,depth;
	private String type,localisation,state;
	private ArrayList<Product> list_product = new  ArrayList<Product>();
	/**
	 * Constructeur de la classe storage
	 * @param number
	 * @param width
	 * @param height
	 * @param depth
	 * @param type
	 * @param localisation
	 * @param state
	 * @param list_product
	 */
	public Storage(float number,float width,float height,float depth,String type,String localisation,String state,ArrayList<Product> list_product ){
		this.number = number;
		this.width = width;
		this.height = height;
		this.depth = depth;
		this.type = type;
		this.localisation = localisation;
		this.state = state;
		this.list_product = list_product;
	}
	
	/**
	 * @return the number
	 */
	public float getNumber() {
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
	public float getWidth() {
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
	public float getHeight() {
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
	public float getDepth() {
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
	
	/*
	 * Toutes les méthodes qui suivent sont à réécrire lorsque la BDD sera mise en place
	 * Voir si on stock uniquement sur BDD ou si on garde des variables local
	 */
	
	/**
	 * Ajoute un produit à la liste courante
	 * @param produit : Produit que l'on souhaite ajouter à la liste
	 */
	public void ajouterProduit(Product produit){
		list_product.add(produit);
	}
	
	/**
	 * Supprime un produit (repérer par son numéro de lot) de la liste courante
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
	 * Méthode de modification d'un produit (repérer par son numéro de lot)
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
