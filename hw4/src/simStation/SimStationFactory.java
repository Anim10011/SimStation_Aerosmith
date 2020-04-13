package simStation;

import mvc.*;

/*
 * Edit History (Keven Lam)
 * 
 * 4/5 - Created SimStationFactory.
 * 
 * 4/5 - Added makeView().
 */

public class SimStationFactory implements AppFactory {

	@Override
	public Model makeModel() {
		return new Simulation();
	}
	
	public View makeView(Model model) {
		return new SimStationView(model);
	}

	@Override
	public String[] getEditCommands() {
		return new String[] {"Start", "Suspend", "Resume", "Stop", "Stats"};
	}

	@Override
	public Command makeEditCommand(Model model, String type) {
		if (type == "Start") return new StartCommand(model);
		if (type == "Suspend") return new SuspendCommand(model);
		if (type == "Resume") return new ResumeCommand(model);
		if (type == "Stop") return new StopCommand(model);
		if (type == "Stats") return new StatsCommand(model);
		return null;
	}

	@Override
	public String getTitle() {
		return "SimStation";
	}

	@Override
	public String[] getHelp() {
		String[] help = new String[5];
		help[0] = "Start: starts the simulation";
		help[1] = "Suspend: suspends the simulation";
		help[2] = "Resume: resumes the simualtion";
		help[3] = "Stop: stops the simulation";
		help[4] = "Stats: returns information about the simulation";
		return null;
	}

	@Override
	public String about() {
		return "Aerosmith All Rights Reserved";
	}
}
