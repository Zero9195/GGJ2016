package de.GGJ.main;

import java.util.ArrayList;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Vector2f;

import de.GGJ.entities.*;


public class MonkProtector extends BasicGame {
	
	private Monk monk = null;
	private ArrayList<Opponent> opponents;
	
	MonkProtector(String title) {
		super(title);
	}

	
	@Override
	public void render(GameContainer arg0, Graphics arg1) throws SlickException {
		
		monk.getImage().draw(monk.getPosition().x, monk.getPosition().y, monk.getScale());
		
		for (Opponent op : opponents) {
			op.getImage().draw(op.getPosition().x, op.getPosition().y, op.getScale());
		}
		
		arg1.setBackground(Color.white);
	}

	
	@Override
	public void init(GameContainer arg0) throws SlickException {
		
		monk = new Monk(arg0.getHeight(), arg0.getWidth());
		opponents = new ArrayList<Opponent>();
		
		Opponent fly = new Fly(new Vector2f(90, 150));
		Opponent spider = new Spider(new Vector2f(260, 40));
		
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
