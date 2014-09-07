package org.osito.mindstorms.gripper.brain;

import static org.osito.mindstorms.robot.BeanProvider.colorSensor;
import static org.osito.mindstorms.robot.hardware.Port.S1;

import org.osito.mindstorms.gripper.body.Body;

import rx.Subscription;
import rx.subscriptions.Subscriptions;

public class Scan implements State {

	private Subscription subscription = Subscriptions.empty();

	@Override
	public void start(Body body, Brain brain) {
		subscription = colorSensor(S1).red()
						.filter((e) -> e > 0)
						.first()
						.subscribe((e) -> grab(body, brain));
	}

	private void grab(Body body, Brain brain) {
		body.stop();
		brain.setState(new Grab());
	}

	@Override
	public void stop() {
		subscription.unsubscribe();
	}

}
