package prisoner;

import simStation.*;

import java.util.*;

import mvc.*;

/*
 * Edit History (Keven)
 * 
 * 4/11 - Created
 * 
 * 4/11 - Modified populate() to create prisoners and then passed in a strategy
 * 
 * 4/12 - Modified getStats to format averages nicely
 * 
 * 4/15 - Moved the driver function into here (Keven)
 * 
 */

public class PrisonersDilemma extends Simulation {
	
	public static int NEIGHBOR_RADIUS = 10;
	public static int MOVE_SPEED = 20;
	public static int NUM_PRISONERS = NUM_AGENTS - (NUM_AGENTS % 4);
	
	private String[] stats;
	
	public PrisonersDilemma() {
		super();
		stats = new String[7];
		stats[0] = super.getStats()[0];
		stats[1] = super.getStats()[1];
		stats[2] = "Average Fitness per Strategy:";
		stats[3] = "Always Cooperate: 0";
		stats[4] = "Always Cheat: 0";
		stats[5] = "Randomly Cooperate: 0";
		stats[6] = "Tit for Tat: 0";
	}
	
	@Override
	public void populate() {
		List<Agent> agents = super.getAgents();
		for (int i = 0; i < NUM_PRISONERS; i++) {
			int ith = i % 4;
			Prisoner p = new Prisoner("Prisoner " + (i + 1), this);
			if (ith == 0) {
				p.setStrategy(new AlwaysCooperate(p));
				agents.add(p);
			}
			else if (ith == 1) {
				p.setStrategy(new AlwaysCheat(p));
				agents.add(p);
			}
			else if (ith == 2) {
				p.setStrategy(new Chaos(p));
				agents.add(p);
			}
			else if (ith == 3) {
				p.setStrategy(new TitForTat(p));
				agents.add(p);
			}
		}
	}
	
	@Override
	public String[] getStats() {
		String[] simStats = super.getStats();
		
		stats[0] = simStats[0];
		stats[1] = simStats[1];
		
		stats[3] = "Always Cooperate: "+ String.format("%.2f", this.getAverageFitness(new AlwaysCooperate(null)));
		stats[4] = "Always Cheat: " + String.format("%.2f", this.getAverageFitness(new AlwaysCheat(null)));
		stats[5] = "Randomly Cooperate: " + String.format("%.2f",this.getAverageFitness(new Chaos(null)));
		stats[6] = "Tit for Tat: " + String.format("%.2f", this.getAverageFitness(new TitForTat(null)));
		return stats;
	}
	
	public double getAverageFitness(PrisonersDilemmaStrat strat) {
		double total = 0;
		int count = 0;
		for (Agent a : super.getAgents()) {
			Prisoner p = (Prisoner) a;
			if (p.getStrategy().getClass() == strat.getClass()) {
				total += p.getFitness();
				count++;
			}
		}
		return total / count;
	}
	
	public static void main(String[] args) {
		AppPanel panel = new SimulationPanel(new PrisonersDilemmaFactory());
		panel.display();
	}
}