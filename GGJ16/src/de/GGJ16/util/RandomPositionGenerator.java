package de.GGJ16.util;

import org.newdawn.slick.geom.Vector2f;

public class RandomPositionGenerator {
	
	private int minX = 0;
	private int minY = 0;
	private int maxX;
	private int maxY;
	private int borderWidth;
	
	public RandomPositionGenerator(int maxX, int maxY, int border) {
		this.maxX = maxX;
		this.maxY = maxY;
		this.borderWidth = border;
	}
	
	public RandomPositionGenerator(int minX, int minY, int maxX, int maxY, int border) {
		this.minX = minX;
		this.minY = minY;
		this.maxX = maxX;
		this.maxY = maxY;
		this.borderWidth = border;
	}
	
	public int getMinX() {
		return this.minX;
	}
	
	public int getMinY() {
		return this.minY;
	}
	
	public int getMaxX() {
		return this.maxX;
	}
	
	public int getMaxY() {
		return this.maxY;
	}
	
	public int getBorderWidth() {
		return this.borderWidth;
	}
	
	public void setMinY(int minY) {
		this.minY = minY;
	}

	public void setMinX(int minX) {
		this.minX = minX;
	}
	
	public void setMaxY(int maxY) {
		this.maxY = maxY;
	}
	
	public void setMaxX(int maxX) {
		this.maxX = maxX;
	}
	
	public Vector2f getRandomPosition() {
		float xPos;
		float yPos;
		boolean right = Math.random() * 100 % 2 == 0;
		xPos = (int) (Math.random() * (borderWidth));
		if (right) {
			xPos = maxX - xPos;
		} 
		
		boolean up = Math.random() * 100 % 2 == 0;
		yPos = (int) (Math.random() * (borderWidth));
		if (up) {
			yPos = maxY - yPos;
		} 
		
		return new Vector2f(xPos, yPos);
	}
}
