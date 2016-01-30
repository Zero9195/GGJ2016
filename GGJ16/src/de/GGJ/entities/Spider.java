package de.GGJ.entities;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Vector2f;

public class Spider extends Opponent {
	
	protected static final float scale = 1.0f;

	public Spider(Vector2f pos) throws SlickException {
		super(15, pos, 30);
		setSheet(new Image("resources/spider.png"), 1, 1);
	}
	
	public float getScale() {
		return scale;
	}

}
