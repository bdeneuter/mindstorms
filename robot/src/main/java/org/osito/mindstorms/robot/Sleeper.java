package org.osito.mindstorms.robot;

import java.util.concurrent.TimeUnit;

public class Sleeper {

	public static void sleep(int time, TimeUnit unit) {
		try {
			Thread.sleep(TimeUnit.MILLISECONDS.convert(time, unit));
		} catch (InterruptedException e) {}
	}
	
}
