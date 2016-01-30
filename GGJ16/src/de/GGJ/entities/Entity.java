package de.GGJ.entities;

import org.newdawn.slick.Image;
import org.newdawn.slick.geom.Vector2f;

public abstract class Entity {
	private Image image;
	protected Vector2f pos;
	private float scale;
	
	public Image getImage() {
		return image;
	}

	public void setImage(Image image){
		this.image = image;
	}
	
	public Vector2f getPosition() {
		return pos;
	}
	
	public void setPosition(Vector2f pos) {
		this.pos = pos;
	}
	
	public float getScale() {
		return scale;
	}
	
	public void setScale(float scale) {
		this.scale = scale;
	}
}
