package org.osito.mindstorms.gripper.brain;

import org.osito.mindstorms.gripper.body.Body;

public class Brain {

	public static final int DISTANCE_THRESHOLD = 30;
	
	private State state;
	private Body body;
	
	public Brain(Body body) {
		this.body = body;
		state = new Start();
	}

	public void setState(State state) {
		this.state.stop();
		this.state = state;
		this.state.start(body, this);
	}

	public void start() {
		state.start(body, this);
	}
	
}
