package de.GGJ.entities;

import org.newdawn.slick.Image;
import org.newdawn.slick.geom.Vector2f;

public class Background extends Entity {
	
	Image image;

    public Background(Vector2f pos, float scale) {
        super(pos, scale);
    }
	
	@Override
	public Image getImage() {
		return image;
	}
	
	public void setImage(Image image){
		this.image = image;
	}

}
