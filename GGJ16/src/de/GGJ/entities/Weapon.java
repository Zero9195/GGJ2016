/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.GGJ.entities;

import org.newdawn.slick.geom.Vector2f;

/**
 *
 * @author Marw
 */
public abstract class Weapon extends Sprite{
    
    public Weapon(Vector2f pos, float scale) {
        super(pos, 0, scale); // a weapon has no speed
    }
    
    
    
    
}
