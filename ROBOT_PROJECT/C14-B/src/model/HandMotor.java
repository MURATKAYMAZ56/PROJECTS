package model;

//import lejos.hardware.Button;
import lejos.hardware.motor.EV3MediumRegulatedMotor;
import lejos.hardware.port.Port;
import lejos.utility.Delay;

/**
*
* Doel: Regelt bediening van hefmotor van de Robot
*
* @author C14b
*
*/

public class HandMotor {
	private EV3MediumRegulatedMotor motor;

	public HandMotor(Port port) {
		super();
		this.motor = new EV3MediumRegulatedMotor(port);
	}

	public void handsUp(int angle) {
		motor.setSpeed(20);
		motor.rotate(angle);
		Delay.msDelay(1000);
	}
	
	public void handsDown(int angle) {
		handsUp(-angle);
	}
	
}
