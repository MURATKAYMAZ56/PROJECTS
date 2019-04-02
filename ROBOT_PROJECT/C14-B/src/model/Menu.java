package model;

import lejos.hardware.Button;
import lejos.hardware.lcd.LCD;
import lejos.utility.Delay;
import programs.Program;

/**
*
* Doel: Display the menu and launch programs
*
* @author C14b
*
*/

public class Menu {
	private Program[] programs;
	
	public Menu(Program[] programs) {
		super();
		this.programs = programs;
	}
	
	private void print(int index) {
		// Print title, options and selector
		LCD.clear();
		// Title
		LCD.drawString("MENU", 0, 1);
		LCD.drawString("Exit", 2, 2);
		// Menu options
		for (int i = 0; i < programs.length; i++) {
			String title = programs[i].getTitle();
			LCD.drawString(title, 2, i + 3);
		}
		// Selector
		LCD.drawChar('*', 0, index + 3);
		// Delay to prevent menu selector not going too fast
			Delay.msDelay(200);	
	}
	
	private int moveSelector(int index) {
		int newIndex = index;
		// Navigate menu
		if (Button.DOWN.isDown())
			newIndex++;
		else if (Button.UP.isDown())
			newIndex--;
		return newIndex % programs.length;
	}
	
	public void display() {
		int index = 0;
		
		while(index >= 0) {
			// Print menu
			print(index);	
			// Navigate menu
			int prevIndex = 0;
			while(Button.ENTER.isUp()) {
				// Move selector on change
				index = moveSelector(index);
				// Print changes
				if (index != prevIndex)
					print(index);
				// Remember index
				prevIndex = index;
			}
			// Run program on Enter
//			
			if (index >= 0) {
				LCD.clear();
				programs[index].run();		
			}
		}
		LCD.clear();
	}

}
