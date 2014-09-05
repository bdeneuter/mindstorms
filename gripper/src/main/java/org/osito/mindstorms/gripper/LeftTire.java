package org.osito.mindstorms.gripper;

import static org.osito.mindstorms.robot.BeanProvider.motor;
import static org.osito.mindstorms.robot.hardware.Port.B;

public class LeftTire extends Tire {

	public LeftTire() {
		super(motor(B));
	}

}
