package de.GGJ.entities;

import org.newdawn.slick.geom.Vector2f;

public class Opponent extends Entity {
	
	protected int strength;
	
	Opponent(int strength, Vector2f pos) {
		this.strength = strength;
		this.pos = pos;
	}
	
	public void debugInformation() {
		System.out.println("[strength] = " + this.strength);
	}

}
