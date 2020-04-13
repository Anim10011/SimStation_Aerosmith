package randomWalk;

import simStation.*;

public class RandomWalk extends Simulation {
	
	public static int SPEED = 10;
	
	public RandomWalk() {
		super();
	}
	
	public void populate() {
		for (int i = 0; i < Simulation.NUM_AGENTS; i++) {
			agents.add(new Drunk("Drunk" + (i + 1), this));
		}
	}
	
	
}
