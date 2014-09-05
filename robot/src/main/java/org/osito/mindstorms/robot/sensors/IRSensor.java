package org.osito.mindstorms.robot.sensors;

import java.util.concurrent.Executor;

import lejos.hardware.sensor.EV3IRSensor;
import rx.Observable;
import rx.subjects.PublishSubject;

public class IRSensor {

	private PublishSubject<Float> subject = PublishSubject.create();
	
	public IRSensor(EV3IRSensor sensor, Executor executor) {
		float[] sample = new float[sensor.getDistanceMode().sampleSize()];
		executor.execute(() -> sample(sensor, sample, executor));
	}

	private void sample(EV3IRSensor sensor, float[] sample, Executor executor) {
		sensor.getDistanceMode().fetchSample(sample, 0);
		subject.onNext(sample[0]);
		executor.execute(() -> sample(sensor, sample, executor));
	}
	
	public Observable<Float> distance() {
		return subject;
	}
	
}
