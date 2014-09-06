package org.osito.mindstorms.robot;

import static java.util.concurrent.Executors.newSingleThreadExecutor;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ThreadFactory;

import lejos.hardware.Brick;
import lejos.hardware.BrickFinder;
import lejos.hardware.motor.EV3LargeRegulatedMotor;
import lejos.hardware.motor.EV3MediumRegulatedMotor;
import lejos.hardware.sensor.EV3ColorSensor;
import lejos.hardware.sensor.EV3IRSensor;
import lejos.hardware.sensor.EV3TouchSensor;

import org.osito.mindstorms.robot.hardware.Button;
import org.osito.mindstorms.robot.hardware.ButtonType;
import org.osito.mindstorms.robot.hardware.NoOpButton;
import org.osito.mindstorms.robot.hardware.Port;
import org.osito.mindstorms.robot.sensors.ColorSensor;
import org.osito.mindstorms.robot.sensors.IRSensor;
import org.osito.mindstorms.robot.sensors.TouchSensor;

public class BeanProvider {

	private static Brick brick;
	private static IRSensor irSensor;
	private static TouchSensor touchSensor;
	private static EV3LargeRegulatedMotor largeMotor;
	private static Map<Port, EV3MediumRegulatedMotor> mediumMotor = new HashMap<>();
	private static ColorSensor colorSensor;
	
	public static Brick brick() {
		if (brick == null) {
			brick = BrickFinder.getDefault();
		}
		return brick;
	}
	
	public static Button button(ButtonType type) {
		switch (type) {
		case ESCAPE:
			return new Button(lejos.hardware.Button.ESCAPE);
		case ENTER:
			return new Button(lejos.hardware.Button.ENTER);
		default:
			return new NoOpButton();
		}
	}
	
	public static TouchSensor touchSensor(Port port) {
		if (touchSensor == null) {
			touchSensor = new TouchSensor(new EV3TouchSensor(port.getPort()), newSingleThreadExecutor(DeamonThreadFactory.INSTANCE));			
		}
		return touchSensor;
	}
	
	public static IRSensor irSensor(Port port) {
		if (irSensor == null) {
			irSensor = new IRSensor(new EV3IRSensor(port.getPort()), newSingleThreadExecutor(DeamonThreadFactory.INSTANCE));
		}
		return irSensor;
	}

	public static EV3MediumRegulatedMotor mediumMotor(Port port) {
		EV3MediumRegulatedMotor motor = mediumMotor.get(port);
		if (motor == null) {
			motor = new EV3MediumRegulatedMotor(port.getPort());
			mediumMotor.put(port, motor);
		}
		return motor;
	}
	
	public static EV3LargeRegulatedMotor largeMotor(Port port) {
		if (largeMotor == null) {
			largeMotor = new EV3LargeRegulatedMotor(port.getPort());			
		}
		return largeMotor;
	}

	public static ColorSensor colorSensor(Port port) {
		if (colorSensor == null) {
			colorSensor = new ColorSensor(new EV3ColorSensor(port.getPort()), newSingleThreadExecutor(DeamonThreadFactory.INSTANCE));			
		}
		return colorSensor;
	}
		
	private static class DeamonThreadFactory implements ThreadFactory {

		public static ThreadFactory INSTANCE = new DeamonThreadFactory();
		
		@Override
		public Thread newThread(Runnable r) {
			Thread thread = new Thread(r);
			thread.setDaemon(true);
			return thread;
		}
		
	}
}
