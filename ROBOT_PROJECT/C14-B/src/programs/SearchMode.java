package programs;

import cratepicker.SampleArray;
import cratepicker.SearchTurnSpeed;
import lejos.hardware.Button;
import lejos.hardware.lcd.LCD;
import lejos.utility.Delay;
import model.Robot;
import model.Timer;

/**
 *
 * Doel: Vinden en optillen van beacon
 *
 * @author C14b
 *
 */

public class SearchMode extends Program {
	private static final int ARRIVAL_DISTANCE = 8;
	private static final int ARRIVAL_BEARING = 0;

	private SampleArray bearingSample;
	private SampleArray distanceSample;
	private SearchTurnSpeed turnSpeed = new SearchTurnSpeed(ARRIVAL_DISTANCE);

	public SearchMode(Robot robot, int sampleSize) {
		super(robot, "SearchMode");
		bearingSample = new SampleArray(sampleSize);
		distanceSample = new SampleArray(sampleSize);
	}

	// Print how far it is  from the beacon
	public void printResults(double bearing, double distance) {
		LCD.clear();
		LCD.drawString("COORD: " + bearing, 0, 3);
		LCD.drawString("DIST: " + distance, 0, 5);
	}

	private void moveToTarget(double bearing, double distance) {
		// Calculate turn
		int[] turn = turnSpeed.get(bearing, distance);
		// Set power
		robot.getEngine().setPower(turn[0], turn[1]);
	}

	// Everytime it scans something put those results in the sample
	private void scanToSample() {
		double[] result = robot.getIrSensor().getResult();
		double bearing = result[0];
		double distance = result[1];
		// scan
		bearingSample.add(bearing);
		// It is impossible that distance = 0, so then result shouldnt be trusted
		if (distance != 0)
			distanceSample.add(distance);
	}

	private void fillSampleArray() {
		while (!distanceSample.isFilled()) {
			scanToSample();
		}
	}

	private void searchTarget() {
		Timer printTimer = new Timer();
		while (distanceSample.getAvg() > ARRIVAL_DISTANCE || bearingSample.getAvg() > ARRIVAL_BEARING) {
			if (distanceSample.getAvg() > 99) {
				robot.getEngine().setPower(30);
			} else {
				moveToTarget(bearingSample.getAvg(), distanceSample.getAvg());				
			}
			// Print results scan
			if (printTimer.getTime() > 2) {
				printResults(bearingSample.getAvg(), distanceSample.getAvg());
				printTimer.reset();
			}
			scanToSample();
		}
	}

	@Override
	public void run() {
		Button.waitForAnyPress();
		// Hands down to pick crate up
		Delay.msDelay(500);
		robot.getHandMotor().handsDown(40);
		Delay.msDelay(500);
		// Start search
		fillSampleArray();
		searchTarget();
		robot.getEngine().stop();
		LCD.clear();
		LCD.drawString(bearingSample.getAvg() + " " + distanceSample.getAvg(), 0, 3);
		LCD.drawString("Target found", 0, 5);
		grabAndMoveBack();
		// Wait for button to close program
		Button.waitForAnyPress();
	}

	public void grabAndMoveBack() {
		//while (timer.getTimeMs() < 25000) {
			robot.getHandMotor().handsUp(55);
			Delay.msDelay(1000);
			robot.getEngine().setPower(-25);
			Delay.msDelay(4000);
			robot.getEngine().stop();
			robot.getHandMotor().handsDown(55);
			Delay.msDelay(1000);
			robot.getEngine().setPower(-25);
			Delay.msDelay(2000);
			robot.getEngine().stop();

		

	}

}
