package de.GGJ.util;

import java.awt.Font;

import org.newdawn.slick.Image;
import org.newdawn.slick.geom.Vector2f;

import de.GGJ.entities.Entity;

public class Score extends Entity {
	
	private int score;
	Font font;
	private int size;
	
	public Score() {
        super(new Vector2f(745,20), 1.0f);
		this.score = 0;
		this.size = 32;
		this.font = new Font("Verdana", Font.BOLD, this.size);
	}

	@Override
	public Image getImage() {
		return null;
	}
	
	public String getRepresentableString() {
		return "" + this.score;
	}
	
	public Font getFormattedFont() {
		return this.font;
	}
	
	public void winPoints(int i) {
		this.score += i;
	}
	
	public void losePoints(int i) {
		this.score -= i;
	}
	

}
