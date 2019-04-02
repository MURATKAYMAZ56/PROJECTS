package model;

import lejos.utility.Stopwatch;

public class Timer {
	private Stopwatch stopwatch;
	private double time; // in ms
	private boolean isOn;
	
	public Timer() {
		stopwatch = new Stopwatch();
		reset();
	}
	
	public void reset() {
		stopwatch.reset();
		isOn = true;
	}
	
	public void stop() {
		time = stopwatch.elapsed();
		isOn = false;
	}
	
	public double getTime() {
		if (isOn) {
			time = stopwatch.elapsed();
		}
		return time / 1000.0;	
	}
	
	public double getTimeMs() {
		if (isOn) {
			time = stopwatch.elapsed();
		}
		return time;
	}

}
