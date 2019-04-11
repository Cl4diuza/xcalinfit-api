package com.xcal.xcalinfit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.xcal.xcalinfit.entity.FoodModel;
import com.xcal.xcalinfit.entity.FoodModelRepository;

@Service
public class FoodService {

	@Autowired
	private FoodModelRepository repo;

	public void create(FoodModel food) {
		Assert.notNull(food.getName(), "Name can not be null");
		Assert.notNull(food.getContent(), "Content can not be null");

		repo.save(food);
	}

	public List<FoodModel> getAll() {
		return repo.findAll();
	}

	public FoodModel getByName(String name) {
		return repo.findByName(name);
	}

	public void del(String id) {
		repo.deleteById(id);
	}
}
