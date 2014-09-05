package org.osito.mindstorms.gripper;

import static org.osito.mindstorms.gripper.Action.MOVE_BACKWARDS;
import static org.osito.mindstorms.gripper.Action.MOVE_FORWARD;
import static org.osito.mindstorms.gripper.Action.STOP;
import lejos.hardware.motor.EV3MediumRegulatedMotor;
import rx.subjects.BehaviorSubject;
import rx.subjects.Subject;


public class Tire {

	private Subject<Action, Action> subject = BehaviorSubject.create(STOP);
	
	public Tire(EV3MediumRegulatedMotor motor) {
		subject.filter((e) -> e == MOVE_FORWARD).subscribe((e) -> motor.forward());
		subject.filter((e) -> e == MOVE_BACKWARDS).subscribe((e) -> motor.backward());
		subject.filter((e) -> e == STOP).subscribe((e) -> motor.stop());
	}
	
	public void moveForward() {
		subject.onNext(MOVE_FORWARD);
	}
	
	public void moveBackwards() {
		subject.onNext(MOVE_BACKWARDS);
	}
	
	public void stop() {
		subject.onNext(STOP);
	}
}
