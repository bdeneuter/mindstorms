package com.github.bdeneuter.mindstorms.samples;

import com.google.common.base.Joiner;
import lejos.hardware.Battery;
import lejos.hardware.Sound;
import lejos.utility.Delay;

import java.util.Arrays;

public class HelloWorld {

    public static void main(String[] args) {
        String message = args.length > 0 ? args[0] : "Hello world!";

        System.out.println(Joiner.on(", ").join(Arrays.asList("Hello", "world", "with", "guava")));

        Delay.msDelay(500);
        Sound.beep();

        System.out.println();
        System.out.println("Battery voltage:");
        System.out.println(Battery.getVoltage());

        Delay.msDelay(3000);
    }

}
