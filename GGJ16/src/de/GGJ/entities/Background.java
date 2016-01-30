package de.GGJ.entities;

import org.newdawn.slick.Image;

public class Background extends Entity {
	
	Image image;
	
	@Override
	public Image getImage() {
		return image;
	}
	
	public void setImage(Image image){
		this.image = image;
	}

}
