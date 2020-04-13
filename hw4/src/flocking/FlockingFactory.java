package flocking;

import mvc.Model;
import simStation.*;

/*
 * Edit History (Alvin)
 * 
 * 4/8 - Created
 * 
 */

public class FlockingFactory extends SimulationFactory {
    @Override
    public Model makeModel() {
        return new Flocking();
    }
}
