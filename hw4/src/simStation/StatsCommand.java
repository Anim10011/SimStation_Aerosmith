package simStation;

import mvc.*;

/*
 * Edit History 
 * 3/27 - Created (Alvin)
 *
 * 4/5 - modified the stats display(Keven)
 * 
 */

public class StatsCommand extends Command {

	public StatsCommand(Model model) {
		super(model);
	}

	@Override
	public void execute() {
		Simulation sim = (Simulation)model;
		String[] stats = sim.getStats();
		Utilities.inform(stats);
	}

}
