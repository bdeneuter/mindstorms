package org.osito.mindstorms.gripper.brain;

import org.osito.mindstorms.gripper.body.Body;

public class Start implements State {

	@Override
	public void start(Body body, Brain brain) {
		body.hands().open();
		body.hands().close();
		body.hands().open();
		brain.setState(new MoveForward());
	}

	@Override
	public void stop() {
		
	}

}
