package de.GGJ.entities;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Fly extends Opponent {
	
	public static final float scale = 0.08f;
	
	public Fly (int strength) throws SlickException {
		super(strength);
		setSheet(new Image("resources/fly.png"), 1, 1);
	}

}