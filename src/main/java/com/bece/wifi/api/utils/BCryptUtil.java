package com.bece.wifi.api.utils;

import java.security.SecureRandom;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class BCryptUtil {
	
	private final static Integer strength = 10;

	public static String hash(String password) {
		
		BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder(
				BCryptUtil.strength, 
				new SecureRandom()
		);
		
		String encodedPassword = bcrypt.encode(password);
		
		return encodedPassword;
	}
	
	public static Boolean compare(String password, String hash) {
		return true;
	}
}
