package de.GGJ.entities;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Image;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Shape;
import org.newdawn.slick.geom.Vector2f;

public class Sprite extends Entity {
	
	/**
	 * Movement direction.
	 */
	private Vector2f dir;
	/**
	 * Movement speed.
	 */
	private float speed;
	/**
	 * Currently rendered image.
	 */
	private Image currentImage;
	/**
	 * SpriteSheet cut into pieces and saved in this array.
	 */
	private Image[][] images; //0=Down, 1=Left, 2=Right, 3=Up 
	/**
	 * Used for collision detection.
	 */
	private Shape boundingBox;
	
	@Override
	public void update(GameContainer container, int delta) {
		
	}
	
	@Override
	public Image getImage() {
		return currentImage;
	}
	
	public void setSheet(Image sheet, int rows, int columns) {
		Image[][] images = new Image[rows][columns];
		images[0][0] = sheet;
		
		
		currentImage = images[0][0];
		boundingBox = new Rectangle(0, 0, currentImage.getWidth(), currentImage.getHeight());
	}
	
	public void setDirection(Vector2f dir) {
		this.dir = dir.normalise();
	}
	
	public Vector2f getDirection() {
		return dir;
	}
	
	public float getSpeed() {
		return speed;
	}
	
	public void setSpeed(float speed){
		this.speed = speed;
	}
	
	@Override
	public void setPosition(Vector2f pos){
		super.setPosition(pos);
		boundingBox.setLocation(pos);
	}
	
	public void move() {
		setPosition(getPosition().add(dir.copy().scale(speed)));
	}
}
