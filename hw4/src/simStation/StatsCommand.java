package simStation;

import mvc.*;

/*
 * Edit History (Keven Lam)
 * 
 * 4/5 - Created StatsCommand.
 */

public class StatsCommand extends Command {

	public StatsCommand(Model model) {
		super(model);
	}

	@Override
	public void execute() {
		Simulation sim = (Simulation)model;
		String[] stats = sim.getStats();
		Utilities.inform(stats);;
	}
}
