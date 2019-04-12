package com.xcal.xcalinfit.controller;

import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xcal.xcalinfit.service.AuthService;

@RestController
@RequestMapping("login")
class LoginController {

	@Autowired
	private AuthService service;

	@GetMapping("test")
	public String test() {
		return "login service is up";
	}

	@PostMapping("login")
	public String create(@RequestBody String login) throws JSONException {

		boolean isLogin = service.login(login);

		if (isLogin) {
			return "ok";
		}
		return "not ok";
	}

}
