package de.GGJ.entities;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Image;
import org.newdawn.slick.geom.Vector2f;

public class Sprite extends Entity {
	/**
	 * Movement direction and speed
	 */
	private Vector2f dir;
	/**
	 * Currently rendered image
	 */
	private Image currentImage;
	/**
	 * SpriteSheet cut into pieces and saved in this array.
	 */
	private Image[][] images; //0=Down, 1=Left, 2=Right, 3=Up 
	
	@Override
	public Image getImage() {
		return currentImage;
	}
	
	public void setSheet(Image sheet, int rows, int columns) {
		Image[][] images = new Image[rows][columns];
		images[0][0] = sheet;
		
		
		currentImage = images[0][0];
	}
	
	public void setDirection(Vector2f dir) {
		this.dir = dir;
	}
	
	public Vector2f getDirection() {
		return dir;
	}
	
	@Override
	public void update(GameContainer container, int delta) {
		super.update(container, delta);
	}
}
