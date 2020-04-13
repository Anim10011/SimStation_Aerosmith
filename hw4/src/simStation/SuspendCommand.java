package simStation;

import mvc.*;

/*
 * Edit History (Keven Lam)
 * 
 * 4/5 - Created SuspendCommand.
 */

public class SuspendCommand extends Command {

	public SuspendCommand(Model model) {
		super(model);
	}

	@Override
	public void execute() {
		Simulation sim = (Simulation)model;
		sim.suspend();	
	}

}
