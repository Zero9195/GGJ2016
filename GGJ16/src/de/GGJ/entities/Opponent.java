package de.GGJ.entities;

import org.newdawn.slick.Image;

public class Opponent extends Entity {
	
	protected int strength;
	
	Opponent(int strength) {
		this.strength = strength;
	}
	
	public void debugInformation() {
		System.out.println("[strength] = " + this.strength);
	}

}
