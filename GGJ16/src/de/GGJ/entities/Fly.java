package de.GGJ.entities;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Vector2f;

public class Fly extends Opponent {
	
	private static final float scale = 0.08f;
	
	public Fly (Vector2f pos) throws SlickException {
		super(10, pos);
		setImage(new Image("resources/fly.png"));
	}
	
	public float getScale() {
		return scale;
	}

}