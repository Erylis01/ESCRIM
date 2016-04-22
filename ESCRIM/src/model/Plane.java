package model;

import java.sql.Connection;
import java.util.ArrayList;

import controller.Bdd;

/**
 * Classe de métier permettant de décrire l'objet avion
 * @author William
 *
 */
public class Plane {
	
	/**
	 * Attributs de la classe
	 */
	private String type;
	private int maxload;
	private ArrayList<Container> list_container = new ArrayList<Container>();
	private String[][] avions;

	/**
	 * Constructeur par default
	 */
	public Plane(){
		
	}
	/**
	 * Constructeur de la classe plane
	 * 
	 * @param type
	 * @param maxload
	 * @param list_container
	 */
	public Plane(String type, int maxload, ArrayList<Container> list_container) {
		this.type = type;
		this.maxload = maxload;
		this.list_container = list_container;
	}

	/**
	 * Permet de récupérer le type
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
	 * Permet de récupérer le chargement maximal
	 * @return maxload - int
	 */
	public int getMaxload() {
		return maxload;
	}

	/**
	 * Permet de modifier le chargement maximal
	 * @param maxload - int
	 */
	public void setMaxload(int maxload) {
		this.maxload = maxload;
	}

	/**
	 * Permet de récupérer une liste de contenair
	 * @return list_container - ArrayList<Container>
	 */
	public ArrayList<Container> getList_container() {
		return list_container;
	}

	/**
	 * Permet de modifier une liste de contenair
	 * @param list_container - ArrayList<Container>
	 */
	public void setList_container(ArrayList<Container> list_container) {
		this.list_container = list_container;
	}

	/**
	 * Méthode permettabt de récupérer le tableau de contenair des avions
	 * @return avions - String[][]
	 */
	public String[][] getList() {
		Connection conn = Bdd.ConnectDB();
		ArrayList<Plane> liste_avion = Bdd.RecupAvion(conn);
		avions = new String[liste_avion.size()][2];
		for (int i = 0; i < liste_avion.size(); i++) {
			avions[i][0] = liste_avion.get(i).getType();
			avions[i][1] = Integer.toString(liste_avion.get(i).getMaxload());
		}
		return avions;
	}
	
	/**
	 * Permet de récupérer une liste de type d'avion
	 * @return TypeAvion - String[]
	 */
	public String[] getListType(){
		String [] TypeAvion = new String[avions.length];
		for(int i=0;i<avions.length;i++){
			TypeAvion[i]=avions[i][0];
		}
		return TypeAvion;
	}
	
	/**
	 * Permet d'afficher une lsite d'avion / Fonction de vérification
	 */
	public void affichage() {
		for (int i = 0; i < avions.length; i++) {
			for (int j = 0; j < avions[0].length; j++) {
				System.out.print(avions[i][j] + " *");
			}
			System.out.println("");
		}
	}
}
