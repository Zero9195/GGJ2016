
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
	private float speed = 0;
	/**
	 * Currently rendered image.
	 */
	private Image currentImage;

	/**
	 * Used for collision detection.
	 */
	private Shape boundingBox = new Rectangle(0, 0, 1, 1);
    
    /**
     *
     * @param pos
     * @param speed
     * @param scale
     */
    public Sprite(Vector2f pos, float speed, float scale) {
        super(pos, scale);
        this.speed = speed;
        dir = Direction.STOP;
    }
    
	@Override
	public void update(GameContainer container, int delta) {
		move(delta);
	}
	
	@Override
	public Image getImage() {
		return currentImage;
	}
	
	public void setSheet(Image sheet, int rows, int columns) {
		currentImage = sheet;
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
	
	public void move(int delta) {
		setPosition(getPosition().add(dir.copy().scale(speed*delta/1000)));
	}
	
	public Shape getBounding(){
		return boundingBox;
	}
	
	public Vector2f getCentralPoint() {
		float xPos = this.getPosition().x + this.currentImage.getWidth() / 2;
		float yPos = this.getPosition().y + this.currentImage.getHeight() / 2;
		
		return new Vector2f(xPos, yPos);
	}
	
	public void setPositionViaCentralPoint(Vector2f newPos) {
		float xPos = newPos.x - this.currentImage.getWidth() / 2 * this.getScale();
		float yPos = newPos.y - this.currentImage.getHeight() / 2 * this.getScale();
		
		Vector2f pos = new Vector2f(xPos, yPos);
		this.setPosition(pos);	
	}
	
}
