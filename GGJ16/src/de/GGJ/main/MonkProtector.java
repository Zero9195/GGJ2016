package de.GGJ.main;

import java.util.ArrayList;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.Input;

import de.GGJ.entities.*;
import de.GGJ16.util.RandomPositionGenerator;


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
		
		RandomPositionGenerator rpg = new RandomPositionGenerator(arg0.getWidth(), arg0.getHeight());
		
		Opponent fly = new Fly(rpg.getRandomPosition());
		Opponent spider = new Spider(rpg.getRandomPosition());
		
		System.out.println(fly.getPosition());
		System.out.println(spider.getPosition());
		
		opponents.add(fly);
		opponents.add(spider);
	}

	
	@Override
	public void update(GameContainer container, int delta) throws SlickException {
		Input input = container.getInput();
        
        //move player
        if (input.isKeyPressed(Input.KEY_W)) {
            
        }else if(input.isKeyPressed(Input.KEY_A)) {
            
        }else if(input.isKeyPressed(Input.KEY_S)) {
            
        }else if(input.isKeyPressed(Input.KEY_D)) {
            
        }
        
        //hit
        if (input.isKeyPressed(Input.KEY_SPACE)) {
            
        }
        
        //close game
        if (input.isKeyPressed(Input.KEY_ESCAPE) || input.isKeyPressed(Input.KEY_E) || input.isKeyPressed(Input.KEY_Q)) {
            container.exit();
        }
        
	}
	
	
	public static void main(String args[]) throws SlickException {
		
		AppGameContainer app = new AppGameContainer(new MonkProtector("Monk Protector"));
		
		app.setDisplayMode(800, 600, false);
		
		app.start();
		
	}
}
