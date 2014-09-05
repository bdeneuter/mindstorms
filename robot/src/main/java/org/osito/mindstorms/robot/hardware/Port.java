package org.osito.mindstorms.robot.hardware;

import static org.osito.mindstorms.robot.BeanProvider.brick;

public enum Port {
	A, B, C, D, S1, S2, S3, S4;

	public lejos.hardware.port.Port getPort() {
		return brick().getPort(name());
	}
}
