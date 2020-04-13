package randomWalk;

import mvc.Utilities;
import simStation.*;

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
