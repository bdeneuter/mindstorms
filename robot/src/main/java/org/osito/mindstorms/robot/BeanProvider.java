package org.osito.mindstorms.robot;

import static java.util.concurrent.Executors.newSingleThreadExecutor;
import lejos.hardware.Brick;
import lejos.hardware.BrickFinder;
import lejos.hardware.motor.EV3MediumRegulatedMotor;
import lejos.hardware.sensor.EV3IRSensor;
import lejos.hardware.sensor.EV3TouchSensor;

import org.osito.mindstorms.robot.hardware.Button;
import org.osito.mindstorms.robot.hardware.ButtonType;
import org.osito.mindstorms.robot.hardware.Port;
import org.osito.mindstorms.robot.sensors.IRSensor;
import org.osito.mindstorms.robot.sensors.TouchSensor;

public class BeanProvider {

	private static Brick brick;
	private static IRSensor irSensor;
	private static TouchSensor touchSensor;
	
	public static Brick brick() {
		if (brick == null) {
			brick = BrickFinder.getDefault();
		}
		return brick;
	}
	
	public static Button button(ButtonType type) {
		return new Button(lejos.hardware.Button.ESCAPE);
	}
	
	public static TouchSensor touchSensor(Port port) {
		if (touchSensor == null) {
			touchSensor = new TouchSensor(new EV3TouchSensor(port.getPort()), newSingleThreadExecutor());			
		}
		return touchSensor;
	}
	
	public static IRSensor irSensor(Port port) {
		if (irSensor == null) {
			irSensor = new IRSensor(new EV3IRSensor(port.getPort()), newSingleThreadExecutor());
		}
		return irSensor;
	}

	public static EV3MediumRegulatedMotor motor(Port port) {
		return new EV3MediumRegulatedMotor(port.getPort());
	}
	
}
