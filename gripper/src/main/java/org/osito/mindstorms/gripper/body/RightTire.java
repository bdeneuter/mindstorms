package org.osito.mindstorms.gripper.body;

import static org.osito.mindstorms.robot.BeanProvider.mediumMotor;
import static org.osito.mindstorms.robot.hardware.Port.C;

public class RightTire extends Tire {

	public RightTire() {
		super(mediumMotor(C));
	}

}
