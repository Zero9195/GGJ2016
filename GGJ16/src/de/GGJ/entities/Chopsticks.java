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
public class Chopsticks extends Weapon{
    
    public Chopsticks(Vector2f pos) throws SlickException{
        super(pos, 0.7f);
        setSheet(new Image("resources/chopSticks.png"), 1, 1);
    }
}
