package flocking;

import simStation.*;

/*
 * Edit History (Alvin)
 * 
 * 4/8 - Created
 * 
 * 4/11 - Modified super() to accept to Simulation
 * 
 * 4/11 - Modified xc and yc to work with Point
 * 
 * 4/11 - Added NEIGHBOR_RADIUS
 * 
 */

public class Bird extends Agent {
    private Heading heading;
    private int speed;
    public static Integer MAX_SPEED = 5;
    public static Integer NEIGHBOR_RADIUS = 10;
    public Bird(String name, int xc, int yc, Heading heading, int speed, Simulation world) {
        super(name, world);
        this.location.x = xc;
        this.location.y = yc;
        this.heading = heading;
        this.speed = speed;
        this.world = world;
    }

    @Override
    public void update() {
        Bird neighbor = (Bird) world.getNeighbor(this, NEIGHBOR_RADIUS);
        this.heading = neighbor.heading;
        this.speed = neighbor.speed;
        move(speed);
    }
}
