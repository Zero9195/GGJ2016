package de.GGJ.main;

import java.awt.Font;
import java.util.ArrayList;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.TrueTypeFont;
import org.newdawn.slick.geom.Vector2f;
import org.newdawn.slick.Input;

import de.GGJ.collisionDetection.Direction;
import de.GGJ.entities.*;
import de.GGJ.util.RandomPositionGenerator;
import de.GGJ.util.Score;


public class MonkProtector extends BasicGame {
	
	private Monk monk = null;
	private ArrayList<Opponent> opponents;
    private Novice novice;
    private Score score;
    private TrueTypeFont ttf = null;
	
	MonkProtector(String title) {
		super(title);
        this.novice = null;
	}

	@Override
	public void render(GameContainer container, Graphics graphics) throws SlickException {
		
		monk.getImage().draw(monk.getPosition().x, monk.getPosition().y, monk.getScale());
		
		for (Opponent op : opponents) {
			op.getImage().draw(op.getPosition().x, op.getPosition().y, op.getScale());
		}		
		
		novice.getImage().draw(novice.getPosition().x, novice.getPosition().y, novice.getScale());
		
		//Version 1:
		//nicer but drops framerate significantly
		ttf.drawString(score.getPosition().x, score.getPosition().y, score.getRepresentableString(), Color.white);
		
		//Version 2:
		//standard version, but at higher framerate
		//graphics.drawString(score.getRepresentableString(), score.getPosition().x, score.getPosition().y);
		
		graphics.setBackground(Color.red);
	}

	
	@Override
	public void init(GameContainer container) throws SlickException {
		
		monk = new Monk(container.getHeight(), container.getWidth());
        novice = new Novice(container.getWidth() / 2, container.getHeight() / 4);
		opponents = new ArrayList<>();
		score = new Score();
		ttf = new TrueTypeFont(score.getFormattedFont(), true);
		
		RandomPositionGenerator rpg = new RandomPositionGenerator(container.getWidth(), container.getHeight());
		
		Opponent fly = new Fly(new Vector2f(0, 0));
		Opponent spider = new Spider(new Vector2f(0, 0));
		fly.setPositionViaCentralPoint(rpg.getRandomPosition());
		spider.setPositionViaCentralPoint(rpg.getRandomPosition());
		
		opponents.add(fly);
		opponents.add(spider);	
	}

	
	@Override
	public void update(GameContainer container, int delta) throws SlickException {
		Input input = container.getInput();
        
        novice.update(container, delta);
        
        //TODO integrate framerate into losing points to decrease attacking speed
        for (Opponent op : opponents) {
			op.update(container, delta);
			if (op.isAttacking()) {
				this.score.losePoints(op.getStrength());
			}
		}
        
        //attack
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
