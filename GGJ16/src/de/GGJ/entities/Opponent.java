package de.GGJ.entities;

import org.newdawn.slick.geom.Vector2f;

public class Opponent extends Sprite {
	
	protected int strength;
    
	public Opponent(int strength, Vector2f pos, float speed) {
        super(pos, speed);
        this.strength = strength;
	}
	
	public void debugInformation() {
		System.out.println("[strength] = " + this.strength);
	}

}
