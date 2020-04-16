package randomWalk;

import mvc.AppPanel;
import simStation.*;

/*
 * Edit History (Min-yuan)
 * 
 * 4/12 - Created
 * 
 * 4/12 - Modified to use NUM_AGENTS in populate()
 * 
 * 4/15 - Moved driver function into here (Keven)
 * 
 */

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
	
	public static void main(String[] args) {
		AppPanel panel = new SimulationPanel(new RandomWalkFactory());
		panel.display();
	}
	
}
