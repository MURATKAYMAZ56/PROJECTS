package model;

import lejos.hardware.motor.UnregulatedMotor;
import lejos.hardware.port.Port;

/**
 *
 * Doel: Regelt bediening van twee rijmotoren op Robot
 *
 * @author C14b
 *
 */

public class Engine {
	UnregulatedMotor[] motors = new UnregulatedMotor[2];

	public Engine(Port leftMotor, Port rightMotor) {
		super();
		motors[0] = new UnregulatedMotor(leftMotor);
		motors[1] = new UnregulatedMotor(rightMotor);
	}
	
	// Set power	
	public void setPower(int powerLeft, int powerRight) {
		motors[0].setPower(powerLeft);
		motors[1].setPower(powerRight);
	}
	
	public void setPower(int power) {
		setPower(power, power);
	}
		
	// Stop
	public void stop() {
		motors[0].setPower(0);
		motors[1].setPower(0);
	}
	
	// Close
	public void close() {
		motors[0].close();
		motors[1].close();
	}

}
