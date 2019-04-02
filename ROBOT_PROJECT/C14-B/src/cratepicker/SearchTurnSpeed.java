package cratepicker;

/**
*
* Doel: Calculates speed/turn based on bearing and distance, for beacon finder
*
* @author C14b
*
*/

public class SearchTurnSpeed {
	private int arrivalDistance;
	
	public SearchTurnSpeed(int arrivalDistance) {
		super();
		this.arrivalDistance = arrivalDistance;
	}
	
	private double calculateSpeed(double bearing, double distance) {
		double distanceToArrival = distance - arrivalDistance;
		double distanceBasedSpeed = 1.5 * (distanceToArrival) + 15;
		return distanceBasedSpeed - bearing;
	}
	
	private double calculateCurve(double bearing) {
		double curveAmount = 16 * Math.sqrt(Math.abs(bearing));
		if (bearing < 0) {
			return curveAmount * -1;
		} else {
			return curveAmount;
		}
	}
	
	public int[] get(double bearing, double distance) {
		// Calculate speed and curve
		double speed = calculateSpeed(bearing, distance);
		double curve = calculateCurve(bearing);
		// Set turn
		int turnLeft = (int)(speed + curve);
		int turnRight = (int)(speed - curve);
		return new int[] {turnLeft, turnRight};
	}

}
