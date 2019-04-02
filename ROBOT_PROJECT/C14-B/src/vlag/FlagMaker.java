package vlag;

/**
*
* Doel: Makes (hardcalled) flags when called
*
* @author C14b
*
*/

public class FlagMaker {
	
	public FlagMaker() {
		super();
	}
	
	public Flag[] getFlags() {
		
		Flag dutchFlag = new Flag("Red", "White", "Blue");
		Flag belgianFlag = new Flag("Black", "Yellow", "Red");
		Flag italianFlag = new Flag("Green", "White", "Red");
		Flag germanFlag = new Flag("Black", "Red", "Yellow");
		Flag frenchFlag = new Flag("Blue", "White", "Red");
		Flag austrianFlag = new Flag("Red", "White", "Red");
		Flag spanishFlag = new Flag("Red", "Yellow", "Red");
		
		Flag[] flags = new Flag[] {dutchFlag, belgianFlag, italianFlag, germanFlag, frenchFlag, austrianFlag, spanishFlag}; 
		
		return flags;
	}
}
