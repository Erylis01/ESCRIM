package model;

import java.sql.Connection;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import controller.Bdd;

public class Historique extends AbstractTableModel {

	private String id, date, pays, config, avion;
	private String[][] configs;
	private final String[] entetes = { "ID", "DATE", "PAYS", "CONFIGURATION", "AVION" };

	/**
	 * Constructeur par default
	 */
	public Historique() {

	}

	/**
	 * Constructeur
	 * 
	 * @param id
	 * @param date
	 * @param pays
	 * @param config
	 * @param avion
	 */
	public Historique(String id, String date, String pays, String config, String avion) {
		this.id = id;
		this.date = date;
		this.pays = pays;
		this.config = config;
		this.avion = avion;
	}

	@Override
	public int getColumnCount() {
		return entetes.length;
	}

	@Override
	public int getRowCount() {
		return configs.length;
	}

	@Override
	public String getColumnName(int columnIndex) {
		return entetes[columnIndex];
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		return configs[rowIndex][columnIndex];
	}

	/**
	 * Permet de récupérer l'ensemble des configurations et de remplir dans un
	 * tableau de string
	 * 
	 * @return Tableau de string de config
	 */
	public String[][] getList() {
		Connection conn = Bdd.ConnectDB();
		ArrayList<Historique> liste_configs = Bdd.RecupHisto(conn);
		configs = new String[liste_configs.size()][5];
		for (int i = 0; i < liste_configs.size(); i++) {
			configs[i][0] = liste_configs.get(i).getId();
			configs[i][1] = liste_configs.get(i).getDate();
			configs[i][2] = liste_configs.get(i).getPays();
			configs[i][3] = liste_configs.get(i).getConfig();
			configs[i][4] = liste_configs.get(i).getAvion();
		}
		return configs;
	}

	/**
	 * Permet de récupérer la liste des configurations filtrer par date
	 * 
	 * @param Date
	 * @return
	 * @throws ParseException
	 */
	public String[][] getListDate(String Date) throws ParseException {
		DateFormat df = new SimpleDateFormat("dd-MMM-yyyy");
		java.sql.Date datesql = new java.sql.Date(df.parse(Date).getTime());
		Connection conn = Bdd.ConnectDB();
		ArrayList<Historique> liste_configs = Bdd.RecupHisto(datesql, conn);
		configs = new String[liste_configs.size()][5];
		for (int i = 0; i < liste_configs.size(); i++) {
			configs[i][0] = liste_configs.get(i).getId();
			configs[i][1] = liste_configs.get(i).getDate();
			configs[i][2] = liste_configs.get(i).getPays();
			configs[i][3] = liste_configs.get(i).getConfig();
			configs[i][4] = liste_configs.get(i).getAvion();
		}
		return configs;
	}

	public String[][] getListPays(String Pays){
		Connection conn = Bdd.ConnectDB();
		ArrayList<Historique> liste_configs =Bdd.RecupHisto(Pays, conn);
		configs = new String[liste_configs.size()][5];
		for (int i = 0; i < liste_configs.size(); i++) {
			configs[i][0] = liste_configs.get(i).getId();
			configs[i][1] = liste_configs.get(i).getDate();
			configs[i][2] = liste_configs.get(i).getPays();
			configs[i][3] = liste_configs.get(i).getConfig();
			configs[i][4] = liste_configs.get(i).getAvion();
		}
		return configs;
	}

	/**
	 * Permet d'afficher la l'historique
	 */
	public void affichage() {
		for (int i = 0; i < configs.length; i++) {
			for (int j = 0; j < configs[0].length; j++) {
				System.out.print(configs[i][j] + " *");
			}
			System.out.println("");
		}
	}

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
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
	 * @param date
	 *            the date to set
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
	 * @param pays
	 *            the pays to set
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
	 * @param config
	 *            the config to set
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
	 * @param avion
	 *            the avion to set
	 */
	public void setAvion(String avion) {
		this.avion = avion;
	}

}
