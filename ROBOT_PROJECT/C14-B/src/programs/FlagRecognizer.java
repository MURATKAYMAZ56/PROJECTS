package programs;

import vlag.Country;
import vlag.CountryMaker;

import java.util.Arrays;
import lejos.hardware.Button;
import lejos.hardware.lcd.LCD;
import lejos.utility.Delay;
import model.Robot;

/**
*
* Doel: Program that can recognize flags and play respective anthem
*
* @author C14b
*
*/

public class FlagRecognizer extends Program {

	public FlagRecognizer(Robot robot) {
		super(robot, "FlagRecognizer");
	}

	@Override
	public void run() {
		// Set mode
		robot.getColorSensor().setMode("ColorID");
		waitForInput();
		LCD.clear();
		String[] scannedFlag = getScannedFlag();
		driveToWhite();
		robot.getEngine().stop();
		playCountryAnthem(scannedFlag);
		displayEndMessage();
	}

	private void driveToWhite() {
		robot.getEngine().setPower(20);
		String scannedColor = robot.getColorSensor().getColorString();
		while (scannedColor.equals("White")) {
			scannedColor = robot.getColorSensor().getColorString();
		}
		robot.getEngine().stop();
	}

	private void displayEndMessage() {
		LCD.clear();
		LCD.drawString("Press Enter to", 0, 3);
		LCD.drawString("quit the program", 0, 4);
		Button.ENTER.waitForPress();
	}

	private void waitForInput() {
		LCD.drawString("Press Enter to", 0, 3);
		LCD.drawString("read a flag", 0, 4);
		Button.ENTER.waitForPress();
	}

	private String[] getScannedFlag() {
		String[] scannedFlag = new String[3];
		for (int i = 0; i < 3; i++) {
			driveToNextColor(); 
			scannedFlag[i] = robot.getColorSensor().getColorString();
			LCD.drawString("Color: " + scannedFlag[i], 0, (i + 2));
		}
		return scannedFlag;

	}

	private void driveToNextColor() {
		String prevColor = robot.getColorSensor().getColorString();
		String currentColor = prevColor;
		robot.getEngine().setPower(20);
		while (currentColor == prevColor) {
			currentColor = robot.getColorSensor().getColorString();
		}
		Delay.msDelay(250);
	}

	private void playCountryAnthem(String[] scannedFlag) {
		CountryMaker countryMaker = new CountryMaker();
		Country[] countries = countryMaker.getCountries();
		for (Country c : countries) {
			if (Arrays.equals(scannedFlag, c.getFlag().getFlag())) {
				LCD.clear();
				LCD.drawString(String.format("Country: "), 0, 1);
				LCD.drawString(String.format(c.getName()), 0, 2);
				LCD.drawString("Anthem:", 0, 4);
				LCD.drawString(c.getAnthem().getAnthemTitle(), 0, 5);
				c.getAnthem().playAnthem();
			}
		}
	}

}
