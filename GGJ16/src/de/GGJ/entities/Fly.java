package de.GGJ.entities;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Vector2f;

public class Fly extends Opponent {
	
	private static final float SCALE = 1.0f;
	
	public Fly (Vector2f pos) throws SlickException {
        super(10, pos, 50, SCALE);
		setSheet(new Image("resources/fly.png"), 1, 1);
	}
	
    @Override
	public float getScale() {
		return SCALE;
	}

}