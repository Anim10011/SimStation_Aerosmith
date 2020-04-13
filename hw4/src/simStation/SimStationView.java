package simStation;

import java.awt.Color;
import java.awt.Graphics;

import mvc.*;
import java.util.*;

public class SimStationView extends View {

	public SimStationView(Model model) {
		super(model);
	}
	
	public void paintComponent(Graphics gc) {
		Color oldColor = gc.getColor();
		
		Simulation sim = (Simulation)model;
		List<Agent> agents = sim.getAgents();
		
		gc.setColor(Color.RED);
		for (Agent a : agents) {
			gc.fillRect(a.getX(), a.getY(), Simulation.AGENT_SIZE, Simulation.AGENT_SIZE);
		}
		gc.setColor(oldColor);
	}
}
