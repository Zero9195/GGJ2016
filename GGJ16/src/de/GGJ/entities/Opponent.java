package de.GGJ.entities;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.geom.Vector2f;

public class Opponent extends Sprite {
	
	protected int strength;
    
	public Opponent(int strength, Vector2f pos, float speed) {
        super(pos, speed);
        this.strength = strength;  
	}
	
	public void debugInformation() {
		System.out.println("[strength] = " + this.strength);
	}
	
	public void update(GameContainer container, int delta) {
		
		float centerX = container.getWidth() / 2;
		float centerY = container.getHeight() / 2;
		
		float xMovement = centerX - this.getCentralPoint().x;
		float yMovement = centerY - this.getCentralPoint().y;
		Vector2f directionToCenter = new Vector2f(xMovement, yMovement);
		
		this.setDirection(directionToCenter);
		if (this.getPosition().x != centerX && this.getPosition().y != centerY) {
			super.update(container, delta);			
		}
	}

}