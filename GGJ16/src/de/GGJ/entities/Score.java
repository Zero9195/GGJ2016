package de.GGJ.entities;

import java.awt.Font;

import org.newdawn.slick.Image;
import org.newdawn.slick.geom.Vector2f;

public class Score extends Entity {
	
	private int score;
	Font font;
	private int size;
	
	public Score() {
		this.score = 0;
		this.size = 32;
		this.font = new Font("Verdana", Font.BOLD, this.size);
		Vector2f pos = new Vector2f(750, 20);
		this.setPosition(pos);
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
	
	

}
