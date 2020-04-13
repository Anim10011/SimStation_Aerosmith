package prisoner;

import mvc.*;
import simStation.*;

public class PrisonersDilemmaFactory extends SimulationFactory {
	
	public Model makeModel() {
		return new PrisonersDilemma();
	}
}
