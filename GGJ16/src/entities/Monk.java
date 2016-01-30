package entities;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.tests.xml.Entity;

public class Monk extends Entity {
	
	public static final float scale = 0.4f;

	private int lifePoints;
	private Image visual = null;
	
	public Monk() throws SlickException {
		this.lifePoints = 100;
		visual = new Image("resources/monk.jpeg");
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
	
}
