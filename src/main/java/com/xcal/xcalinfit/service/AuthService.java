package com.xcal.xcalinfit.service;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xcal.xcalinfit.entity.UserModel;
import com.xcal.xcalinfit.entity.UserModelRepository;
import com.xcal.xcalinfit.util.passwordUtils;

@Service
public class AuthService {

	@Autowired
	private UserModelRepository userRepo;

	public boolean login(String login) throws JSONException {

		JSONObject loginObject = new JSONObject(login);
		String email = loginObject.getString("email");
		String rawPassword = loginObject.getString("password");

		UserModel user = userRepo.findByEmail(email);

		String encodedPassword = user.getPassword();

		if (passwordUtils.isMatch(rawPassword, encodedPassword)) {
			return true;
		}

		return false;

	}
}
