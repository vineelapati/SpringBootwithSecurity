package com.sams.assertmanagement.common;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;

/**
 * @author SPSOFT
 *
 */
public class CommonUtil {
	
	public static String encryption(String value)throws Exception
	{
		MessageDigest md = MessageDigest.getInstance("SHA-256");  
		byte[] bs = md.digest(value.getBytes(StandardCharsets.UTF_8));
		
		BigInteger number = new BigInteger(1, bs);  
		  
        // Convert message digest into hex value  
        StringBuilder hexString = new StringBuilder(number.toString(16));  
  
        return hexString.toString();
		
	}

}
