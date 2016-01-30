package de.GGJ.entities;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Vector2f;

public class Monk extends Entity {
	
	private static final float scale = 0.4f;

	private int lifePoints;
	private Image visual = null;
	
	public Monk(float height, float width) throws SlickException {
		this.lifePoints = 100;
		visual = new Image("resources/monk.jpeg");
		float xPos = width / 2 - this.visual.getWidth() / 2 * scale;
		float yPos = height / 2 - this.visual.getHeight() / 2 * scale;
		this.pos = new Vector2f(xPos, yPos);
	}
	
	public boolean isAlive() {
		return this.lifePoints > 0;
	}
	
	public void attack(int strength) {
		lifePoints -= strength;
	}
	
	public void debugInformation() {
		System.out.println("[lifepoints] = " + this.lifePoints);
	}
	
	public Image getImage() {
		return this.visual;
	}
	
	public float getScale() {
		return scale;
	}
	
}
