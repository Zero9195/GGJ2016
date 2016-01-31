package de.GGJ.entities;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.geom.Vector2f;

public abstract class Opponent extends Sprite {
	
	protected int strength;
	//variabel to determine whether points are currently lost
	private boolean attacking;
    
	public Opponent(int strength, Vector2f pos, float speed, float scale) {
        super(pos, speed, scale);
        this.strength = strength;  
        this.attacking = false;
	}
	
	public void debugInformation() {
		System.out.println("[strength] = " + this.strength);
	}
	
    @Override
	public void update(GameContainer container, int delta) {
		
		float centerX = container.getWidth() / 2;
		float centerY = container.getHeight() / 2;
		
		float xMovement = centerX - this.getCentralPoint().x;
		float yMovement = centerY - this.getCentralPoint().y;
		Vector2f directionToCenter = new Vector2f(xMovement, yMovement);
		
		this.setDirection(directionToCenter);
		
		//has yet to reach center
		if (Math.abs(xMovement) > 0.1 || Math.abs(yMovement) > 0.1) {
			super.update(container, delta);			
		} else {
			this.attacking = true;
		}
		
	}
	
	public int getStrength() {
		return this.strength;
	}
	
	public boolean isAttacking() {
		return this.attacking;
	}

}