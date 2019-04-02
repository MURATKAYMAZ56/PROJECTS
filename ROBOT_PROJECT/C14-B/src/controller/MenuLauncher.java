package controller;

import lejos.hardware.port.MotorPort;
import lejos.hardware.port.SensorPort;
import linefollower.LineTuning;
import model.Menu;
import model.Robot;
import programs.FlagRecognizer;
import programs.LineFollower;
import programs.LineRider;
import programs.Program;
import programs.SearchMode;

/**
*
* Doel: Main launcher for program, which displays menu that holds access all programs
*
* @author C14b
*
*/

public class MenuLauncher {

	public static void main(String[] args) {
		// Configure all robot ports
		Robot robot = new Robot(MotorPort.C, MotorPort.B, SensorPort.S2, "RGB", SensorPort.S3, 3, MotorPort.A);
		// All programs
		LineTuning lineTuning = new LineTuning(360, 0.43, 400);
		Program lineFollower = new LineFollower(robot, 40, lineTuning);
		Program lineRider = new LineRider(robot);
		Program flagRecognizer = new FlagRecognizer(robot);
		Program searchMode = new SearchMode(robot, 10);
		Program[] menuPrograms = new Program[] {lineFollower, lineRider, flagRecognizer, searchMode};
		// Create and display menu
		Menu menu = new Menu(menuPrograms);
		menu.display();
	}

}
