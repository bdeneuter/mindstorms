package org.osito.mindstorms.robot;

import static java.util.concurrent.Executors.newWorkStealingPool;

import java.util.concurrent.Executor;

import lejos.hardware.Brick;
import lejos.hardware.BrickFinder;
import lejos.hardware.sensor.EV3IRSensor;

import org.osito.mindstorms.robot.hardware.Button;
import org.osito.mindstorms.robot.hardware.ButtonType;
import org.osito.mindstorms.robot.hardware.Port;
import org.osito.mindstorms.robot.sensors.IRSensor;

public class BeanProvider {

	private static Brick brick;
	private static IRSensor irSensor;
	private static Executor executor = newWorkStealingPool();
	
	public static Brick brick() {
		if (brick == null) {
			brick = BrickFinder.getDefault();
		}
		return brick;
	}
	
	public static Button button(ButtonType type) {
		return new Button(lejos.hardware.Button.ESCAPE);
	}
	
	public static IRSensor irSensor(Port port) {
		if (irSensor == null) {
			irSensor = new IRSensor(new EV3IRSensor(brick().getPort(port.name())), executor);
		}
		return irSensor;
	}
	
}
