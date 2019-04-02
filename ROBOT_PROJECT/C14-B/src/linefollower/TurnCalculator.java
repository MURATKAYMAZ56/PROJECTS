package linefollower;

/**
*
* Doel: Calculates turn, based on amount of light the sensor picks up
*
* @author C14b
*
*/

public class TurnCalculator {
	LineTuning tuning;
	private double integral;
	private double prevOffset;
	
	public TurnCalculator(LineTuning tuning) {
		super();
		this.tuning = tuning;
	}
	
	public int getTurn(double offset) {
		// Calculate
		integral = offset + integral;
		double derivative = offset - prevOffset;
		// Multiply
		double calculatedP = tuning.getProportionalMultiplier() * offset;
		double calculatedI = tuning.getIntegralMultiplier() * integral;
		double calculatedD = tuning.getDerivativeMultiplier() * derivative; 
		// For next derivative
		prevOffset = offset;
		// Combine pid
		return (int)(calculatedP + calculatedI + calculatedD);
	}

}
