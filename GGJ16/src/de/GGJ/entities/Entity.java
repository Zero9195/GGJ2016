package de.GGJ.entities;

import org.newdawn.slick.Image;
import org.newdawn.slick.geom.Vector2f;

public abstract class Entity {
	private Image image;
	private Vector2f pos;
	private float scale;
	
	public Image getImage() {
		return image;
	}
	
	public Vector2f getPosition() {
		return pos;
	}
	
	public void setImage(Image image){
		this.image = image;
	}
	
	public float getScale() {
		return scale;
	}
	
	public void setScale(float scale) {
		this.scale = scale;
	}
}
