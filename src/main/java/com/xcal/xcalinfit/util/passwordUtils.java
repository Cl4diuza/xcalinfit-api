package com.xcal.xcalinfit.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class passwordUtils {

	public static String encode(String rawPassword) {

		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		String encodedPassword = encoder.encode(rawPassword);
		return encodedPassword;
	}

	public static boolean isMatch(String rawPassword, String encodedPassword) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

		if (encoder.matches(rawPassword, encodedPassword)) {
			return true;
		}

		return false;
	}

}
