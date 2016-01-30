package de.GGJ.entities;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Fly extends Opponent {
	
	private static final float scale = 0.08f;
	
	public Fly (int strength) throws SlickException {
		super(strength);
		setImage(new Image("resources/fly.png"));
	}
	
	public float getScale() {
		return scale;
	}

}