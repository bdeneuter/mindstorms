package org.osito.mindstorms.gripper.brain;

import org.osito.mindstorms.gripper.body.Body;

public interface State {

	void start(Body body, Brain brain);
	
	void stop();
	
}
