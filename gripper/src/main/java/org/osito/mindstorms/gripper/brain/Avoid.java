package org.osito.mindstorms.gripper.brain;

import static java.util.concurrent.TimeUnit.SECONDS;
import static org.osito.mindstorms.gripper.brain.Brain.DISTANCE_THRESHOLD;
import static rx.subscriptions.Subscriptions.empty;

import org.osito.mindstorms.gripper.body.Body;

import rx.Subscription;


public class Avoid implements State {
	
	private Subscription subscription = empty();

	@Override
	public void start(Body body, Brain brain) {
		
		body.rightTire().stop();
		body.leftTire().moveForward();

		subscription = body.head().distance()
			.filter((e) -> e > DISTANCE_THRESHOLD)
			.first()
			.delaySubscription(1, SECONDS) // Let it turn a little more away
			.subscribe((e) -> {
				body.leftTire().stop();
				brain.setState(new MoveForward(), new Scan());
			});
	}
	
	@Override
	public void stop() {
		subscription.unsubscribe();
	}

}
