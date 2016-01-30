package de.GGJ.entities;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Spider extends Opponent {
	
	protected static final float scale = 0.3f;

	public Spider() throws SlickException {
		super(15);
		setImage(new Image("resources/spider.jpeg"));
	}
	
	public float getScale() {
		return scale;
	}

}
