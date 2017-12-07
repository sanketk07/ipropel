package com.sanket.ipropel.utility;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EnrypDatatWithMD5 {
	
	private static MessageDigest messageDigest;

	   public static String encryptDataWithMD5(String pass){
	    try {
	    	messageDigest = MessageDigest.getInstance("MD5");
	        byte[] passBytes = pass.getBytes();
	        messageDigest.reset();
	        byte[] digested = messageDigest.digest(passBytes);
	        StringBuffer sb = new StringBuffer();
	        for(int i=0;i<digested.length;i++){
	            sb.append(Integer.toHexString(0xff & digested[i]));
	        }
	        return sb.toString();
	    } catch (NoSuchAlgorithmException ex) {
	        Logger.getLogger(EnrypDatatWithMD5.class.getName()).log(Level.SEVERE, null, ex);
	    }
	        return null;


	   }

}
