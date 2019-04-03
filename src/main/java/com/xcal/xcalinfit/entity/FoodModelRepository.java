package com.xcal.xcalinfit.entity;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface FoodModelRepository extends MongoRepository<FoodModel, String> {

	@Query(fields = "{ 'name' : 1}")
	FoodModel findByName(String name);
}
