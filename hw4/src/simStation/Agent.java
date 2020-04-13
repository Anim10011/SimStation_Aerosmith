package simStation;

import java.io.*;

import mvc.Utilities;

public abstract class Agent implements Runnable, Serializable {
	private String name;
	private Heading direction;
	private int xc;
	private int yc;
	private AgentState state;
	private Simulation world;
	
	public Agent(String name, Simulation world) {
		this.name = name;
		this.world = world;
		direction = null;
		xc = Utilities.rng.nextInt(Simulation.WORLD_SIZE);
		yc = Utilities.rng.nextInt(Simulation.WORLD_SIZE);
		state = AgentState.READY;
	}
	
	public void start() {
		Thread thread = new Thread(this);
		thread.start();
	}
	
	public void run() {
		while (!isStopped()) {
			state = AgentState.RUNNING;
			update();
			try {
				Thread.sleep(100);
				synchronized(this) {
					while(isSuspended()) {
						wait();
					}
				}
			}
			catch (Exception e) {
				System.out.println(e);
			}
		}
	}
	
	public synchronized void resume() {
		if (!isStopped()) {
			state = AgentState.RUNNING;
			notify();
		}
	}
	
	public synchronized void move(int steps) {
		if (direction == Heading.N) {
			yc -= steps;
			if (yc < 0) yc += Simulation.WORLD_SIZE;
		}
		else if (direction == Heading.S) {
			yc += steps;
			if (yc >= Simulation.WORLD_SIZE) yc -= Simulation.WORLD_SIZE;
		}
		else if (direction == Heading.E) {
			xc += steps;
			if (xc >= Simulation.WORLD_SIZE) xc -= Simulation.WORLD_SIZE;
		}
		else if (direction == Heading.W) {
			xc -= steps;
			if (xc < 0) xc += Simulation.WORLD_SIZE;
		}
		world.changed();
	}
	
	public abstract void update();
	
	public synchronized void stop() { state = AgentState.STOPPED; }
	
	public synchronized boolean isStopped() { return state == AgentState.STOPPED; }
	
	public synchronized void suspend() { state = AgentState.SUSPENDED; }
	
	public synchronized boolean isSuspended() { return state == AgentState.SUSPENDED; }
	
	public int getX() { return xc; }
	
	public int getY() { return yc; }
	
	public Heading getDirection() { return direction; }
	
	public Simulation getWorld() { return world; }
	
	public String getName() { return name; }
	
	public synchronized void setDirection(Heading newDirection) { direction = newDirection; }
}