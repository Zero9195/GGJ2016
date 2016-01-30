package de.GGJ.main;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class MonkProtector extends BasicGame {

	//TODO find appropiate image for monk with alpha value
	private Image monk = null;
	private Image fly = null;
	private Image spider = null;
	
	private static final float scaleOfMonk = 0.4f;
	private static final float scaleOfFly = 0.08f;
	private static final float scaleOfSpider = 0.3f;
	
	private static final String monkImageFile = "resources/monk.jpeg";
	private static final String flyImageFile = "resources/fly.png";
	private static final String spiderImageFile = "resources/spider.jpeg";
	
	
	public MonkProtector(String title) {
		super(title);
	}

	@Override
	public void render(GameContainer arg0, Graphics arg1) throws SlickException {
		float yPos = arg0.getHeight() / 2 - monk.getHeight() / 2 * scaleOfMonk;
		float xPos = (arg0.getWidth() / 2) - (monk.getWidth() / 2) * scaleOfMonk;
		monk.draw(xPos, yPos, scaleOfMonk);
		arg1.setBackground(Color.white);
		
		fly.draw(10, 10, scaleOfFly);
		spider.draw(270, 320, scaleOfSpider);
	}

	@Override
	public void init(GameContainer arg0) throws SlickException {
		monk = new Image(monkImageFile);
		fly = new Image(flyImageFile);
		spider = new Image(spiderImageFile);
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
