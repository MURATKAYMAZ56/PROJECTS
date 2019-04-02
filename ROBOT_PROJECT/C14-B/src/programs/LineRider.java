package programs;

/**
 * Doel: Mindstormrobot volgt een (zwarte) lijn over een willekeurig parcours.
 * 
 * Auteur: 
 */

import lejos.hardware.Button;
import lejos.hardware.Sound;
import lejos.hardware.lcd.LCD;
import lejos.utility.Delay;
import lejos.utility.Stopwatch;
import model.Timer;
import model.Move;
import model.Robot;

public class LineRider extends Program {

	private Stopwatch searchClock = new Stopwatch();
//	int aantalKeer;
	private boolean lastTurnWasRight = false; // if the last search was to the right
	private String currentColor;
	private String startStopColor;
	private String roadColor;
	private Move move;
	private boolean didFirstSearch = false; // first try to search back for the line
	private boolean didSecondSearch = false; // second try to search back for the line (the other way around)
	private boolean startStopColorFound = false;
	private boolean roadColorFound = false;
	Timer RaceTime = new Timer();

	public LineRider(Robot robot) {
		super(robot, "LineRider");
		this.move = new Move(robot);
	}

	@Override
	public void run() {
		final int MAX_SEARCHTIME = 400;

		LCD.drawString("Press button to", 0, 3);
		LCD.drawString("start the race", 0, 4);
		Sound.beepSequenceUp();
		Button.waitForAnyPress();
		LCD.clear();

		while (Button.DOWN.isUp()) {

			currentColor = robot.getColorSensor().getColorString();
			printTime();
			if (startStopColorFound == false) {
				startRace();
			}

			else if (roadColorFound == false) {
				findRoadColor();
			}

			else { // the 'Racing part'

				if (currentColor.equals(roadColor)) { // scanned color is the same as the road color, so drive
														// straight forward
					move.moveForward();
					didFirstSearch = false;
					didSecondSearch = false;

				} else if (!didFirstSearch) { // first search for corner
					doFirstSearch(lastTurnWasRight);
					didFirstSearch = true;

				} else if (didFirstSearch && searchClock.elapsed() > MAX_SEARCHTIME && !didSecondSearch) { // search
																											// other way
																											// around
					lastTurnWasRight = searchOtherWay(lastTurnWasRight);
					didSecondSearch = true;

				} else if (currentColor.equals(startStopColor)) { // see the endline, so stop driving
					move.stopMoving();
					break;
				}
			}

		}
		RaceTime.stop();
		Sound.beepSequence();
		LCD.clear();
		LCD.drawString("Laptime:", 5, 3);
		LCD.drawString(String.format("%.2f seconds", RaceTime.getTime()), 2, 4);
		Button.waitForAnyPress();
//		System.out.printf("Laptime: %.1f secondes", RaceTime.getTime());
//		Delay.msDelay(10000); // show the RaceTime on the screen for 10 seconds, then stop the program

	}

	private void startRace() {
		startStopColor = currentColor; // detect the color of the starting line
		RaceTime.reset(); // reset and start the Race timer
		keepMoving(startStopColor); // robot keeps moving forward as long as it detects the color of the
									// starting line
		startStopColorFound = true;
	}

	private void findRoadColor() {
		Delay.msDelay(100); // put in a short delay to prevent it from detecting a wrong color as the
		// roadcolor
		roadColor = robot.getColorSensor().getColorString();
		keepMoving(roadColor); // robot keeps moving forward as long as it detects the color of the road
		roadColorFound = true;
	}

	public void keepMoving(String color) { // makes sure the robot keeps moving forward
		while (currentColor.equals(color)) {
			move.moveForward();
			currentColor = robot.getColorSensor().getColorString();
		}
	}

	private void doFirstSearch(boolean lastTurnWasRight) { // search back for color of the road
		searchClock.reset();
		if (lastTurnWasRight) {
			move.turnRight();
		} else {
			move.turnLeft();
		}

	}

	private boolean searchOtherWay(boolean lastTurnWasRight) { // search back for the color of the road (the other way
																// around)
		if (lastTurnWasRight) {
			move.turnLeft();
			return false; // boolean 'lastTurnWasRight' is set to false
		} else {
			move.turnRight();
			return true; // boolean 'lastTurnWasRight' is set to true
		}
	}

	private void printTime() {
		if (RaceTime.getTime() % 1 == 0) {
			LCD.clear(6, 1, 6);
			LCD.drawString(String.format("Racetime: %.0f", RaceTime.getTime()), 0, 3);
		}
//		aantalKeer++;
	}

}
