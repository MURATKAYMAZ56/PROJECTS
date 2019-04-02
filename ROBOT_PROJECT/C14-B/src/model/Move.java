package model;

public class Move {
	Robot robot;
	
	public Move(Robot robot) {
		this.robot = robot;
	}
	
	public void moveForward() {
		robot.getEngine().setPower(50);
	}
	
	public void turnLeft() {
		robot.getEngine().setPower(-45, 45);
	}
	
	public void turnRight() {
		robot.getEngine().setPower(45, -45);
	}
	
	public void stopMoving() {
		robot.getEngine().stop();
	}
}
