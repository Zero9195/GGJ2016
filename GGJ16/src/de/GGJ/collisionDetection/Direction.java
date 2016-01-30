package de.GGJ.collisionDetection;

import org.newdawn.slick.geom.Vector2f;

public class Direction {
	/**
	 * Static directions.
	 */
    public final static Vector2f STOP = new Vector2f(0,0);
	public final static Vector2f NORTH = new Vector2f(0,-1);
	public final static Vector2f SOUTH = new Vector2f(0,1);
	public final static Vector2f WEST = new Vector2f(-1,0);
	public final static Vector2f EAST = new Vector2f(1,0);
	public final static Vector2f NORTHEAST = new Vector2f(1,-1).normalise();
	public final static Vector2f NORTHWEST = new Vector2f(-1,-1).normalise();
	public final static Vector2f SOUTHEAST = new Vector2f(1,1).normalise();
	public final static Vector2f SOUTHWEST = new Vector2f(-1,1).normalise();
}
