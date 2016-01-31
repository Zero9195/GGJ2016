package de.GGJ.entities;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Vector2f;

public class Monk extends Entity {
	
	private static final float SCALE = 1.0f;

	private int lifePoints;
	private Image visual = null;
	
	public Monk(float height, float width) throws SlickException {
        super(new Vector2f(0,0), SCALE);
		this.lifePoints = 100;
		visual = new Image("resources/monky.png");
		float xPos = width / 2 - this.visual.getWidth() / 2 * SCALE;
		float yPos = height / 2 - this.visual.getHeight() / 2 * SCALE;
		this.setPosition(new Vector2f(xPos, yPos));
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
	
    @Override
	public Image getImage() {
		return this.visual;
	}
	
    @Override
	public float getScale() {
		return SCALE;
	}
	
}
