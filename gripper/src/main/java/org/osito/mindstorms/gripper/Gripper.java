package org.osito.mindstorms.gripper;

import org.osito.mindstorms.gripper.body.Body;
import org.osito.mindstorms.gripper.brain.Brain;
import org.osito.mindstorms.robot.Application;

public class Gripper {

	public static void main(String[] args) {
		new Application().start(() -> {
			new Brain(new Body()).start();
		});
	}

}
