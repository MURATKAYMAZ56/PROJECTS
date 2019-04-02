package linefollower;

/**
 *
 * Doel: Holds all tuning aspects for lineRider, possible to be changed for every type of parcours
 *
 * @author C14b
 *
 */

public class LineTuning {
	private int proportionalMultiplier;
	private double integralMultiplier;
	private int derivativeMultiplier;
	
	public LineTuning(int proportionalMultiplier, double integralMultiplier, int derivativeMultiplier) {
		this.proportionalMultiplier = proportionalMultiplier;
		this.integralMultiplier = integralMultiplier;
		this.derivativeMultiplier = derivativeMultiplier;
	}

	public int getProportionalMultiplier() {
		return proportionalMultiplier;
	}

	public double getIntegralMultiplier() {
		return integralMultiplier;
	}

	public int getDerivativeMultiplier() {
		return derivativeMultiplier;
	}
	
	

}
