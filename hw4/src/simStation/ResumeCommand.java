package simStation;

import mvc.*;

/*
 * Edit History (Keven Lam)
 * 
 * 4/5 - Created ResumeCommand.
 */

public class ResumeCommand extends Command {

	public ResumeCommand(Model model) {
		super(model);
	}

	@Override
	public void execute() {
		Simulation sim = (Simulation)model;
		sim.resume();
	}
}
