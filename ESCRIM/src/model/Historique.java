package model;

import java.sql.Connection;
import java.sql.Date;
import java.text.ParseException;
import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import controller.Bdd;

/**
 * Implémentation de la classe métier des historiques
 * @author William
 *
 */
@SuppressWarnings("serial")
public class Historique extends AbstractTableModel {
	
	/**
	 * Attributs de la classe
	 */
	private String id, date, pays, config, avion;
	private String[][] configs;
	private final String[] entetes = { "ID", "DATE", "PAYS", "CONFIGURATION", "AVION" };

	/**
	 * Constructeur par default
	 */
	public Historique() {

	}

	/**
	 * Constructeur de la classe
	 * @param id - String
	 * @param date - String
	 * @param pays - String
	 * @param config - String
	 * @param avion - String
	 */
	public Historique(String id, String date, String pays, String config, String avion) {
		this.id = id;
		this.date = date;
		this.pays = pays;
		this.config = config;
		this.avion = avion;
	}
	
	/**
	 * Renvoie le nombre de colonne
	 * @return columnCount - int
	 */
	@Override
	public int getColumnCount() {
		return entetes.length;
	}
	
	/**
	 * Renvoie le nombre de ligne
	 * @return rowCount - int
	 */
	@Override
	public int getRowCount() {
		return configs.length;
	}

	/**
	 * Renvoie le nom des colonnes suivant l'index de la colonne
	 * @param columnIndex - int
	 * @return columnName - String
	 */
	@Override
	public String getColumnName(int columnIndex) {
		return entetes[columnIndex];
	}
	
	/**
	 * Renvoie la valeur du cellule
	 * @param rowIndex - int
	 * @param columnIndex - int
	 * @return value - Object
	 */
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		return configs[rowIndex][columnIndex];
	}

	/**
	 * Permet de récupérer l'ensemble des configurations et de remplir dans un
	 * tableau de string
	 * @return configs - String[]
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
	 * @param date - Date
	 * @return configs - String[]
	 * @throws ParseException
	 */
	public String[][] getListDate(Date date) throws ParseException {
		Connection conn = Bdd.ConnectDB();
		ArrayList<Historique> liste_configs = Bdd.RecupHisto(date, conn);
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
	 * Permet de récupérer une liste de configuration en fonction d'un pays
	 * @param Pays - String
	 * @return configs - String[]
	 */
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
	 * Permet de récupérer l'id
	 * @return id - String
	 */
	public String getId() {
		return id;
	}

	/**
	 * Permet de modifier l'id
	 * @param id - String
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * Permet de renvoyer la date
	 * @return date - String
	 */
	public String getDate() {
		return date;
	}

	/**
	 * Permet de modifier la date
	 * @param date - Date
	 */
	public void setDate(String date) {
		this.date = date;
	}

	/**
	 * Permet de renvoyer le pays
	 * @return pays - String
	 */
	public String getPays() {
		return pays;
	}

	/**
	 * Permet de modifier le pays
	 * @param pays - String
	 */
	public void setPays(String pays) {
		this.pays = pays;
	}

	/**
	 * Permet de récupérer une configuration
	 * @return config - String
	 */
	public String getConfig() {
		return config;
	}

	/**
	 * Permet de modifier la config
	 * @param config - config
	 */
	public void setConfig(String config) {
		this.config = config;
	}

	/**
	 * .Permet de récupérer l'avion
	 * @return avion - String
	 */
	public String getAvion() {
		return avion;
	}

	/**
	 * Permet de modifier l'avion
	 * @param avion - String
	 */
	public void setAvion(String avion) {
		this.avion = avion;
	}

}
