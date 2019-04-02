package vlag;

/**
*
* Doel: Class for flag, that holds its attribute, a string of colors
*
* @author C14b
*
*/

public class Flag {
	
	String[] flag = new String[3];

	public Flag(String color1, String color2, String color3) {
		flag[0] = color1;
		flag[1] = color2;
		flag[2] = color3;
	}

	public String[] getFlag() {
		return flag;
	}
	
	
	
}
