package model;

import java.sql.Connection;
import java.util.ArrayList;

import controller.Bdd;

public class Plane {

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
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type
	 *            the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * @return the maxload
	 */
	public int getMaxload() {
		return maxload;
	}

	/**
	 * @param maxload
	 *            the maxload to set
	 */
	public void setMaxload(int maxload) {
		this.maxload = maxload;
	}

	/**
	 * @return the list_container
	 */
	public ArrayList<Container> getList_container() {
		return list_container;
	}

	/**
	 * @param list_container
	 *            the list_container to set
	 */
	public void setList_container(ArrayList<Container> list_container) {
		this.list_container = list_container;
	}

	
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
	
	public String[] getListType(){
		String [] TypeAvion = new String[avions.length];
		for(int i=0;i<avions.length;i++){
			TypeAvion[i]=avions[i][0];
		}
		return TypeAvion;
	}
	
	public void affichage() {
		for (int i = 0; i < avions.length; i++) {
			for (int j = 0; j < avions[0].length; j++) {
				System.out.print(avions[i][j] + " *");
			}
			System.out.println("");
		}
	}
}
