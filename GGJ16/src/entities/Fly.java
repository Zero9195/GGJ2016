package entities;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Fly extends Opponent {
	
	public Fly (int strength) throws SlickException {
		super(strength);
		this.visual = new Image("resources/fly.png");
	}

}