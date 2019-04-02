package cratepicker;

/**
 *
 * Doel: Maak array van scanresultaten, zodat het gemiddelde teruggegeven kan worden
 *
 * @author C14b 
 *
 */

public class SampleArray {
	private double[] sample;
	private int index = 0;
	private boolean isFilled = false;
	
	public SampleArray(int sampleSize) {
		sample = new double[sampleSize];
	}
	
	public double[] get() {
		return sample;
	}
	
	public double getAvg() {
		// sum values in array
		int sum = 0;
		for (double d : sample) 
			sum += d;
		// divide by number of items
		return sum / sample.length;
	}
	
	public boolean isFilled() {
		return isFilled;
	}
	
	private void checkIfFilled() {
		if (!isFilled && index == sample.length - 1)
			isFilled = true;
	}
	
	public void add(double value) {
		// increase index
		index ++;
		// make sure it is lower than length
		if (index == sample.length)
			index = 0;
		// check if filled
		checkIfFilled();
		// set value
		sample[index] = value;
	}

}