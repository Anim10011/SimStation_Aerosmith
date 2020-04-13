package simStation;

import mvc.Utilities;

/*
 * Edit History (Keven Lam)
 * 
 * 4/5 - Created Heading. Added nextHeading().
 */

public enum Heading {
	N, S, E, W;
	
	public static Heading nextHeading() {
		int tmp = Utilities.rng.nextInt(4);
		
		if (tmp == 0) return N;
		if (tmp == 1) return S;
		if (tmp == 2) return E;
		if (tmp == 3) return W;
		return null;
	}
}
