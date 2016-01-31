package de.GGJ.main;

import java.util.ArrayList;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.TrueTypeFont;
import org.newdawn.slick.geom.Vector2f;

import de.GGJ.entities.Background;
import de.GGJ.entities.Fly;
import de.GGJ.entities.Monk;
import de.GGJ.entities.Novice;
import de.GGJ.entities.Opponent;
import de.GGJ.entities.Spider;
import de.GGJ.entities.Weapon;
import de.GGJ.util.RandomPositionGenerator;
import de.GGJ.util.Score;


public class MonkProtector extends BasicGame {
	
	private Monk monk = null;
	private ArrayList<Opponent> opponents;
    private Novice novice;
    private Score score;
    private TrueTypeFont ttf;
    private int damageTimer;
    private int spawnTimer;
    private int timeToRespawn;
    private int accelerationOfSpawning;
    private RandomPositionGenerator rpg;
    private boolean won;
    private boolean paused;
    private Background bg;
    private int pointsToWin;
	
	MonkProtector(String title) {
		super(title);
        this.novice = null;
	}

	@Override
	public void init(GameContainer container) throws SlickException {
		
		monk = new Monk(container.getHeight(), container.getWidth());
        novice = new Novice(container.getWidth() / 2, container.getHeight() / 4);
		opponents = new ArrayList<>();
		score = new Score();
		ttf = new TrueTypeFont(score.getFormattedFont(), true);
		this.bg = new Background(new Vector2f(0, 0), 0.25f);
		Image tmp = new Image("resources/bgaffengame.png");
		this.bg.setImage(tmp);
		this.damageTimer = 0;
		this.spawnTimer = 0;
		this.timeToRespawn = 5000;
		this.accelerationOfSpawning = 50;
		this.won = false;
		this.paused = false;
		this.pointsToWin = 10;
		
		rpg = new RandomPositionGenerator(container.getWidth(), container.getHeight());
		
		Opponent fly = new Fly(new Vector2f(0, 0));
		Opponent spider = new Spider(new Vector2f(0, 0));
		fly.setPositionViaCentralPoint(rpg.getRandomPosition());
		spider.setPositionViaCentralPoint(rpg.getRandomPosition());
		
		opponents.add(fly);
		opponents.add(spider);	
	}

	
	@Override
	public void render(GameContainer container, Graphics graphics) throws SlickException {
		
		bg.getImage().draw(bg.getPosition().x, bg.getPosition().y, bg.getScale());
		
		monk.getImage().draw(monk.getPosition().x, monk.getPosition().y, monk.getScale());
		
		for (Opponent op : opponents) {
			op.getImage().draw(op.getPosition().x, op.getPosition().y, op.getScale());
		}		
		
		novice.getImage().draw(novice.getPosition().x, novice.getPosition().y, novice.getScale());
		novice.renderWeapon();

		ttf.drawString(score.getPosition().x, score.getPosition().y, score.getRepresentableString(), Color.white);

		//tell user if in pause or winnig state
		if (this.won) {
			int offset = ttf.getWidth("You won!") / 2;
			ttf.drawString(container.getWidth() / 2 - offset, container.getHeight() / 3, "You won!");
		}
		if (this.paused) {
			int offset = ttf.getWidth("Paused!") / 2;
			ttf.drawString(container.getWidth() / 2 - offset, container.getHeight() / 3, "Paused!");
		}

	}
	
	@Override
	public void update(GameContainer container, int delta) throws SlickException {
		Input input = container.getInput();
        
		if (!won && !paused) {
			novice.update(container, delta);
			Weapon w = novice.getWeapon();
			Opponent op;
			this.damageTimer += delta;
			this.spawnTimer += delta;
			
			for (int i = 0; i < opponents.size(); i++) {
				op = opponents.get(i);
				op.update(container, delta);
				
				if(w.isActivated() && op.getBounding().intersects(w.getBounding())){
					opponents.remove(op);
					this.score.winPoints(op.getStrength());
					i--;
					continue;
				}
				
				if (op.isAttacking() && this.damageTimer >= 1000) {
					this.score.losePoints(op.getStrength());
					this.damageTimer %= 1000;
				}
			}
			
			if (spawnTimer >= timeToRespawn) {
				spawn();
				spawnTimer %= timeToRespawn;
				if (timeToRespawn > this.accelerationOfSpawning) {
					timeToRespawn -= this.accelerationOfSpawning;        		
				}
			}
			if (this.score.getScore() >= this.pointsToWin) {
				this.won = true;
			}
		}
        
		//pause game
		if (input.isKeyPressed(Input.KEY_P)) {
			this.paused = !this.paused;
		}
		
        //attack
        if (input.isKeyPressed(Input.KEY_SPACE)) {
        }
        //close game
        if (input.isKeyPressed(Input.KEY_ESCAPE) || input.isKeyPressed(Input.KEY_E) || input.isKeyPressed(Input.KEY_Q)) {
            container.exit();
        }   
	}
	
	private void spawn() throws SlickException {
		int decision = (int) (Math.random() * 2);
		Opponent tmp;
		Vector2f pos = this.rpg.getRandomPosition();
		if (decision == 0) {
			tmp = new Spider(new Vector2f(0, 0));
		} else {
			tmp = new Fly(new Vector2f(0, 0));
		}
		tmp.setPositionViaCentralPoint(pos);
		this.opponents.add(tmp);
	}
	
	
	public static void main(String args[]) throws SlickException {
		
		AppGameContainer app = new AppGameContainer(new MonkProtector("Monk Protector"));
		
		app.setDisplayMode(800, 600, false);
		
		app.start();
		
	}
}
