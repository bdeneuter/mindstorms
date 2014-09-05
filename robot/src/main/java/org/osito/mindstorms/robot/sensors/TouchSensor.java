package org.osito.mindstorms.robot.sensors;

import java.util.concurrent.Executor;

import lejos.hardware.sensor.EV3TouchSensor;
import lejos.hardware.sensor.SensorMode;
import rx.Observable;
import rx.subjects.PublishSubject;

public class TouchSensor {

	private PublishSubject<Float> subject = PublishSubject.create();

	public TouchSensor(EV3TouchSensor sensor, Executor executor) {
		sample(sensor, new float[sensor.getTouchMode().sampleSize()], executor);
	}
	
	private void sample(SensorMode sensorMode, float[] sample, Executor executor) {
		sensorMode.fetchSample(sample, 0);
		subject.onNext(sample[0]);
		executor.execute(() -> sample(sensorMode, sample, executor));
	}
	
	public Observable<Float> touch() {
		return subject.filter((e) -> e == 1);
	}
	
}
