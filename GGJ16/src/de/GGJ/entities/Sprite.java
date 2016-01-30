package de.GGJ.entities;

import org.newdawn.slick.Image;

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
	
}
