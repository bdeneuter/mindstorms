package org.osito.mindstorms.robot.sensors;

import java.util.concurrent.Executor;

import lejos.hardware.sensor.EV3ColorSensor;
import lejos.hardware.sensor.SensorMode;
import rx.Observable;
import rx.subjects.PublishSubject;

public class ColorSensor {

	private EV3ColorSensor sensor;
	private Executor executor;

	private Ambient ambient;
	private Red red;
	
	public ColorSensor(EV3ColorSensor sensor, Executor executor) {
		this.sensor = sensor;
		this.executor = executor;
	}
	
	private void sample(PublishSubject<float[]> subject, SensorMode sensorMode, float[] sample, Executor executor) {
		sensorMode.fetchSample(sample, 0);
		subject.onNext(sample);
		executor.execute(() -> sample(subject, sensorMode, sample, executor));
	}
	
	public Observable<Float> ambient() {
		if (ambient == null) {
			ambient = new Ambient();
		}
		return ambient.subject.map((e) -> e[0]);
	}
	
	public Observable<Float> red() {
		if (red == null) {
			red = new Red();
		}
		return red.subject.map((e) -> e[0]);
	}
	
	private class Ambient {
		
		private PublishSubject<float[]> subject = PublishSubject.create();
		
		public Ambient() {
			sample(subject, sensor.getAmbientMode(), new float[sensor.getAmbientMode().sampleSize()], executor);
		}
		
	}
	
	private class Red {
		
		private PublishSubject<float[]> subject = PublishSubject.create();
		
		public Red() {
			sample(subject, sensor.getRedMode(), new float[sensor.getRedMode().sampleSize()], executor);
		}
		
	}
	
}
