package de.GGJ.entities;

import org.newdawn.slick.Image;
import org.newdawn.slick.geom.Vector2f;

public class Sprite extends Entity {

	Image currentImage;
	Image[][] images; //0=Down, 1=Left, 2=Right, 3=Up 
	
	@Override
	public Image getImage() {
		return currentImage;
	}
	
	public void setSheet(Image sheet, int rows, int columns) {
		Image[][] images = new Image[rows][columns];
		images[0][0] = sheet;
		
		
		currentImage = images[0][0];
	}
	
	
	
	//experimetnal functions to get and set central position
	
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
