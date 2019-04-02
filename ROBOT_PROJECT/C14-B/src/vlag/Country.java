package vlag;

/**
*
* Doel: Class holds attributes for country
*
* @author C14b
*
*/

public class Country {
	
	String name;
	Flag flag;
	Anthem anthem;
	
	public Country(String name, Flag flag, Anthem anthem) {
		super();
		this.name = name;
		this.flag = flag;
		this.anthem = anthem;
	}

	public String getName() {
		return name;
	}

	public Flag getFlag() {
		return flag;
	}

	public Anthem getAnthem() {
		return anthem;
	}
	
	
	

}
