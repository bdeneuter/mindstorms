package org.osito.mindstorms.gripper.body;

import lejos.hardware.motor.EV3MediumRegulatedMotor;


public class Tire {

	private EV3MediumRegulatedMotor motor;
	
	public Tire(EV3MediumRegulatedMotor motor) {
		this.motor = motor;
	}
	
	public void moveForward() {
		motor.forward();
	}
	
	public void moveBackwards() {
		motor.backward();
	}
	
	public void stop() {
		motor.stop();
	}
}
