package randomWalk;

import mvc.*;
import simStation.*;

/*
 * Edit History (Min-yuan)
 * 
 * 4/12 - Created
 * 
 */

public class RandomWalkFactory extends SimulationFactory {
	
	@Override
	public Model makeModel() {
		return new RandomWalk();
	}
}
