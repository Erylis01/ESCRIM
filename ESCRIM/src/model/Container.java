package model;

/**
 * Classe de mise en place des contenair
 * @author William
 *
 */
public class Container {

	private int ID_contenair,volume,depth,width,height;
	
	/**
	 * Constructeur de la classe Container
	 * @param ID_contenair - int
	 * @param volume - int
	 * @param depth - int
	 * @param width - int
	 * @param height - int
	 */
	public Container(int volume, int depth, int width, int height){ 
		this.volume = volume;
		this.depth = depth;
		this.width = width;
		this.height = height;
	}

	
	/**
	 * Renvoi l'ID du contenair
	 * @return ID_contenair - int
	 */
	public int getID_contenair() {
		return ID_contenair;
	}


	/**
	 * Modifie l'ID du contenair
	 * @param iD_contenair - int
	 */
	public void setID_contenair(int iD_contenair) {
		ID_contenair = iD_contenair;
	}



	/**
	 * Renvoie le volume du contenair
	 * @return volume - int
	 */
	public int getVolume() {
		return volume;
	}

	/**
	 * Modifie le volume du contenair
	 * @param volume - int
	 */
	public void setVolume(int volume) {
		this.volume = volume;
	}

	/**
	 * Renvoie la profondeur du contenair
	 * @return depth - int
	 */
	public int getDepth() {
		return depth;
	}

	/**
	 * Modifie la valeur du contenair
	 * @param depth - int
	 */
	public void setDepth(int depth) {
		this.depth = depth;
	}

	/**
	 * Renvoie la largeur du contenair
	 * @return width - int
	 */
	public int getWidth() {
		return width;
	}

	/**
	 * Modifie la largeur du contenair
	 * @param width - int
	 */
	public void setWidth(int width) {
		this.width = width;
	}

	/**
	 * Renvoie la hauteur du contenair
	 * @return height - int
	 */
	public int getHeight() {
		return height;
	}

	/**
	 * Modifie la hauteur du contenair
	 * @param height - int
	 */
	public void setHeight(int height) {
		this.height = height;
	}
}
