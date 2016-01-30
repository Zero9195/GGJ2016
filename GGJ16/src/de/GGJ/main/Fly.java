package de.GGJ.main;

public class Fly extends Opponent {
	
	Fly (int strength) {
		super(strength);
	}

	public void debugInformation() {
		System.out.println("[strength] = " + this.strength);
	}
}
