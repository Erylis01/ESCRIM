package model;

import java.util.ArrayList;

public class Plane {

	private String type;
	private int maxload;
	private ArrayList <Container> list_container= new ArrayList <Container>();
	
	
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
	 * @return the maxload
	 */
	public int getMaxload() {
		return maxload;
	}
	/**
	 * @param maxload the maxload to set
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
	 * @param list_container the list_container to set
	 */
	public void setList_container(ArrayList<Container> list_container) {
		this.list_container = list_container;
	}
}
