package de.GGJ.entities;

import org.newdawn.slick.geom.Vector2f;

public class Opponent extends Sprite {
	
	protected int strength;
	
	Opponent(int strength, Vector2f pos) {
		this.strength = strength;
		this.setPosition(pos);
	}
	
	public void debugInformation() {
		System.out.println("[strength] = " + this.strength);
	}

}
