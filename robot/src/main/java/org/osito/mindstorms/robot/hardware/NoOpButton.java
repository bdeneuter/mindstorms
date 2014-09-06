package org.osito.mindstorms.robot.hardware;

import static rx.Observable.empty;
import lejos.hardware.Key;
import lejos.hardware.KeyListener;
import rx.Observable;


public class NoOpButton extends Button {

	public NoOpButton() {
		super(new Key(){

			@Override
			public int getId() {
				return -1;
			}

			@Override
			public boolean isDown() {
				return false;
			}

			@Override
			public boolean isUp() {
				return false;
			}

			@Override
			public void waitForPress() {
				
			}

			@Override
			public void waitForPressAndRelease() {
				
			}

			@Override
			public void addKeyListener(KeyListener listener) {
				
			}

			@Override
			public void simulateEvent(int event) {
				
			}

			@Override
			public String getName() {
				return "";
			}});
	}
	
	@Override
	public Observable<KeyEvent> keyEvents() {
		return empty();
	}

}
