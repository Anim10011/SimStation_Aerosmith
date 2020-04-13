package plague;

import mvc.*;
import simStation.*;

/*
 * Edit History (Alex)
 * 4/1  - Created
 * 
 */

public class PlagueFactory extends SimulationFactory {
	
	@Override
	public Model makeModel() { return new PlagueSim(); }
	
}
