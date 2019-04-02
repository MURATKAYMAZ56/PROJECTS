package model;

import lejos.hardware.port.Port;
import lejos.hardware.sensor.EV3ColorSensor;
import lejos.robotics.Color;

/**
 *
 * Doel: Regelt bediening van ColorSensor op Robot
 *
 * @author C14B
 *
 */

public class ColorSensor {
	private EV3ColorSensor colorSensor;
	private float[] result;
	
	public ColorSensor (Port port, String mode) {
		super();
		this.colorSensor = new EV3ColorSensor(port);
		setMode(mode);
	}
	
	// Set mode
	public void setMode(String mode) {
		colorSensor.setCurrentMode(mode);
		setResult();
	}
	
	public void setMode(int mode) {
		colorSensor.setCurrentMode(mode);
		setResult();
	}
	
	private void setResult() {
		if (colorSensor.getCurrentMode() <= 1) {
			result = new float[1];
		} else {
			result = new float[3];
		}
	}
	
	// Scan
	private void checkIfMode(int mode) {
		if (colorSensor.getCurrentMode() != mode) {
			setMode(mode);
		}
	}
	
	private void scan(int mode) {
		checkIfMode(mode);
		colorSensor.fetchSample(result, 0);
	}
	
	// Get value
	public int getColorID() {
		scan(0);
		return (int)(result[0]);
	}
	
	public String getColorString() {
		int color = getColorID();
		if (color == Color.BLACK) {
			return "Black";
		} else if (color == Color.BLUE) {
			return "Blue";
		} else if (color == Color.GREEN) {
			return "Green";
		} else if (color == Color.RED) {
			return "Red";
		} else if (color == Color.ORANGE) {
			return "Orange";
		} else if (color == Color.WHITE) {
			return "White";
		} else if (color == Color.YELLOW) {
			return "Yellow";
		} else {
			return "none";
		}
	}
	
	public double[] getRgb() {
		scan(2);
		return new double[] {result[0], result[1], result[2]};
	}
	
	public double getRgbAvg() {
		double[] rgb = getRgb();
		double sumRgb = rgb[0] + rgb[1] + rgb[2];
		return sumRgb / 3;
	}
	
	public boolean RgbIsColor(int requestedColor) {
		double[] rgb = getRgb();
		boolean hasRequestedColor = rgb[requestedColor] > 0.16;
		boolean hasOtherColor = rgb[(requestedColor + 1) % 3] > 0.05 || rgb[(requestedColor + 2) % 3] > 0.05;
		if (hasRequestedColor && !hasOtherColor) {
			return true;
		} else {
			return false;
		}
	}
	
}
