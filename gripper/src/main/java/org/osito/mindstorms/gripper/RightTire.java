package org.osito.mindstorms.gripper;

import static org.osito.mindstorms.robot.BeanProvider.motor;
import static org.osito.mindstorms.robot.hardware.Port.C;

public class RightTire extends Tire {

	public RightTire() {
		super(motor(C));
	}

}
