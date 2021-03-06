package com.xcal.xcalinfit.entity;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FoodModelRepository extends MongoRepository<FoodModel, String> {

	List<FoodModel> findByName(String name);
}
