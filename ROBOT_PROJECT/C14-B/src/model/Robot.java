package model;

import lejos.hardware.port.Port;


public class Robot {
	private Engine engine;
	private ColorSensor colorSensor;
	private IrSensor irSensor;
	private HandMotor handMotor;
	
	public Robot(Port leftMotorPort, Port rightMotorPort, Port colorPort, String mode, Port irPort, int beaconChannel, Port handPort) {
		super();
		this.engine = new Engine(leftMotorPort, rightMotorPort);
		this.colorSensor = new ColorSensor(colorPort, mode);
		this.irSensor = new IrSensor(irPort, beaconChannel);
		this.handMotor = new HandMotor(handPort);
	}
	
	// Getters
	public Engine getEngine() {
		return engine;
	}
	
	public ColorSensor getColorSensor() {
		return colorSensor;
	}
	
	public IrSensor getIrSensor() {
		return irSensor;
	}
	
	public HandMotor getHandMotor() {
		return handMotor;
	}

}
