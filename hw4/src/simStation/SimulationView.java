package simStation;

import mvc.*;
import java.awt.*;

/*
 * Edit History 
 * 3/27 - Created (Alvin)
 * 
 * 4/1  - added logic to check for initialized array (Alvin)
 *      - changed implementation of for loop to use ArrayList features (Alvin)
 * 	   
 * 4/10 - moved all color logic into Agent class (Min-yuan)
 */

public class SimulationView extends View{
	
	public SimulationView(Model model) {
		super(model);
	}

	public SimulationView(Simulation sim) {
		super(sim);
	}
	
	public void paintComponent(Graphics gc) {
		
		Simulation sim = (Simulation) model;
		Color oldColor = gc.getColor();
		
		gc.setColor(Color.BLACK);
		gc.drawRect(0, 0, Simulation.WORLD_SIZE, Simulation.WORLD_SIZE);
		
		for (Agent a : sim.getAgents()) {
			if (a != null) {
				gc.setColor(a.getColor());
				gc.fillOval(a.getLocation().x, a.getLocation().y, Simulation.SIZE, Simulation.SIZE);
			} else {
				break;
			}
		}
		
		gc.setColor(oldColor);
	}
}
