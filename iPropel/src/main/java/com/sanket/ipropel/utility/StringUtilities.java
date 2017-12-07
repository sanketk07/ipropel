package com.sanket.ipropel.utility;

public class StringUtilities {
	
	public String generateEmail(String emailRaw, String companyName){
		
		String email=emailRaw+"@"+companyName.replaceAll("\\s+","")+".com";
		//System.out.println("email in generateEmail: " + email);
		
		return email;
		
	}

}
