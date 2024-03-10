package edu.westga.comp4420.junit_sample.model;

public class TelephoneChecker {
	
	/** Verifies that the provided number is a valid phone number.
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @param number the number provided to be checked
	 * 
	 * @return	true	if number is a valid phone number
	 * 			false	if number is not a valid phone number
	 */
	public boolean verifyNumber(long number) {
		if (number < 1000000L) {
			return false;
		} else if (number <= 9999999L) {
			return true;
		} else if (number < 1000000000L) {
			return false;
		} else {
			return number <= 9999999999L;
		} 
	}
	
	/** Identifies if a provided phone number is potential spam based on the area code.
	 * The following area codes should be reported as potential spam:
	 * 	999
	 * 	900
	 * 	888
	 * 	800
	 * 	911
	 * 	411
	 * 
	 * @precondition number if a valid phone number, else throw IAE
	 * @postcondition none
	 * 
	 * @param number the number provided to be checked
	 * 
	 * @return	true	if number matches heuristics for potential spam
	 * 			false	if number does not match heuristics for potential spam
	 */
	public boolean identifySpam(long number) {
		if (!this.verifyNumber(number)) {
			throw new IllegalArgumentException("The provided number is not a valid phone number.");
		}

		if (this.checkSpamAreaCode(number)) {
			return true;
		}
		
		return false;
	}
	
	private boolean checkSpamAreaCode(long number) {
		String[] areaCodes = {"999", "900", "888", "800", "911", "411"};
		String numberStr = Long.toString(number).substring(0, 3);
		
		for (int i = 0; i < areaCodes.length; i++) {
			if (numberStr.equals(areaCodes[i])) {
				return true;
			}
		}
		return false;
	}
}

/*
Notes from class
Anything that is a 7 or 10 digit number is a valid number


implement and test identify spam: check validate phone number. During the precondition, 
if the phone number is not valid throw an IllegalArgumentException

check if the number has 10 digits. ONly 10 digit phone numbers have area code

if it does not have one of the area codes or no area code it will return false
*/