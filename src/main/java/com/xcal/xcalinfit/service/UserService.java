package com.xcal.xcalinfit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.xcal.xcalinfit.entity.UserModel;
import com.xcal.xcalinfit.entity.UserModelRepository;
import com.xcal.xcalinfit.util.passwordUtils;

@Service
public class UserService {

	@Autowired
	private UserModelRepository repo;

	public void create(UserModel user) {
		Assert.notNull(user.getEmail(), "Email can not be null");
		Assert.notNull(user.getPassword(), "Password can not be null");

		user.setPassword(passwordUtils.encode(user.getPassword()));

		repo.save(user);
	}

	public UserModel getByEmail(String email) {
		return repo.findByEmail(email);
	}

	public void del(String id) {
		repo.deleteById(id);
	}
}
