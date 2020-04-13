package randomWalk;

import mvc.*;
import simStation.*;

public class RandomWalkFactory extends SimulationFactory {
	
	@Override
	public Model makeModel() {
		return new RandomWalk();
	}
}
