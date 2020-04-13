package randomWalk;

import mvc.Utilities;
import simStation.*;

/*
 * Edit History (Min-yuan)
 * 
 * 4/12 - Created
 * 
 * 4/12 - Added constant SPPED
 * 
 */

public class Drunk extends Agent {
	
	public static int SPEED = 10;
	
	public Drunk(String name, Simulation sim) {
		super(name, sim);
	}

	@Override
	public void update() {
		super.setDirection(Heading.randHeading());
		super.move(Utilities.rng.nextInt(RandomWalk.SPEED));
	}

}
