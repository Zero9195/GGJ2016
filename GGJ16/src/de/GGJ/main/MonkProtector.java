package de.GGJ.main;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

import de.GGJ.entities.*;

public class MonkProtector extends BasicGame {

	private Monk monk = null;
	private Fly fly = null;
	private Spider spider = null;
	
	MonkProtector(String title) {
		super(title);
	}

	@Override
	public void render(GameContainer arg0, Graphics arg1) throws SlickException {
		
		float yPos = arg0.getHeight() / 2 - monk.getImage().getHeight() / 2 * Monk.scale;
		float xPos = (arg0.getWidth() / 2) - monk.getImage().getWidth() / 2 * Monk.scale;
		
		monk.getImage().draw(xPos, yPos, Monk.scale);
		fly.getImage().draw(10, 10, Fly.scale);
		spider.getImage().draw(270, 320, Spider.scale);
		
		arg1.setBackground(Color.white);
	}

	@Override
	public void init(GameContainer arg0) throws SlickException {
		monk = new Monk();
		fly = new Fly(10);
		spider = new Spider(15);
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
