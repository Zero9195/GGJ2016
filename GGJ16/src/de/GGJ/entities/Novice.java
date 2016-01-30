/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.GGJ.entities;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Vector2f;

/**
 *
 * @author Marw
 */
public class Novice extends Sprite{
    protected static final float scale = 0.3f;
    protected int strength;
    protected int speed;

	public Novice(Vector2f pos) throws SlickException {
		this.setPosition(pos);
        strength = 100;
		speed = 5;
        setSheet(new Image("resources/spider.jpeg"), 1, 1);
	}

    public Novice(float xPos, float yPos) {
        this.setPosition(new Vector2f(xPos, yPos));
    }
	
	public float getScale() {
		return scale;
	}
    
    public void update(int multiplierX, int multiplierY) {
        this.getPosition().add(new Vector2f(multiplierX * speed, multiplierY * speed));
    }
}
