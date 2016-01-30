package de.GGJ.main;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class MonkProtector extends BasicGame {

	private Image monk = null;
	
	private static final float scaleOfMonk = 0.4f;
	
	
	public MonkProtector(String title) {
		super(title);
	}

	@Override
	public void render(GameContainer arg0, Graphics arg1) throws SlickException {
		float yPos = arg0.getHeight() / 2;
		float xPos = arg0.getWidth() / 2;
		monk.draw(yPos, xPos, scaleOfMonk);
	}

	@Override
	public void init(GameContainer arg0) throws SlickException {
		monk = new Image("data/monkey-med.jpeg");
	}

	@Override
	public void update(GameContainer arg0, int arg1) throws SlickException {
		
	}
	
	public static void main(String args[]) throws SlickException {
		
		AppGameContainer app = new AppGameContainer(new MonkProtector("Monk Protector"));
		
		app.setDisplayMode(800, 600, false);
		
		app.start();
		
	}
}
