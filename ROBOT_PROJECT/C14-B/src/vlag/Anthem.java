package vlag;

import lejos.hardware.Sound;
import lejos.utility.Delay;

/**
*
* Doel: Class for anthem, with an array of its notes
*
* @author C14b
*
*/

public class Anthem {
	String title;
	Note[] anthem;
	
	public Anthem(String title, Note[] anthem) {
		super();
		this.title = title;
		this.anthem = anthem;
	}
	
	public void playAnthem() {
		for (int i=0; i<anthem.length; i++) {
			Sound.playTone(anthem[i].getFrequency(), anthem[i].getDurationMS());
			Delay.msDelay(anthem[i].getWaitMS());
		}
	}
	
	public String getAnthemTitle() {
		return this.title;
	}
}
