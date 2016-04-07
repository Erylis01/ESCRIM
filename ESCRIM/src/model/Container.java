package model;

public class Container {

	private int ID_contenair,volume,depth,width,height;
	
	/**
	 * Constructeur de la classe Container
	 * @param ID_contenair
	 * @param volume
	 * @param depth
	 * @param width
	 * @param height
	 */
	public Container(int ID_contenair, int volume, int depth, int width, int height){ 
		this.volume = volume;
		this.depth = depth;
		this.width = width;
		this.height = height;
	}

	
	/**
	 * 
	 * @return ID_contenair
	 */
	public int getID_contenair() {
		return ID_contenair;
	}


	/**
	 * 
	 * @param iD_contenair
	 */
	public void setID_contenair(int iD_contenair) {
		ID_contenair = iD_contenair;
	}



	/**
	 * @return the volume
	 */
	public int getVolume() {
		return volume;
	}

	/**
	 * @param volume the volume to set
	 */
	public void setVolume(int volume) {
		this.volume = volume;
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
}
