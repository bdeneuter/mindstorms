package org.osito.mindstorms.robot.hardware;

import static org.osito.mindstorms.robot.hardware.KeyEvent.PRESSED;
import static org.osito.mindstorms.robot.hardware.KeyEvent.RELEASED;
import rx.Observable;
import rx.subjects.PublishSubject;
import rx.subjects.Subject;
import lejos.hardware.Key;
import lejos.hardware.KeyListener;

public class Button {

	private Key key;
	private Subject<KeyEvent, KeyEvent> subject = PublishSubject.create();
	
	public Button(Key key) {
		this.key = key;
		this.key.addKeyListener(new KeyListener() {
			
			@Override
			public void keyReleased(Key k) {
				subject.onNext(RELEASED);
			}
			
			@Override
			public void keyPressed(Key k) {
				subject.onNext(PRESSED);
			}
		});
	}
	
	public Observable<KeyEvent> keyEvents() {
		return subject;
	}

}
