package de.GGJ16.util;

import org.newdawn.slick.geom.Vector2f;

public class RandomPositionGenerator {
	
	private int maxX;
	private int maxY;
	
	public RandomPositionGenerator(int maxX, int maxY) {
		this.maxX = maxX;
		this.maxY = maxY;
	}
	
	public Vector2f getRandomPosition() {
		
		int decision = (int) (Math.random() * 4);
		
		//0 is left, 1 is top, 2 is right, 3 is down
		int xPos = 0;
		int yPos = 0;
		
		switch (decision) {
		case 0:
			yPos = (int) (Math.random() * this.maxY);
			break;
		case 1:
			xPos = (int) (Math.random() * this.maxX);
			break;
		case 2:
			yPos = (int) (Math.random() * this.maxY);
			xPos = maxX;
			break;
		case 3:
			xPos = (int) (Math.random() * this.maxX);
			yPos = maxY;
			break;
		default:
			System.err.println("Fatal error");
		}
		
		return new Vector2f(xPos, yPos);
	}
}