/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.GGJ.entities;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Vector2f;

import de.GGJ.collisionDetection.Direction;

/**
 *
 * @author Marw
 */
public class Novice extends Sprite{
    protected static final float SCALE = 1.0f;
    protected int strength;

	public Novice(Vector2f pos) throws SlickException {
		super(pos, 100, SCALE);
        strength = 100;
        setSheet(new Image("resources/monky.png"), 1, 1);
	}

    public Novice(float xPos, float yPos) throws SlickException {
        this(new Vector2f(xPos, yPos));
    }
	
    @Override
	public float getScale() {
		return SCALE;
	}
    
    @Override
    public void update(GameContainer container, int delta) {
		Input input = container.getInput();
    	
    	//move player
        if (input.isKeyDown(Input.KEY_W)) {
//        	if(input.isKeyDown(Input.KEY_A)){
//        		setDirection(Direction.NORTHWEST);
//        	} else if(input.isKeyDown(Input.KEY_D)){
//        		setDirection(Direction.NORTHEAST);
//        	} else {
        		setDirection(Direction.NORTH);
//        	}
        } else if(input.isKeyDown(Input.KEY_S)) {
//        	if(input.isKeyDown(Input.KEY_A)){
//        		setDirection(Direction.SOUTHWEST);
//        	} else if(input.isKeyDown(Input.KEY_D)){
//        		setDirection(Direction.SOUTHEAST);
//        	} else {
        		setDirection(Direction.SOUTH);
//        	}
        } else if(input.isKeyDown(Input.KEY_A)) {
            setDirection(Direction.WEST);
        } else if(input.isKeyDown(Input.KEY_D)) {
            setDirection(Direction.EAST);
        }else{
            setDirection(Direction.STOP);
        }
        
        move(delta);
        
        Vector2f pos = getPosition();
		pos.x = Math.max(0, pos.x);
		pos.x = Math.min(container.getWidth(), pos.x);
		pos.y = Math.max(0, pos.y);
		pos.y = Math.min(container.getHeight(), pos.y);
    }
}
