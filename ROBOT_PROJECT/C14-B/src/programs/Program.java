package programs;

import model.Robot;

/**
*
* Doel: Superclass voor programma's, zodat elk programma een title, robot en run-method heeft
*
* @author C14b
*
*/

public abstract class Program {
	protected Robot robot;
	protected String title;
	
	protected Program(Robot robot, String title) {
		this.robot = robot;
		this.title = title;
	}
	
	public abstract void run();
	
	public String getTitle() {
		return title;
	}

}
