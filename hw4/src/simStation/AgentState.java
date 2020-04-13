package simStation;

import java.io.Serializable;

/*
 * Edit History 
 * 3/27 - Created (Keven)
 * 
 */

public enum AgentState implements Serializable {
	READY, RUNNING, SUSPENDED, STOPPED;
}
