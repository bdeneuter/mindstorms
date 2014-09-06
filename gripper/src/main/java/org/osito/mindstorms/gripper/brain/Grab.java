package org.osito.mindstorms.gripper.brain;

import org.osito.mindstorms.gripper.body.Body;

public class Grab implements State {

	@Override
	public void start(Body body, Brain brain) {
		body.hands().close();
	}

	@Override
	public void stop() {

	}

}
