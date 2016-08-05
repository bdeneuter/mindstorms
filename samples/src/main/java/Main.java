import lejos.hardware.Battery;
import lejos.hardware.Sound;
import lejos.utility.Delay;

public class Main {

    public static void main(String[] args) {
        String message = args.length > 0 ? args[0] : "Hello world!";

        System.out.println(message);

        Delay.msDelay(500);
        Sound.beep();

        System.out.println();
        System.out.println("Battery voltage:");
        System.out.println(Battery.getVoltage());

        Delay.msDelay(3000);
    }

}
