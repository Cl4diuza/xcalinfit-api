package com.xcal.xcalinfit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xcal.xcalinfit.entity.UserModel;
import com.xcal.xcalinfit.service.TokenService;
import com.xcal.xcalinfit.service.UserService;

@RestController
@RequestMapping("user")
class UserController {

	@Autowired
	private UserService userService;
	@Autowired
	private TokenService tokenService;

	@GetMapping("test")
	public String test() {
		return "user service is up";
	}

	@GetMapping("get/{email}")
	public UserModel getUserByEmail(@PathVariable("email") String email) {
		return userService.getByEmail(email);
	}

	@PostMapping("create")
	public String createUser(@RequestBody UserModel user) {
		userService.create(user);
		String userId = user.getId();
		return tokenService.createToken(userId);
	}

	@DeleteMapping("delete/{id}")
	public String del(@PathVariable("id") String id) {
		userService.del(id);
		return "ok";
	}
}
