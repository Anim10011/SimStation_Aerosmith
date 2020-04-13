package prisoner;

import mvc.*;
import simStation.*;

/*
 * Edit History (Keven)
 * 
 * 4/11 - Created
 * 
 */

public class PrisonersDilemmaFactory extends SimulationFactory {
	
	public Model makeModel() {
		return new PrisonersDilemma();
	}
}
