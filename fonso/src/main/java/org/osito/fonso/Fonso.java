package org.osito.fonso;

import static rx.Observable.create;
import lejos.hardware.BrickFinder;
import lejos.hardware.lcd.GraphicsLCD;
import rx.Observable;
import rx.Subscriber;

public class Fonso {

	public static void main(String[] args) {
		GraphicsLCD lcd = BrickFinder.getDefault().getGraphicsLCD();
		System.out.println("Hello");
		Observable<String> observable = create((Subscriber<? super String> e) -> System.out.println(e));
		System.out.println(observable);
	}

}
