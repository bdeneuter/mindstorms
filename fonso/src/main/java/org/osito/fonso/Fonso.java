package org.osito.fonso;

import static org.osito.mindstorms.robot.BeanProvider.irSensor;
import static org.osito.mindstorms.robot.hardware.Port.S1;
import lejos.hardware.Button;

import org.osito.mindstorms.robot.Application;

public class Fonso {
	public static void main(String[] args) {
		new Application().start(() -> {
			
			irSensor(S1).distance()
						.filter((e) -> e < 10)
						.subscribe((e) -> Button.LEDPattern(3));
			
			irSensor(S1).distance()
						.filter((e) -> e >= 10)
						.subscribe((e) -> Button.LEDPattern(1));
			
		});
	}

}
