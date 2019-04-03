package com.xcal.xcalinfit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xcal.xcalinfit.entity.FoodModel;
import com.xcal.xcalinfit.service.FoodService;

@RestController
@RequestMapping("food")
class FoodController {

	@Autowired
	private FoodService service;

	@GetMapping("test")
	public String test() {
		return "Service is up";
	}

	@GetMapping("all")
	public List<FoodModel> getAll() {
		return service.getAll();
	}

	@GetMapping("get/{name}")
	public FoodModel getFoodByName(@PathVariable("name") String name) {
		return service.getByName(name);
	}

	@PostMapping("create")
	public String create(@RequestBody FoodModel food) {
		service.create(food);
		return "ok";
	}
}
