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
    protected boolean activated;
    protected final static float STARTSCALE = 0.3f;
    protected float maxScale;
    
    public Weapon(Vector2f pos, float scale) {
        super(pos, 0, scale); // a weapon has no speed
        maxScale = scale;
    }
    
    public void setActivated(boolean activate) {
        activated = activate;
    }
    
    public boolean isActivated() {
        return activated;
    }
    
    public void activate(Vector2f pos) {
        activated = true;
        setPosition(pos);
        setScale(STARTSCALE);
    }

    void changeScale() {
        float tempScale = getScale();
        if (tempScale < maxScale) {
            tempScale += 0.1f / 250;
            setScale(tempScale);
        } else {
            setActivated(false);
        }
    }
}
