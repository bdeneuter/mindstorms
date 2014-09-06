package org.osito.mindstorms.gripper.brain;

import static org.osito.mindstorms.gripper.brain.Brain.DISTANCE_THRESHOLD;
import static rx.subscriptions.Subscriptions.empty;

import org.osito.mindstorms.gripper.body.Body;

import rx.Subscription;

public class MoveForward implements State {

	private Subscription subscription = empty();
	
	@Override
	public void start(Body body, Brain brain) {		
		body.moveForward();
		subscription = body.head().distance()
			.filter((distance) -> distance < DISTANCE_THRESHOLD)
			.subscribe((distance) -> brain.setState(new Avoid()));
	}

	@Override
	public void stop() {
		subscription.unsubscribe();
	}

}
