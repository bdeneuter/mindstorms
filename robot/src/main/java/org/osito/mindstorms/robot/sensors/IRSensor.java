package org.osito.mindstorms.robot.sensors;

import java.util.concurrent.Executor;

import lejos.hardware.sensor.EV3IRSensor;
import lejos.hardware.sensor.SensorMode;
import rx.Observable;
import rx.subjects.PublishSubject;

public class IRSensor {

	private PublishSubject<Float> subject = PublishSubject.create();
	
	public IRSensor(EV3IRSensor sensor, Executor executor) {
		executor.execute(() -> sample(sensor.getDistanceMode(), new float[sensor.getDistanceMode().sampleSize()], executor));
	}

	private void sample(SensorMode sensorMode, float[] sample, Executor executor) {
		sensorMode.fetchSample(sample, 0);
		subject.onNext(sample[0]);
		executor.execute(() -> sample(sensorMode, sample, executor));
	}
	
	public Observable<Float> distance() {
		return subject;
	}
	
}
