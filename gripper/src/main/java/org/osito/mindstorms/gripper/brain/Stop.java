package org.osito.mindstorms.gripper.brain;

import static org.osito.mindstorms.robot.BeanProvider.button;
import static org.osito.mindstorms.robot.hardware.ButtonType.ENTER;
import static org.osito.mindstorms.robot.hardware.KeyEvent.RELEASED;
import static rx.subscriptions.Subscriptions.empty;

import org.osito.mindstorms.gripper.body.Body;

import rx.Subscription;

public class Stop implements State {

	private Subscription subscription = empty();

	@Override
	public void start(Body body, Brain brain) {
		body.rightTire().stop();
		body.leftTire().stop();
		subscription = button(ENTER).keyEvents()
									.filter((e) -> e == RELEASED)
									.subscribe((e) -> brain.setState(new MoveForward(), new Scan()));
	}

	@Override
	public void stop() {
		subscription.unsubscribe();
	}

}
