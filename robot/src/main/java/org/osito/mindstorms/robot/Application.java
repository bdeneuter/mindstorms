package org.osito.mindstorms.robot;

import static org.osito.mindstorms.robot.BeanProvider.button;
import static org.osito.mindstorms.robot.hardware.ButtonType.ESCAPE;
import static org.osito.mindstorms.robot.hardware.KeyEvent.RELEASED;
import lejos.hardware.Button;

public class Application {

	public final void start(Runnable runnable) {
		button(ESCAPE).keyEvents()
					  .filter((e) -> e == RELEASED)
					  .subscribe((e) -> System.exit(0));
		Button.LEDPattern(1);
		runnable.run();
		keepAlive();
	}

	private void keepAlive() {
		while (true) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
				System.exit(1);
			}
		}
	}

	
}
