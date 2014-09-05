package org.osito.mindstorms.gripper;

import org.osito.mindstorms.robot.Application;

public class Gripper {

	private static final int THRESHOLD = 30;

	public static void main(String[] args) {
		new Application().start(() -> {
			
			LeftTire leftTire = new LeftTire();
			RightTire rightTire = new RightTire();
			Head head = new Head();
			
			head.distance()
				.filter((distance) -> distance >= THRESHOLD + 2)
				.subscribe((distance) -> {
					leftTire.moveForward();
					rightTire.moveForward();
				});
			
			head.distance()
			.filter((distance) -> distance < THRESHOLD)
			.subscribe((distance) -> {
				leftTire.stop();
				rightTire.stop();
			});

		});
	}

}
