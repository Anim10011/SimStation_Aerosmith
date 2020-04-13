package simStation;

import java.util.*;

import mvc.*;

/*
 * Edit History (Keven Lam)
 * 
 * 4/5 - Created Simulation.
 * 
 * 4/8 - Added getNeighbor().
 * 
 * 4/11 - Added constants, WORLD_SIZE, AGENT_SIZE, NUM_AGENTS
 * 
 * 4/11 - Added getClock().
 */
public class Simulation extends Model {

	public static int WORLD_SIZE = 250;
	public static int AGENT_SIZE = 5;
	public static int NUM_AGENTS = 50;

	private Timer timer;
	private int clock;
	private List<Agent> agents;

	public Simulation() {
		agents = new ArrayList<>();
		clock = 0;
		timer = null;
	}

	public void start() {
		populate();
		for (Agent a : agents) {
			a.start();
		}
		startTimer();
		changed();
	}

	public void resume() {
		for (Agent a : agents) {
			a.resume();
		}
	}

	public void suspend() {
		for (Agent a : agents) {
			a.suspend();
		}
	}

	public void stop() {
		for (Agent a : agents) {
			a.stop();
		}
		if (timer != null) {
			stopTimer();
		}
	}
	
	public Agent getNeighbor(Agent target, int radius) {
		Agent neighbor = null;
		
		for (Agent a : agents) {
			if (((a.getX() * a.getX()) + (a.getY() * a.getY()) <= radius * radius)
					&& a != target) {
				// a^2 + b^2 = c^2 Kind of a weird way to get the distance between
				// the two, but should work.
				neighbor = a;
			}
		}
		return neighbor;
	}

	public void populate() {}

	public String[] getStats() {
		String[] stats = new String[2];
		stats[0] = "#agents = " + agents.size();
		stats[1] = "clock = " + clock;
		return stats;
	}

	public List<Agent> getAgents() {
		return agents;
	}

	private void startTimer() {
		timer = new Timer();
		timer.scheduleAtFixedRate(new ClockUpdater(), 1000, 1000);
	}

	private void stopTimer() {
		timer.cancel();
		timer.purge();
	}

	private class ClockUpdater extends TimerTask {
		public void run() {
			clock++;
			//changed();
		}
	}
	
	public int getClock() {
		return clock;
	}
}