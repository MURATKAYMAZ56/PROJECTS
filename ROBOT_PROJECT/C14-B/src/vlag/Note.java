package vlag;

/**
*
* Doel: Every note has a frequency (toonhoogte), duration (lengte) and a wait until next note)
*
* @author C14b
*
*/

public class Note {
	int frequency;
	int durationMS;
	int waitMS;
	
	public Note(int frequency, int durationMS) {
		this(frequency, durationMS, 100);
	}
	
	public Note(int frequency, int durationMS, int waitMS) {
		super();
		this.frequency = frequency;
		this.durationMS = durationMS;
		this.waitMS = waitMS;
	}

	public int getFrequency() {
		return frequency;
	}

	public int getDurationMS() {
		return durationMS;
	}

	public int getWaitMS() {
		return waitMS;
	}
	
	
}
