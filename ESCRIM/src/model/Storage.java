package model;

import java.util.ArrayList;

/**
 * Classe permettant de mettre en place le mod�le de l'objet stockage
 * @author William
 *
 */
public class Storage {
	
	private float number,width,height,depth;
	private String type,localisation,state;
	private ArrayList<Product> list_product = new  ArrayList<Product>();
	
	/**
	 * Constructeur de la classe storage
	 * @param number - float 
	 * @param width - float
	 * @param height - float
	 * @param depth - float
	 * @param type - String
	 * @param localisation - String
	 * @param state - String
	 * @param list_product - ArrayList<Product>
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
	 * Permet de r�cup�rer le nombre
	 * @return number - float
	 */
	public float getNumber() {
		return number;
	}
	
	/**
	 * Permet de modifier le nombre
	 * @param number - float
	 */
	public void setNumber(int number) {
		this.number = number;
	}
	
	/**
	 * Permet de r�cup�rer la largeur
	 * @return width - float
	 */
	public float getWidth() {
		return width;
	}
	
	/**
	 * Permet de modifier la largeur
	 * @param width - float
	 */
	public void setWidth(int width) {
		this.width = width;
	}
	
	/**
	 * Permet de modifier la hauteur
	 * @return height - float
	 */
	public float getHeight() {
		return height;
	}
	
	/**
	 * Permet de modifier la hauteur
	 * @param height - float
	 */
	public void setHeight(int height) {
		this.height = height;
	}
	
	/**
	 * Permet de r�cup�rer la profondeur
	 * @return depth - float
	 */
	public float getDepth() {
		return depth;
	}
	
	/**
	 * Permet de modifier la pronfondeur
	 * @param depth - float
	 */
	public void setDepth(int depth) {
		this.depth = depth;
	}
	
	/**
	 * Permet de r�cup�rer le type
	 * @return type - String
	 */
	public String getType() {
		return type;
	}
	
	/**
	 * Permet de modifier le type
	 * @param type - String
	 */
	public void setType(String type) {
		this.type = type;
	}
	
	/**
	 * Permet de r�cup�rer la localisation
	 * @return localisation - String
	 */
	public String getLocalisation() {
		return localisation;
	}
	
	/**
	 * Permet de modifier la localisation
	 * @param localisation - String
	 */
	public void setLocalisation(String localisation) {
		this.localisation = localisation;
	}
	
	/**
	 * Permet de modifier l'�tat
	 * @return state - String
	 */
	public String getState() {
		return state;
	}
	
	/**
	 * Permet de modifier l'�tat
	 * @param state - String
	 */
	public void setState(String state) {
		this.state = state;
	}
	
	/**
	 * Permet de r�cup�rer la liste de produit
	 * @return list_product - ArrayList<Product>
	 */
	public ArrayList<Product> getList_product() {
		return list_product;
	}
	/**
	 * Permet de modifier la liste de produit
	 * @param list_product - ArrayList<Product>
	 */
	public void setList_product(ArrayList<Product> list_product) {
		this.list_product = list_product;
	}
	
	/*
	 * Toutes les m�thodes qui suivent sont � r��crire lorsque la BDD sera mise en place
	 * Voir si on stock uniquement sur BDD ou si on garde des variables local
	 */
	
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
