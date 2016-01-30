package entities;

import org.newdawn.slick.Image;
import org.newdawn.slick.tests.xml.Entity;

public class Opponent extends Entity {
	
	protected Image visual = null;
	protected int strength;
	
	Opponent(Image i, int strength) {
		this.visual = i;
		this.strength = strength;
	}
	
	public void debugInformation() {
		System.out.println("[strength] = " + this.strength);
	}
	
	public Image getImage() {
		return this.visual;
	}

}