package de.GGJ.main;

import java.util.ArrayList;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

import entities.*;

public class MonkProtector extends BasicGame {

	private static final float scaleFly = 0.08f;
	private static final float scaleSpider = 0.3f;
	
	private Monk monk = null;
	private ArrayList<Opponent> opponents;
	
	MonkProtector(String title) {
		super(title);
	}

	
	@Override
	public void render(GameContainer arg0, Graphics arg1) throws SlickException {
		
		float yPos = arg0.getHeight() / 2 - monk.getImage().getHeight() / 2 * Monk.scale;
		float xPos = (arg0.getWidth() / 2) - monk.getImage().getWidth() / 2 * Monk.scale;
		
		monk.getImage().draw(xPos, yPos, Monk.scale);
		
		for (Opponent op : opponents) {
			float scale = 1.0f;
			if (op instanceof Fly) {
				scale = scaleFly;
			} else {
				scale = scaleSpider;
			}
			op.getImage().draw(100, 240, scale);
		}
		
		arg1.setBackground(Color.white);
	}

	
	@Override
	public void init(GameContainer arg0) throws SlickException {
		monk = new Monk();
		opponents = new ArrayList<Opponent>();
		Opponent fly = new Fly(10);
		Opponent spider = new Spider(15);
		
	
		opponents.add(fly);
		opponents.add(spider);
		
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
