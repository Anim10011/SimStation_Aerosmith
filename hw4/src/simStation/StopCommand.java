package simStation;

import mvc.*;

/*
 * Edit History (Keven Lam)
 * 
 * 4/5 - Created StopCommand.
 */

public class StopCommand extends Command {

	public StopCommand(Model model) {
		super(model);
	}

	@Override
	public void execute() {
		Simulation sim = (Simulation)model;
		sim.stop();
	}
}
