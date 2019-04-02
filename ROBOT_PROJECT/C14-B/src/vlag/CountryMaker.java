package vlag;

/**
*
* Doel: Makes all countries when called (hardcoded)
*
* @author C14b
*
*/

public class CountryMaker {

	public CountryMaker() {
		super();
	}
	
	public Country[] getCountries() {
		Country[] countries = new Country[7];
		
		FlagMaker flagArray = new FlagMaker();
		Flag[] flags = flagArray.getFlags();
		
		AnthemMaker anthemArray = new AnthemMaker();
		Anthem[] anthems = anthemArray.getAnthems();
		
		countries[0] = new Country("the Netherlands", flags[0], anthems[0]);
		countries[1] = new Country("Belgium", flags[1], anthems[1]);
		countries[2] = new Country("Italy", flags[2], anthems[2]);
		countries[3] = new Country("Germany", flags[3], anthems[3]);
		countries[4] = new Country("France", flags[4], anthems[4]);
		countries[5] = new Country("Austria", flags[5], anthems[5]);
		countries[6] = new Country("Spain", flags[6], anthems[6]);
		return countries;
	}


	
}

