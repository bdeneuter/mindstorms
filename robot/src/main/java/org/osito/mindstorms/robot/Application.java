package org.osito.mindstorms.robot;

import static org.osito.mindstorms.robot.BeanProvider.button;
import static org.osito.mindstorms.robot.hardware.ButtonType.ESCAPE;

public class Application {

	private boolean keepRunning = true;
	
	public final void start(Runnable runnable) {
		button(ESCAPE).keyEvents().subscribe((e) -> keepRunning = false);
		runnable.run();
		keepAlive();
	}

	private void keepAlive() {
		while (keepRunning) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
				System.exit(1);
			}
		}
		System.exit(0);
	}

	
}
