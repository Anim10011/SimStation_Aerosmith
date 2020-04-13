package simStation;

import java.io.Serializable;

import mvc.*;

/*
 * Edit History 
 * 3/27 - Created (Keven)
 *
 *
 * 
 */

public enum Heading implements Serializable {
	NORTH, EAST, SOUTH, WEST;
	
	public static Heading randHeading() {
		
		switch(Utilities.rng.nextInt(4)) {
		case 0:
			return NORTH;
		case 1:
			return EAST;
		case 2:
			return SOUTH;
		case 3:
			return WEST;
		}
		
		return null;
	}
}
