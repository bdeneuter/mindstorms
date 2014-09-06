package org.osito.mindstorms.gripper.body;

import static org.osito.mindstorms.robot.BeanProvider.mediumMotor;
import static org.osito.mindstorms.robot.hardware.Port.B;

public class LeftTire extends Tire {

	public LeftTire() {
		super(mediumMotor(B));
	}

}
