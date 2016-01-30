package de.GGJ.main;

import org.newdawn.slick.tests.xml.Entity;

public class Monk extends Entity {

	private int lifePoints;
	
	Monk() {
		this.lifePoints = 100;
	}
	
	public boolean isAlive() {
		return this.lifePoints > 0;
	}
	
	public void attack(int strength) {
		lifePoints -= strength;
	}
	
}
