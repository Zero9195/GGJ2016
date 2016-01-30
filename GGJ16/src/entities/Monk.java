package entities;

import org.newdawn.slick.Image;
import org.newdawn.slick.tests.xml.Entity;

public class Monk extends Entity {

	private int lifePoints;
	private Image visual = null;
	
	Monk() {
		this.lifePoints = 100;
		//TODO insert real image path
		//visual = Image("path/to/image");
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
