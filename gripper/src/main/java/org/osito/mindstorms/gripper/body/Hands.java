package org.osito.mindstorms.gripper.body;

import static java.util.concurrent.TimeUnit.SECONDS;
import static org.osito.mindstorms.robot.BeanProvider.largeMotor;
import static org.osito.mindstorms.robot.Sleeper.sleep;
import static org.osito.mindstorms.robot.hardware.Port.A;

public class Hands {

	public void open() {
		largeMotor(A).backward();
		sleep(2, SECONDS);
		largeMotor(A).stop();
	}
	
	public void close() {
		largeMotor(A).forward();
		sleep(2, SECONDS);
		largeMotor(A).stop();
	}
}
