package org.osito.mindstorms.gripper.body;

import static org.osito.mindstorms.robot.BeanProvider.irSensor;
import static org.osito.mindstorms.robot.hardware.Port.S4;
import rx.Observable;


public class Head {

	public Observable<Float> distance() {
		return irSensor(S4).distance();
	}
	
}
