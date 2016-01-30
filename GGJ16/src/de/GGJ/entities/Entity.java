package de.GGJ.entities;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Image;
import org.newdawn.slick.geom.Vector2f;

public abstract class Entity {
	private Vector2f pos;
	private float scale;
	
	public abstract Image getImage();

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
	
	public void update(GameContainer container, int delta) {}
}
