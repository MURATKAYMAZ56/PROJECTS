package programs;

import lejos.hardware.Button;
import lejos.hardware.Sound;
import lejos.hardware.lcd.LCD;
import linefollower.LineTuning;
import linefollower.TurnCalculator;
import model.Robot;
import model.Timer;


/**
 *
 * Doel: Follows the side of the line, based on RGB input
 *
 * @author C14b
 *
 */

public class LineFollower extends Program {
	// Based on the average between: white is 26 of all colors and black is 0
	private static final double AVG_WHITE_BLACK = 0.13; 
	private TurnCalculator turnCalculator;
	private int baseSpeed;
	
	public LineFollower(Robot robot, int baseSpeed, LineTuning lineTuning) {
		super(robot, "LineFollower");
		turnCalculator = new TurnCalculator(lineTuning);	
		this.baseSpeed = baseSpeed;
	}
	
	private double getOffset() {
		return AVG_WHITE_BLACK - robot.getColorSensor().getRgbAvg();
	}
	
	private int calculateSpeed(double offset) {
		if (offset > 0.08) {
			return baseSpeed - 30;
		} else {
			return baseSpeed;
		}
	}
	
	// Need to be filled in
	@Override
	public void run() {
		// Booleans for measuring start and end of race
		boolean raceFinished = false;
		boolean raceStarted = false;
		// Instantiate and immediately stop timer
		Timer timer = new Timer();
		timer.stop();
		// Intro and go to starting line
		Sound.beepSequenceUp();
		Button.waitForAnyPress();
		turnToLine();
		// Run until button is pressed or passing line
		while(Button.DOWN.isUp() && raceFinished == false) {
			followLine();
			if (robot.getColorSensor().RgbIsColor(0)) {
				// First time red start the timer
				if (!raceStarted || timer.getTime() < 1) {
					timer.reset();
					raceStarted = true;
				// Second time red stop race
				} else if (raceStarted && timer.getTime() > 1) {
					timer.stop();
					raceFinished = true;
				}
			}
		}
		for (int i = 0; i < 200; i++) {
			followLine();
		}
//		Delay.msDelay(700);
		robot.getEngine().stop();
		printResults(timer.getTime());
		Button.waitForAnyPress();
	}

	private void followLine() {
		double offset = getOffset();
		int speed = calculateSpeed(offset);
		int turn = turnCalculator.getTurn(offset);
		robot.getEngine().setPower(speed - turn, speed + turn);
	}

	private void printResults(double time) {
		Sound.beepSequence();
		LCD.clear();
		LCD.drawString("Laptime:", 5, 3);
		LCD.drawString(String.format("%.2f seconds", time), 2, 4);
	}

	private void turnToLine() {
		robot.getEngine().setPower(20, -20);
		double offset = getOffset();
		while (offset > 0.01) {
			offset = getOffset();
		}
		robot.getEngine().setPower(0);
	}

}
