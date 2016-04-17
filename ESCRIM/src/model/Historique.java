package model;

import java.sql.Connection;
import java.util.ArrayList;

import controller.Bdd;

public class Historique {

	private String id,date,pays,config,avion;
	
	public Historique(String id,String date,String pays,String config,String avion){
		this.id=id;
		this.date=date;
		this.pays=pays;
		this.config=config;
		this.avion=avion;
	}

	public void getList(){
		Connection conn=Bdd.ConnectDB();
		ArrayList<Historique> liste_configs=Bdd.RecupHisto(conn);
	}
	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the date
	 */
	public String getDate() {
		return date;
	}

	/**
	 * @param date the date to set
	 */
	public void setDate(String date) {
		this.date = date;
	}

	/**
	 * @return the pays
	 */
	public String getPays() {
		return pays;
	}

	/**
	 * @param pays the pays to set
	 */
	public void setPays(String pays) {
		this.pays = pays;
	}

	/**
	 * @return the config
	 */
	public String getConfig() {
		return config;
	}

	/**
	 * @param config the config to set
	 */
	public void setConfig(String config) {
		this.config = config;
	}

	/**
	 * @return the avion
	 */
	public String getAvion() {
		return avion;
	}

	/**
	 * @param avion the avion to set
	 */
	public void setAvion(String avion) {
		this.avion = avion;
	}

}
