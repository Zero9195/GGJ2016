package entities;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Spider extends Opponent {
	
	public static final float scale = 0.3f;

	public Spider(int strength) throws SlickException {
		super(strength);
		this.visual = new Image("resources/spider.jpeg");
	}

}
