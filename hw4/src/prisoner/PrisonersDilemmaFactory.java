package prisoner;

import mvc.*;
import simStation.*;

public class PrisonersDilemmaFactory extends SimStationFactory {
	
	public Model makeModel() {
		return new PrisonersDilemma();
	}
}
