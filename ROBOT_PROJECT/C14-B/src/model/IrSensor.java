package model;

import lejos.hardware.port.Port;
import lejos.hardware.sensor.EV3IRSensor;

/**
 *
 * Doel: Verkrijgt informatie uit Ir Sensor 
 *
 * @author C14b
 *
 */

public class IrSensor { 
	private EV3IRSensor ev3IrSensor;
	private int beaconChannel;
	
	public IrSensor(Port port, int beaconChannel) {
		this.ev3IrSensor = new EV3IRSensor(port);
		this.ev3IrSensor.setCurrentMode("Seek"); // een andere modus was niet nodig voor ons programma
		this.beaconChannel = beaconChannel;
	}
	
	public void setBeaconChannel(int channel) {
		beaconChannel = channel;
	}
	
	// Returns distance and bearing (left/right)
	public double[] getResult() {
		float[] scan = new float[8];
		ev3IrSensor.fetchSample(scan, 0);
		int indexBearing = beaconChannel * 2 - 2;
		int indexDistance = indexBearing + 1;
		double bearing = (double)(scan[indexBearing]);
		double distance = (double)(scan[indexDistance]);
		return new double[] {bearing, distance};
	}
}
